package com.cubic.training.BankingProject;

public class SavingsAccount extends Account {
	double AccNumber;
	String User;
	
	
    public SavingsAccount(double acc ,String user,double balance) {
    	super(balance);
		this.AccNumber=acc;
		this.User=user;
	}





	@Override
	int Interest(double Amount) {
		// TODO Auto-generated method stub
		return 0;
	}


}
