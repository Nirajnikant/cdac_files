package com.app.core;

public class FixedStack implements Stack{
	private Emp[] emps;
	private int top;
	
	public FixedStack() {
		emps = new Emp[STACK_SIZE];
		top = -1;
	}
	//push
	@Override
	public void push(Emp e) {
//		check if stack full
		if (top<STACK_SIZE) 
			emps[++top] = e;
		else 
			System.out.println("Stack overflow!!!");
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
