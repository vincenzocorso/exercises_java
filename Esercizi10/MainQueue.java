import queue.*;

public class Main
{
	public static void main(String[] args)
	{
		Queue<Integer> queue = new ArrayListQueue<>();
		for(int i = 0; i < 10; i++)
			queue.enqueue(i);
		
		while(!queue.isEmpty())
			System.out.println(queue.dequeue());
	}
}