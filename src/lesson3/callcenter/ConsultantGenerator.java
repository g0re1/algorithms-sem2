package lesson3.callcenter;

import lesson3.RealyBlockingQueue;

public class ConsultantGenerator {
	private int id=0;
	private int number;
	
	public ConsultantGenerator(int number){
		this.number = number;
	}
	
	public Consultant makeConsultant(){
		id++;
		return new Consultant(id, new RealyBlockingQueue());
	}

}
