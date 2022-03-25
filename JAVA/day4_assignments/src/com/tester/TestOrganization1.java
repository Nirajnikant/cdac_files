package com.tester;

import java.util.Scanner;

import com.app.org.Manager;
import com.app.org.Worker;

public class TestOrganization1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("To hire manager enter Manager details in the format name, deptId, basic Salary and performance Bonus");
		String name= sc.next();
		String deptId = sc.next();
		double basic = sc.nextDouble();
		int pBonus = sc.nextInt();
		System.out.println(name+deptId+basic+pBonus);
		Manager m1 = new Manager(name, deptId, basic, pBonus);
		
		System.out.println("To hire Worker enter Worker details in the format name, deptId, basic Salary, hours worked, hourly rate");
		String name1= sc.next();
		String deptId1 = sc.next();
		double basic1 = sc.nextDouble();
		int hrwrk = sc.nextInt();
		int hrrate = sc.nextInt();
		System.out.println(name1+deptId1+basic1+hrwrk+hrrate);
		Worker w1 = new Worker(name1,deptId1,basic1,hrwrk,hrrate);
		
		System.out.println(m1.toString());
		System.out.println(w1.toString());
		sc.close();
	}

}
