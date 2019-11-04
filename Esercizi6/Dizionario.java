import java.util.*;

public class Dizionario extends Libro
{
	protected String lingua;

	public Dizionario(String id, String titolo, String isbn, Autore[] autori, String casaEditrice, String lingua)
	{
		super(id, titolo, isbn, autori, casaEditrice);
		this.lingua = lingua;
	}

	public Dizionario()
	{
		super();
		Scanner stringScanner = new Scanner(System.in);
		System.out.print("Inserisci la lingua: ");
		this.lingua = stringScanner.nextLine();
	}

	public String getLingua()
	{
		return this.lingua;
	}

	@Override
	public String getInfo()
	{
		return "Dizionario";
	}

	@Override
	public String toString()
	{
		return super.toString() + "\nLingua: " + this.lingua;
	}

	public static Comparator<Documento> getLinguaComparator()
	{
		return new Comparator<Documento>()
		{
			public int compare(Documento d1, Documento d2)
			{
				if(!(d1 instanceof Dizionario)) return -1;
				if(!(d2 instanceof Dizionario)) return 1;
				Dizionario l1 = (Dizionario)d1;
				Dizionario l2 = (Dizionario)d2;
				return l1.lingua.compareToIgnoreCase(l2.lingua);
			}
		};
	}
}