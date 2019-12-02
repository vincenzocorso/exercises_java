package giochicarte.briscola;
import java.util.*;
import giochicarte.*;

public class GiocatoreBriscola extends Giocatore
{
	protected int punteggio;

	public GiocatoreBriscola(String nickname)
	throws NullPointerException
	{
		super(nickname);
	}

	public int getPunteggio()
	{
		return this.punteggio;
	}

	public void daiPunti(int punti)
	throws IllegalArgumentException
	{
		if(punti < 0)
			throw new IllegalArgumentException();

		this.punteggio += punti;
	}

	@Override
	public void pescaCarta()
	{
		this.mano.add(Briscola.mazzo.pescaCarta());
	}

	@Override
	public Carta giocaCarta()
	{
		System.out.println("Le tue carte sono: ");
		for(int i = 0; i < this.mano.size(); i++)
			System.out.print((i+1) + ". " + this.mano.get(i) + "    ");
		System.out.println("");
		
		Carta carta = null;
		boolean scelta = false;
		while(!scelta)
		{
			try
			{
				Scanner in = new Scanner(System.in);
				System.out.print("-> ");
				carta = this.mano.remove(in.nextInt() - 1);
				scelta = true;
			}
			catch(NoSuchElementException ex)
			{
				System.out.println("Errore: devi inserire un intero.");
			}
			catch(IndexOutOfBoundsException ex)
			{
				System.out.println("Errore: scelta non valida.");
			}
		}

		return carta;
	}

	@Override
	public String toString()
	{
		return super.toString() + " (" + this.punteggio + ")";
	}
}