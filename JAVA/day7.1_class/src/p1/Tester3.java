package p1;

/*
 * 0. Create difference type of Printers(ConsolePrinter, FilePrinter, NetworkPrinter)
 * and access it's common functionality and specific functionality in a single for-each loop.
 */
public class Tester3 {

	public static void main(String[] args) {
		//array of interface type of references
		Printer[] printers = {new FilePrinter(), new ConsolePrinter(), new NetworkPrinter()};//1-array :holder of refs, 3-objs
		for(Printer p : printers) {
//			p=printer[0];p=printer[1];p=printer[2];
			p.print("Text mesg!!!");//run time poly(Dynamic memory dispatch)
			if(p instanceof FilePrinter) {
				((FilePrinter)p).closeFileHandle();
			}
			else
				System.out.println("not a filePrinter.");
			
		}
	}

} 