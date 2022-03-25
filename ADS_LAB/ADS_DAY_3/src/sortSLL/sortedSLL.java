package sortSLL;

import core.SListNode;
import custom_exceptions.SListExceptions;

public class sortedSLL {

//	public class Insert {
//
//	}

	SListNode head;
	SListNode current;
	SListNode previous;
	
	public sortedSLL() {
		head = null;
	}
	
	public void Insert(int element) {
		SListNode newNode = new SListNode(element);
		if(head == null) {
			head = newNode;
		}
		else {
			current = head;
			previous = null;
			while(current != null) {
				if(current.data > element)
					break;
				previous = current;
				current = current.next;
			}
			if(current == head) {
				head = newNode;
				newNode.next = current;
				System.out.println(element+" added in front");
			}
			else if(current == null) {
				previous.next = newNode;
				System.out.println(element+ " added at last");
			}
			else {
				previous.next = newNode;
				newNode.next = current;
				System.out.println(element+" added in between");
			}
			
		}
	}
	
	public void Delete(int element) throws SListExceptions {
		if(head == null)
			throw new SListExceptions("List is empty");
		else {
			current = head;
			previous = null;
			while(current != null) {
				if(current.data == element)
					break;
				previous = current;
				current = current.next; 
			}
			if(current == head) {
				head = null;
				System.out.println(current.data);
			}
			else if(current == null) {
				System.out.println(element+ " not found in list");
			}
			else {
				System.out.println(element+ " found in between");
				previous.next= current.next;
			}
		}
	}
	
	public boolean Search(int element) throws SListExceptions{
		if(head == null)
			throw new SListExceptions("List is empty");
		current = head;
		previous = null;
		while(current != null) {
			if(current.data == element)
				return true;
			current = current.next;
		}
		return false;
	}
	
	public void DeleteAll() {
		head = null;
		System.out.println("List is deleted");
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
}
