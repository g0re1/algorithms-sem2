package lesson12.map.exercise;

import lesson11.set.AbstractSetTest;
import lesson11.set.Set;

public class SetWithMapsAsDataStorageTest extends AbstractSetTest {

	protected Set createSet() {
		return new SetWithMapsAsDataStorage();
	}
}
