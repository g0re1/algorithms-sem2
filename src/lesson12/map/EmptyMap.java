package lesson12.map;

public class EmptyMap extends HashMap {
	public static void main(String[] args){
		Map map = new EmptyMap();
		map.set("A", 5);
	}
	
	public Object set(Object key, Object value){
		throw new UnsupportedOperationException();
	}
}
