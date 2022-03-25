package exc_handling;

public class TestCheckedExc {

	public static void main(String[] args) {
		System.out.println("Before Sleep");
		//Thread class : public static void sleep (long msec) throws InterruptedException : checked exc
		//javac forces handling of checked excs
		try {
			Thread.sleep(5000);
			System.out.println("end of try..");
//			the moment there is exception entire try block is aborted and catch is executed thereby
//			handling exception and code after catch is executed
		} catch (InterruptedException e) {
			System.out.println("exc occurred!!!!!");
		}
		System.out.println("after sleep");
	}

}
