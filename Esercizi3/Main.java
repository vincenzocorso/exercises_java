public class Main
{
	public static void main(String[] args)
	{
		String nome = "Vincenzo";
		String cognome = "Corso";
		System.out.println(iniziali(nome, cognome));

		System.out.println("The reverse of \"ciao\" is " + stringReverse("ciao"));

		System.out.println("Occorrenze: " + contaOccorrenze("AA", "AAAAA"));

		String[] emails = {"vincenzocorso99@gmail.com", "vinc_99@gmai.com", "vinc99gmail.com", "vinc99@gmailcom", "vince99@gm.ail.it", "vinc99@gm.ail.comcom"};
		System.out.println("\nEmail check with regex");
		for(String e : emails)
			System.out.println(e + " is " + (isValidEmailRegex(e) ? "" : "not ") + "valid");
		
		System.out.println("\nEmail check without regex");
		for(String e : emails)
			System.out.println(e + " is " + (isValidEmail(e) ? "" : "not ") + "valid");

		System.out.println("\nFibonacci strings:");
		for(int i = 1; i <= 10; i++)
			System.out.println("fib(" + i + ") = " + fibonacciString(i));
		
		System.out.println("\nRandom strings:");
		for(int i = 0; i <= 10; i++)
			System.out.println(randomString(10, 6));

		System.out.println("\nSum of digit of 12345: " + sumOfDigit(12345));

		System.out.println("\nElimina vocali: " + eliminaVocali("Ciao mi chiamo Vincenzo Corso."));

		System.out.println("\nRappresentazione unaria di 6: " + rappresentazioneUnaria(6));

		System.out.println("\nString capitalize: " + stringCapitalize("Questa e' una stringa"));

		System.out.println("\nciao is anagram of icao? " + isAnagram("ciao", "icao"));
		System.out.println("\nciao is anagram of icaao? " + isAnagram("ciao", "icaao"));
		System.out.println("\nciao is anagram of ziczao? " + isAnagram("ciao", "ziczao"));
		System.out.println("\nciao is anagram of ical? " + isAnagram("ciao", "ical"));
		System.out.println("\nciao is anagram of oaic? " + isAnagram("ciao", "oaic"));
	}

	public static String iniziali(String nome, String cognome)
	{
		return nome.charAt(0) + "&" + cognome.charAt(0);
	}

	public static String stringReverse(String s)
	{
		StringBuilder a = new StringBuilder();

		for(int i = s.length() - 1; i >= 0; i--)
			a.append(s.charAt(i));
		return a.toString();

		/*	oppure ;)
			StringBuilder a = new StringBuilder(s);
			return a.reverse().toString();
		*/
	}

	public static int contaOccorrenze(String pattern, String s)
	{
		int occorrenze = 0;

		int indice = s.indexOf(pattern, 0);
		while(indice != -1)
		{
			occorrenze++;
			indice = s.indexOf(pattern, indice + 1);
		}

		return occorrenze;
	}

	public static boolean isValidEmailRegex(String email)
	{
		/*
			1. Sequenza di caratteri alfanumerici escluso l'underscore
			2. @
			3. Sequenza di caratteri alfanumerici compreso il punto
			4. .
			5. Una sequenza di almeno 2 caratteri minuscoli
		*/
		return email.matches("[\\w&&[^_]]*@[\\w\\.]*\\.[a-z]{2,}");
	}

	public static boolean isValidEmail(String email)
	{
		boolean nome = true, dominio = false, estensione = false;

		for(int i = 0; i < email.length(); i++)
		{
			if(nome)
			{
				if(email.charAt(i) == '@')
				{
					nome = false;
					dominio = true;

					if(email.indexOf(".", i+1) == -1)
						return false;
				}
				else if((!Character.isDigit(email.charAt(i)) && !Character.isLetter(email.charAt(i))) || email.charAt(i) == '_')
					return false;
			}
			else if(dominio)
			{
				if(email.charAt(i) == '.')
				{
					if(email.indexOf(".", i+1) == -1)
					{
						dominio = false;
						estensione = true;
					}
				}
				else if(!Character.isDigit(email.charAt(i)) && !Character.isLetter(email.charAt(i)))
					return false;
			}
			else if(estensione)
			{
				if(!Character.isLetter(email.charAt(i)))
					return false;
			}
		}

		return true;
	}

	public static String fibonacciString(int n)
	{
		StringBuilder i = new StringBuilder("b");
		StringBuilder j = new StringBuilder("a");

		if(n == 1)
			return i.toString();
		else if(n == 2)
			return j.toString();

		for(int k = 2; k < n; k++)
		{
			int j_length = j.length();
			j.append(i);
			i.replace(0, i.length(), j.substring(0, j_length).toString());
		}

		return j.toString();
	}

	public static String randomString(int a, int n)
	{
		StringBuilder risultato = new StringBuilder();
		for(int i = 0; i < n; i++)
			risultato.append(String.valueOf((int)(Math.random() * a)));
		return risultato.toString();
	}

	public static int sumOfDigit(int n)
	{
		String a = String.valueOf(n);
		int risultato = 0;

		for(int i = 0; i < a.length(); i++)
			risultato += Integer.parseInt("" + a.charAt(i));
		
		return risultato;
	}

	public static boolean isAnagram(String a, String b)
	{
		StringBuilder temp = new StringBuilder(b);

		for(int i = 0; i < a.length(); i++)
		{
			int index = temp.indexOf("" + a.charAt(i));
			if(index != -1)
				temp.deleteCharAt(temp.indexOf("" + a.charAt(i)));
			else return false;
		}

		return (temp.length() != 0) ? false : true;
	}

	public static String eliminaVocali(String s)
	{
		return s.replaceAll("[aeiou]", "");
	}

	public static String rappresentazioneUnaria(int n)
	{
		StringBuilder s = new StringBuilder();
		for(int i = 1; i <= n; i++)
			s.append("0");
		return s.toString();
	}

	public static String stringCapitalize(String s)
	{
		StringBuilder risultato = new StringBuilder(s);
		risultato.setCharAt(0, Character.toUpperCase(risultato.charAt(0)));

		for(int i = 1; i < s.length(); i++)
		{
			if(Character.isWhitespace(s.charAt(i)))
			{
				i++;
				risultato.setCharAt(i, Character.toUpperCase(risultato.charAt(i)));
			}
		}

		return risultato.toString();
	}
}