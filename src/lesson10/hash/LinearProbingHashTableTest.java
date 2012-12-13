package lesson10.hash;

public class LinearProbingHashTableTest extends AbstractHashTableTest {

	protected HashTable createHashTable(int capacity) {
		return new LinearProbingHashTable(capacity);
	}

}
