package lesson2;

import lesson1.Iterator;

public class EmptyList implements List {
	
	public static void main(String[] args){
		List list = new EmptyList();
		list.add(1);
	}

	@Override
	public void add(Object element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object delete(Object element) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object get(int id) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insert(int index, Object element)
			throws IndexOutOfBoundsException {
		 throw new UnsupportedOperationException();
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object set(int index, Object element)
			throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
