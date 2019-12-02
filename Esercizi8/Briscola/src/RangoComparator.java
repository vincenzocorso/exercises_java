package giochicarte.briscola;
import giochicarte.*;
import java.util.*;

public class RangoComparator implements Comparator<Carta>
{
	@Override
	public int compare(Carta carta1, Carta carta2)
	{
		if(Briscola.getValoreCarta(carta1) < Briscola.getValoreCarta(carta2))
			return -1;
		else if(Briscola.getValoreCarta(carta1) > Briscola.getValoreCarta(carta2))
			return 1;
		else
		{
			if(Briscola.getValoreRango(carta1) < Briscola.getValoreRango(carta2))
				return -1;
			else if(Briscola.getValoreRango(carta1) > Briscola.getValoreRango(carta2))
				return 1;
			else
				return 0;
		}
	}
}