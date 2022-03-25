package java8_dates;

//import static java.time.LocalDate.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			LocalDate date = LocalDate.now();
			System.out.println(date);
			LocalTime time = LocalTime.now();
			System.out.println(time);
			LocalDateTime timeStamp = LocalDateTime.now();
			System.out.println(timeStamp);
			//LocalDate.of(int yr, int month, int day)
			System.out.println(LocalDate.of(2010, 5, 24));
			System.out.println(LocalTime.of(4, 42));
			System.out.println("Enter date : yr-month-date");
			System.out.println("You entered "+LocalDate.parse(sc.next()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
