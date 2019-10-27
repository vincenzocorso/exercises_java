import java.util.*;

public class MainArray
{
	public static void main(String[] args)
	{
		int[] array = new int[]{1, 2, 3, 3, 4, 4, 3, 6, 6, 1, 6};
		stampaArray(array);

		double media = mediaValori(new int[]{1, 2, 3, 4, 6});
		System.out.println("Media: " + media);

		int[] pari = selezionaPari(new int[]{0, 1, 2, 3, 4, 5, 6});
		stampaArray(pari);

		int[] nonDuplicati = eliminaDuplicati(new int[]{1, 1, 1, 1, 1, 1});
		stampaArray(nonDuplicati);
		nonDuplicati = eliminaDuplicati(new int[]{1, 2, 2, 2, 3, 4});
		stampaArray(nonDuplicati);

		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6}));
		selezionaPari(list);
		System.out.println(list);

		ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 2, 2, 2, 3, 6}));
		eliminaDuplicati(list2);
		System.out.println(list2);

		ArrayList<Integer> list3 = new ArrayList<Integer>(Arrays.asList(new Integer[]{2, 2, 2, 2, 2, 2}));
		eliminaDuplicati(list3);
		System.out.println(list3);
	}

	public static void stampaArray(int[] array)
	{
		System.out.print("[");
		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array[i]);
			if(i != array.length - 1)
				System.out.print(", ");
		}
		System.out.println("]");
	}

	public static double mediaValori(int[] array)
	{
		double totale = 0;
		
		for(int i : array)
			totale += i;
		
		return totale / array.length;
	}

	public static int[] selezionaPari(int[] array)
	{
		int taglia = 0;
		for(int i : array)
			if(i % 2 == 0)
				taglia++;
		
		int[] risultato = new int[taglia];

		for(int i = 0, j = 0; i < array.length; i++)
		{
			if(array[i] % 2 == 0)
				risultato[j++] = array[i];
		}

		return risultato;
	}

	public static int[] eliminaDuplicati(int[] array)
	{
		if(array.length == 0)
			return null;

		Arrays.sort(array);
		int taglia = 1;
		for(int i = 1, j = 0; i < array.length; i++)
		{
			if(array[j] != array[i])
			{
				taglia++;
				j = i;
			}
		}

		int[] risultato = new int[taglia];

		risultato[0] = array[0];
		for(int i = 1, j = 0, k = 1; i < array.length; i++)
		{
			if(array[j] != array[i])
			{
				j = i;
				risultato[k++] = array[j];
			}
		}
		
		return risultato;
	}

	public static void selezionaPari(ArrayList<Integer> array)
	{
		for(int i = 0; i < array.size(); i++)
			if(array.get(i) % 2 != 0)
				array.remove(i);
	}

	public static void eliminaDuplicati(ArrayList<Integer> array)
	{
		Collections.sort(array);
		int j = 0;
		while(j < array.size() - 1)
		{
			if(array.get(j) == array.get(j+1))
				array.remove(j+1);
			else j++;
		}
	}
}