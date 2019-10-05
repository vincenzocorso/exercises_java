package geometria.figurepiane;

public class Cerchio
{
	static final double PI_GRECO = 3.14;
	double raggio;

	public Cerchio()
	{
		this(1.0);
	}

	public Cerchio(double raggio)
	{
		this.raggio = raggio;
	}

	public double calcolaArea()
	{
		return PI_GRECO * this.raggio * this.raggio;
	}
}