import java.util.*;

public class InversoMoltiplicativo
{
	public static void main(String[] args)
	{
		boolean flag = false;
		while(!flag)
		{
			try
			{
				Scanner in = new Scanner(System.in);
				System.out.print("Inserisci un numero intero: ");
				int intero = in.nextInt();
				System.out.println("L'inverso moltiplicativo di " + intero + " e' " + (1.0 / intero));
				flag = true;
			}
			catch(InputMismatchException exception)
			{
				System.out.println("Errore: devi inserire un numero intero.");
			}
		}
	}
}