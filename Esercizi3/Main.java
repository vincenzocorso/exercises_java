public class Main
{
	public static void main(String[] args)
	{
		String nome = "Vincenzo";
		String cognome = "Corso";
		System.out.println(iniziali(nome, cognome));

		System.out.println("The reverse of \"abcd\" is " + stringReverse("abcd"));

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
			5. Una sequenza di 2 o 3 caratteri minuscoli
		*/
		return email.matches("[\\w&&[^_]]*@[\\w\\.]*\\.[a-z]{2,3}");
	}

	public static boolean isValidEmail(String email)
	{
		boolean nome = true, dominio = false, estensione = false;
		boolean flag = false;

		for(int i = 0; i < email.length(); i++)
		{
			if(nome)
			{
				if(email.charAt(i) == '@')
				{
					nome = false;
					dominio = true;
				}
				else if(!Character.isDigit(email.charAt(i)) || !Character.isLetter(email.charAt(i)) || email.charAt(i) == '_')
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
				else if(!Character.isDigit(email.charAt(i)) || !Character.isLetter(email.charAt(i)))
					return false;
			}
			else if(estensione)
			{
				if(Character.isLetter(email.charAt(i)))
				{
					if(i == email.length() - 1)
						flag = true;
				}
				else if(email.length() - i < 2 && email.length() - i > 3)
					return false;
				else return false;
			}
		}

		return flag;
	}

	public static String fibonacciString(int n)
	{
		String[] dp = new String[1000];
		dp[0] = "";
		dp[1] = "b";
		dp[2] = "a";
		
		int j = 2;
		while(j < n)
		{
			dp[j+1] = dp[j].concat(dp[j-1]);
			j++;
		}

		return dp[n];
	}
}