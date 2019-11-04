import java.util.*;

public class Quotidiano extends Documento
{
	protected String data;

	public Quotidiano(String id, String titolo, String data)
	{
		super(id, titolo);
		this.data = data;
	}

	public Quotidiano()
	{
		super();
		Scanner stringScanner = new Scanner(System.in);
		System.out.print("Inserisci la data: ");
		this.data = stringScanner.nextLine();
	}

	public String getData()
	{
		return this.data;
	}

	@Override
	public String getInfo()
	{
		return "Quotidiano";
	}

	@Override
	public String toString()
	{
		return super.toString() + "\nData: " + this.data;
	}

	public static Comparator<Documento> getDataComparator()
	{
		return new Comparator<Documento>()
		{
			public int compare(Documento d1, Documento d2)
			{
				if(!(d1 instanceof Quotidiano)) return -1;
				if(!(d2 instanceof Quotidiano)) return 1;
				Quotidiano q1 = (Quotidiano)d1;
				Quotidiano q2 = (Quotidiano)d2;
				return q1.data.compareTo(q2.data);
			}
		};
	}
}