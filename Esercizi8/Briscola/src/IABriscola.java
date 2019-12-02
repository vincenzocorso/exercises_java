package giochicarte.briscola;
import giochicarte.*;

public class IABriscola extends GiocatoreBriscola
{
	public IABriscola(String nickname)
	throws NullPointerException
	{
		super(nickname);
	}

	@Override
	public Carta giocaCarta()
	{
		return this.mano.remove(0);
	}
}