package lesson5;

import junit.framework.TestCase;

public class ReverseComparatorTest extends TestCase {

		public void testLessThanOther(){
			ReverseComparator comparator = new ReverseComparator(NaturalComparator.INSTANCE);
			assertTrue( comparator.compare("A" ,"B") > 0 );
		}
		public void testEqualToOther(){
			ReverseComparator comparator = new ReverseComparator(NaturalComparator.INSTANCE);
			assertTrue(  comparator.compare("B" ,"B") == 0 );
		}
		public void testGreaterThanOther(){
			ReverseComparator comparator = new ReverseComparator(NaturalComparator.INSTANCE);
			assertTrue(  comparator.compare("B" ,"A") < 0 );
		}


}


