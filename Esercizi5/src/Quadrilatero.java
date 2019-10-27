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
		if(vertici.length == 4)
		{
			double mab = (vertici[1].getY() - vertici[0].getY()) / (vertici[1].getX() - vertici[0].getX());
			double mbc = (vertici[2].getY() - vertici[1].getY()) / (vertici[2].getX() - vertici[1].getX());
			double yp = vertici[3].getY();

			boolean flag = true;
			if(mab != mbc)
			{
				double k1 = mab * (vertici[3].getX() - vertici[0].getX()) + vertici[0].getY();
				double k2 = mbc * (vertici[3].getX() - vertici[1].getX()) + vertici[1].getY();

				if(vertici[0].getX() != vertici[2].getX())
				{
					double mac = (vertici[0].getY() - vertici[2].getY()) / (vertici[0].getX() - vertici[2].getX());
					double k3 = mac * (vertici[1].getX() - vertici[0].getX()) + vertici[0].getY();

					if(vertici[1].getY() > k3) // caso 1
					{
						double k4 = mac * (vertici[3].getX() - vertici[0].getX()) + vertici[0].getY();

						if( (yp >= k4 && (yp >= k1 || yp >= k2)) || (yp == k1 || yp == k2) )
							flag = false;
					}
					else if(vertici[1].getY() < k3) // caso 2
					{
						if( yp >= k1 || yp >= k2 )
							flag = false;
					}
					else flag = false;
				}
				else
				{
					if(vertici[1].getX() > vertici[0].getX()) // caso 3
					{
						if( (vertici[3].getX() >= vertici[0].getX() && (yp >= k1 || yp <= k2)) || vertici[3].getX() == vertici[0].getX() )
							flag = false;
					}
					else if(vertici[1].getX() < vertici[0].getX()) // caso 4
					{
						if( yp <= k1 || yp >= k2 )
							flag = false;
					}
					else flag = false;
				}
			}
			else flag = false;
			
			if(flag)
			{
				this.vertici = Arrays.copyOf(vertici, vertici.length);
				for(int i = 0; i < 4; i++)
				{
					/* Precalcola il coefficente angolare delle rette che individuano i lati del quadrilatero.
					Nei casi in cui si hanno lati paralleli all'asse y non si deve distinguere tra +infinito e -infinito. */
					this.direzioneLati[i] = (vertici[(i+1)%4].getY() - vertici[i].getY()) / (vertici[(i+1)%4].getX() - vertici[i].getX());
					if(Double.isInfinite(this.direzioneLati[i]))
						this.direzioneLati[i] = Double.POSITIVE_INFINITY;

					// Precalcola le lunghezze dei lati del quadrilatero.
					this.lunghezzaLati[i] = vertici[i].calcolaDistanza(vertici[(i+1)%4]);
				}
			}
			else System.out.println("Errore: i quattro punti non individuano un quadrilatero o non sono stati inseriti nell'ordine corretto.");
		}
		else System.out.println("Errore: bisogna definire quattro punti.");
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
		Quadrilatero a;

		// Quadrilateri validi: convessi e non convessi (non intrecciati)
		vertici = new Punto[]{new Punto(-2.0, 0.0), new Punto(0.0, 4.0), new Punto(2.0, 1.0), new Punto(2.0, -1.0)};
		a = new Quadrilatero(vertici);
		System.out.println("Perimetro: " + a.calcolaPerimetro() + "\nArea: " + a.calcolaArea() + "\n");

		vertici = new Punto[]{new Punto(-2.0, 0.0), new Punto(0.0, 4.0), new Punto(2.0, 0.0), new Punto(2.0, -1.0)};
		a = new Quadrilatero(vertici);
		System.out.println("Perimetro: " + a.calcolaPerimetro() + "\nArea: " + a.calcolaArea() + "\n");

		vertici = new Punto[]{new Punto(-2.0, 0.0), new Punto(1.0, -1.0), new Punto(2.0, 1.0), new Punto(2.0, -5.0)};
		a = new Quadrilatero(vertici);
		System.out.println("Perimetro: " + a.calcolaPerimetro() + "\nArea: " + a.calcolaArea() + "\n");

		vertici = new Punto[]{new Punto(0.0, 2.0), new Punto(2.0, -2.0), new Punto(0.0, -4.0), new Punto(-1.0, -6.0)};
		a = new Quadrilatero(vertici);
		System.out.println("Perimetro: " + a.calcolaPerimetro() + "\nArea: " + a.calcolaArea() + "\n");

		vertici = new Punto[]{new Punto(0.0, 2.0), new Punto(2.0, -2.0), new Punto(0.0, -4.0), new Punto(-2.0, -2.0)};
		a = new Quadrilatero(vertici);
		System.out.println("Perimetro: " + a.calcolaPerimetro() + "\nArea: " + a.calcolaArea() + "\n");

		vertici = new Punto[]{new Punto(1.0, 2.0), new Punto(), new Punto(1.0, -4.0), new Punto(-2.0, -1.0)};
		a = new Quadrilatero(vertici);
		System.out.println("Perimetro: " + a.calcolaPerimetro() + "\nArea: " + a.calcolaArea() + "\n");

		vertici = new Punto[]{new Punto(1.0, 2.0), new Punto(), new Punto(1.0, -4.0), new Punto(-2.0, -3.0)};
		a = new Quadrilatero(vertici);
		System.out.println("Perimetro: " + a.calcolaPerimetro() + "\nArea: " + a.calcolaArea() + "\n");

		// Quadrilateri non validi: non convessi intrecciati (restituiscono un errore)
		/*vertici = new Punto[]{ new Punto(-2.0, 0.0), new Punto(0.0, 4.0), new Punto(2.0, 1.0), new Punto(3.0, 3.0)};
		a = new Quadrilatero(vertici);*/
		/*vertici = new Punto[]{ new Punto(-2.0, 0.0), new Punto(0.0, 4.0), new Punto(2.0, 1.0), new Punto(4.0, 1.0)};
		a = new Quadrilatero(vertici);*/
		/*vertici = new Punto[]{ new Punto(-2.0, 0.0), new Punto(0.0, 4.0), new Punto(2.0, 1.0), new Punto(1.0, 3.0)};
		a = new Quadrilatero(vertici);*/
		/*vertici = new Punto[]{ new Punto(0.0, 2.0), new Punto(2.0, -2.0), new Punto(0.0, -4.0), new Punto(2.0, -5.0)};
		a = new Quadrilatero(vertici);*/
		/*vertici = new Punto[]{ new Punto(0.0, 2.0), new Punto(2.0, -2.0), new Punto(0.0, -4.0), new Punto(0.0, -1.0)};
		a = new Quadrilatero(vertici);*/
		/*vertici = new Punto[]{new Punto(1.0, 2.0), new Punto(), new Punto(1.0, -4.0), new Punto(-2.0, -4.0)};
		a = new Quadrilatero(vertici);*/
		/*vertici = new Punto[]{new Punto(1.0, 2.0), new Punto(), new Punto(1.0, -4.0), new Punto(3.0, -1.0)};
		a = new Quadrilatero(vertici);*/
	}
}