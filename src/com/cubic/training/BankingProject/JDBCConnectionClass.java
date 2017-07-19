package com.cubic.training.BankingProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionClass {
	public Connection GetConnection() throws ClassNotFoundException, SQLException{
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  Connection con=null;
		  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Oracle123");
	     return con;
	  }

}
