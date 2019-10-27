package geometria.figurepiane;
import geometria.Punto;

/**
* Questa classe permette di creare dei parallelogrammi.
*/
public class Parallelogramma extends Trapezio
{
	/**
	* Costruisce un parallelogramma usando i vertici passati a parametro. Se la costruzione fallisce viene restituito un messaggio di errore.
	* @param vertici I punti del parallelogramma elencati in senso orario.
	*/
	public Parallelogramma(Punto[] vertici)
	{
		super(vertici);

		if(this.direzioneLati[0] != this.direzioneLati[2] || this.direzioneLati[1] != this.direzioneLati[3])
		{
			if(this.lunghezzaLati[0] != this.lunghezzaLati[2] || this.lunghezzaLati[1] != this.lunghezzaLati[3])
			{
				this.vertici = null;
				this.direzioneLati = this.lunghezzaLati = null; // TODO: eccezioni
				System.out.println("Errore: i quattro punti non individuano un parallelogramma.");
			}
		}
	}

	/**
	* Test della classe.
	*/
	public static void main(String[] args)
	{
		System.out.println("Test della classe Parallelogramma");
		Punto[] vertici;
		Parallelogramma a;

		// Parallelogrammi validi
		vertici = new Punto[]{new Punto(0.0, 3.0), new Punto(3.0, 3.0), new Punto(5.0, 0.0), new Punto()};
		a = new Parallelogramma(vertici);
		System.out.println("Perimetro: " + a.calcolaPerimetro() + "\nArea: " + a.calcolaArea() + "\n");

		vertici = new Punto[]{new Punto(-1.0, -3.0), new Punto(-2.0, 0.0), new Punto(0.0, 2.0), new Punto(4.0, 2.0)};
		a = new Parallelogramma(vertici);
		System.out.println("Perimetro: " + a.calcolaPerimetro() + "\nArea: " + a.calcolaArea() + "\n");

		// Parallelogrammi non validi (restituiscono un errore)
		vertici = new Punto[]{new Punto(-2.0, 0.0), new Punto(0.0, 4.0), new Punto(2.0, 1.0), new Punto(2.0, -1.0)};
		a = new Parallelogramma(vertici);
	}
}