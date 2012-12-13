package lesson1;

public interface Iterator {
	public void first();
	public void last();
	public boolean isDone();
	public void next();
	public void previous();
	public Object current() throws IteratorOutOfBoundsException;
}
