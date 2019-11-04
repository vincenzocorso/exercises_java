import java.util.*;

public class Libro extends Documento
{
	protected String isbn;
	protected Autore[] autori;
	protected String casaEditrice;

	public Libro(String id, String titolo, String isbn, Autore[] autori, String casaEditrice)
	{
		super(id, titolo);
		this.isbn = isbn;
		this.autori = autori;
		this.casaEditrice = casaEditrice;
	}

	public Libro()
	{
		super();
		Scanner stringScanner = new Scanner(System.in);
		do
		{
			System.out.print("Inserisci il codice isbn: ");
			this.isbn = stringScanner.nextLine().strip();
		}
		while(!isbn.matches("[\\d]{3}[\\d]{1,5}[\\d]{2,7}[\\d]{1,6}[\\dxX]"))
		System.out.print("Inserisci gli autori separati da virgole (Cognome Nome): ");
		String stringaAutori = stringScanner.nextLine().strip();
		String[] datiAutori = stringaAutori.split(",");
		this.autori = new Autore[datiAutori.length];
		for(int i = 0; i < datiAutori.length; i++)
		{
			String[] autore = datiAutori[i].strip().split(" ");
			this.autori[i] = new Autore(autore[1], autore[0]);
		}
		Arrays.sort(this.autori);
		System.out.print("Inserisci la casa editrice: ");
		this.casaEditrice = stringScanner.nextLine();
	}

	public String getIsbn()
	{
		return this.isbn;
	}

	public Autore[] getAutori()
	{
		return this.autori;
	}

	public Autore getAutore(int indice)
	{
		return this.autori[indice];
	}

	public String getCasaEditrice()
	{
		return this.casaEditrice;
	}

	@Override
	public String getInfo()
	{
		return "Libro";
	}

	@Override
	public String toString()
	{
		StringBuilder risultato = new StringBuilder(super.toString() + "\nISBN: " + this.isbn + "\nAutori: ");
		for(Autore a : this.autori)
			risultato.append(a + ", ");
		risultato.append("\nCasa editrice: " + this.casaEditrice);
		return risultato.toString();
	}

	public static Comparator<Documento> getIsbnComparator()
	{
		return new Comparator<Documento>()
		{
			public int compare(Documento d1, Documento d2)
			{
				if(!(d1 instanceof Libro)) return -1;
				if(!(d2 instanceof Libro)) return 1;
				Libro l1 = (Libro)d1;
				Libro l2 = (Libro)d2;
				return l1.isbn.compareTo(l2.isbn);
			}
		};
	}

	public static Comparator<Documento> getAutoriComparator()
	{
		return new Comparator<Documento>()
		{
			public int compare(Documento d1, Documento d2)
			{
				if(!(d1 instanceof Libro)) return -1;
				if(!(d2 instanceof Libro)) return 1;
				Libro l1 = (Libro)d1;
				Libro l2 = (Libro)d2;
				int min = Math.min(l1.autori.length, l2.autori.length);
				for(int i = 0; i < min; i++)
				{
					int comp = l1.autori[i].compareTo(l2.autori[i]);
					if(comp != 0) return comp;
				}
				if(l1.autori.length == l2.autori.length) return 0;
				return (l1.autori.length < l2.autori.length) ? -1 : 1;
			}
		};
	}

	public static Comparator<Documento> getCasaEditriceComparator()
	{
		return new Comparator<Documento>()
		{
			public int compare(Documento d1, Documento d2)
			{
				if(!(d1 instanceof Libro)) return -1;
				if(!(d2 instanceof Libro)) return 1;
				Libro l1 = (Libro)d1;
				Libro l2 = (Libro)d2;
				return l1.casaEditrice.compareToIgnoreCase(l2.casaEditrice);
			}
		};
	}
}