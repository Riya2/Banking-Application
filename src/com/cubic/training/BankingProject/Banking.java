package com.cubic.training.BankingProject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Banking {
	static Statement st;
	static ResultSet rs;
	static Connection con;
      static SavingsAccount sa;
      
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		UserChoice uc = new UserChoice();
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner br=new Scanner(System.in);
		JDBCConnectionClass jd=new JDBCConnectionClass();
          Connection con = jd.GetConnection();
		
		if (con != null) {
			 System.out.println("Connection succeed");

		} else {
			System.out.println("connection Failed");

		}
		
		System.out.println("Enter your Account number:");
        int Acc_n=br.nextInt();
        st=con.createStatement();
       
        String query="Select * from Account where AccountNumber="+Acc_n;
      
        rs=st.executeQuery(query);
       
        while(rs.next()){
        	// System.out.println( rs.getString(2)+""+ rs.getInt(3));
        	 sa=new SavingsAccount(rs.getDouble(1), rs.getString(2), rs.getDouble(3));
             
        }
        System.out.println("curent balance is:"+ sa.getBalance());
        
       
        uc.userchoise(sa,con);
        uc.UpdateTable(sa,con);
        con.close();
	}
	
}
