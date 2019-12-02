import java.util.*;
import java.io.*;

public class AddLinesNumber
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
		
		String s;
		int count = 0;
		while((s = in.readLine()) != null)
		{
			out.print(++count + "\t");
			out.println(s);
		}
		
		in.close();
		out.close();
	}
}