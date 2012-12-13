package lesson12.map;

public class DefaultEntry implements Map.Entry {
	private final Object key;
	private Object value;

	public String toString(){
		return "[ "+key+", "+ value+ " ]";
	}
	
	public DefaultEntry(Object key, Object value){
		assert key != null : "Key cannot be null";
		this.key = key;
		this.value = value;
	}
	public Object getKey() {
		return key;
	}
	
	public Object setValue(Object value){
		Object oldValue = this.value;
		this.value = value;
		return oldValue;
	}
	
	public Object getValue(){
		return value;
	}
	
	public boolean equals(Object object){
		if(this == object) return true;
		
		if(object == null || this.getClass() != object.getClass()) return false;
		
		DefaultEntry other = (DefaultEntry)object;
		
		return key.equals(other.key) && value.equals(other.value);
	}
}
