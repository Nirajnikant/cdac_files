package hashTable;

public class HashTable {
	Bucket[] hashTable;
	int size;

	public HashTable(int n) {
		size = n;
		// Create array of references to Bucket, each set to null.
		hashTable = new Bucket[size];
	}

	private int hashFunctionModN(int key) {
		return key % size;
	}

	public void Add(int key) {
		int bucketId = hashFunctionModN(key);

		if (hashTable[bucketId] == null) {
			// Bucket is empty. Create a new Bucket object.
			Bucket head = new Bucket(key);
			hashTable[bucketId] = head;
//			System.out.println(hashTable[bucketId].key);

			return;
		}

		// Bucket is full.
		System.out.println("Collision: Key = " + key + " bucketId = " + bucketId);

		Bucket node = hashTable[bucketId];
//		System.out.println(node.key);
		while(node.next!=null)
			node = node.next;
		
		node.next = new Bucket(key);
	}

	public boolean Search(int key) {
		int bucketId = hashFunctionModN(key);

		if (hashTable[bucketId] == null) {
			// Bucket empty => Key not found.
			return false;
		}
		
		Bucket node = hashTable[bucketId];
//		System.out.println(node.key);
		// Bucket exists, check if it has the key.
		while(node !=null) {
//			System.out.println(node.key);

			if (node.key == key) {
				// Found
				
				System.out.println("Key = " + key + " found in bucketId = " + bucketId);
				return true;
			}
			System.out.println();
			node = node.next;
		}
		return false;
	}
}
