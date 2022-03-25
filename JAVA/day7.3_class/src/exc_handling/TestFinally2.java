package exc_handling;

public class TestFinally2 {

	/**
	 * @param args
	 */ 
	public static void main(String[] args) {
		System.out.println("1");
		try {
			testMe();
			System.out.println("back in main");//not printed :exc
		} catch (Exception e) {
			System.out.println("in main's catch-all  " + e);
		} finally {
			System.out.println("in main's finally");
		}
		System.out.println("main over..");

	}

	private static void testMe()  throws InterruptedException     {
		try {
			System.out.println("in meth's try");
			String[] ss = { "aa", "bb" };
			Thread.sleep(1000);//main thread will be sleeping
			System.out.println(ss[2]);//exc : ArrayIndexOutOfBound
			boolean flag = false;
			if (flag)
				return;
			System.out.println("end of try");
		} finally {
			System.out.println("in meth's finally");
		} 
//		only one finally for a finally block
//		finally {
//			System.out.println("in meth's finally again");
//		}
		System.out.println("meth end");// not printed because of exc
		// in case of exc JVM can execute only catch or finally block
	}

}
