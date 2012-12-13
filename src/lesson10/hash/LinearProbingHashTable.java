package lesson10.hash;

public class LinearProbingHashTable implements HashTable {
	private Object[] tbl;
	private int size;
	
	public LinearProbingHashTable(int capacity) {
		assert capacity > 0 :"Capacity must be bigger than 0";
		tbl = new Object[capacity];
		size=0;
	}
	
	public static void main(String[] args){
		LinearProbingHashTable hash = new LinearProbingHashTable(1000);
		for(int i=0; i<10;i++){
			hash.add(String.valueOf(i));
		}	
		
		for(int i=0; i<10;i++){
			hash.add(String.valueOf(i));
		}	
		
		for(int i=0;i<hash.size();i++){
		   System.out.println( hash.contains(String.valueOf(i)) );
		}
		
		hash.show();
	}
	
	public void show(){
		for(int i=0;i<tbl.length;i++){
			System.out.println(tbl[i]);
		}
	}
	
	private void ensureCapacity(){
		if(size >= tbl.length){
			Object[] newTbl = new Object[2*tbl.length];
			for(int i=0;i<tbl.length;i++){
				newTbl[i] = tbl[i];
			}
			tbl = newTbl;
		}
	}
	
	public void add(Object value) {
		assert value != null :"Value cannot be null";
		if(contains(value)) return;
		
		this.ensureCapacity();
		
		String val = String.valueOf(value);
		int hash = Math.abs(val.hashCode()) % (tbl.length-1);
		int copyHash = hash;
		
		do{
			if(hash==tbl.length) hash=0;
			if (isPlace(hash)){
				tbl[hash] = val;
				size++;
				return;
			}
			else{
				hash++;
				}
			}
		while(hash  != copyHash);
	}
	
	private boolean isPlace(int hash){
		return tbl[hash] == null ? true : false;
	}

	public boolean contains(Object value) {
		//String val = String.valueOf(value);
		for(int i=0; i<tbl.length;i++){
			if(tbl[i] == null) continue;
			else if(tbl[i].equals(value)) return true;
		}
		return false;
	}

	public int size() {
		return size;
	}
}
