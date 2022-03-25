package SList;
import SList.SListNode;
import custom_exceptions.SListExceptions;

public class SList {
	SListNode head;
	SListNode tail;

	public SList() {
		head = null;
		tail = null;
	}

	public void AddAtFront(int element) {
		SListNode newNode;
		newNode = new SListNode(element);

		//newNode.data = element;
		//newNode.next = null;

		if (head == null) {
			head = newNode;
			tail = newNode;
			return;
		}

		newNode.next = head;
		head = newNode;
	}

	public void AddAtRear(int element) {
		// Make space for new element, newNode.
		SListNode newNode;
		newNode = new SListNode(element);

		// Store element in newNode's data
		//newNode.data = element;
		// Set newNode's next to empty
		//newNode.next = null;

		// if (list is empty) then
		if (head == null) {
			// Set head and tail to newNode
			head = newNode;
			tail = newNode;
			// Stop
			return;
		}

		// Set tail's next to newNode
		tail.next = newNode;
		// Set tail to newNode
		tail = newNode;
	}

	public int getCount() {
		int count = 0;
		SListNode current;

		current = head;
		while (current != null) {
			++count;
			current = current.next;
		}

		return count;
	}

	public int[] getElements() throws SListExceptions{
		if(head == null)
			throw new SListExceptions("List is Empty");
		int elements[] = new int[getCount()];
		int i = 0;
		SListNode current;

		current = head;
		while (current != null) {
			elements[i] = current.data;
			++i;
			current = current.next;
		}
		return elements;
	}
	
	public int DeleteFirstNode() throws SListExceptions{
		if(head ==  null)
			throw new SListExceptions("List is Empty");
		
			SListNode temp = head;
			head = head.next;
			return temp.data;
		
	}
	
	public int DeleteLastNode() throws SListExceptions{
		if(head == null) {
			throw new SListExceptions("List is Empty");
		}
		if(head == tail) {
			DeleteFirstNode();
		}
		
		SListNode current = head;
		while (current.next != tail)
			current = current.next;
		current.next = null;
		SListNode temp = tail;
		tail = current;
		return temp.data;

	}
}
