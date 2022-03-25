package exc_handling;

public class Test1 {

	public static void main(String[] args) {
		try {
			int a = 10;
//			int b= 0;// to view ArithmaticException uncomment and comment below line
			int b = 3;
			System.out.println("Result "+(a/b));//ArithmeticException: / by zero
//			String s = "a12345";// to view NumberFormateException uncomment and comment below line
			String s = "12345";
			
			System.out.println("int value "+ Integer.parseInt(s));//NumberFormat Exception :because of a in s
//			int[] data = {12,34,678};// to view ArrayIndexOutOfBoundsException uncomment and comment below line
			int[] data = {12,34,678,123};
			System.out.println(data[3]);//ArrayIndexOutOfBoundsException : range of array is less
			String s2 = null;
			System.out.println("char at 0th index "+s2.charAt(0)); //NullPointerException : s2 is null
			System.out.println("End of Try");
		} catch (ArithmeticException | NullPointerException e) {
//		as soon as a line 8 there is AritmaticExceptoin try block searches matching catch 
//		block
			System.out.println("1. AE | NE");
		}
//		catch (ArithmeticException | NullPointerException e) {  // handles both ArithmaticException and Null pointer exception
////			as soon as a line 8 there is AritmaticExceptoin try block searches matching catch 
////			block
//				System.out.println("1. AE | NE");
		}catch(Exception e) {
//		catching all error at once
//		Exception is super class of all exception : upcasting
			System.out.println("in catch all");
			System.out.println("err message" + e.getMessage());
			System.out.println("name and message "+ e);
			e.printStackTrace();
		}
//		catch (NumberFormatException e) {
////			as soon as a line 12 there is NumberFormatException try block searches matching catch 
////			block
//			System.out.println("2. NFE");
//		} catch (ArrayIndexOutOfBoundsException e) {
////			as soon as a line 16 there is NumberFormatException try block searches matching catch 
////			block
//			System.out.println("3. OutOfBound");
//		} catch (NullPointerException e) {
////			as soon as a line 19 there is NullPointerException try block searches matching catch 
////			block
//			System.out.println("3. NPE");
//		}
		System.out.println("main over...");
	}

}
