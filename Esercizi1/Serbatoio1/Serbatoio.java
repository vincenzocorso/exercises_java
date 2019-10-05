/**
	Questa classe astrae il concetto di serbatoio.
	@author Vincenzo Corso
*/
public class Serbatoio
{
	private int livello;
	private final int CAPACITA;

	/**
		Inizializza la capacita' del serbatoio a 100.
	*/
	public Serbatoio()
	{
		this.CAPACITA = 100;
	}

	/**
		Rifornisce il serbatoio.
		@param j La quantita' da aggiungere al serbatoio.
	*/
	public void rifornisci(int j)
	{
		this.livello += j;
	}

	/**
		Consuma il liquido nel serbatoio.
		@param j La quantita' da consumare.
	*/
	public void consuma(int j)
	{
		this.livello -= j;
	}

	public static void main(String[] args)
	{
		Serbatoio s = new Serbatoio();
		s.rifornisci(10);
		s.consuma(5);
		System.out.println("Livello: " + s.livello);
		System.out.println("Capacita': " + s.CAPACITA);
	}
}