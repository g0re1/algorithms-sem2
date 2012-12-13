package lesson1;

public class DummyPredicate implements Predicate{

		private final Iterator _iterator;
		private boolean _result;
		
		public static void main(String[] args ){
			/*final Object[] ARRAY = {"A","B","C","D","E","F"};
			DummyPredicate d = new DummyPredicate(false,new ArrayIterator(ARRAY) );
			*/
		}
		
		public DummyPredicate(boolean result, Iterator iterator){
		_result = result;
		_iterator = iterator;
		_iterator.first();
		}
		
		public boolean evaluate(Object object){
			boolean dupa = ( _iterator.current() == object );
			_iterator.next();
			
			return _result;
		}
}