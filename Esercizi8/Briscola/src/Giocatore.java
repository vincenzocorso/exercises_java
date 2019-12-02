package giochicarte;
import java.util.*;

public abstract class Giocatore
{
	protected final String nickname;
	protected ArrayList<Carta> mano = new ArrayList<>();

	public Giocatore(String nickname)
	throws NullPointerException
	{
		if(nickname == null)
			throw new NullPointerException();
		
		this.nickname = nickname;
	}

	public abstract void pescaCarta();

	public abstract Carta giocaCarta();

	@Override
	public String toString()
	{
		return this.nickname;
	}
}