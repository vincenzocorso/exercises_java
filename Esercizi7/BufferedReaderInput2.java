import java.util.*;
import java.io.*;

public class BufferedReaderInput2
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new FileReader("input.txt"));

		int n;
		while((n = in.read()) != -1)
			System.out.print((char)n);

		in.close();
	}
}