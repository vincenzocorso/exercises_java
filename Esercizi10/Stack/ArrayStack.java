import java.util.*;

public class ArrayStack<T> implements Stack<T>
{
	private T[] stack;
	private int size;
	private double loadFactor;

	@SuppressWarnings("unchecked")
	public ArrayStack(int initialCapacity, double loadFactor)
	throws IllegalArgumentException
	{
		if(initialCapacity < 0 || loadFactor <= 0)
			throw new IllegalArgumentException();

		this.stack = (T[]) new Object[initialCapacity];
		this.size = 0;
		this.loadFactor = loadFactor;
	}

	public ArrayStack(int initialCapacity)
	{
		this(initialCapacity, 0.75);
	}

	public ArrayStack(double loadFactor)
	{
		this(16, loadFactor);
	}

	public ArrayStack()
	{
		this(16, 0.75);
	}

	@Override
	public void push(T elemento)
	{
		if(this.size > this.loadFactor * stack.length)
			this.resize(stack.length * 2);
		this.stack[size++] = elemento;
	}

	@Override
	public T pop()
	throws NoSuchElementException
	{
		if(this.size < (1 - this.loadFactor) * stack.length)
			this.resize(stack.length / 2);
		return this.stack[--size];
	}

	@Override
	public T peek()
	throws NoSuchElementException
	{
		return this.stack[size-1];
	}

	@Override
	public boolean isEmpty()
	{
		return this.size == 0;
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
		this.stack = (T[])new Object[0];
		this.size = 0;
	}

	@SuppressWarnings("unchecked")
	private void resize(int newCapacity)
	{
		System.out.println("New size: " + newCapacity);
		T[] newStack = (T[])new Object[newCapacity];
		System.arraycopy(this.stack, 0, newStack, 0, this.size);
		this.stack = newStack;
	}
}