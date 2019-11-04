import java.util.*;
import java.io.*;

public class CopyFile2
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		PrintWriter out = new PrintWriter(new FileWriter("output.txt"));

		String c;
		while((c = in.readLine()) != null)
			out.println(c);

		in.close();
		out.close();
	}
}