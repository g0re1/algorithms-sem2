package lesson1.exercise;

import junit.framework.TestCase;

public class RecursivePowerCalcTest extends TestCase{
	RecursivePowerCalc calc = RecursivePowerCalc.INSTANCE;
	
	public void testCalculate(){
		assertEquals(16, calc.calculate(2, 4) );
		assertEquals(1, calc.calculate(2, 0) );
	}
	
}
