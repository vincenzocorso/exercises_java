import java.util.*;

/**
 * Rappresenta un aereo che trasporta passeggeri.
 */
public class Aereo
{
	/**
	 * Il numero di passeggeri che l'aereo pu&ograve; trasportare.
	 */
	public final int capienzaAereo;
	private int postiRimanenti;
	private Passeggero[] posti;

	/**
	 * Instanzia un oggetto di tipo aereo di cui si indica la capienza.
	 * @param capienzaAereo la capienza dell'aereo.
	 * @throws IllegalArgumentException se capienzaAereo &egrave; un numero minore o uguale a zero.
	 */
	public Aereo(int capienzaAereo)
	throws IllegalArgumentException
	{
		if(capienzaAereo <= 0)
			throw new IllegalArgumentException();
		
		this.capienzaAereo = this.postiRimanenti = capienzaAereo;
		this.posti = new Passeggero[this.capienzaAereo];
	}

	/**
	 * Restituisce la lista dei passeggeri dell'aereo.
	 * @return la lista dei passeggeri.
	 * @see Passeggero
	 */
	public Passeggero[] getListaPasseggeri()
	{
		Passeggero[] passeggeri = new Passeggero[this.capienzaAereo - this.postiRimanenti];
		for(int i = 0, j = 0; i < this.posti.length; i++)
			if(this.posti[i] != null)
				passeggeri[j++] = this.posti[i];

		return passeggeri;
	}

	/**
	 * Assegna il posto designato sull'aereo ad un passeggero.
	 * @param passeggero il passeggero.
	 * @param numeroPosto il posto da assegnare.
	 * @throws AereoPienoException se i posti sono tutti occupati.
	 * @throws NullPointerException se passeggero &egrave; null.
	 * @throws IndexOutOfBoundsException se numeroPosto &egrave; minore di zero o maggiore uguale della capienza dell'aereo.
	 * @throws PostoOccupatoException se il posto indicato &egrave; gi&agrave; occupato da un altro 
	 */
	public void assegnaPosto(Passeggero passeggero, int numeroPosto)
	throws AereoPienoException, NullPointerException, IndexOutOfBoundsException, PostoOccupatoException
	{
		if(this.postiRimanenti == 0)
			throw new AereoPienoException();

		if(passeggero == null)
			throw new NullPointerException();
		
		if(numeroPosto < 0 || numeroPosto >= this.capienzaAereo)
			throw new IndexOutOfBoundsException();
		
		if(this.posti[numeroPosto] != null)
			throw new PostoOccupatoException();
		
		this.posti[numeroPosto] = passeggero;
		this.postiRimanenti--;
	}

	/**
	 * Assegna il primo posto disponibile sull'aereo ad un passeggero
	 * @param passeggero il passeggero.
	 * @throws AereoPienoException se i posti sono tutti occupati.
	 * @throws NullPointerException se passeggero &egrave; null.
	 * @throws IndexOutOfBoundsException se numeroPosto &egrave; minore di zero o maggiore uguale della capienza dell'aereo.
	 */
	public void assegnaPosto(Passeggero passeggero)
	throws AereoPienoException, NullPointerException, IndexOutOfBoundsException, PostoOccupatoException
	{
		int i;
		for(i = 0; i < this.posti.length; i++)
			if(this.posti[i] == null)
				break;
		this.assegnaPosto(passeggero, i);
	}

	/**
	 * Cancella l'assegnazione di un posto sull'aereo.
	 * @param numeroPosto il numero del posto.
	 * @throws IndexOutOfBoundsException se numeroPosto &egrave; minore di zero o maggiore uguale della capienza dell'aereo.
	 * @throws PostoLiberoException se il posto &egrave; gi&agrave; libero.
	 */
	public void cancellaAssegnazionePosto(int numeroPosto)
	throws IndexOutOfBoundsException, PostoLiberoException
	{
		if(numeroPosto < 0 || numeroPosto >= this.capienzaAereo)
			throw new IndexOutOfBoundsException();
		
		if(this.posti[numeroPosto] == null)
			throw new PostoLiberoException();
		
		this.posti[numeroPosto] = null;
		this.postiRimanenti++;
	}

	/**
	 * Restituisce il numero di posti sull'aereo non ancora occupati.
	 * @return il numero di posti rimanenti.
	 */
	public int getNumeroPostiDisponibili()
	{
		return this.postiRimanenti;
	}

	/**
	 * Test della classe
	 */
	public static void main(String[] args)
	{
		boolean aereoCreato = false;
		while(!aereoCreato)
		{
			try
			{
				int capienza=1;
				boolean flag = false;
				while(!flag)
				{
					try
					{
						Scanner intScanner = new Scanner(System.in);
						System.out.print("Inserisci la capienza' dell'aereo: ");
						capienza = intScanner.nextInt();
						flag = true;
					}
					catch(InputMismatchException exception)
					{
						System.out.println("Errore: devi inserire un intero positivo.");
					}
				}
				Aereo a = new Aereo(capienza);
				aereoCreato = true;

				int scelta = 1;
				while(scelta != 0)
				{
					Scanner intScanner = new Scanner(System.in);
					Scanner stringScanner = new Scanner(System.in);
					try
					{
						System.out.println("\n==== MENU ====");
						System.out.println("1. Stampa la situazione dei posti disponibili.");
						System.out.println("2. Stampa la lista dei passeggeri.");
						System.out.println("3. Assegna un posto al passeggero.");
						System.out.println("4. Cancella l'assegnazione di un posto.");
						System.out.println("0. Esci.");

						flag = false;
						while(!flag)
						{
							try
							{
								System.out.print("--> ");
								scelta = intScanner.nextInt();
								flag = true;
							}
							catch(InputMismatchException exception)
							{
								System.out.println("Errore: devi inserire un numero intero.");
							}
						}

						System.out.println("");
						switch(scelta)
						{
							case 0: System.out.println("Uscita dal programma..."); break;
							case 1: System.out.println("Sull'aereo sono presenti " + a.getNumeroPostiDisponibili() + " posti disponibili."); break;
							case 2:
								Passeggero[] lista = a.getListaPasseggeri();
								if(lista.length > 0)
								{
									System.out.println("Lista passeggeri: ");
									for(Passeggero p : lista)
										System.out.println(p);
								}
								else
									System.out.println("La lista passeggeri e' vuota.");
							break;
							case 3:
								System.out.print("Inserisci il nome del passeggero: ");
								String nome = stringScanner.nextLine();
								System.out.print("Inserisci il cognome del passeggero: ");
								String cognome = stringScanner.nextLine();
								try
								{
									Passeggero p = new Passeggero(nome, cognome);
									System.out.print("Inserisci il numero del posto o -1 per scegliere il primo disponibile: ");
									int numeroPosto = intScanner.nextInt();
									if(numeroPosto == -1)
										a.assegnaPosto(p);
									else
										a.assegnaPosto(p, numeroPosto);
								}
								catch(NullPointerException exception)
								{
									System.out.println("Errore: e' stato utilizzato un riferimento null.");
								}
								catch(IllegalArgumentException exception)
								{
									System.out.println("Errore: il nome o il cognome del passeggero non sono validi.");
								}
							break;
							case 4:
								System.out.print("Inserisci il numero del posto: ");
								int numeroPosto = intScanner.nextInt();
								a.cancellaAssegnazionePosto(numeroPosto);
							break;
							default: System.out.println("Errore: comando non valido."); break;
						}
					}
					catch(AereoPienoException exception)
					{
						System.out.println("Errore: l'aereo e' pieno.");
						flag = true;
					}
					catch(IndexOutOfBoundsException exception)
					{
						System.out.println("Errore: il numero del posto deve essere compreso tra zero e la capacita' dell'aereo.");
					}
					catch(PostoOccupatoException exception)
					{
						System.out.println("Errore: il posto scelto e' gia' occupato.");
					}
					catch(PostoLiberoException exception)
					{
						System.out.println("Errore: il posto inserito risulta gia' libero.");
					}
				}
			}
			catch(IllegalArgumentException exception)
			{
				System.out.println("Errore: devi inserire un intero positivo.");
			}
		}
	}
}

class PostoOccupatoException extends Exception
{
	public PostoOccupatoException() {}

	public PostoOccupatoException(String msg)
	{
		super(msg);
	}
}

class PostoLiberoException extends RuntimeException
{
	public PostoLiberoException() {}

	public PostoLiberoException(String msg)
	{
		super(msg);
	}	
}

class AereoPienoException extends RuntimeException
{
	public AereoPienoException() {}

	public AereoPienoException(String msg)
	{
		super(msg);
	}	
}