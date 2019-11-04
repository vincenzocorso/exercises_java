import java.util.*;
import java.io.*;

public class CopyFile
{
	public static void main(String[] args) throws Exception
	{
		FileReader in = new FileReader("input.txt");
		FileWriter out = new FileWriter("output.txt");

		int c;
		while((c = in.read()) != -1)
			out.write(c);

		in.close();
		out.close();
	}
}