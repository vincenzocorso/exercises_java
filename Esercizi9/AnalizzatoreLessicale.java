import java.util.*;
import java.io.*;

public class AnalizzatoreLessicale
{
	public static void main(String[] args)
	{
		try
		(
			BufferedReader filein = new BufferedReader(new FileReader("testo.txt"));
			PrintWriter fileout = new PrintWriter(new FileWriter("output.txt"));
		)
		{
			Map<String, Integer> occorrenze = new HashMap<>();
			Scanner in = new Scanner(filein);
			while(in.hasNext())
			{
				String parola = in.next();
				if(occorrenze.containsKey(parola))
					occorrenze.put(parola, occorrenze.get(parola) + 1);
				else
					occorrenze.put(parola, 1);
			}
			System.out.println(occorrenze);

			Set<Map.Entry<String, Integer>> set = occorrenze.entrySet();
			List<Map.Entry<String, Integer>> list = new ArrayList<>(set);
			Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
				{
					@Override
					public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2)
					{
						return e2.getValue().compareTo(e1.getValue());
					}
				}
			);
			for(Map.Entry<String, Integer> entry : list)
				fileout.println(entry.getKey() + ": " + entry.getValue());
		}
		catch(IOException ex)
		{
			System.out.println("Errore: impossibile trovare il file.");
		}
	}
}