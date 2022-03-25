package hashTable;
public class mainProg {
	public static void main(String[] args) {
		HashTable ht = new HashTable(10);

		ht.Add(45); // Store at bucketId 5
		System.out.println("Add(45)");
		ht.Add(16); // Store at bucketId 6
		System.out.println("Add(16)");
		ht.Add(28); // Store at bucketId 8
		System.out.println("Add(28)");
		ht.Add(55); // Collision => Find next empty bucket.
		System.out.println("Add(55)");
		ht.Add(15); // Collision => Find next empty bucket.
		System.out.println("Add(15)");
		ht.Add(105); // Collision => Find next empty bucket.
		System.out.println("Add(105)");

		if (ht.Search(5) == true) {
			System.out.println("5 Found");
		} else {
			System.out.println("5 Not Found");
		}
		if (ht.Search(16) == true) {
			System.out.println("16 Found");
		} else {
			System.out.println("16 Not Found");
		}
		if (ht.Search(105) == true) {
			System.out.println("105 Found");
		} else {
			System.out.println("105 Not Found");
		}
		if (ht.Search(205) == true) {
			System.out.println("205 Found");
		} else {
			System.out.println("205 Not Found");
		}
	}
}
