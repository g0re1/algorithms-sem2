package lesson3.callcenter;

public class Call {
	private int id;
	private long time;
	
	public Call(int id, long time){
		this.id = id;
		this.time = time;
	}
	
	public int getId(){
		return id;
	}
	
	public void realize(){
		System.out.println("Zlecenie : "+id+" = "+id+"  remaining time = "+time);
		try{
			Thread.sleep(time);
			if(id==-1) Thread.currentThread().join();
		}
		catch(InterruptedException e){}
	}
}
