import java.util.ArrayList;

public class CatalogoLibri
{
	private ArrayList<Libro> catalogo = new ArrayList<Libro>();

	public void inserisciLibro(Libro libro)
	{
		int i = 0;
		for(; i < catalogo.size(); i++)
		{
			if(libro.getTitolo().compareToIgnoreCase(catalogo.get(i).getTitolo()) < 0)
				break;
		}

		catalogo.add(i, libro);
	}

	public void stampa()
	{
		System.out.println("| Catalogo libri |");
		for(Libro libro : catalogo)
			System.out.println(libro + "\n");
	}

	public Libro cercaPerId(int id)
	{
		for(Libro l : catalogo)
		{
			if(l.getId() == id)
				return l;
		}

		return null;
	}

	public Libro[] cercaPerTitolo(String titolo)
	{
		ArrayList<Libro> risultato = new ArrayList<Libro>();

		for(Libro l : catalogo)
		{
			if(l.getTitolo().equals(titolo))
				risultato.add(l);
		}

		Libro[] array = new Libro[risultato.size()];
		risultato.toArray(array);
		return array;
	}

	public Libro[] cercaPerAutore(String autore)
	{
		ArrayList<Libro> risultato = new ArrayList<Libro>();

		for(Libro l : catalogo)
		{
			Autore[] autori = l.getAutori();
			for(Autore a : autori)
			{
				if(a.toString().equals(autore))
					risultato.add(l);
			}
		}

		Libro[] array = new Libro[risultato.size()];
		risultato.toArray(array);
		return array;
	}

	public Libro[] cercaPerPrezzo(double prezzoMinimo, double prezzoMassimo)
	{
		ArrayList<Libro> risultato = new ArrayList<Libro>();

		for(Libro l : catalogo)
		{
			if(l.getPrezzo() >= prezzoMinimo && l.getPrezzo() <= prezzoMassimo)
				risultato.add(l);
		}

		Libro[] array = new Libro[risultato.size()];
		risultato.toArray(array);
		return array;
	}

	public Libro[] cercaPerCasaEditrice(String casaEditrice)
	{
		ArrayList<Libro> risultato = new ArrayList<Libro>();

		for(Libro l : catalogo)
		{
			if(l.getCasaEditrice().equals(casaEditrice))
				risultato.add(l);
		}

		Libro[] array = new Libro[risultato.size()];
		risultato.toArray(array);
		return array;
	}
}