package p1;

public class FilePrinter implements Printer {

	@Override
	public void print(String mesg) {
		System.out.println("Storing a mesg on the File: "+mesg);
	}
	//can implementation class add new function? YES

	public void closeFileHandle() {
		System.out.println("closing file handle..");
	}
}