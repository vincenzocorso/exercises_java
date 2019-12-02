import java.util.*;

public class Main
{
	public static boolean consecutivi(Set<Integer> s)
	{
		for(Iterator<Integer> i = s.iterator(); i.hasNext();)
		{
			int n = i.next();
			if(n >= -10 && n <= 9 && s.contains(n+1))
				return true;
		}
		return false;
	}

	public static boolean consecutivi2(Set<Integer> s)
	{
		for(Iterator<Integer> i = s.iterator(); i.hasNext();)
		{
			if(s.contains(i.next() + 1))
				return true;
		}
		return false;
	}

	public static boolean consecutivi3(Set<Integer> s)
	{
		for(Integer i : s)
		{
			if(s.contains(i+1))
				return true;
		}
		return false;
	}

	public static void eliminaPari(Set<Integer> s)
	{
		for(Iterator<Integer> i = s.iterator(); i.hasNext();)
		{
			if(i.next() % 2 == 0)
				i.remove();
		}
	}

	public static void stampaPrimoQuadrante(Set<Punto> p)
	{
		System.out.print("[");
		for(Iterator<Punto> i = p.iterator(); i.hasNext();)
		{
			Punto punto = i.next();
			if(punto.getX() > 0 && punto.getY() > 0)
				System.out.print(punto + " ");
		}
		System.out.println("]");
	}

	public static TreeSet<Persona> ordinaInsiemeDiPersone(HashSet<Persona> hashset, Comparator<Persona> comparator)
	{
		TreeSet<Persona> risultato = new TreeSet<>(comparator);
		for(Iterator<Persona> i = hashset.iterator(); i.hasNext();)
			risultato.add(i.next());
		return risultato;
	}

	public static void findPari(ArrayList<Integer> array)
	{
		for(Iterator<Integer> i = array.iterator(); i.hasNext();)
			if(i.next() % 2 != 0)
				i.remove();
	}

	public static void eliminaDuplicati(ArrayList<Integer> array)
	{
		for(ListIterator<Integer> i = array.listIterator(); i.hasNext();)
		{
			int n = i.next();
			if(array.subList(i.nextIndex(),array.size()).contains(n))
				i.remove();
		}
	}

	public static void main(String[] args)
	{
		Integer[] array = new Integer[]{5, -7, 10, -11, 9};
		Set<Integer> set = new HashSet<>(Arrays.asList(array));
		System.out.println(set);
		System.out.println("consecutivi: " + consecutivi(set));
		System.out.println("consecutivi2: " + consecutivi2(set));
		System.out.println("consecutivi3: " + consecutivi3(set));

		array = new Integer[]{0, 1, 2, 5, 66, 8, 10, 12, 3, 5, 7, -30};
		set = new HashSet<>(Arrays.asList(array));
		System.out.println(set);
		eliminaPari(set);
		System.out.println(set);

		Punto[] array2 = new Punto[]{new Punto(-1,0), new Punto(1,1), new Punto(1,2), new Punto(-4,5)};
		Set<Punto> punti = new HashSet<>(Arrays.asList(array2));
		System.out.println(punti);
		stampaPrimoQuadrante(punti);

		Persona[] array3 = new Persona[]{new Persona("Pippo", "Pluto"), new Persona("Vincenzo", "Corso"), new Persona("Mario", "Rossi"), new Persona("Mario", "Verdi")};
		HashSet<Persona> persone = new HashSet<>(Arrays.asList(array3));
		System.out.println(persone);
		System.out.println(ordinaInsiemeDiPersone(persone, new Comparator<Persona>()
			{
				@Override
				public int compare(Persona p1, Persona p2)
				{
					return p1.toString().compareTo(p2.toString());
				}
			}
		));

		array = new Integer[]{0, 1, 3, 5, 6, 8, 32, -24, 31};
		ArrayList<Integer> arraylist = new ArrayList<>(Arrays.asList(array));
		System.out.println(arraylist);
		findPari(arraylist);
		System.out.println(arraylist);

		array = new Integer[]{0, 1, -3, 5, 1, 0, 7, -3, 3};
		arraylist = new ArrayList<>(Arrays.asList(array));
		System.out.println(arraylist);
		eliminaDuplicati(arraylist);
		System.out.println(arraylist);
	}
}