import java.util.Arrays;

public class mainProg {
	public static void main(String[] args) {
		SortedDListDesc l = new SortedDListDesc();

		l.Insert(10);
		l.Insert(5);
		l.Insert(20);
		l.Insert(1);
		l.Insert(15);

		System.out.println(Arrays.toString(l.getElements()));
		
		l.Delete(1);
		System.out.println(Arrays.toString(l.getElements()));
		System.out.println(l.Search(5));
		System.out.println(l.Search(12));

	}

}
