public class Main
{
	public static void main(String[] args)
	{
		ContoBancario a = new ContoBancario("Mario Rossi", 100.50);
		ContoBancario b = new ContoBancario("Vincenzo Corso");

		System.out.println(a.getNomeTitolare() + "(" + a.getNumeroConto() + "): " + a.getSaldo());
		System.out.println(b.getNomeTitolare() + "(" + b.getNumeroConto() + "): " + b.getSaldo());
		a.trasferisci(b, 100.0);
		System.out.println(a.getNomeTitolare() + "(" + a.getNumeroConto() + "): " + a.getSaldo());
		System.out.println(b.getNomeTitolare() + "(" + b.getNumeroConto() + "): " + b.getSaldo());
	}
}