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
		Imposta il livello del serbatoio a 0.
	*/
	public Serbatoio()
	{
		this(0);
	}

	/**
		Inizializza la capacita' del serbatoio a 0.
		Imposta il livello del serbatoio ad un certo valore.
		@param livello Il livello del serbatoio.
	*/
	public Serbatoio(int livello)
	{
		this.livello = livello;
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

	/**
		Da informazioni sul liquido rimanente nel serbatoio.
		@return Il livello del serbatoio.
	*/
	public int getLivello()
	{
		return this.livello;
	}

	/**
		Da informazioni sulla capacita' del serbatoio.
		@return La capacita' del serbatoio.
	*/
	public int getCapacita()
	{
		return this.CAPACITA;
	}
}