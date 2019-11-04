import java.util.*;
import java.io.*;

public class ScannerInput
{
	public static void main(String[] args) throws Exception
	{
		File f = new File("input.txt");
		if(f.exists())
		{
			Scanner in = new Scanner(f);

			while(in.hasNextLine())
				System.out.println(in.nextLine());

			in.close();
		}
	}
}