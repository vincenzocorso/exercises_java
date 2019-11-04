import java.util.*;
import java.io.*;

public class InputToFile2
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new FileWriter("output.txt"));

		String s;
		while((s = in.readLine()) != null)
			out.println(s);
		
		out.close();
	}
}