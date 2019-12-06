package queue;
import java.util.*;

public class ArrayQueue<E> implements Queue<E>
{
	private E[] queue;
	private int head;
	private int tail;
	private int size;
	private double loadFactor;

	@SuppressWarnings("unchecked")
	public ArrayQueue(int initialCapacity, double loadFactor)
	throws IllegalArgumentException
	{
		if(initialCapacity <= 0 || loadFactor <= 0)
			throw new IllegalArgumentException();

		this.loadFactor = loadFactor;
		this.queue = (E[])new Object[initialCapacity];
		this.head = this.tail = 0;
		this.size = 0;
	}

	public ArrayQueue(int initialCapacity)
	{
		this(initialCapacity, 0.75);
	}

	public ArrayQueue(double loadFactor)
	{
		this(16, loadFactor);
	}

	public ArrayQueue()
	{
		this(16, 0.75);
	}
	
	@Override
	public void enqueue(E element)
	{
		if(this.size > this.loadFactor * this.queue.length)
			this.resize(this.queue.length * 2);

		this.queue[this.tail] = element;
		this.tail = (this.tail + 1) % this.queue.length;
		this.size++;
	}
	
	@Override
	public E dequeue()
	throws NoSuchElementException
	{
		if(this.isEmpty())
			throw new NoSuchElementException();
		
		if(this.size < (1 - this.loadFactor) * this.queue.length)
			this.resize(this.queue.length / 2);

		E element = this.queue[this.head];
		this.head = (this.head + 1) % this.queue.length;
		this.size--;
		return element;
	}
	
	@Override
	public E peek()
	throws NoSuchElementException
	{
		if(this.isEmpty())
			throw new NoSuchElementException();
		
		return this.queue[this.tail-1];
	}
	
	@Override
	public boolean isEmpty()
	{
		if(this.size == 0)
			return true;
		else
			return false;
	}
	
	@Override
	public int size()
	{
		return this.size;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void clear()
	{
		this.queue = (E[])new Object[4];
		this.head = this.tail = 0;
		this.size = 0;
	}

	@SuppressWarnings("unchecked")
	private void resize(int newCapacity)
	{
		E[] newQueue = (E[])new Object[newCapacity];
		int j = 0;
		for(int i = head; i < tail; i = (i+1) % this.queue.length)
			newQueue[j++] = this.queue[i];
		
		this.head = 0;
		this.tail = j;
		this.queue = newQueue;
	}
}