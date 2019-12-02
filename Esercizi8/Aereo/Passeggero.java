public class Passeggero
{
	private String nome;
	private String cognome;

	public Passeggero(String nome, String cognome)
	throws NullPointerException, IllegalArgumentException
	{
		if(nome == null || cognome == null)
			throw new NullPointerException();

		if(!nome.matches("[a-zA-Z]{2,}") || !cognome.matches("[a-zA-Z]{2,}"))
			throw new IllegalArgumentException();
		
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

	@Override
	public String toString()
	{
		return this.nome + " " + this.cognome;
	}
}