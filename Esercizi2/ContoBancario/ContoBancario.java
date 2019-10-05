public class ContoBancario
{
	private static int contatore;

	private double saldo;
	private String nomeTitolare;
	private int numeroConto;

	public ContoBancario(String nomeTitolare)
	{
		this(nomeTitolare, 0.0);
	}

	public ContoBancario(String nomeTitolare, double saldoIniziale)
	{
		this.nomeTitolare = nomeTitolare;
		this.saldo = saldoIniziale;
		this.numeroConto = ContoBancario.contatore++;
	}

	public void preleva(double cifra)
	{
		this.saldo -= cifra;
	}

	public void versa(double cifra)
	{
		this.saldo += cifra;
	}

	public double getSaldo()
	{
		return this.saldo;
	}

	public String getNomeTitolare()
	{
		return this.nomeTitolare;
	}

	public int getNumeroConto()
	{
		return this.numeroConto;
	}

	public void trasferisci(ContoBancario c, double cifra)
	{
		this.preleva(cifra);
		c.versa(cifra);
	}
}