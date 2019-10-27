import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		CatalogoLibri catalogo = new CatalogoLibri();
		Libro[] risultato;
		Scanner in = new Scanner(System.in);
		int scelta;

		do
		{
			do
			{
				System.out.println("\n| MENU |");
				System.out.println("1. Inserisci libro");
				System.out.println("2. Stampa catalogo");
				System.out.println("3. Ricerca per codice");
				System.out.println("4. Ricerca per titolo");
				System.out.println("5. Ricerca per autore");
				System.out.println("6. Ricerca per prezzo");
				System.out.println("7. Ricerca per casa editrice");
				System.out.println("8. Esci");
				System.out.println("");
				scelta = in.nextInt();
			}
			while(scelta < 1 && scelta > 8);

			System.out.println("");
			switch(scelta)
			{
				case 1:
					Libro b = new Libro();
					catalogo.inserisciLibro(b);
					break;
				
				case 2:
					catalogo.stampa();
					break;
				
				case 3:
					in = new Scanner(System.in);
					int codice;
					do
					{
						System.out.print("Inserisci il codice del libro: ");
						codice = in.nextInt();
					}
					while(codice <= 0);
					System.out.println(catalogo.cercaPerId(codice));
					break;
				
				case 4:
					in = new Scanner(System.in);
					System.out.print("Inserisci il titolo del libro: ");
					String titolo = in.nextLine();
					risultato = catalogo.cercaPerTitolo(titolo);
					for(Libro l : risultato)
						System.out.println(l + "\n");
					break;

				case 5:
					in = new Scanner(System.in);
					System.out.print("Inserisci l'autore del libro: ");
					String autore = in.nextLine();
					risultato = catalogo.cercaPerAutore(autore);
					for(Libro l : risultato)
						System.out.println(l + "\n");
					break;
				
				case 6:
					in = new Scanner(System.in);
					double prezzoMinimo, prezzoMassimo;
					do
					{
						System.out.print("Inserisci il range di prezzo (minimo e massimo): ");
						prezzoMinimo = in.nextDouble();
						prezzoMassimo = in.nextDouble();
					}
					while(prezzoMinimo < 0.0 || prezzoMassimo < 0 || prezzoMinimo > prezzoMassimo);
					risultato = catalogo.cercaPerPrezzo(prezzoMinimo, prezzoMassimo);
					for(Libro l : risultato)
						System.out.println(l + "\n");
					break;
				
				case 7:
					in = new Scanner(System.in);
					System.out.print("Inserisci il nome della casa editrice: ");
					String casaEditrice = in.nextLine();
					risultato = catalogo.cercaPerCasaEditrice(casaEditrice);
					for(Libro l : risultato)
						System.out.println(l + "\n");
					break;
			}
		}
		while(scelta != 8);
	}
}