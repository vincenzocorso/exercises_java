import java.util.*;

public class DistribuzioneNumeri
{
	public static void main(String[] args)
	{
		Map<Integer, Integer> frequenzeNumeri = new TreeMap<Integer, Integer>();
		Random generatoreNumeri = new Random();
		for(int i = 1; i <= 1000000000; i++)
		{
			Integer numeroCasuale = generatoreNumeri.nextInt(10);
			
			if(frequenzeNumeri.containsKey(numeroCasuale))
				frequenzeNumeri.put(numeroCasuale, frequenzeNumeri.get(numeroCasuale) + 1);
			else
				frequenzeNumeri.put(numeroCasuale, 1);
		}
		System.out.println(frequenzeNumeri);
	}
}