package queue;
import java.util.*;

public class LinkedListQueue<E> implements Queue<E>
{
	private LinkedList<E> queue = new LinkedList<>();
	
	@Override
	public void enqueue(E element)
	{
		queue.addLast(element);
	}
	
	@Override
	public E dequeue()
	throws NoSuchElementException
	{
		return queue.removeFirst();
	}
	
	@Override
	public E peek()
	throws NoSuchElementException
	{
		return queue.get(0);
	}
	
	@Override
	public boolean isEmpty()
	{
		return queue.size() == 0;
	}
	
	@Override
	public int size()
	{
		return queue.size();
	}
	
	@Override
	public void clear()
	{
		queue.clear();
	}
}