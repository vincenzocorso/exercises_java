package geometria.figurepiane;
import geometria.Punto;

/**
* Questa classe permette di creare dei quadrati.
*/
public class Quadrato extends Rettangolo
{
	/**
	* Costruisce un quadrato usando i vertici passati a parametro. Se la costruzione fallisce viene restituito un messaggio di errore.
	* @param vertici I punti del quadrato elencati in senso orario.
	*/
	public Quadrato(Punto[] vertici)
	{
		super(vertici);

		if(this.lunghezzaLati[0] != this.lunghezzaLati[1])
		{
			this.vertici = null;
			this.direzioneLati = this.lunghezzaLati = null; // TODO: eccezioni
			System.out.println("Errore: i quattro punti non individuano un quadrato.");
		}
	}

	/**
	* Test della classe.
	*/
	public static void main(String[] args)
	{
		System.out.println("Test della classe Quadrato");
		Punto[] vertici;
		Quadrato a;

		// Quadrati validi
		vertici = new Punto[]{new Punto(), new Punto(0.0, 3.0), new Punto(3.0, 3.0), new Punto(3.0, 0.0)};
		a = new Quadrato(vertici);
		System.out.println("Perimetro: " + a.calcolaPerimetro() + "\nArea: " + a.calcolaArea() + "\n");

		// Quadrati non validi (restituiscono un errore)
		vertici = new Punto[]{new Punto(), new Punto(0.0, 3.0), new Punto(5.0, 3.0), new Punto(5.0, 0.0)};
		a = new Quadrato(vertici);
	}
}