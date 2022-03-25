package com.app.core;

public class GrowableStack extends FixedStack{
	private Emp[] emps;
	private int top;
	private int size = STACK_SIZE;
	
	public GrowableStack() {
		emps = new Emp[STACK_SIZE];
		top = -1;
	}
	//push
	@Override
	public void push(Emp e) {
//		check if stack full
		if (top < emps.length-1)
			emps[++top] = e;
		else {
//			create a NEW array : double original capacity
			Emp[] tmp = new Emp[emps.length*2];
//			array copy : for loop
			for(int i=0;i<emps.length-1;i++) {
				tmp[i] = emps[i];
//				reassign emps --> newly created array, marking old array for GC
				emps = tmp;
				emps[++top] = e;
			}
		}
	
		emps[++top] = e;
	}
	//pop
	@Override
	public Emp pop() {
//		check if stack empty
		if(top == -1) {
			System.out.println("Stack Overflow!!!!");
			return null;
		}
		return emps[top--];
	}
}
