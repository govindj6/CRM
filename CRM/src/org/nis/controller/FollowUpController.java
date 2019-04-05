package org.nis.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.nis.model.FollowUp;

public class FollowUpController {
	public static String provider="jdbc:mysql://localhost:3306/CRM";
	public static String userid="root";
	public static String password="123";
	
	public static boolean addNewRecord(FollowUp F)
	{	
		try
		{
		   Class.forName("com.mysql.jdbc.Driver").newInstance();	
		   Connection cn=DriverManager.getConnection(provider,userid,password);
		   String query="insert into FollowUp(complaintid,currentdate,conversation,employeeid) values('"+F.getComplaintid()+"','"+F.getCurrentdate()+"','"+F.getConversation()+"','"+F.getEmployeeid()+"')";
		      
		   System.out.println(query);
		   boolean st=DBHelper.executeUpdate(cn, query);
		   return(st);
		}
		catch(Exception e)
		{
			System.out.println("addNewRecord:"+e);
			return(false);
		}
	}
	
	public static ResultSet displayComplaintsById(String complaintid)
	{	
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();	
			Connection cn=DriverManager.getConnection(provider,userid,password);
		    String query="select F.transactionid,F.complaintid,F.currentdate,F.conversation,(select E.employeename from employees E where E.employeeid=F.employeeid)as ename from followup F where F.complaintid='"+complaintid+"'";
		      
		    System.out.println(query);
		    ResultSet rs=DBHelper.executeQuery(cn, query);		     
	        return(rs);	   
		}
		catch(Exception e)
		{
			System.out.println("displayComplaintById: "+e);
			return(null);
		}
	}
}
