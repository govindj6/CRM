package org.nis.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.nis.model.Engineers;

public class EngineerController {
	public static String provider="jdbc:mysql://localhost:3306/CRM";
	public static String userid="root";
	public static String password="123";
	
	public static boolean addNewRecord(Engineers e)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,userid,password);
			String query="insert into engineers values('"+e.getSCid()+"','"
							+e.getEngineerid()+"','"+e.getEngineername()+"','"
							+e.getFathername()+"','"+e.getDob()+"','"
							+e.getGender()+"','"+e.getAddress()+"','"
							+e.getState()+"','"+e.getCity()+"','"+e.getMobno()+"','"
							+e.getEmailid()+"','"+e.getDesignation()+"','"
							+e.getPassword()+"','"+e.getPhoto()+"')";
			boolean st=DBHelper.executeUpdate(cn, query);
			return st;
		}
		catch(Exception c)
		{
			System.out.print("Error in addNewRecord : "+c);
			return false;
		}
	}
	public static ResultSet DisplayAll()
	{ 
		try
		{
		    Class.forName("com.mysql.jdbc.Driver").newInstance();	
			Connection cn=DriverManager.getConnection(provider,userid,password);
		    String query="select * from engineers"; 
		    ResultSet rs=DBHelper.executeQuery(cn, query);
		    return(rs);
		}
		catch(Exception e)
		{
			System.out.println("DisplayAll:"+e);
			return(null);
		}
	}
	public static ResultSet DisplayEngineerById(String eid)
	{ 
		try
		{
		    Class.forName("com.mysql.jdbc.Driver").newInstance();	
			Connection cn=DriverManager.getConnection(provider,userid,password);
		    String query="select * from engineers where engineerid='"+eid+"'"; 
		    System.out.println(query);
		    ResultSet rs=DBHelper.executeQuery(cn, query);
		    return(rs);
		}
		catch(Exception e)
		{
			System.out.println("DisplayEngineerById:"+e);
			return(null);
		}
	}
	public static boolean editRecord(Engineers e)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,userid,password);
			if(!e.getState().equals("-Select-")){}
			String query="update Engineers set scid='"+e.getSCid()+"', engineername='"+e.getEngineername()+"', fathername='"+e.getFathername()+"',dob='"+e.getDob()+"',gender='"+e.getGender()+"',address='"+e.getAddress()+"',state='"+e.getState()+"',city='"+e.getCity()+"',mobno='"+e.getMobno()+"',emailid='"+e.getEmailid()+"',designation='"+e.getDesignation()+"' where engineerid='"+e.getEngineerid()+"'";
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
			String query="delete from Engineers where engineerid='"+eid+"'";
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
			String query="update engineers set photo='"+filename+"' where engineerid='"+eid+"'";
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

public static Engineers checkPassword(String eid,String epwd)
{ 
	try
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,userid,password);
		String query="select * from engineers where engineerid='"+eid+"' and password='"+epwd+"'";

     ResultSet rs=DBHelper.executeQuery(cn, query);
     if(rs.next())
     {
    	 Engineers E=new Engineers();
    	 E.setEngineerid(rs.getString(2));
    	 E.setEngineername(rs.getString(3));
    	 E.setDesignation(rs.getString(12));
    	 E.setPhoto(rs.getString(14));
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
public static Engineers changePassword(String eid,String npwd)
{ try{
   Class.forName("com.mysql.jdbc.Driver").newInstance();	
	Connection cn=DriverManager.getConnection(provider,userid,password);
     String query="update engineer set password='"+npwd+"' engineerid='"+eid+"' and password='"+npwd+"'";
     		 
     ResultSet rs=DBHelper.executeQuery(cn, query);
     if(rs.next())
     { Engineers A=new Engineers();
    	 A.setEngineerid(rs.getString(2));
    	 A.setEngineername(rs.getString(3));
    	 return(A);
    	 
     }
    	 
     return(null);


}catch(Exception e)
{System.out.println("Admin controller to check password:"+e);
 return(null);
}
}
}
