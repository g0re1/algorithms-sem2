package lesson1.exercise;

public class RecursivePowerCalc {
	public static final RecursivePowerCalc INSTANCE = new RecursivePowerCalc();
	
	public static void main(String[] args){
		System.out.println( INSTANCE.calculate(2, 4) );
	}
	
	private RecursivePowerCalc(){}
	
	public long calculate(int base,int exponent){
		if (exponent == 0){return 1;}
		long sum=1;
		
		sum=base*calculate(base, exponent-1);
		
		return sum;
	}

}
