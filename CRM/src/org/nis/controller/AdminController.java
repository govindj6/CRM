package org.nis.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.nis.model.Admin;



public class AdminController {
	private static String path="jdbc:mysql://localhost:3306/CRM";
	private static String user="root";
	private static String password="123";
	
	public static Admin checkPassword(String aid,String pwd)
	{ 
		try
		{
		    Class.forName("com.mysql.jdbc.Driver").newInstance();	
			Connection cn=DriverManager.getConnection(path,user,password);
			String query="select * from admin where aid='"+aid+"' and password='"+pwd+"'";
	     		 
			ResultSet rs=DBHelper.executeQuery(cn, query);
			if(rs.next())
			{ 
				 Admin A=new Admin();
		    	 A.setAdminid(rs.getString(1));
		    	 A.setAdminname(rs.getString(2));
		    	 return(A);
	    	}
	    	return(null);
		}
		catch(Exception e)
		{
			System.out.println("checkpassword:"+e);
			return(null);
		}
	}
}
