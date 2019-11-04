import java.util.*;

public class Biblioteca
{
	private String nome;
	ArrayList<Documento> archivio = new ArrayList<Documento>();

	public Biblioteca()
	{
		Scanner stringScanner = new Scanner(System.in);
		System.out.print("Inserisci il nome della biblioteca: ");
		this.nome = stringScanner.nextLine();
	}

	public void stampa()
	{
		if(this.archivio.size() > 0)
		{
			for(Documento d : this.archivio)
				System.out.println(d + "\n");
		}
		else System.out.println("L'archivio e' vuoto.");
	}

	public void inserisciDocumento()
	{
		Scanner intScanner = new Scanner(System.in);
		int scelta = 0;
		while(scelta < 1 || scelta > 3)
		{
			System.out.println("Che tipo di documento vuoi inserire?\n1. Libro\n2. Dizionario\n3. Quotidiano");
			System.out.print("--> ");
			scelta = intScanner.nextInt();
		}

		Documento documento;
		switch(scelta)
		{
			case 1:
			case 2:
				documento = (scelta == 1) ? new Libro() : new Dizionario();
				if(ricercaPerIsbn(((Libro)documento).isbn) == -1)
					this.archivio.add(documento);
				else System.out.println("Errore: Il documento e' gia' presente nell'archivio.");
				break;
			case 3:
				documento = new Quotidiano();
				ArrayList<Documento> q = ricercaPerTitolo(((Quotidiano)documento).titolo);
				boolean flag = false;
				for(Documento d : q)
					if(d instanceof Quotidiano && ((Quotidiano)d).data.equalsIgnoreCase(((Quotidiano)documento).data))
						flag = true;
				if(flag) System.out.println("Errore: Il documento e' gia' presente nell'archivio.");
				else this.archivio.add(documento);
				break;
		}
	}

	public void eliminaDocumento()
	{
		Scanner stringScanner = new Scanner(System.in);
		System.out.print("Inserisci l'id del documento da eliminare: ");
		int indice = ricercaPerId(stringScanner.nextLine());
		if(indice != -1) this.archivio.remove(indice);
		else System.out.println("Errore: Il documento non e' stato trovato.");
	}

	public void ricercaDocumento()
	{
		Scanner stringScanner = new Scanner(System.in);
		Scanner intScanner = new Scanner(System.in);
		int scelta = 0;
		while(scelta < 1 || scelta > 4)
		{
			System.out.println("Come vuoi cercare il documento?\n1. Per id\n2. Per titolo\n3. Per autore\n4. Per isbn");
			System.out.print("--> ");
			scelta = intScanner.nextInt();

			switch(scelta)
			{
				case 1:
					System.out.print("Inserisci l'id del documento da cercare: ");
					int indice = this.ricercaPerId(stringScanner.nextLine());
					if(indice != -1) System.out.println(this.archivio.get(indice));
					else System.out.println("Errore: Il documento non e' stato trovato.");
					break;
				case 2:
					System.out.print("Inserisci il titolo del documento da cercare: ");
					ArrayList<Documento> q = ricercaPerTitolo(stringScanner.nextLine().strip());
					if(q.size() != 0)
						for(Documento d : q)
							System.out.println(d + "\n");
					else System.out.println("Errore: Nessuno documento e' stato trovato con questi parametri .");
					break;
				case 3:
					System.out.print("Inserisci l'autore: ");
					String[] datiAutore = stringScanner.nextLine().strip().split(" ");
					Autore a = new Autore(datiAutore[1], datiAutore[0]);
					ArrayList<Documento> l = ricercaPerAutore(a);
					if(l.size() != 0)
						for(Documento d : l)
							System.out.println(d + "\n");
					else System.out.println("Errore: Nessuno documento e' stato trovato con questi parametri.");
					break;
				case 4:
					System.out.print("Inserisci l'autore: ");
					indice = this.ricercaPerIsbn(stringScanner.nextLine().strip());
					if(indice != -1) System.out.println(this.archivio.get(indice));
					else System.out.println("Errore: Il documento non e' stato trovato.");
					break;
			}
		}
	}

	public void ordina()
	{
		Scanner intScanner = new Scanner(System.in);
		int scelta = 0;
		while(scelta < 1 || scelta > 4)
		{
			System.out.println("In che modo vuoi ordinare l'archivio?\n1. Per id\n2. Per autore\n3. Per isbn\n4. Per titolo");
			System.out.print("--> ");
			scelta = intScanner.nextInt();
		}

		switch(scelta)
		{
			case 1: Collections.sort(this.archivio, Documento.getIdComparator()); break;
			case 2: Collections.sort(this.archivio, Libro.getAutoriComparator()); break;
			case 3: Collections.sort(this.archivio, Libro.getIsbnComparator()); break;
			case 4: Collections.sort(this.archivio, Documento.getTitoloComparator()); break;
		}
	}

	public int ricercaPerId(String id)
	{
		for(int i = 0; i < this.archivio.size(); i++)
		{
			if((this.archivio.get(i)).id.equalsIgnoreCase(id))
				return i;
		}
		return -1;
	}

	public int ricercaPerIsbn(String isbn)
	{
		for(int i = 0; i < this.archivio.size(); i++)
		{
			if(this.archivio.get(i) instanceof Libro && ((Libro)this.archivio.get(i)).isbn.equalsIgnoreCase(isbn))
				return i;
		}
		return -1;
	}

	public ArrayList<Documento> ricercaPerTitolo(String titolo)
	{
		ArrayList<Documento> risultato = new ArrayList<Documento>();
		for(Documento d : this.archivio)
		{
			if(d.titolo.equalsIgnoreCase(titolo));
				risultato.add(d);
		}

		return risultato;
	}

	public ArrayList<Documento> ricercaPerAutore(Autore autore)
	{
		ArrayList<Documento> risultato = new ArrayList<Documento>();
		for(Documento d : this.archivio)
		{
			if(d instanceof Libro)
			{
				for(Autore a : ((Libro)d).autori)
					if(a.equals(autore))
						risultato.add(d);
			}
		}

		return risultato;
	}

	public static void main(String[] args)
	{
		Biblioteca biblioteca = new Biblioteca();

		Scanner intScanner = new Scanner(System.in);

		int scelta = 1;
		while(scelta != 0)
		{
			System.out.println("\n0. Esci");
			System.out.println("1. Visualizza l'archivio");
			System.out.println("2. Inserisci un documento");
			System.out.println("3. Elimina un documento");
			System.out.println("4. Ricerca un documento");
			System.out.println("5. Ordina i documenti");
			System.out.print("--> ");

			scelta = intScanner.nextInt();

			System.out.println("");
			switch(scelta)
			{
				case 0: System.out.println("Chiusura del programma"); break;
				case 1: biblioteca.stampa(); break;
				case 2: biblioteca.inserisciDocumento(); break;
				case 3: biblioteca.eliminaDocumento(); break;
				case 4: biblioteca.ricercaDocumento(); break;
				case 5: biblioteca.ordina(); break;
				default: System.out.println("Errore: comando non riconosciuto"); break;
			}
		}
	}
}