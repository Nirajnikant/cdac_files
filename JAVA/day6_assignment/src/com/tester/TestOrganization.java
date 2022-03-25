package com.tester;

import java.util.Scanner;

import com.app.org.*;
import static com.app.org.Emp.offset;

public class TestOrganization {

	public static void main(String[] args) {
		Emp[] employee = new Emp[5];
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		int counter = 0;
		while(!exit) {	
			System.out.printf("Options\n1. Hire Manager\n2. Hire Worker\n3. Display info of all Employee\n4. Update basic Salary\n5.Exit");
			switch (sc.nextInt()) {
				case 1://Hire Manager
					if(counter < employee.length) {
						System.out.println("Enter Manager Details: name , deptID, basic Salary, performance Bonus");
						employee[counter++] = new Mgr(sc.next(),sc.next(), sc.nextDouble(), sc.nextDouble());//upcasting
					}
					else
						System.out.println("Event Full!!!");
					break;	
				case 2://Hire Worker
					if(counter < employee.length) {
						System.out.println("Enter Worker Details: name , deptID, basic Salary, Hours Worked, Hourly Rate");
						employee[counter++] = new Worker(sc.next(),sc.next(), sc.nextDouble(), sc.nextInt(), sc.nextDouble());//upcasting
					}
					else
						System.out.println("Event Full!!!");
					break;
				case 3://Display all information
					for(Emp e : employee) {
						if(e!=null) {
							System.out.println(e);
							System.out.println("Net Salary = "+e.netSalary());
							if(e instanceof Mgr)
								System.out.println(((Mgr) e).getPerformanceBonus());
							else
								System.out.println(((Worker)e).getHourlyRate());
						}
					}
					break;
				case 4: //update basic salary
					System.out.println("Enter Employee Id");
					
					int id = sc.nextInt()-offset;
					if(id < counter && id >= 0) {
						System.out.println("Enter increment in basic");
						Emp e1 = employee[id];
						e1.setBasic(e1.getBasic()+sc.nextDouble());
						System.out.println("basic salary update...");
					}
					else {
						System.out.println("Entered id is not valid");
					}
					break;
				case 5:
					exit = true;
					break;
			}
		}
		sc.close();
	}

}