package lesson3.callcenter;

import java.util.Random;

public class CallGenerator {
	private int id=0;
	private int number;
	
	public CallGenerator(int number){
		this.number = number;
	}
	
	public Call MakeCall(){
		Random random = new Random();
		int x = 1000+random.nextInt(5000);
		if(number == id) return new Call(-1,0);
		
		id++;
		return new Call(id,x);
	}
}
