package giochicarte;
import java.util.*;

public class Mazzo
{
	private ArrayList<Carta> mazzo = new ArrayList<>();
	public static final String[] semi = new String[]{"Bastoni", "Coppe", "Denari", "Spade"};
	public static final String[] ranghi = new String[]{"Asso", "Due", "Tre", "Quattro", "Cinque", "Sei", "Sette", "Donna", "Cavallo", "Re"};

	public Mazzo()
	{
		for(int i = 0; i < Mazzo.semi.length; i++)
			for(int j = 0; j < Mazzo.ranghi.length; j++)
				mazzo.add(new Carta(Mazzo.semi[i], Mazzo.ranghi[j]));
	}

	public int numeroCarte()
	{
		return this.mazzo.size();
	}

	public void mischiaCarte()
	{
		Collections.shuffle(this.mazzo);
	}

	public Carta pescaCarta()
	{
		return this.mazzo.remove(mazzo.size() - 1);
	}

	public void inserisciCarta(Carta carta, int posizione)
	throws NullPointerException, IndexOutOfBoundsException
	{
		if(carta == null)
			throw new NullPointerException();

		this.mazzo.add(posizione, carta);
	}
}