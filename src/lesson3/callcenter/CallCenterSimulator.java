package lesson3.callcenter;

public class CallCenterSimulator {
	public static void main(String[] args){
		
		CallCenter callCenter = new CallCenter();
		callCenter.open();
		CallGenerator callGen = new CallGenerator(10);
		
		while(true){

			callCenter.accept(callGen.MakeCall());

		}
	}
}
