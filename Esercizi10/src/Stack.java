package stack;
import java.util.*;

public interface Stack<T>
{
	public abstract void push(T elemento);
	public abstract T pop() throws NoSuchElementException;
	public abstract T peek() throws NoSuchElementException;
	public abstract boolean isEmpty();
	public abstract int size();
	public abstract void clear();
}