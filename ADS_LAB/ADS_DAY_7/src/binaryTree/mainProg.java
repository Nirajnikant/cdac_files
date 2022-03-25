package binaryTree;

import java.util.Arrays;

public class mainProg {

	public static void main(String[] args) {
		BinaryTree bt01 = new BinaryTree();

		bt01.CreateBinaryTree01();
		int[] result = bt01.Inorder();
		System.out.println(bt01.CountLeafNode());
		System.out.println(Arrays.toString(result));
		
		int[] resultPre = bt01.PreOrder();

		System.out.println(Arrays.toString(resultPre));
		
		int[] resultPost = bt01.PostOrder();

		System.out.println(Arrays.toString(resultPost));

		BST bst01 = new BST();
		bst01.CreateBST01();
		bst01.inOrder();
//		System.out.println(Arrays.toString(resbst));
		bst01.Insert(25);
//		System.out.println(Arrays.toString(bst01.Inorder()));
		bst01.inOrder();

		bst01.Delete(100);
//		System.out.println(Arrays.toString(bst01.Inorder()));
		bst01.inOrder();

		if (bst01.Search(90))
			System.out.println("90 Found");
		else
			System.out.println("90 Not Found");
			
		if (bst01.Search(40))
			System.out.println("40 Found");
		else
			System.out.println("40 Not Found");
	}
}
