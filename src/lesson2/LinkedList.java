package lesson2;

import lesson1.Iterator;
import lesson1.IteratorOutOfBoundsException;

public class LinkedList extends AbstractList  {
	
	private Element warden;
	private Element prev;
	private int size;
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.add(1);
		list.delete(0);
		list.add(2);
		System.out.println(list.get(0));
		
	}
	
	public LinkedList(){
		Element warden = new Element(null);
		this.warden = warden;
		prev = warden;
		size=0;
	}


	public void add(Object el) {
		assert el != null : "Element cannot be null";
		Element element = new Element(el);
		element.setNext(warden);	
		warden.setPrevious(element);
		
		element.setPrevious(prev);
		prev.setNext(element);
		
		size++;
		prev = element;
	}
	
	public void clear() {
		warden.setNext(null);
		warden.setPrevious(null);	
		size=0;
	}

	public boolean contains(Object element) {
		Element next = warden;
		for(int i=0; i < size; i++){
			next = next.getNext();
			if(next.getValue() == element ) return true;
		}
		
		return false;
	}
	
	public boolean delete(int id) {
		if (isOutOfBounds(id)) return false;
		Element el = findElement(id);
		
		Element next = el.getNext(); // this element next
		Element prev = el.getPrevious(); // this element previous
		
		next.setPrevious(prev); // next element previous is now previous.getPrevious
		prev.setNext(next); // prev element next is now next.getNext
		
		size--;
		return true;
	}

	public Object delete(Object element) throws IndexOutOfBoundsException {
		int id = indexOf(element);
		if (id==-1)  throw new IndexOutOfBoundsException();
		
		delete(id);
		
		Element el = new Element(element);
		return el.getValue();
	}

	public Object get(int id) throws IndexOutOfBoundsException {
		if ( isOutOfBounds(id) ) throw new IndexOutOfBoundsException();
				
		Element next = warden.next;
		
		for(int i=0; i<id; i++){
			next = next.getNext();		
		}
		
		return next.getValue();
	}
	
	private boolean isOutOfBounds(int id){
		return ( (id < 0) || (id > size-1) );
	}

	public int indexOf(Object element) {
		Element next = warden;
		
		for(int i=0; i < size; i++){
			next = next.getNext();
			if(next.getValue() == element) return i;
		}
				
		return -1;
	}
	
	private Element findElement(int index){
		assert index>size+1: "Index nie moze byc wiekszy od wielkosci tablicy";
		assert index<0: "Index nie moze byc mniejszy od 0 .. zastanow sie";
		
		Element el;
		
		if(index<size/2){	
			el = warden.next;	
			for(int i=0; i < index; i++){
				el =  el.getNext();
			}
		}
		else{
			el = warden.previous;
			for(int i=0; i < index; i++){
				el = el.getPrevious();
			}
		}
		return el;
	}

	public void insert(int index, Object element) throws IndexOutOfBoundsException {
		assert element != null : "Element cannot be null";
		if( (size==index) ) add(element);
		else{
			
			if(isOutOfBounds(index) )throw new IndexOutOfBoundsException() ;
			Element next = findElement(index);
			
			Element el= new Element(element);
			
			Element nextPrev = next.getPrevious();
			nextPrev.setNext(el);
			next.setPrevious(el);
			
			el.setPrevious(nextPrev);
			el.setNext(next);	
			size++;
		}
	}

	public boolean isEmpty() {
		return (size==0);
	}

	public Object set(int index, Object element)throws IndexOutOfBoundsException {
		if(isOutOfBounds(index) )throw new IndexOutOfBoundsException() ;
		
		Element actual = findElement(index);
		
		Element newEl = new Element(element);
		Element prev = actual.getPrevious();
		Element next = actual.getNext();
		
		// invert actual prev and next to newEl prev and next
		newEl.setNext(next);
		newEl.setPrevious(prev);
		prev.setNext(newEl);
		next.setPrevious(newEl);

		return actual.getValue();
	}


	public int size() {
		return size;
	}

	public Iterator iterator() {
		return new LinkedListIterator();
		
	}
	
/*	public int compareTo(Object other){
		Element actual = prev.getNext();

		return actual.compareTo(other);

	}*/
	
	private class Element{
		private Element previous = null;
		private Element next = null;
		private Object value;
		
		public Element(Object value){
			this.setValue(value);
		}
		
		public void setPrevious(Element previous) {
			this.previous = previous;
		}
		public Element getPrevious() {
			return previous;
		}
		public void setNext(Element next) {
			this.next = next;
		}
		public Element getNext() {
			return next;
		}
		public void setValue(Object value) {
			this.value = value;
		}
		public Object getValue() {
			return value;
		}	
	}	
	
	private class LinkedListIterator implements Iterator{
		Element next = warden;
		Element previous = warden;;
		Element current;

		public Object current() throws IteratorOutOfBoundsException {
			Object obj;
			try{
				obj = current.getValue();
			}
			catch(NullPointerException e){throw new IteratorOutOfBoundsException(); }
			if ( obj == null ) throw new IteratorOutOfBoundsException();
			
			return obj;
		}
		public void first() {
			next = warden.getNext();
			previous = warden.getPrevious();
			current = next;
		}
		public boolean isDone() {
			return ( (next== warden) || (previous == warden) );
		}
		public void last() {
			next = warden.getNext();
			previous = warden.getPrevious();
			current = previous;
		}
		public void next() {
			next = next.getNext();	
			current = next;
		}
		public void previous() {
			previous = previous.getPrevious();
			current = previous;
		}	
	}


}
