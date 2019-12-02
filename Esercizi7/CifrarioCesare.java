import java.util.*;
import java.io.*;

public class CifrarioCesare
{
	private static String cifrario(String input, int chiave, boolean cifra)
	{
		StringBuilder risultato = new StringBuilder();
		for(int i = 0; i < input.length(); i++)
		{
			int c = (int)input.charAt(i);
			char a = (cifra == true) ? (char)((c+chiave) % 256) : (char)((c-chiave) % 256);
			risultato.append("" + a);
		}
		
		return risultato.toString();
	}
	
	public static String cifra(String input, int chiave)
	{
		return cifrario(input, chiave, true);
	}
	
	public static String decifra(String input, int chiave)
	{
		return cifrario(input, chiave, false);
	}
	
	public static void main(String[] args) throws Exception
	{
		// Cifra il contenuto di input.txt e lo salva in output.txt
		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
		
		String s;
		while((s = in.readLine()) != null)
		{
			String rigaCrifrata = cifra(s, 4);
			out.println(rigaCrifrata);
		}
		in.close();
		out.close();
		
		// Decifra il contenuto di output.txt e lo salva in output2.txt
		in = new BufferedReader(new FileReader("output.txt"));
		out = new PrintWriter(new FileWriter("output2.txt"));
		
		while((s = in.readLine()) != null)
		{
			String rigaDecrifrata = decifra(s, 4);
			out.println(rigaDecrifrata);
		}
		in.close();
		out.close();
	}
}