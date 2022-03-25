public class CircularSortedDList {
	DListNode head;

	public CircularSortedDList() {
		// Create dummy head node.
		head = new DListNode(-1);
		// Set next and previous of head to itself.
		head.next = head;
		head.previous = head;
	}

	public void Insert(int element) {
		// Make memory for new element, say newNode.
		// Store element in newNode's data.
		// Set newNode's next and previous to empty.
		DListNode newNode = new DListNode(element);

		// Find current node, before which newNode is to be added
		// Set current to head's next.
		DListNode current = head.next;
		// while (current is not head) do
		while (current != head) {
			// if (current node's data > element) then
			if (current.data > element) {
				// end the loop
				break;
			}
			// Set current to current's next.
			current = current.next;
		}

		// Adding between two nodes.
		// Set previous node of current as previous of newNode.
		newNode.previous = current.previous;
		// Set current as next of newNode
		newNode.next = current;
		// Set next of current's previous node, to newNode
		current.previous.next = newNode;
		// Set newNode as previous of current
		current.previous = newNode;
		// Stop.
	}
//	Day5 assignment
	public void Delete(int element) {
		if(head == null)
			System.out.println("List is empty");
		
		else {
			DListNode current = head.next;
			while(current != head) {
				if(current.data == element)
					break;
				current = current.next;
			}
			if(current == head)
				System.out.println("Element not in List");
			else {
				current.previous.next = current.next;
				current.next.previous = current.previous;
				System.out.println(current.data+" is deleted from DLL");
			}
		}
		
	}
//	day 5 assignment
	public void DeleteAll() {
		head = null;
		System.out.println("List is Emptyed");
	}


	public int getCount() {
		int count = 0;
		DListNode current;

		current = head.next;
		while (current != head) {
			++count;
			current = current.next;
		}

		return count;
	}
	
	
	public int[] getElements() {
		int elements[] = new int[getCount()];
		int i = 0;
		DListNode current;

		current = head.next;
		while (current != head) {
			elements[i] = current.data;
			++i;
			current = current.next;
		}
		return elements;
	}

	public int[] getElementsInReverse() {
		int elements[] = new int[getCount()];
		int i = 0;
		DListNode current;

		current = head.previous;
		while (current != head) {
			elements[i] = current.data;
			++i;
			current = current.previous;
		}
		return elements;
	}
}
