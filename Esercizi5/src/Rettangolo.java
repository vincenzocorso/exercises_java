package geometria.figurepiane;
import geometria.Punto;

/**
* Questa classe permette di creare dei rettangoli.
*/
public class Rettangolo extends Parallelogramma
{
	/**
	* Costruisce un rettangolo usando i vertici passati a parametro. Se la costruzione fallisce viene restituito un messaggio di errore.
	* @param vertici I punti del rettangolo elencati in senso orario.
	*/
	public Rettangolo(Punto[] vertici)
	{
		super(vertici);

		if(this.direzioneLati[0] != -1.0 / this.direzioneLati[1] && (this.direzioneLati[0] != Double.POSITIVE_INFINITY || this.direzioneLati[1] != 0.0))
		{
			this.vertici = null;
			this.direzioneLati = this.lunghezzaLati = null; // TODO: eccezioni
			System.out.println("Errore: i quattro punti non individuano un rettangolo.");
		}
	}

	/**
	* Test della classe.
	*/
	public static void main(String[] args)
	{
		System.out.println("Test della classe Rettangolo");
		Punto[] vertici;
		Parallelogramma a;

		// Rettangoli validi
		vertici = new Punto[]{new Punto(), new Punto(0.0, 3.0), new Punto(5.0, 3.0), new Punto(5.0, 0.0)};
		a = new Parallelogramma(vertici);
		System.out.println("Perimetro: " + a.calcolaPerimetro() + "\nArea: " + a.calcolaArea() + "\n");

		// Rettangoli non validi (restituiscono un errore)
	}
}