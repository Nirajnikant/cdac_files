package p1;

public class ConsolePrinter implements Printer {
	@Override
	public void print(String mesg) {
		System.out.println("Printing a mesg on the console: "+mesg);
	}
}
