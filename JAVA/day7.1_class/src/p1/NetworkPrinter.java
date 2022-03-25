package p1;

public class NetworkPrinter implements Printer {
	//can implementation class access interface constants ? YES   --DATA
	//how? using i/f name.membername OR directly : DIRECTLY
	@Override
	public void print(String mesg) {
		System.out.println("Sending a mesg on the socket to the server: "+mesg);
		System.out.println(DATA);
	}
}