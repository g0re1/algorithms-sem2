package lesson1;

public class PowerCalculator {
	
	public static void main(String[] args ){
	
		System.out.println( INSTANCE.calculate(2,2) );
	}

	public static final PowerCalculator INSTANCE = new PowerCalculator();
	
	private PowerCalculator(){};
	
	public int  calculate(int base, int exponent){
		if ( exponent ==  0)return 0;

		int sum=1;
		
		for(int i=0; i<exponent; i++){
			sum *= base;
		// System.out.println(base+ " " +i);
		}	
		return sum;
		
	}
}
