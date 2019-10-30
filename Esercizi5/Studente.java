public final class Studente extends Persona
{
	private String universita;
	private String matricola;

	public Studente(String nome, String cognome, String universita, String matricola)
	{
		super(nome, cognome);
		this.universita = universita;
		this.matricola = matricola;
	}

	public Studente(String nome, String cognome)
	{
		this(nome, cognome, "", "");
	}

	public String getUniversita()
	{
		return this.universita;
	}

	public String getMatricola()
	{
		return this.matricola;
	}

	@Override
	public void presentati()
	{
		super.presentati();
		System.out.println("Studio in " + this.universita + "\nIl mio codice matricola e' " + this.matricola);
	}

	@Override
	public String toString()
	{
		return super.toString() + "Universita: " + this.universita + "\nMatricola: " + this.matricola + "\n";
	}
}