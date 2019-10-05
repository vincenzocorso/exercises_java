package geometria.figurepiane;

public class Quadrato
{
	double lato;

	public Quadrato()
	{
		this(1.0);
	}

	public Quadrato(double lato)
	{
		this.lato = lato;
	}

	public double calcolaArea()
	{
		return this.lato * this.lato;
	}

	public void raddoppiaLato()
	{
		this.lato *= 2;
	}
}