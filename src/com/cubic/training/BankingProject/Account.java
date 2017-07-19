package com.cubic.training.BankingProject;

public abstract class Account {
	private double balance;
	private int interest;

	abstract int Interest(double Amount);

	public Account(double balance) {
		this.balance = balance;
	}

	public void Deposit(double Amount) {
		balance = balance + Amount;
		System.out.println("You have succesfully deposited:"+ balance);
	}

	public void Withdrawal(double Amount) {
		balance = balance - Amount;
		System.out.println("You have successfully withdrawal :"+ balance);
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getInterest() {
		return interest;
	}

	public void setInterest(int interest) {
		this.interest = interest;
	}

}
