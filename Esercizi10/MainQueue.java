import queue.*;

public class Main
{
	public static void main(String[] args)
	{
		Queue<Integer> queue = new ArrayQueue<>();
		for(int i = 0; i < 15; i++)
			queue.enqueue(i);
		
		while(!queue.isEmpty())
			System.out.println(queue.dequeue());
	}
}