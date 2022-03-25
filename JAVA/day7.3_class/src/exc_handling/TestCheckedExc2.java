package exc_handling;

public class TestCheckedExc2 {

	public static void main(String[] args) throws InterruptedException {
//	invoker of main method main thread
//	who is delegating what, to whom==>
//		main method is delegating the exception handling to it's caller(main thread)
//		
		
//		throws does not handle the exception
		
		//Thread class : public static void sleep (long msec) throws InterruptedException : checked exc
		//javac forces handling of checked excs
			Thread.sleep(5000);
			System.out.println("end of try..");
			
			System.out.println("after sleep");
	}

}
