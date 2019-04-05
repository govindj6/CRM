package org.nis.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.nis.model.Admin;
import org.nis.model.Engineers;
import org.nis.model.ServiceCenter;

public class ServiceCenterController {
	private static String provider="jdbc:mysql://localhost:3306/CRM";
	private static String userid="root";
	private static String password="123";
	public static boolean addNewRecord(ServiceCenter S)
	{ 
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();	
			Connection cn=DriverManager.getConnection(provider,userid,password);
			String query="insert into servicecenters values('"+S.getCompanyId()+"','"+S.getSCid()+"','"+S.getOwnername()+"','"+S.getFirmName()+"','"+S.getAddress()+"','"+S.getState()+"','"+S.getCity()+"','"+S.getEmailid()+"','"+S.getMobileno()+"')";
			boolean st=DBHelper.executeUpdate(cn, query);
			return(st);
		}
		catch(Exception e)
		{
			System.out.println("addNewRecord:"+e);
			return(false);
		}
	}
	
	public static ResultSet DisplayAll()
	{ 
		try
		{
		    Class.forName("com.mysql.jdbc.Driver").newInstance();	
			Connection cn=DriverManager.getConnection(provider,userid,password);
		    String query="select * from servicecenters"; 
		    ResultSet rs=DBHelper.executeQuery(cn, query);
		    return(rs);
		}
		catch(Exception e)
		{
			System.out.println("DisplayAll:"+e);
			return(null);
		}
	}
	public static ResultSet DisplayServiceCenterById(String scid)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();	
			Connection cn=DriverManager.getConnection(provider,userid,password);
			String query="select * from servicecenters where scid='"+scid+"'";
			ResultSet rs=DBHelper.executeQuery(cn, query);
			return(rs);
		}
		catch(Exception e)
		{
			System.out.println("DisplayServiceCenterById:"+e);
			return null;
		}
	}
	public static ResultSet DisplayServiceCenterByCompanyId(String cid)
	{ 
		try
		{
		    Class.forName("com.mysql.jdbc.Driver").newInstance();	
			Connection cn=DriverManager.getConnection(provider,userid,password);
		    String query="select * from servicecenters where companyid='"+cid+"'";
		    ResultSet rs=DBHelper.executeQuery(cn, query);
		    return(rs);
		}
		catch(Exception e)
		{
			System.out.println("addNewRecord:"+e);
			return(null);
		}
	}
	public static ResultSet DisplayServiceCenterByCompanyId_CityId(String cid,String cityid)
	{ 
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();	
			Connection cn=DriverManager.getConnection(provider,userid,password);
			String query="select * from servicecenters where companyid='"+cid+"' and city='"+cityid+"'";
			ResultSet rs=DBHelper.executeQuery(cn, query);
			return(rs);
		}
		catch(Exception e)
		{
			System.out.println("DisplayServiceCenterByCompanyId_CityId:"+e);
			return(null);
		}
	}
	public static boolean editRecord(ServiceCenter s)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,userid,password);
			String query="update servicecenters set companyid='"+s.getCompanyId()+"', ownername='"+s.getOwnername()+"',firmname='"+s.getFirmName()+"',address='"+s.getAddress()+"',state='"+s.getState()+"',city='"+s.getCity()+"',mobileno='"+s.getMobileno()+"',emailid='"+s.getEmailid()+"' where scid='"+s.getSCid()+"'";
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
	public static boolean deleteRecord(String sid)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,userid,password);
			String query="delete from servicecenters where scid='"+sid+"'";
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
	public static ServiceCenter checkPassword(String sid,String pwd)
	{ 
		try
		{
		    Class.forName("com.mysql.jdbc.Driver").newInstance();	
			Connection cn=DriverManager.getConnection(provider,userid,password);
			String query="select * from servicecenters where scid='"+sid+"' and password='"+pwd+"'";
	     		 
			ResultSet rs=DBHelper.executeQuery(cn, query);
			if(rs.next())
			{ 
				 ServiceCenter S=new ServiceCenter();
		    	 S.setSCid(rs.getString(2));
		    	 S.setFirmName(rs.getString(4));
		    	 S.setCompanyId(rs.getString(1));
		    	 S.setCity(rs.getString(7));
		    	 S.setState(rs.getString(8));
		    	 return(S);
	    	}
	    	return(null);
		}
		catch(Exception e)
		{
			System.out.println("checkpassword:"+e);
			return(null);
		}
	}
	
	
	public static ServiceCenter changePassword(String sid,String npwd)
	{ try{
	   Class.forName("com.mysql.jdbc.Driver").newInstance();	
		Connection cn=DriverManager.getConnection(provider,userid,password);
	     String query="update servicecenyter set password='"+npwd+"' engineerid='"+sid+"' and password='"+npwd+"'";
	     		 
	     ResultSet rs=DBHelper.executeQuery(cn, query);
	     if(rs.next())
	     { ServiceCenter A=new ServiceCenter();
	    	 A.setSCid(rs.getString(2));
	    	 A.setOwnername(rs.getString(3));
	    	 return(A);
	    	 
	     }
	    	 
	     return(null);


	}catch(Exception e)
	{System.out.println("Admin controller to check password:"+e);
	 return(null);
	}
	}
}
