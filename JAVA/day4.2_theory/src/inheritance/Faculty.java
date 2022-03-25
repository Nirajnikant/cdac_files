package inheritance;

public class Faculty extends Person{
	private int yrsExp;
	private String subMatter;
	public Faculty(String fn, String ln, int yrsExp, String subMatter) {
		super(fn,ln);
		System.out.println("3");
		this.yrsExp = yrsExp;
		this.subMatter = subMatter;
	}
}
