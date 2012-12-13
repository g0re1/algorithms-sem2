package lesson2;

import lesson1.Iterable;

public interface List extends Iterable{
	public boolean delete(int id);
	public Object delete(Object element)throws IndexOutOfBoundsException;
	public int size();
	public void add(Object element);
	public Object set(int index,Object element)throws IndexOutOfBoundsException;
	public Object get(int id) throws IndexOutOfBoundsException;
	public void insert(int index,Object element)throws IndexOutOfBoundsException;
	public boolean contains(Object element);
	public boolean isEmpty();
	public int indexOf(Object element);
	public void clear();
}
