package binaryTree;

public class BST {
	BTNode root;
	int[] result;
	int count;

	public BST() {
		root = null;
	}

	public boolean Search(int element) {
		// Set current to root.
		BTNode current = root;

		// while (current != empty) do
		while (current != null) {
			// if (element = current's data) then
			if (element == current.data) {
				// FOUND
				// Stop
				return true;
			}

			// if (element < current's data) then
			if (element < current.data) {
				// Set current to current's left child.
				current = current.lChild;
			} else {
				// Set current to current's right child.
				current = current.rChild;
			}
		}

		// NOT FOUND
		return false;
	}

	public void CreateBST01() {
		BTNode n1, n2, n3, n4, n5, n6, n7;

		n1 = new BTNode(50);
		n2 = new BTNode(20);
		n3 = new BTNode(100);
		n4 = new BTNode(10);
		n5 = new BTNode(30);
		n6 = new BTNode(80);
		n7 = new BTNode(90);

		n1.lChild = n2;
		n1.rChild = n3;

		n2.lChild = n4;
		n2.rChild = n5;

		n3.lChild = n6;

		n6.rChild = n7;

		root = n1;
	}
	
	public void Insert(int element) {
		BTNode previous = null;
		BTNode current = root;
		while(current != null) {
			previous = current;
			if(element < current.data)
				current = current.lChild;
			else
				current = current.rChild;
		}
		
		BTNode newNode = new BTNode(element);
		newNode.lChild = null;
		newNode.rChild = null;
		
		if(previous == null)
			root = newNode;
		
		if(element < previous.data)
			previous.lChild = newNode;
		else
			previous.rChild = newNode;
		
	}
	
	public void Delete(int element) {
		
		BTNode previous = null;
		BTNode current = root;
		while(current != null) {
			if(current.data == element)
				break;
			previous = current;
			if(element < current.data)
				current = current.lChild;
			else
				current = current.rChild;
		}
		
		if(current == null) {
			System.out.println("Element Not Found");
			return;
		}
		// Deleting leaf node
		if(current.lChild==null && current.rChild==null) {
			System.out.println(previous.data);
//			if(current == root) {
//				root = null;
//				return;
//			}
			if(current != root) {
				
				if(previous.lChild == current) {
					previous.lChild = null;
					return;
				}
				else {
					previous.rChild = null;
					return;
				}
			}
			else 
				root = null;
			return;
		}
		// Deleting node with only one child?
		if(current.lChild == null) {
			if(current == root) {
				root = current.rChild;
				return;
			}
			if(current == previous.lChild)
				previous.lChild = current.rChild;
			else
				previous.rChild = current.rChild;
			
			return;
		}
		
		if(current.rChild == null) {
			if(current == root) {
				root = current.lChild;
				return;
			}
			if(current == previous.lChild)
//				current.lChild = previous.lChild;
				previous.lChild = current.lChild;
			else
				previous.rChild = current.lChild;
			
			return;
		}
		
		// Deleting a node with two child’s !!!
		BTNode inorderSuccessor = current.rChild;
		BTNode isParent = current;
		while(inorderSuccessor.lChild != null) {
			isParent = inorderSuccessor;
			inorderSuccessor = inorderSuccessor.lChild;
		}
		int tempData = inorderSuccessor.data;
		inorderSuccessor.data = current.data;
		current.data = tempData;
		
		if(inorderSuccessor.lChild==null && inorderSuccessor.rChild==null) {
			if(inorderSuccessor==isParent.lChild)
				isParent.lChild = null;
			else
				isParent.rChild = null;
			
			return;
		}
		
		if(inorderSuccessor==isParent.lChild)
			isParent.lChild = inorderSuccessor.rChild;
		else
			isParent.rChild = inorderSuccessor.rChild;
		
		return;
	}
	
	
	
//	private int getCount(BTNode node) {
//		// if (node is empty) then
//		if (node == null) {
//			// Stop.
//			return 0;
//		}
//
//		int result = 0;
//		// if (node has a left child) then
//		if (node.lChild != null) {
//			// Inorder(node's left child)
//			result += getCount(node.lChild);
//		}
//
//		// Process node.
//		++result;
//
//		// if (node has a right child) then
//		if (node.rChild != null) {
//			// Inorder(node's right child)
//			result += getCount(node.rChild);
//		}
//
//		return result;
//	}
//
//	private void Inorder(BTNode node) {
//		// if (node is empty) then
//		if (node == null) {
//			// Stop.
//			return;
//		}
//
//		// if (node has a left child) then
//		if (node.lChild != null) {
//			// Inorder(node's left child)
//			Inorder(node.lChild);
//		}
//
//		// Process node.
//		//System.out.println(node.data);
//		result[count] = node.data;
//		++count;
//
//		// if (node has a right child) then
//		if (node.rChild != null) {
//			// Inorder(node's right child)
//			Inorder(node.rChild);
//		}
//	}
//
//	public int[] Inorder() {
//		result = new int[getCount(root)];
//		count = 0;
//
//		Inorder(root);
//
//		return result;
//	}
	
	public void inorder(BTNode node)
    {
        if (node == null) {
            return;
        }
 
        inorder(node.lChild);
        System.out.print(node.data + " ");
        inorder(node.rChild);
    }

	public void inOrder() {
		inorder(root);
		System.out.println();
		
	}
}

























