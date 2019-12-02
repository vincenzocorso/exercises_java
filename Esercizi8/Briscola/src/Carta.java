package giochicarte;

public class Carta
{
	private final String seme;
	private final String rango;

	public Carta(String seme, String rango)
	throws NullPointerException
	{
		if(seme == null || rango == null)
			throw new NullPointerException();
		
		this.seme = seme;
		this.rango = rango;
	}

	public String getSeme()
	{
		return this.seme;
	}

	public String getRango()
	{
		return this.rango;
	}

	@Override
	public String toString()
	{
		return this.rango + " di " + this.seme;
	}
}