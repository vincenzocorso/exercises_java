import java.util.*;

public class Cassaforte
{
	private String messaggioSegreto;
	private String password;
	private int numeroTentativiFalliti;

	public Cassaforte(String messaggioSegreto, String password)
	throws NullPointerException, FormatoPasswordInvalidoException
	{
		if(messaggioSegreto == null)
			throw new NullPointerException();
		
		if(password == null || !controllaFormatoPassword(password))
			throw new FormatoPasswordInvalidoException();
		
		this.messaggioSegreto = messaggioSegreto;
		this.password = password;
	}

	private static boolean controllaFormatoPassword(String password)
	{
		if(password.length() >= 6 && password.matches("[\\D]*(\\d)[\\D\\d]*"))
			return true;
		else
			return false;
	}

	public void stampaMessaggioSegreto(String password)
	throws PasswordErrataException, CassaforteBloccataException
	{
		if(this.numeroTentativiFalliti >= 3)
			throw new CassaforteBloccataException();

		if(password == null || !this.password.equals(password))
		{
			this.numeroTentativiFalliti++;
			throw new PasswordErrataException();
		}

		System.out.println("Messaggio segreto: " + this.messaggioSegreto);
	}

	public void reimpostaPassword(String passwordAttuale, String nuovaPassword)
	throws FormatoPasswordInvalidoException, PasswordErrataException, CassaforteBloccataException
	{
		if(this.numeroTentativiFalliti >= 3)
			throw new CassaforteBloccataException();

		if(nuovaPassword == null || !controllaFormatoPassword(nuovaPassword))
			throw new FormatoPasswordInvalidoException();
		
		if(passwordAttuale == null || !this.password.equals(passwordAttuale))
		{
			this.numeroTentativiFalliti++;
			throw new PasswordErrataException();
		}
		
		this.password = nuovaPassword;
	}

	public static void main(String[] args)
	{
		boolean cassaforteCreata = false;
		while(!cassaforteCreata)
		{
			try
			{
				System.out.println("==== CREAZIONE CASSAFORTE ====");
				Scanner in = new Scanner(System.in);
				System.out.print("Inserisci il messaggio segreto: ");
				String messaggioSegreto = in.nextLine();
				System.out.print("Inserisci la password della cassaforte: ");
				String password = in.nextLine();

				Cassaforte c = new Cassaforte(messaggioSegreto, password);
				cassaforteCreata = true;
				
				int scelta = 1;
				while(scelta != 0)
				{
					try
					{
						String str1, str2;
						Scanner inputInt = new Scanner(System.in);

						System.out.println("\n==== MENU ====");
						System.out.println("1. Reimposta password.");
						System.out.println("2. Recupera messaggio segreto.");
						System.out.println("0. Esci");
						scelta = inputInt.nextInt();

						switch(scelta)
						{
							case 0: System.out.println("Uscita dal programma."); break;
							case 1:
								System.out.print("Inserisci la password della cassaforte: ");
								str1 = in.nextLine();
								System.out.print("Inserisci la nuova password: ");
								str2 = in.nextLine();
								c.reimpostaPassword(str1, str2);
							break;
							case 2:
								System.out.print("Inserisci la password della cassaforte: ");
								str1 = in.nextLine();
								c.stampaMessaggioSegreto(str1);
							break;
							default: System.out.println("Errore: comando non valido."); break;
						}
					}
					catch(FormatoPasswordInvalidoException exception)
					{
						System.out.println("Errore: Formato password non valido");
					}
					catch(PasswordErrataException exception)
					{
						System.out.println("Errore: Password errata.");
					}
					catch(CassaforteBloccataException exception)
					{
						System.out.println("Errore: Cassaforte bloccata.");
					}
				}
			}
			catch(NullPointerException exception)
			{
				System.out.println("Errore: Il messaggio segreto e' un riferimento a null.");
			}
			catch(FormatoPasswordInvalidoException exception)
			{
				System.out.println("Errore: Formato password non valido");
			}
		}
	}
}

class FormatoPasswordInvalidoException extends Exception
{
	public FormatoPasswordInvalidoException() {}

	public FormatoPasswordInvalidoException(String msg)
	{
		super(msg);
	}
}

class PasswordErrataException extends Exception
{
	public PasswordErrataException() {}

	public PasswordErrataException(String msg)
	{
		super(msg);
	}
}

class CassaforteBloccataException extends Exception
{
	public CassaforteBloccataException() {}

	public CassaforteBloccataException(String msg)
	{
		super(msg);
	}
}