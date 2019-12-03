package queue;
import java.util.*;

public interface Queue<E>
{
	public abstract void enqueue(E element);
	public abstract E dequeue() throws NoSuchElementException;
	public abstract E peek() throws NoSuchElementException;
	public abstract boolean isEmpty();
	public abstract int size();
	public abstract void clear();
}