package main;

public class RedBlackBST {
	private RedBlackNode root;
	private RedBlackNode rbNode;
	
	public RedBlackBST() {
		rbNode = new RedBlackNode();
		rbNode.color = 0;
		rbNode.left = null;
		rbNode.right = null;
		root = rbNode;
	}

	private void fixDelete(RedBlackNode inNode) {
		RedBlackNode newNode;
		while (inNode != root && inNode.color == 0) {
			if (inNode == inNode.parent.left) {
				newNode = inNode.parent.right;
				if (newNode.color == 1) {
					newNode.color = 0;
					inNode.parent.color = 1;
					rotateLeft(inNode.parent);
					newNode = inNode.parent.right;
				}

				if (newNode.left.color == 0 && newNode.right.color == 0) {
					newNode.color = 1;
					inNode = inNode.parent;
				} else {
					if (newNode.right.color == 0) {
						newNode.left.color = 0;
						newNode.color = 1;
						rotateRight(newNode);
						newNode = inNode.parent.right;
					}

					newNode.color = inNode.parent.color;
					inNode.parent.color = 0;
					newNode.right.color = 0;
					rotateLeft(inNode.parent);
					inNode = root;
				}
			} else {
				newNode = inNode.parent.left;
				if (newNode.color == 1) {
					newNode.color = 0;
					inNode.parent.color = 1;
					rotateRight(inNode.parent);
					newNode = inNode.parent.left;
				}

				if (newNode.right.color == 0 && newNode.right.color == 0) {
					newNode.color = 1;
					inNode = inNode.parent;
				} else {
					if (newNode.left.color == 0) {
						newNode.right.color = 0;
						newNode.color = 1;
						rotateLeft(newNode);
						newNode = inNode.parent.left;
					}

					newNode.color = inNode.parent.color;
					inNode.parent.color = 0;
					newNode.left.color = 0;
					rotateRight(inNode.parent);
					inNode = root;
				}
			}
		}
		inNode.color = 0;
	}

	private void shiftNode(RedBlackNode inNode1, RedBlackNode inNode2) {
		if (inNode1.parent == null) {
			root = inNode2;
		} else if (inNode1 == inNode1.parent.left) {
			inNode1.parent.left = inNode2;
		} else {
			inNode1.parent.right = inNode2;
		}
		inNode2.parent = inNode1.parent;
	}

	private void deleteRBNodeHelper(RedBlackNode RedBlackNode, int key) {
		RedBlackNode rbNode0 = rbNode;
		RedBlackNode rbNode1, rbNode2;
		while (RedBlackNode != rbNode) {
			if (RedBlackNode.data == key) {
				rbNode0 = RedBlackNode;
			}

			if (RedBlackNode.data <= key) {
				RedBlackNode = RedBlackNode.right;
			} else {
				RedBlackNode = RedBlackNode.left;
			}
		}

		if (rbNode0 == rbNode) {
			System.out.println("Couldn't find key in the tree");
			return;
		}

		rbNode2 = rbNode0;
		int yOriginalColor = rbNode2.color;
		if (rbNode0.left == rbNode) {
			rbNode1 = rbNode0.right;
			shiftNode(rbNode0, rbNode0.right);
		} else if (rbNode0.right == rbNode) {
			rbNode1 = rbNode0.left;
			shiftNode(rbNode0, rbNode0.left);
		} else {
			rbNode2 = min(rbNode0.right);
			yOriginalColor = rbNode2.color;
			rbNode1 = rbNode2.right;
			if (rbNode2.parent == rbNode0) {
				rbNode1.parent = rbNode2;
			} else {
				shiftNode(rbNode2, rbNode2.right);
				rbNode2.right = rbNode0.right;
				rbNode2.right.parent = rbNode2;
			}

			shiftNode(rbNode0, rbNode2);
			rbNode2.left = rbNode0.left;
			rbNode2.left.parent = rbNode2;
			rbNode2.color = rbNode0.color;
		}
		if (yOriginalColor == 0) {
			fixDelete(rbNode1);
		}
	}


	private void insertFix(RedBlackNode toFix) {
		RedBlackNode fixBlockNode;
		while (toFix.parent.color == 1) {
			if (toFix.parent == toFix.parent.parent.right) {
				fixBlockNode = toFix.parent.parent.left;
				if (fixBlockNode.color == 1) {
					fixBlockNode.color = 0;
					toFix.parent.color = 0;
					toFix.parent.parent.color = 1;
					toFix = toFix.parent.parent;
				} else {
					if (toFix == toFix.parent.left) {
						toFix = toFix.parent;
						rotateRight(toFix);
					}
					toFix.parent.color = 0;
					toFix.parent.parent.color = 1;
					rotateLeft(toFix.parent.parent);
				}
			} else {
				fixBlockNode = toFix.parent.parent.right;

				if (fixBlockNode.color == 1) {
					fixBlockNode.color = 0;
					toFix.parent.color = 0;
					toFix.parent.parent.color = 1;
					toFix = toFix.parent.parent;
				} else {
					if (toFix == toFix.parent.right) {
						toFix = toFix.parent;
						rotateLeft(toFix);
					}
					toFix.parent.color = 0;
					toFix.parent.parent.color = 1;
					rotateRight(toFix.parent.parent);
				}
			}
			if (toFix == root) {
				break;
			}
		}
		root.color = 0;
	}
	public RedBlackNode min(RedBlackNode RedBlackNode) {
		while (RedBlackNode.left != rbNode) {
			RedBlackNode = RedBlackNode.left;
		}
		return RedBlackNode;
	}

	public void rotateLeft(RedBlackNode inNode) {
		RedBlackNode newNode = inNode.right;
		inNode.right = newNode.left;
		if (newNode.left != rbNode) {
			newNode.left.parent = inNode;
		}
		newNode.parent = inNode.parent;
		if (inNode.parent == null) {
			this.root = newNode;
		} else if (inNode == inNode.parent.left) {
			inNode.parent.left = newNode;
		} else {
			inNode.parent.right = newNode;
		}
		newNode.left = inNode;
		inNode.parent = newNode;
	}

	public void rotateRight(RedBlackNode inNode) {
		RedBlackNode newNode = inNode.left;
		inNode.left = newNode.right;
		if (newNode.right != rbNode) {
			newNode.right.parent = inNode;
		}
		newNode.parent = inNode.parent;
		if (inNode.parent == null) {
			this.root = newNode;
		} else if (inNode == inNode.parent.right) {
			inNode.parent.right = newNode;
		} else {
			inNode.parent.left = newNode;
		}
		newNode.right = inNode;
		inNode.parent = newNode;
	}

	public void insert(int key) {
		RedBlackNode RedBlackNode = new RedBlackNode();
		RedBlackNode.parent = null;
		RedBlackNode.data = key;
		RedBlackNode.left = rbNode;
		RedBlackNode.right = rbNode;
		RedBlackNode.color = 1;

		RedBlackNode node2 = null;
		RedBlackNode node1 = this.root;

		while (node1 != rbNode) {
			node2 = node1;
			if (RedBlackNode.data < node1.data) {
				node1 = node1.left;
			} else {
				node1 = node1.right;
			}
		}

		RedBlackNode.parent = node2;
		if (node2 == null) {
			root = RedBlackNode;
		} else if (RedBlackNode.data < node2.data) {
			node2.left = RedBlackNode;
		} else {
			node2.right = RedBlackNode;
		}

		if (RedBlackNode.parent == null) {
			RedBlackNode.color = 0;
			return;
		}

		if (RedBlackNode.parent.parent == null) {
			return;
		}

		insertFix(RedBlackNode);
	}

	public void deleteNode(int data) {
		deleteRBNodeHelper(this.root, data);
	}
}
