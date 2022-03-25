package p1;

public class Tester2 {
//	Printer p; // p : interface type of the ref.,  : state :: heap
	public static void main(String[] args) {
		 Printer p;//i/f ref type var, mem allocated in stack : how many bytes : as per the JVM specifications
//		 System.out.println(p);
//		 p = new Printer();
		 //can i/f type of ref directly(w/o typecasting) refer to conceret implementation class instance? YES
		 p = new FilePrinter();// IS-A : implements : upcasting
		 p.print("something..."); //no complier err : since print() : declared in Printer i/f, JVM invokes print : FilePrinter's object
		 
//		 p.closeFileHandle();
		 ((FilePrinter)p).closeFileHandle();// valid downcasting
		 
		 p = new ConsolePrinter();//upcasting
		 p.print("something...");	 
		 ((FilePrinter)p).closeFileHandle();
	}
}