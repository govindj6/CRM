package org.nis.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.nis.model.Admin;
import org.nis.model.Companies;
import org.nis.model.Employees;


public class CompanyController {
	public static String provider="jdbc:mysql://localhost:3306/CRM";
	public static String userid="root";
	public static String password="123";
	
	public static boolean addNewRecord(Companies c)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,userid,password);
			String query="insert into company values('"+c.getCompanyid()+"','"
							+c.getCompanyname()+"','"+c.getOwnername()+"','"
							+c.getAddress()+"','"+c.getState()+"','"
							+c.getCity()+"','"+c.getContactperson()+"','"
							+c.getMobileno()+"','"+c.getEmailid()+"','"+c.getLogo()+"')";
			boolean st=DBHelper.executeUpdate(cn, query);
			return st;
		}
		catch(Exception e)
		{
			System.out.print("Error in addNewRecord : "+e);
			return false;
		}
	}
	public static ResultSet DisplayAll()
	{ 
		try
		{
		    Class.forName("com.mysql.jdbc.Driver").newInstance();	
			Connection cn=DriverManager.getConnection(provider,userid,password);
		    String query="select * from company"; 
		    ResultSet rs=DBHelper.executeQuery(cn, query);
		    return(rs);
		}
		catch(Exception e)
		{
			System.out.println("DisplayAll:"+e);
			return(null);
		}
	}
	public static ResultSet DisplayCompanyById(String cid)
	{ 
		try
		{
		    Class.forName("com.mysql.jdbc.Driver").newInstance();	
			Connection cn=DriverManager.getConnection(provider,userid,password);
		    String query="select * from company where companyid='"+cid+"'"; 
		    System.out.println(query);
		    ResultSet rs=DBHelper.executeQuery(cn, query);
		    return(rs);
		}
		catch(Exception e)
		{
			System.out.println("DisplayCompanyById:"+e);
			return(null);
		}
	}
	public static boolean editRecord(Companies c)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,userid,password);
			String query="update company set companyname='"+c.getCompanyname()+"', ownername='"+c.getOwnername()+"',address='"+c.getAddress()+"',state='"+c.getState()+"',city='"+c.getCity()+"',contactperson='"+c.getContactperson()+"',mobileno='"+c.getMobileno()+"',emailid='"+c.getEmailid()+"' where companyid='"+c.getCompanyid()+"'";
			System.out.println(query);
			boolean st=DBHelper.executeUpdate(cn, query);
			return st;
		}
		catch(Exception e)
		{
			System.out.println("Error in editRecord "+e);
			return false;
		}
	}
	public static boolean deleteRecord(String cid)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,userid,password);
			String query="delete from company where companyid='"+cid+"'";
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
	public static boolean editLogo(String filename, String cid)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,userid,password);
			String query="update company set logo='"+filename+"' where companyid='"+cid+"'";
			System.out.println(query);
			boolean st=DBHelper.executeUpdate(cn, query);
			return st;
		}
		catch(Exception c)
		{
			System.out.println("Error in editLogo:"+c);
			return false;
		}
	}
	public static Companies checkPassword(String cid,String email)
	{ 
		try
		{
		    Class.forName("com.mysql.jdbc.Driver").newInstance();	
			Connection cn=DriverManager.getConnection(provider,userid,password);
			String query="select * from company where companyid='"+cid+"' and emailid='"+email+"'";
	     		 
			ResultSet rs=DBHelper.executeQuery(cn, query);
			if(rs.next())
			{ 
				 Companies A=new Companies();
		    	 A.setCompanyid(rs.getString(1));
		    	 A.setCompanyname(rs.getString(2));
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
	
	public static Companies changePassword(String cid,String npwd)
	{ try{
	   Class.forName("com.mysql.jdbc.Driver").newInstance();	
		Connection cn=DriverManager.getConnection(provider,userid,password);
	     String query="update Company  set password='"+npwd+"' Companyid='"+cid+"' and password='"+npwd+"'";
	     		 
	     ResultSet rs=DBHelper.executeQuery(cn, query);
	     if(rs.next())
	     { Companies  A=new Companies ();
	    	 A.setCompanyid(rs.getString(2));
	    	 A.setCompanyname(rs.getString(3));
	    	 return(A);
	    	 
	     }
	    	 
	     return(null);


	}catch(Exception e)
	{System.out.println("Admin controller to check password:"+e);
	 return(null);
	}
	}
}
