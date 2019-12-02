package giochicarte.briscola;
import java.util.*;
import giochicarte.*;

public final class Briscola
{
	static ArrayList<Carta> tavolo;
	static LinkedList<GiocatoreBriscola> giocatori;
	static Carta briscola;
	static Mazzo mazzo;

	private Briscola() {}

	public static int getValoreCarta(Carta carta)
	throws ArrayIndexOutOfBoundsException
	{
		final int[] valori = new int[]{11, 0, 10, 0, 0, 0, 0, 2, 3, 4};
		return valori[Arrays.asList(Mazzo.ranghi).indexOf(carta.getRango())];
	}

	public static int getValoreRango(Carta carta)
	{
		return (1 + Arrays.asList(Mazzo.ranghi).indexOf(carta.getRango()));
	}

	public static boolean isBriscola(Carta carta)
	{
		return carta.getSeme().equals(Briscola.briscola.getSeme());
	}

	public static void main(String[] args)
	{
		System.out.print("Benvenuto nel gioco della briscola...\nInserisci il tuo nome: ");
		Scanner in = new Scanner(System.in);
		String nickname = in.nextLine();

		System.out.println("Scegli il numero di giocatori:\n1. 2 giocatori\n2. 4 giocatori (2 squadre)");
		int scelta = 1;
		boolean modalita = false;
		while(!modalita)
		{
			try
			{
				System.out.print("--> ");
				Scanner intScanner = new Scanner(System.in);
				scelta = intScanner.nextInt();
				if(scelta == 1 || scelta == 2)
					modalita = true;
				else
					System.out.println("Errore: scelta non valida.");
			}
			catch(NoSuchElementException ex)
			{
				System.out.println("Errore: scelta non valida.");
			}
		}

		Briscola.giocatori = new LinkedList<>();
		Briscola.giocatori.add(new GiocatoreBriscola(nickname));
		Briscola.giocatori.add(new IABriscola("CPU_1"));
		if(scelta == 2)
		{
			Briscola.giocatori.add(new IABriscola("CPU_2"));
			Briscola.giocatori.add(new IABriscola("CPU_3"));
			System.out.println("Le squadre sono:\n" + Briscola.giocatori.get(0) + " e " + Briscola.giocatori.get(2));
			System.out.println(Briscola.giocatori.get(1) + " e " + Briscola.giocatori.get(3));
		}
		for(int i = 0; i < (Math.random() * 100) % Briscola.giocatori.size(); i++)
			Briscola.giocatori.addLast(Briscola.giocatori.pollFirst());

		Briscola.mazzo = new Mazzo();
		Briscola.mazzo.mischiaCarte();
		Briscola.briscola = mazzo.pescaCarta();
		mazzo.inserisciCarta(Briscola.briscola, 0);
		for(int i = 0; i < Briscola.giocatori.size() * 2; i++)
			Briscola.giocatori.get(i / 2).pescaCarta();

		int numeroTurni = (scelta == 2) ? 10 : 20;
		for(int t = 1; t <= numeroTurni; t++)
		{
			System.out.println("\nLa briscola e': " + Briscola.briscola);

			tavolo = new ArrayList<>();
			for(int i = 0; i < Briscola.giocatori.size(); i++)
			{
				System.out.println("E' il turno di " + Briscola.giocatori.get(i));
				if(Briscola.mazzo.numeroCarte() > 0)
					Briscola.giocatori.get(i).pescaCarta();
				Carta cartaGiocata = Briscola.giocatori.get(i).giocaCarta();
				System.out.println(Briscola.giocatori.get(i) + " ha giocato " + cartaGiocata);
				Briscola.tavolo.add(cartaGiocata);
			}

			Carta cartaVincente = Briscola.getCartaVincenteSulTavolo();
			GiocatoreBriscola vincitoreTurno = Briscola.giocatori.get(Briscola.tavolo.indexOf(cartaVincente));
			System.out.println("Il turno e' stato vinto da " + vincitoreTurno);
			while(Briscola.giocatori.peek() != vincitoreTurno)
				Briscola.giocatori.addLast(Briscola.giocatori.pollFirst());
			
			for(int i = 0; i < Briscola.tavolo.size(); i++)
				vincitoreTurno.daiPunti(Briscola.getValoreCarta(Briscola.tavolo.get(i)));
		}

		int[] punteggi = new int[]{Briscola.giocatori.get(0).getPunteggio(), Briscola.giocatori.get(1).getPunteggio()};
		for(int i = 2; i < Briscola.giocatori.size(); i++)
			punteggi[i % 2] += Briscola.giocatori.get(i).getPunteggio();

		System.out.println("La vittoria va a: ");
		if(punteggi[0] > punteggi[1])
			for(int i = 0; i < Briscola.giocatori.size(); i+=2)
				System.out.println(Briscola.giocatori.get(i));
		else
			for(int i = 1; i < Briscola.giocatori.size(); i+=2)
				System.out.println(Briscola.giocatori.get(i));
	}

	private static Carta getCartaVincenteSulTavolo()
	{
		Carta cartaMigliore = Briscola.tavolo.get(0);
		for(int i = 1; i < Briscola.tavolo.size(); i++)
		{
			Carta cartaSelezionata = Briscola.tavolo.get(i);
			if(!Briscola.isBriscola(cartaMigliore)) // Se la carta migliore non è briscola
			{
				if(!Briscola.isBriscola(cartaSelezionata)) // Se la carta selezionata non è briscola
				{
					RangoComparator comp = new RangoComparator();
					String semeDiMano = Briscola.tavolo.get(0).getSeme();
					if(cartaSelezionata.getSeme().equals(semeDiMano) && comp.compare(cartaSelezionata, cartaMigliore) > 0)
						cartaMigliore = cartaSelezionata;
				}
				else // Se la carta selezionata è briscola
					cartaMigliore = cartaSelezionata;
			}
			else // Se la carta migliore è briscola
			{
				RangoComparator comp = new RangoComparator();
				if(Briscola.isBriscola(cartaSelezionata) && comp.compare(cartaSelezionata, cartaMigliore) > 0)
					cartaMigliore = cartaSelezionata;
			}
		}

		return cartaMigliore;
	}
}