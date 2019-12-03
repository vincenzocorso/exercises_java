package stack;
import java.util.*;

public class LinkedListStack<T> implements Stack<T>
{
	private LinkedList<T> stack = new LinkedList<>();

	@Override
	public void push(T elemento)
	{
		stack.addLast(elemento);
	}

	@Override
	public T pop()
	throws NoSuchElementException
	{
		return stack.removeLast();
	}

	@Override
	public T peek()
	throws NoSuchElementException
	{
		return stack.getLast();
	}

	@Override
	public boolean isEmpty()
	{
		return stack.size() == 0;
	}

	@Override
	public int size()
	{
		return stack.size();
	}

	@Override
	public void clear()
	{
		stack.clear();
	}
}