package p3;

interface Formula {
	double calculate(double a);//public and abstract
	//public
	default double sqrt(double a, double b) {
		return Math.sqrt(a+b);
	}
	
	//static methods, implicit keyword : public
	static void print(String message) {
		System.out.println("Printing a messsage "+message+" from the interface's static method");
	}
}
