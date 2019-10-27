package geometria.figurepiane;
import geometria.Punto;

/**
* Questa classe permette di creare dei rombi.
*/
public class Rombo extends Parallelogramma
{
	/**
	* Costruisce un rombo usando i vertici passati a parametro. Se la costruzione fallisce viene restituito un messaggio di errore.
	* @param vertici I punti del rombo elencati in senso orario.
	*/
	public Rombo(Punto[] vertici)
	{
		super(vertici);
		
		if(this.lunghezzaLati[0] != this.lunghezzaLati[1])
		{
			this.vertici = null;
			this.direzioneLati = this.lunghezzaLati = null; // TODO: eccezioni
			System.out.println("Errore: i quattro punti non individuano un rombo.");
		}
	}

	/**
	* Test della classe.
	*/
	public static void main(String[] args)
	{
		System.out.println("Test della classe Rombo");
		Punto[] vertici;
		Rombo a;

		// Rombi validi
		vertici = new Punto[]{new Punto(0.0, 2.0), new Punto(1.0, 4.0), new Punto(2.0, 2.0), new Punto(1.0, 0.0)};
		a = new Rombo(vertici);
		System.out.println("Perimetro: " + a.calcolaPerimetro() + "\nArea: " + a.calcolaArea() + "\n");

		vertici = new Punto[]{new Punto(), new Punto(0.0, 3.0), new Punto(3.0, 3.0), new Punto(3.0, 0.0)};
		a = new Rombo(vertici);
		System.out.println("Perimetro: " + a.calcolaPerimetro() + "\nArea: " + a.calcolaArea() + "\n");

		// Rombi non validi (restituiscono un errore)
		vertici = new Punto[]{new Punto(), new Punto(0.0, 3.0), new Punto(5.0, 3.0), new Punto(5.0, 0.0)};
		a = new Rombo(vertici);
	}
}