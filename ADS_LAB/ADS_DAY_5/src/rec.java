import java.util.Scanner;

public class rec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the numerator, denominator");
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			int sign = 1;
			if(num1*num2<0)
				sign = -1;
			num1 = Math.abs(num1);
			num2 = Math.abs(num2);
			
			System.out.println("Reminder = "+ (sign*reminder(num1, num2))+" Quotent = "+(sign*division(num1,num2)));
		}
	}

	private static int reminder(int num1, int num2) {
		if(num1<num2)
			return num1;
		return reminder(num1-num2,num2);
	}
	
	private static int division(int num1, int num2) {
		if(num1<num2)
			return 0;
		return 1+division(num1-num2,num2);
	}

}
