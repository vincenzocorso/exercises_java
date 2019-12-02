/**
* Permette di creare oggetti che rappresentano punti nel piano cartesiano.
*/
public final class Punto
{
	private double x;
	private double y;

	/**
	* Crea un punto sul piano cartesiano alle coordinate indicate.
	*/
	public Punto(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	* Crea un punto nell'origine del piano cartesiano.
	*/
	public Punto()
	{
		this(0.0, 0.0);
	}

	/**
	* Restituisce l'ascissa del punto.
	*/
	public double getX()
	{
		return this.x;
	}

	/**
	* Restituisce l'ordinata del punto.
	*/
	public double getY()
	{
		return this.y;
	}

	/**
	* Calcola la distanza tra questo oggetto ed un altro punto.
	* @return la distanza tra i due punti.
	*/
	public double calcolaDistanza(Punto punto)
	{
		double x = punto.x - this.x;
		double y = punto.y - this.y;
		return Math.sqrt(x*x + y*y);
	}

	/**
	* Restituisce una rappresentazione tramite stringa del punto.
	*/
	@Override
	public String toString()
	{
		return "(" + this.x + ", " + this.y + ")";
	}

	/**
	* Test che permette di verificare il corretto funzionamento della classe.
	*/
	public static void main(String[] args)
	{
		System.out.println("Test della classe Punto");
		Punto a = new Punto(1.2, 3.4);
		Punto b = new Punto(1.9, 3.4);
		System.out.println(a);
		System.out.println(b);
		System.out.println("Distanza: " + a.calcolaDistanza(b));
	}
}