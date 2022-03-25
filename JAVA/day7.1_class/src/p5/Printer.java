package p5;

@FunctionalInterface
public interface Printer {
	// implicit keyword added by javac : public static final
	int DATA = 12345;
	//methods : public abstract :: implicit keyword added by javac
	void print(String mesg);
}