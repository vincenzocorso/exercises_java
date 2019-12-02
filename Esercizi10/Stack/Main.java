public class Main
{
	public static void main(String[] args)
	{
		Stack<Integer> s = new ArrayStack<>();
		for(int i = 0; i < 100; i++)
			s.push(i);
		
		while(!s.isEmpty())
			System.out.println(s.pop());
	}
}