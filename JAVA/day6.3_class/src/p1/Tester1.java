package p1;

public class Tester1 {

	public static void main(String[] args) {
		// create instance of ConolePrinter
		//direct ref.
		ConsolePrinter printer = new ConsolePrinter();
		printer.print("some message!!!");
		//direct ref. (type of the ref n type of the object : SAME)
		FilePrinter filePrinter = new FilePrinter();
		filePrinter.print("another mesg");
	}
}