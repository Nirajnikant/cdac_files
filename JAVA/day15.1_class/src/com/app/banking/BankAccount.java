package com.app.banking;

import java.time.LocalDate;

import custom_exception.BankingException;

import static utils.ValidationRules.*;

import utils.ValidationRules;

public class BankAccount {
	private int accNo;
	private AccountType acType;
	private double balance;
	private LocalDate creadtionDate;
	private String customerName;
	public BankAccount(int accNo, AccountType acType, double balance, LocalDate creadtionDate, String customerName) {
		super();
		this.accNo = accNo;
		this.acType = acType;
		this.balance = balance;
		this.creadtionDate = creadtionDate;
		this.customerName = customerName;
	}
	
	@Override
	public String toString() {
		return "BankAccount [accNo=" + accNo + ", acType=" + acType + ", balance=" + balance + ", creadtionDate="
				+ creadtionDate + ", customerName=" + customerName + "]";
	}
	
	//Business Logic
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) throws BankingException {
		validateBalance(balance - amount);
		balance -= amount;
	}
	
	//transfer funds
	public void trnsferFunds(BankAccount dest, double amount) throws BankingException {
		this.withdraw(amount);
		dest.deposit(amount);
	}

	public int getAccNo() {
		return accNo;
	}

	public AccountType getAcType() {
		return acType;
	}

	public double getBalance() {
		return balance;
	}

	public LocalDate getCreadtionDate() {
		return creadtionDate;
	}

	public String getCustomerName() {
		return customerName;
	}
}
