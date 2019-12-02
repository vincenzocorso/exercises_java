public class Persona
{
	protected String nome;
	protected String cognome;

	public Persona(String nome, String cognome)
	{
		this.nome = nome;
		this.cognome = cognome;
	}

	public String getNome()
	{
		return this.nome;
	}

	public String getCognome()
	{
		return this.cognome;
	}

	public void presentati()
	{
		System.out.println("Mi chiamo " + this.nome + " " + this.cognome);
	}

	@Override
	public String toString()
	{
		return this.nome + " " + this.cognome;
	}
}