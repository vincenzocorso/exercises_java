import java.util.*;

public abstract class Documento
{
	private static int numeroDocumento;

	protected String id;
	protected String titolo;

	public Documento(String id, String titolo)
	{
		this.id = id;
		this.titolo = titolo;
	}

	public Documento()
	{
		Scanner stringScanner = new Scanner(System.in);
		System.out.print("Inserisci il titolo: ");
		this.titolo = stringScanner.nextLine().strip();
		this.id = String.valueOf(++numeroDocumento);
	}

	public String getId()
	{
		return this.id;
	}

	public String getTitolo()
	{
		return this.titolo;
	}

	public abstract String getInfo();

	@Override
	public String toString()
	{
		return "ID: " + this.id + "\nTitolo: " + this.titolo;
	}

	// Note: this comparator imposes orderings that are inconsistent with equals.
	public static Comparator<Documento> getIdComparator()
	{
		return new Comparator<Documento>()
		{
			public int compare(Documento d1, Documento d2)
			{
				return d1.id.compareTo(d2.id);
			}
		};
	}

	// Note: this comparator imposes orderings that are inconsistent with equals.
	public static Comparator<Documento> getTitoloComparator()
	{
		return new Comparator<Documento>()
		{
			public int compare(Documento d1, Documento d2)
			{
				return d1.titolo.compareToIgnoreCase(d2.titolo);
			}
		};
	}
}