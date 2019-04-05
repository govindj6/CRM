package org.nis.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.nis.model.Employees;
import org.nis.model.ServiceCenter;



public class EmployeeController {
	public static String provider="jdbc:mysql://localhost:3306/CRM";
	public static String userid="root";
	public static String password="123";
	
	public static boolean addNewRecord(Employees e)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,userid,password);
			String query="insert into Employees values('"
						+e.getEmployeeid()+"','"
						+e.getEmployeename()+"','"
						+e.getFathername()+"','"
						+e.getDob()+"','"
						+e.getGender()+"','"
						+e.getAddress()+"','"
						+e.getState()+"','"
						+e.getCity()+"','"
						+e.getEmailid()+"','"
						+e.getMobileno()+"','"
						+e.getDesignation()+"','"
						+e.getPassword()+"','"
						+e.getPhotograph()+"')";
			boolean st=DBHelper.executeUpdate(cn, query);
			return st;
		}
		catch(Exception c)
		{
			System.out.println("Error in addNewRecord "+c);
			return false;
		}
	}
	public static ResultSet DisplayAll()
	{ 
		try
		{
		    Class.forName("com.mysql.jdbc.Driver").newInstance();	
			Connection cn=DriverManager.getConnection(provider,userid,password);
		    String query="select * from employees "; 
		    ResultSet rs=DBHelper.executeQuery(cn, query);
		    return(rs);
		}
		catch(Exception e)
		{
			System.out.println("DisplayAll:"+e);
			return(null);
		}
	}
	public static ResultSet DisplayEmployeeById(String eid)
	{ 
		try
		{
		    Class.forName("com.mysql.jdbc.Driver").newInstance();	
			Connection cn=DriverManager.getConnection(provider,userid,password);
		    String query="select * from employees where employeeid='"+eid+"'";
		    System.out.println(query);
		    ResultSet rs=DBHelper.executeQuery(cn, query);
		    return(rs);
		}
		catch(Exception e)
		{
			System.out.println(" Error in DisplayEmployeeById:"+e);
			return(null);
		}
	}
	
	public static boolean editRecord(Employees e)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,userid,password);
			if(!e.getState().equals("-Select-"))
			{}
			String query="update Employees set employeename='"+e.getEmployeename()+"', fathername='"+e.getFathername()+"',dob='"+e.getDob()+"',gender='"+e.getGender()+"',address='"+e.getAddress()+"',state='"+e.getState()+"',city='"+e.getCity()+"',emailid='"+e.getEmailid()+"',mobileno='"+e.getMobileno()+"',designation='"+e.getDesignation()+"' where employeeid='"+e.getEmployeeid()+"'";
			System.out.println(query);
			boolean st=DBHelper.executeUpdate(cn, query);
			return st;
		}
		catch(Exception c)
		{
			System.out.println("Error in editRecord "+c);
			return false;
		}
	}
	public static boolean deleteRecord(String eid)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,userid,password);
			String query="delete from Employees where employeeid='"+eid+"'";
			System.out.println(query);
			boolean st=DBHelper.executeUpdate(cn, query);
			return st;
		}
		catch(Exception c)
		{
			System.out.println("Error in deleteRecord :"+c);
			return false;
		}
	}
	public static boolean editPicture(String filename, String eid)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,userid,password);
			String query="update employees set photograph='"+filename+"' where employeeid='"+eid+"'";
			System.out.println(query);
			boolean st=DBHelper.executeUpdate(cn, query);
			return st;
		}
		catch(Exception c)
		{
			System.out.println("Error in editPicture:"+c);
			return false;
		}
	}
	
	public static Employees checkPassword(String eid,String epwd)
	{ 
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();	
			Connection cn=DriverManager.getConnection(provider,userid,password);
			String query="select * from employees where employeeid='"+eid+"' and password='"+epwd+"'";
	     		 
		     ResultSet rs=DBHelper.executeQuery(cn, query);
		     if(rs.next())
		     { 
		    	 Employees E=new Employees();
		    	 E.setEmployeeid(rs.getString(1));
		    	 E.setEmployeename(rs.getString(2));
		    	 E.setDesignation(rs.getString(11));
		    	 E.setPhotograph(rs.getString(13));
		    	 return(E);
		     }
	    	 return(null);
		}
		catch(Exception e)
		{
			System.out.println("checkpassword:"+e);
			return(null);
		}
	}
	
	public static Employees changePassword(String eid,String npwd)
	{ try{
	   Class.forName("com.mysql.jdbc.Driver").newInstance();	
		Connection cn=DriverManager.getConnection(provider,userid,password);
	     String query="update Employees set password='"+npwd+"' employeeid='"+eid+"' and password='"+npwd+"'";
	     		 
	     ResultSet rs=DBHelper.executeQuery(cn, query);
	     if(rs.next())
	     { Employees A=new Employees();
	    	 A.setEmployeeid(rs.getString(2));
	    	 A.setEmployeename(rs.getString(3));
	    	 return(A);
	    	 
	     }
	    	 
	     return(null);


	}catch(Exception e)
	{System.out.println("Admin controller to check password:"+e);
	 return(null);
	}
	}
}
