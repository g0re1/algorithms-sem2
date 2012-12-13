package lesson10.hash;

public class BucketingHashTableTest extends AbstractHashTableTest{

	protected HashTable createHashTable(int capacity) {
		return new BucketingHashTable(capacity,0.75f);
	}

}
