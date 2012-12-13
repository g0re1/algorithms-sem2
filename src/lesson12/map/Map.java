package lesson12.map;

import lesson1.Iterable;

public interface Map extends Iterable{
	public Object get(Object key);
	public Object set(Object key, Object value);
	public Object delete(Object key);
	public boolean contains(Object key);
	public void clear();
	public int size();
	public boolean isEmpty();
	
	public static interface Entry {
		public Object getKey();
		public Object getValue();
	}
}
