import java.util.Scanner;

/**
* Permette di creare oggetti che rappresentano libri.
* @author Vincenzo Corso (vincenzocorso99@gmail.com)
* @version 0.1
*/
public class Libro
{
	private static int numeroAutori;

	private int id;
	private Autore[] autori;
	private String titolo;
	private double prezzo;
	private String casaEditrice;

	/**
	* Crea un libro, chiedendo all'utente di inserire i dati in input.
	*/
	public Libro()
	{
		Scanner in = new Scanner(System.in);

		System.out.print("Inserisci il nome del libro: ");
		this.titolo = in.nextLine();

		System.out.print("Inserisci gli autori separati da virgole nel formato 'Nome Cognome': ");
		String[] stringheAutori = in.nextLine().split(",");
		this.autori = new Autore[stringheAutori.length];
		for(int i = 0; i < this.autori.length; i++)
		{
			String[] a = stringheAutori[i].strip().split(" ");
			this.autori[i] = new Autore(a[0], a[1]);
		}

		System.out.print("Inserisci il nome della casa editrice del libro: ");
		this.casaEditrice = in.nextLine();

		System.out.print("Inserisci il prezzo del libro: ");
		this.prezzo = in.nextDouble();

		this.id = ++numeroAutori;
	}

	/**
	* Restituisce il numero identificativo del libro;
	*/
	public int getId()
	{
		return this.id;
	}

	/**
	* Restituisce un array contenente gli autori del libro.
	*/
	public Autore[] getAutori()
	{
		return autori;
	}

	/**
	* Restituisce il titolo del libro.
	*/
	public String getTitolo()
	{
		return this.titolo;
	}

	/**
	* Restituisce il prezzo del libro.
	*/
	public double getPrezzo()
	{
		return this.prezzo;
	}

	/**
	* Restituisce il nome della casa editrice.
	*/
	public String getCasaEditrice()
	{
		return this.casaEditrice;
	}

	/**
	* Restituisce una rappresentazione tramite stringa del libro.
	*/
	@Override
	public String toString()
	{
		StringBuilder stringheAutori = new StringBuilder();
		for(Autore autore : autori)
		{
			stringheAutori.append(autore.toString());
			stringheAutori.append(", ");
		}

		return "Codice libro: " + this.getId() + "\nTitolo: " + this.getTitolo() + "\nAutori: " +
				stringheAutori.toString() + "\nCasa editrice: " + this.getCasaEditrice() +
				"\nPrezzo: " + this.getPrezzo(); 
	}
}