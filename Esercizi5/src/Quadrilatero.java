package geometria.figurepiane;
import geometria.Punto;
import java.util.Arrays;

/**
* Questa classe permette di creare dei quadrilateri convessi e non convessi (non intrecciati).
*/
public class Quadrilatero
{
	public static final int NUMERO_LATI = 4;

	protected Punto[] vertici = new Punto[4];
	protected double[] direzioneLati = new double[4];
	protected double[] lunghezzaLati = new double[4];

	/**
	* Costruisce un quadrilatero usando i vertici passati a parametro. Se la costruzione fallisce viene restituito un messaggio di errore.
	* @param vertici I punti del quadrilatero elencati in senso orario.
	*/
	public Quadrilatero(Punto[] vertici)
	{
		// Controlla se ci sono tre vertici allineati.
		boolean flag = false;
		double[] m = new double[4];
		for(int i = 0; i < 4 && !flag; i++)
		{
			m[i] = (vertici[(i+1)%4].getY() - vertici[i].getY()) / (vertici[(i+1)%4].getX() - vertici[i].getX());
			if(!Double.isInfinite(m[i]) && (vertici[(i+2)%4].getY() == m[i] * (vertici[(i+2)%4].getX() - vertici[i].getX()) + vertici[i].getY()))
				flag = true;
			else if(vertici[i].getX() == vertici[(i+1)%4].getX() && vertici[i].getX() == vertici[(i+2)%4].getX())
				flag = true;
		}

		if(!flag)
		{
			// Controlla se i lati non adiacenti si intersecano
			double ya = m[2] * (vertici[0].getX() - vertici[2].getX()) + vertici[2].getY();
			double yb = m[2] * (vertici[1].getX() - vertici[2].getX()) + vertici[2].getY();
			double yc = m[0] * (vertici[2].getX() - vertici[0].getX()) + vertici[0].getY();
			double yd = m[0] * (vertici[3].getX() - vertici[0].getX()) + vertici[0].getY();

			boolean flag1 = false;
			if((vertici[0].getY() - ya) * (vertici[1].getY() - yb) <= 0 && (vertici[2].getY() - yc) * (vertici[3].getY() - yd) <= 0)
				flag1 = true;

			yb = m[3] * (vertici[1].getX() - vertici[3].getX()) + vertici[3].getY();
			yc = m[3] * (vertici[2].getX() - vertici[3].getX()) + vertici[3].getY();
			ya = m[1] * (vertici[0].getX() - vertici[1].getX()) + vertici[1].getY();
			yd = m[1] * (vertici[3].getX() - vertici[1].getX()) + vertici[1].getY();

			boolean flag2 = false;
			if((vertici[1].getY() - yb) * (vertici[2].getY() - yc) <= 0 && (vertici[0].getY() - ya) * (vertici[3].getY() - yd) <= 0)
				flag2 = true;

			if(!flag1 && !flag2)
			{
				this.vertici = Arrays.copyOf(vertici, vertici.length);
				this.direzioneLati = m;
				for(int i = 0; i < 4; i++)
				{
					// Nei casi in cui si hanno lati paralleli all'asse y non si deve distinguere tra +infinito e -infinito.
					if(Double.isInfinite(this.direzioneLati[i]))
						this.direzioneLati[i] = Double.POSITIVE_INFINITY;

					// Precalcola le lunghezze dei lati del quadrilatero.
					this.lunghezzaLati[i] = vertici[i].calcolaDistanza(vertici[(i+1)%4]);
				}
			}
			else System.out.println("Errore: i quattro punti non individuano un quadrilatero.");
		}
		else System.out.println("Errore: ci sono tre punti allineati.");
	}

	/**
	* Calcola il perimetro di un generico quadrilatero.
	* @return il perimetro del quadrilatero.
	*/
	public final double calcolaPerimetro()
	{
		double perimetro = 0.0;

		for(int i = 0; i < 4; i++)
			perimetro += this.lunghezzaLati[i];
		
		return perimetro;
	}

	/**
	* Calcola l'area di un generico quadrilatero.
	* @return l'area del quadrilatero.
	*/
	public double calcolaArea()
	{
		double[] firstVector = new double[]{this.vertici[2].getX() - this.vertici[0].getX(), this.vertici[2].getY() - this.vertici[0].getY()};
		double[] secondVector = new double[]{this.vertici[3].getX() - this.vertici[1].getX(), this.vertici[3].getY() - this.vertici[1].getY()};

		return 0.5 * (firstVector[1] * secondVector[0] - firstVector[0] * secondVector[1]);
	}

	/**
	* Restituisce una rappresentazione tramite stringa del quadrilatero.
	* @return una stringa del tipo '(x1, y1) (x2, y2) (x3, y3) (x4, y4)' 
	*/
	@Override
	public String toString()
	{
		return this.vertici[0].toString() + " " + this.vertici[1].toString() + " " + this.vertici[2].toString() + " " + this.vertici[3].toString();
	}

	/**
	* Test della classe.
	*/
	public static void main(String[] args)
	{
		System.out.println("Test della classe Quadrilatero");
		Punto[] vertici;

		// Quadrilateri validi: convessi e non convessi (non intrecciati)
		vertici = new Punto[]{new Punto(-2.0, 0.0), new Punto(0.0, 4.0), new Punto(2.0, 1.0), new Punto(2.0, -1.0)};
		Quadrilatero a = new Quadrilatero(vertici);
		vertici = new Punto[]{new Punto(-2.0, 0.0), new Punto(0.0, 4.0), new Punto(2.0, 0.0), new Punto(2.0, -1.0)};
		Quadrilatero b = new Quadrilatero(vertici);
		vertici = new Punto[]{new Punto(-2.0, 0.0), new Punto(1.0, -1.0), new Punto(2.0, 1.0), new Punto(2.0, -5.0)};
		Quadrilatero c = new Quadrilatero(vertici);
		vertici = new Punto[]{new Punto(0.0, 2.0), new Punto(2.0, -2.0), new Punto(0.0, -4.0), new Punto(-1.0, -6.0)};
		Quadrilatero d = new Quadrilatero(vertici);
		vertici = new Punto[]{new Punto(0.0, 2.0), new Punto(2.0, -2.0), new Punto(0.0, -4.0), new Punto(-2.0, -2.0)};
		Quadrilatero e = new Quadrilatero(vertici);
		vertici = new Punto[]{new Punto(1.0, 2.0), new Punto(), new Punto(1.0, -4.0), new Punto(-2.0, -1.0)};
		Quadrilatero f = new Quadrilatero(vertici);
		vertici = new Punto[]{new Punto(1.0, 2.0), new Punto(), new Punto(1.0, -4.0), new Punto(-2.0, -3.0)};
		Quadrilatero g = new Quadrilatero(vertici);
		vertici = new Punto[]{ new Punto(-2.0, 0.0), new Punto(0.0, 4.0), new Punto(2.0, 1.0), new Punto(4.0, 1.0)};
		Quadrilatero h = new Quadrilatero(vertici);

		Quadrilatero[] quadrilateri = new Quadrilatero[]{a, b, c, d, e, f, g, h};
		for(Quadrilatero q : quadrilateri)
			System.out.println("Perimetro: " + q.calcolaPerimetro() + "\nArea: " + q.calcolaArea() + "\n");

		// Quadrilateri non validi: non convessi intrecciati (restituiscono un errore)
		/*vertici = new Punto[]{ new Punto(-2.0, 0.0), new Punto(0.0, 4.0), new Punto(2.0, 1.0), new Punto(3.0, 3.0)};
		a = new Quadrilatero(vertici);
		vertici = new Punto[]{ new Punto(-2.0, 0.0), new Punto(0.0, 4.0), new Punto(2.0, 1.0), new Punto(1.0, 3.0)};
		a = new Quadrilatero(vertici);
		vertici = new Punto[]{ new Punto(0.0, 2.0), new Punto(2.0, -2.0), new Punto(0.0, -4.0), new Punto(2.0, -5.0)};
		a = new Quadrilatero(vertici);
		vertici = new Punto[]{ new Punto(0.0, 2.0), new Punto(2.0, -2.0), new Punto(0.0, -4.0), new Punto(0.0, -1.0)};
		a = new Quadrilatero(vertici);
		vertici = new Punto[]{new Punto(1.0, 2.0), new Punto(), new Punto(1.0, -4.0), new Punto(-2.0, -4.0)};
		a = new Quadrilatero(vertici);*/
	}
}