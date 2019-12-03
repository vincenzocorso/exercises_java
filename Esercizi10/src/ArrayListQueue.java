package queue;
import java.util.*;

public class ArrayListQueue<E> implements Queue<E>
{
	private ArrayList<E> queue = new ArrayList<>();
	
	@Override
	public void enqueue(E element)
	{
		queue.add(element);
	}
	
	@Override
	public E dequeue()
	throws NoSuchElementException
	{
		return queue.remove(0);
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