import java.util.*;

public class ArrayListStack<T> implements Stack<T>
{
	private ArrayList<T> stack = new ArrayList<>();

	@Override
	public void push(T elemento)
	{
		stack.add(elemento);
	}

	@Override
	public T pop()
	throws NoSuchElementException
	{
		return stack.remove(stack.size() - 1);
	}

	@Override
	public T peek()
	throws NoSuchElementException
	{
		return stack.get(stack.size() - 1);
	}

	@Override
	public boolean isEmpty()
	{
		return stack.isEmpty();
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