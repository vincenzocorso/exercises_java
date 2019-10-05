public class Main
{
	public static void main(String[] args)
	{
		Serbatoio s = new Serbatoio(5);
		s.rifornisci(10);
		s.consuma(5);
		System.out.println("Livello: " + s.getLivello());
		System.out.println("Capacita': " + s.getCapacita());
	}
}