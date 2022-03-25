package p5;
//	A      Printer   : superinterface
//	 \		/ 
//	  \    /
//	   \  /
//	     B           : implementation class

//@FunctionalInterface   :: CTE because Functionl interfaces needs to ave only one abstract method
///here there are many abstract methods because of EXTENDS
public interface B extends A,Printer{
	boolean testMe(int num);
}
