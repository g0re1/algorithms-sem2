package lesson4;

public class ListStackTestCase extends AbstractStackTestCase {
	private Stack stack = createStack();

	protected Stack createStack() {
		return new ListStack();
	}

}
