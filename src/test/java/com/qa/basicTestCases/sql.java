package com.qa.basicTestCases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class sql {
	@Test
	public void sqltest() throws SQLException
	{
		String url="jdbc:mysql://localhost:3306/actiTime";
		String username="root";
		String password="mysql";
		Connection con=DriverManager.getConnection(url, username, password);
		System.out.println("connection established");
		Statement stmt=con.createStatement();
		//String s="insert into credentials values('admin','mana')";
		//String s="delete from credentials where username='user'";
		String s="update credentials set password='manager' where username='admin'";
		stmt.executeUpdate(s);
		con.close();
	}

}
