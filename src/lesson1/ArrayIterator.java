package lesson1;

public class ArrayIterator implements Iterator {
	private Object[] array;
	private int _current=-1;
	private int _first;
	private int _last;
	
	public static void main(String[] args){
			
		Object[] array = new Object[]{"A"};
		ArrayIterator it = new ArrayIterator(array);
		
		it.first();

		System.out.println( it.isDone());
		
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
	
	public ArrayIterator(Object[] array){
		this.array=array;
		_first = 0;
		_last = array.length-1;
	}

	public ArrayIterator(Object[] array, int first, int last) {
		assert array != null : "nie określono tablicy" ;
		assert first >= 0 : "Początek ma być większy/równy od zero";
		assert last  < array.length : "Ostatni element musi być mniejszy od długości tablicy";
		assert last < first : "Ostatni musi byc mniejszy od pierwszego";
		
		this.array = new Object[last-first+1];
		for(int i=first;i<last+1; i++){
			this.array[i-first] = array[i];
		}
		_first = 0;
		_last = this.array.length-1;
	}

	public Object current() throws IteratorOutOfBoundsException {	
		Object current=null;
		try{
			current =  array[_current];
		}

		catch(ArrayIndexOutOfBoundsException e) {throw new IteratorOutOfBoundsException();}
		return current;
	}

	public void first() {
		_current = _first;
	}

	public boolean isDone() {
		return ( (_current < _first ) || (_current > _last) );
	}

	public void last() {
		_current = _last;	
	}

	public void next() {
		_current += 1; 		
	}

	public void previous() {
		_current -= 1; 		
	}

}