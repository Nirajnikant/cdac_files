package tester;

import java.util.Scanner;

import com.app.core.*;


public class Tester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {//autocloseable scanner
//			i/f ref
			Stack ref = null;
			boolean flag = false;
			while(!flag) {
				System.out.printf("OPTIONS\n1. Choose Fixed Stack\n2. Choose Growable Stack\n3. Push Data\n4. Pop data And Display\n5. Exit");
				switch(sc.nextInt()) {
				case 1: //Choose Fixed Stack
					if(ref == null)//--stack not yet choosen
						ref = new FixedStack();//up casting
					else
						System.out.println("Already Choosen");
					break;
				case 2:	//choose GrowableStack
					if(ref == null)
						ref = new GrowableStack();
					else 
						System.out.println("Already Choosen");
					break;
				case 3: //Push Data
					if(ref !=null) {// stack choosen
						System.out.println("Enter EMp details : name id salary");
						ref.push(new Emp( sc.next(), sc.nextInt(), sc.nextInt()));//run time poly
					}
					else
						System.out.println("Stack Not choosen");
					break;
				case 4: //Pop data
					if(ref !=null) {// stack choosen
						Emp e = ref.pop();
						if(e!=null)
							System.out.println("Emp Details" + e);
					}
					else
						System.out.println("Stack Not choosen");
					break;
				case 5: //exit 
					flag = true;
					break;
				}
			}
//			sc.close();
		}

	}
}
