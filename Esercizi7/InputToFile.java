import java.util.*;
import java.io.*;

public class InputToFile
{
	public static void main(String[] args) throws Exception
	{
		InputStreamReader in = new InputStreamReader(System.in);
		FileWriter out = new FileWriter("output.txt");

		int c;
		while((c = in.read()) != -1)
			out.write(c);
		
		out.close();
	}
}