package geometria.figuresolide;

public class Cubo
{
	double lato;

	public Cubo()
	{
		this(1.0);
	}

	public Cubo(double lato)
	{
		this.lato = lato;
	}

	public double calcolaVolume()
	{
		return this.lato * this.lato * this.lato;
	}
}