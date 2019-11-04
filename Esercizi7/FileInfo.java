import java.util.*;
import java.io.*;

public class FileInfo
{
	public static void main(String[] args) throws Exception
	{
		int numeroRighe = 0, numeroParole = 0, numeroCaratteri = 0, numeroCaratteriAlfabetici = 0;

		BufferedReader in = new BufferedReader(new FileReader("input.txt"));

		String riga;
		while((riga = in.readLine()) != null)
		{
			numeroRighe++;
			Scanner sc = new Scanner(riga);
			while(sc.hasNext())
			{
				String parola = sc.next();
				numeroParole++;
				numeroCaratteri += parola.length();
				for(int i = 0; i < parola.length(); i++)
				{
					if(Character.isLetter(riga.charAt(i)))
						numeroCaratteriAlfabetici++;
				}
			}
			sc.close();
		}
		in.close();

		System.out.println("numero righe: " + numeroRighe + "\nnumero parole: " + numeroParole);
		System.out.println("\nnumero caratteri: " + numeroCaratteri + "\nnumero c. alfabetici: " + numeroCaratteriAlfabetici);
	}
}