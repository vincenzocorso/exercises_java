public final class Dirigente extends Impiegato
{
	private String dipartimento;

	public Dirigente(String nome, String cognome, double salario, String dipartimento)
	{
		super(nome, cognome, null, salario);
		this.dipartimento = dipartimento;
	}

	public Dirigente(String nome, String cognome, double salario)
	{
		this(nome, cognome, salario, "");
	}

	public Dirigente(String nome, String cognome)
	{
		this(nome, cognome, 0.0);
	}

	public String getDipartimento()
	{
		return this.dipartimento;
	}

	@Override
	public void presentati()
	{
		super.presentati();
		System.out.println("Sono dirigente al dipartimento " + this.dipartimento);
	}

	@Override
	public String toString()
	{
		return super.toString() + "Dipartimento: " + this.dipartimento + "\n";
	}
}