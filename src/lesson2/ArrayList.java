package lesson2;

import lesson1.ArrayIterator;
import lesson1.Iterator;

public class ArrayList extends AbstractList {
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	private int size;
	private Object[] array;
	
	public static void main(String[] args ){

		
		Object[] abc = {"A","B","C"} ;
		
		final Object VALUE_A = "A";
		final Object VALUE_B = "B";
		final Object VALUE_C = "C";
		
		
		ArrayList list = new ArrayList(abc);
		list.insert(0, "A");
		
		Iterator it = list.iterator();
		it.first();
		while(!it.isDone()){
			System.out.println(it.current());
			it.next();
		}
		//list.insert(0,VALUE_A);
		//list.insert(0,VALUE_B);

			
		
	}
	
	public ArrayList(){
		array = new Object[DEFAULT_INITIAL_CAPACITY];
		size = 0;
	}
	
	public ArrayList(int length){
		array = new Object[length];
		size=0;
	}

	public ArrayList(Object[] array){
		this.array = new Object[array.length];
		int i=0;
 		while( ( (i<array.length) && (array[i]!=null)) ){
			this.array[i] = array[i];
			i++;
		}
		size=i;
	}

	public void add(Object element) {
		assert element != null : "ArrayList do NOT accept null value";
		
		if(size >= array.length-1){
			Object[] newArray = new Object[size+2*DEFAULT_INITIAL_CAPACITY];
			
			for(int i=0;i<size;i++){
				newArray[i] = array[i];
			}
			array = newArray;
		}
		array[size] = element;
		size++;
	}
	
	public Object get(int id) throws IndexOutOfBoundsException {
		Object element = null;
		try{
			element = array[id];
		}
		catch(IndexOutOfBoundsException e){ throw new IndexOutOfBoundsException();}
		
		if (id > size-1) throw new IndexOutOfBoundsException();
		
		return element;	
	}

	public void clear() {
		array = new Object[size];
		size=0;
	}
	
	public int size() {	
		return size;
	}
	

	public boolean delete(int id) {
		try{
			 get(id);
		}
		catch(IndexOutOfBoundsException e) {return false;}
		
		Object[] newArray = array.clone();		

		for(int j=id;array[j+1]!=null;j++){
			newArray[j] = array[j+1];
		}
		array = newArray;
		size--;
		
		return true;
	}

	public Object delete(Object element) throws IndexOutOfBoundsException {
		
		int	index = indexOf(element);
		if (index==-1)throw new IndexOutOfBoundsException();
	
		delete(index);
		
		return element;
	}

	public int indexOf(Object element) {
		for(int i=0; i<size; i++){
			if (array[i] == element){
				return i;
			}
		}
		
		return -1;
	}
	
	public boolean contains(Object element) {
		 if (indexOf(element) > -1 ) return true;

		return false;
	}

	public void insert(int index, Object element) throws IndexOutOfBoundsException {
		assert element != null : "Element cannot be null";
		if  (size==index) {
			add(element) ;
		}
		else{
		try{
			get(index);
		}
		catch(IndexOutOfBoundsException e) {throw new IndexOutOfBoundsException();}
		
		Object [] newArray = new Object[2*size];
		
		System.arraycopy(array, 0, newArray, 0, index);
		newArray[index] = element;
		System.arraycopy(array, index, newArray, index+1, size-index);
		size++;
		array = newArray;
		}
	}

	public boolean isEmpty() {
		return size == 0 ;
	}

	public Object set(int index, Object element) throws IndexOutOfBoundsException {
		if(index == size){
			add(element);
			return element;
		}
		Object listElement;
		try{
			listElement = get(index);
		}
		catch(IndexOutOfBoundsException e) {throw new IndexOutOfBoundsException();}
		
		array[index] = element;
		return listElement;
	}

	public Iterator iterator() {
		Object [] itArray = new Object[size];
		
		for(int i=0; i<size; i++){
			itArray[i] = array[i] ;
		}
			
		return new ArrayIterator(itArray);
	}
}
