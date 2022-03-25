public class SortedDList {
	DListNode head;
	DListNode tail;

	public SortedDList() {
		head = null;
		tail = null;
	}

	public void Insert(int element) {
		// Make memory for new element, say newNode.
		// Store element in newNode's data.
		// Set newNode's next and previous to empty.
		DListNode newNode = new DListNode(element);

		// Empty list?
		// if list is empty then
		if (head == null) {
			// Set head and tail to newNode.
			head = newNode;
			tail = newNode;
			// Stop.
			return;
		}

		// List is not empty. Find current node, before which newNode is to be added
		// Set current to head.
		DListNode current = head;
		// while (current is not empty) do
		while (current != null) {
			// if (current node's data > element) then
			if (current.data > element) {
				// end the loop
				break;
			}
			// Set current to current's next.
			current = current.next;
		}

		// Adding before first node?
		// if (current is head node) then
		if (current == head) {
			// Set current as next to newNode
			newNode.next = current;
			// Set newNode as previous of current.
			current.previous = newNode;
			// Set newNode as head.
			head = newNode;
			// Stop.
			return;
		}

		// Adding after last node?
		// if (current is empty) then
		if (current == null) {
			// Set newNode as next of tail.
			tail.next = newNode;
			// Set tail as previous of newNode.
			newNode.previous = tail;
			// Set newNode as tail.
			tail = newNode;
			// Stop.
			return;
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

	public int getCount() {
		int count = 0;
		DListNode current;

		current = head;
		while (current != null) {
			++count;
			current = current.next;
		}

		return count;
	}

	public int[] getElements() {
		int elements[] = new int[getCount()];
		int i = 0;
		DListNode current;

		current = head;
		while (current != null) {
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

		current = tail;
		while (current != null) {
			elements[i] = current.data;
			++i;
			current = current.previous;
		}
		return elements;
	}
}
