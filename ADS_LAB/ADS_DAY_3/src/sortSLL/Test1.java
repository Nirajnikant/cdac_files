package sortSLL;

import java.util.Arrays;
import java.util.Scanner;
import sortSLL.sortedSLL.*;

public class Test1 {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			sortedSLL l = new sortedSLL();
			boolean exit = false;
			try {
				while(!exit) {
					System.out.printf("Select your choice\n1. Add element\n2. Delete element\n3. Delete All\n4. Search\n5. Show Elements\n6. Exit");
					switch(sc.nextInt()) {
						case 1:
							System.out.println("Enter Element to add");
	//						SListNode l1 = new SListNode(sc.nextInt());
							l.Insert(sc.nextInt());
							break;
							
						case 2:
							System.out.println("Enter element to delete ");
							l.Delete(sc.nextInt());
							break;
							
						case 3:
							l.DeleteAll();
							break;
							
						case 4:
							System.out.println("Enter element to search :");
							if(l.Search(sc.nextInt()))
									System.out.println("Found");
							else System.out.println("Not Found");
							break;
							
						case 5:
							System.out.println(Arrays.toString(l.getElements()));
							break;
							
						case 6:
							exit = true;
							
					}
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
