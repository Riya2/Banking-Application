package com.cubic.training.BankingProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//import com.cubic.training.ProjectBanking.SavingsAccount;

public class UserChoice {
	static Scanner br = new Scanner(System.in);
	static PreparedStatement ps;
	static Statement st;
	static SavingsAccount trans;
	static ResultSet rs1;
	

	// SavingsAccount san;
	// SavingsAccount sa;

	public static void userchoise(SavingsAccount saa, Connection con) throws SQLException {

		System.out.println("Choose the following options:");

		System.out.println();

		System.out.println("1) Cash Deposit " + "\n" + "2) Cash withDrawal" + "\n" + "3) Check Balance" + "\n"
				+ "4) Fixed Deposit" + "\n" + "5) Transfer Money");
		int choice = br.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter amount to be deposited");
			int amount = br.nextInt();
			saa.Deposit(amount);

			break;

		case 2:
			System.out.println("Enter amount to be withdrawal");
			int am = br.nextInt();
			saa.Withdrawal(am);
			break;
		case 3:
			System.out.println("your balnace is:" + saa.getBalance());
			break;

		case 4:
			System.out.println("Fixed deposit");
		case 5:

			System.out.println("Which account you want to tranfer the money?");
			int transac = br.nextInt();
			
			st = con.createStatement();
			rs1 = st.executeQuery("Select * from account where AccountNumber=" + transac);
			System.out.println("You enter the following account...");

			while (rs1.next()) {
				trans = new SavingsAccount(rs1.getDouble(1), rs1.getString(2), rs1.getDouble(3));
				System.out.println(
						"Account name is :" + rs1.getString(2) + "    " + "  Balanace is :" + rs1.getInt(3) + "   ");

			}
			System.out.println("Please enter the amount to be tranfered..");
			int tranferAmt = br.nextInt();
			//System.out.println("Account name:"+ trans.User+   "      "+"Account number"+ trans.AccNumber);
			trans.Deposit(tranferAmt);
			//UpdateTable(trans);
			saa.Withdrawal(tranferAmt);
			UpdateTable(trans, con);
			System.out.println("Transfered Completed");
			
			break;
		default:
			System.out.println("Please enter the valid case.");

		}
	}

	public static void UpdateTable(SavingsAccount sa, Connection con) throws SQLException {
		// if(sa.equals(sa.depo)){
		double newbal = sa.getBalance();

		ps = con.prepareStatement("update Account set balance=? where AccountNumber=?");
		ps.setDouble(1, newbal);
		ps.setDouble(2, sa.AccNumber);
		ps.executeUpdate();

		// }
		/*
		 * else if(sa.equals(sa.draw)){ double newbal1=sa.draw;
		 * 
		 * ps=con.
		 * prepareStatement("update Account set balance=? where AccountNumber=?"
		 * ); ps.setDouble(1, newbal1); ps.setDouble(2, sa.AccNumber);
		 * ps.executeUpdate(); }
		 * 
		 * else{
		 * 
		 * double newbal=trans.depo;
		 * 
		 * ps=con.
		 * prepareStatement("update Account set balance=? where AccountNumber=?");
		 *  ps.setDouble(1, newbal);
		 *  ps.setDouble(2, trans.AccNumber);
		 * ps.executeUpdate();
		 * 
		 * 
		 * double newbal1=sa.draw;
		 * 
		 * ps=con.
		 * prepareStatement("update Account set balance=? where AccountNumber=?"
		 * ); ps.setDouble(1, newbal1); ps.setDouble(2, sa.AccNumber);
		 * ps.executeUpdate();
		 * 
		 * 
		 * }
		 */

	}

}
