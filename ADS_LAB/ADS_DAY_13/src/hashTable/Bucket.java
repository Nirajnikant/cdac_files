package hashTable;

public class Bucket {
	int key;
//	boolean isCollision;
	Bucket next;

	public Bucket(int key) {
//		isCollision = false;
		this.key = key;
		this.next = null;
	}
}
