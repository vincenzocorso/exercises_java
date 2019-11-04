import java.util.*;
import java.io.*;

public class BufferedReaderInput
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		String s;

		while((s = in.readLine()) != null)
			System.out.println(s);
		
		in.close();
	}
}