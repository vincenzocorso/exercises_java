public class Impiegato extends Persona
{
	protected Impiegato datoreLavoro;
	protected double salario;

	public Impiegato(String nome, String cognome, Impiegato datoreLavoro, double salario)
	{
		super(nome, cognome);
		this.datoreLavoro = datoreLavoro;
		this.salario = salario;
	}

	public Impiegato(String nome, String cognome)
	{
		this(nome, cognome, null, 0.0);
	}

	public Impiegato getDatoreLavoro()
	{
		return this.datoreLavoro;
	}

	public double getSalario()
	{
		return this.salario;
	}

	@Override
	public void presentati()
	{
		super.presentati();
		System.out.println("Lavoro ed ricevo uno stipendio di " + this.salario + " euro al mese");
	}

	@Override
	public String toString()
	{
		return super.toString() +
				"Datore di lavoro: " + ((this.datoreLavoro != null) ? (this.datoreLavoro.nome + " " + this.datoreLavoro.cognome) : "-") +
				"\nSalario: " + this.salario + "\n";
	}
}