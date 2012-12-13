package lesson1;

public class ReverseIterator implements Iterator {
	private Object[] array;
	private int _current=-1;
	private int _first;
	private	int _last;
	private Iterator iterator = null;
	
	public static void main(String[] args) {
		Object[] array = new Object[]{"A","B","C","D","E","F"};
		Iterator iterator = new ArrayIterator(array);
		ReverseIterator it = new ReverseIterator(iterator);
		
		it.first();
		while(!it.isDone()){
			System.out.println(  it.current() );
			it.next();
		}
		
		System.out.println();
		
		it.last();
		while(!it.isDone()){
			System.out.println(  it.current() );
			it.previous();
		}
	}
	
	public ReverseIterator(Iterator iterator){
		this.iterator = iterator;
	}
	
	public Object current() throws IteratorOutOfBoundsException {
		return iterator.current();
	}

	public void first() {
		iterator.last();
	}

	public boolean isDone() {
		return iterator.isDone();
	}

	public void last() {
		iterator.first();	
	}

	public void next() {
		iterator.previous();
	}

	public void previous() {
		iterator.next();
		
	}

}
