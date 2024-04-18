package com.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
Connection con=null;
public void connectToDB() throws SQLException 
{
	//step1:Register Driver
	Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	
	//step2:get connection for database
	 con = DriverManager.getConnection(IpathConstant.DBURL, IpathConstant.DBUsername, IpathConstant.DBPassword);

}
public void executeAndgetData(String query,int colIndex,String expData) throws SQLException
{
	//step3:create statement
	Statement state = con.createStatement();
	
	//step4:Execute Query/Update Query
	ResultSet result = state.executeQuery(query);
	boolean flag=false;
	while(result.next())
	{
		String actual = result.getString(colIndex);
		if(actual.contains(expData))
		{
			flag=true;
			break;
		}
	}
	if(flag==true)
	{
		System.out.println("--data is verified--");
	}
	else
	{
		System.out.println("--data is not present--");
	}
}
public void closeDB() throws SQLException
{
	//step5:close DB connection
	con.close();
}
}
