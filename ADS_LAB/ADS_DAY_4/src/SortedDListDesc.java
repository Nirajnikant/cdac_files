public class SortedDListDesc {
	DListNode head;
	DListNode tail;

	public SortedDListDesc() {
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
			if (current.data < element) {
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
	
	public void Delete(int element) {
		if(head == null) {
			System.out.println("list is empty");
			return;
		}
		DListNode current = head;
		while(current != null) {
			if(current.data == element)
				break;
			current = current.next;
		}
		if(current == head) {
			head = current.next;
			current.next.previous = null;
			return;
		}
		if(current == null) {
			System.out.println("Element not in the list");
			return;
		}
		
		if(current.next == null) {
			current.previous.next = null;
			return;
		}
		current.previous.next = current.next;
		current.next.previous = current.previous;
	}
	
	public boolean Search(int element) {
		if(head == null)
			return false;
		
		DListNode current = head;
		current = head;

		while(current != null) {
			if(current.data == element)
				return true;
			current = current.next;
		}
		return false;
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


}
