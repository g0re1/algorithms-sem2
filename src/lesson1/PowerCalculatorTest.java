package lesson1;
import junit.framework.TestCase;

public class PowerCalculatorTest extends TestCase{
	
	public void testPowerOfZeroIsNone(){
		PowerCalculator calculator = PowerCalculator.INSTANCE;
		
		assertEquals(0,calculator.calculate(0,0) );
		assertEquals(0,calculator.calculate(1,0) );
		assertEquals(0,calculator.calculate(27,0) );
		assertEquals(0,calculator.calculate(143,0) );

	}
	public void testPowerOfOneIsItself(){
		PowerCalculator calculator = PowerCalculator.INSTANCE;
		
		assertEquals(0,calculator.calculate(0,1) );
		assertEquals(1,calculator.calculate(1,1) );
		assertEquals(27,calculator.calculate(27,1) );
		assertEquals(143,calculator.calculate(143,1) );	
	}
	public void testArbitrary(){
		PowerCalculator calculator = PowerCalculator.INSTANCE;
		
		assertEquals(4,calculator.calculate(2,2) );	
		assertEquals(8,calculator.calculate(2,3) );	
		assertEquals(27,calculator.calculate(3,3) );	
		assertEquals(1024,calculator.calculate(2,10) );		
	}
}
