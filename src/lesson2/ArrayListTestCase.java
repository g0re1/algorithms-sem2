package lesson2;

public class ArrayListTestCase extends AbstractListTestCase{

	protected List createList() {
		return new ArrayList();
	}
	
	public void testResiseBeyondDefaultArraySize(){
		List list = new ArrayList(1);
		
		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_C);
		
		assertEquals(3,list.size() );
		
		
		assertSame(VALUE_C,list.get(2));
	}
	
	public void testDeleteFromLastElement(){
		List list = new ArrayList(1);
		
		list.add(VALUE_A);
		list.delete(0);
		
		assertTrue(list.isEmpty());
	}
	

}
