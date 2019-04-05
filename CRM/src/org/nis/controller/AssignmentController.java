package org.nis.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.nis.model.Assignment;
import org.nis.model.Companies;



public class AssignmentController {

	public static String provider="jdbc:mysql://localhost:3306/CRM";
	public static String userid="root";
	public static String password="123";
	
	public static boolean addNewRecord(Assignment a)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,userid,password);
			String query="insert into assign (complaintid,engineerid,assigndate)values('"+a.getComplaintid()+"','"
							+a.getEngineerid()+"','"+a.getAssigndate()+"')";
			System.out.println(query);
			boolean st=DBHelper.executeUpdate(cn, query);
			return st;
		}
		catch(Exception c)
		{
			System.out.print("Error in addNewRecord : "+c);
			return false;
		}
	}
	public static ResultSet DisplayEngineersBySCId(String scid)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();	
			Connection cn=DriverManager.getConnection(provider,userid,password);
			String query="select * from engineers where scid='"+scid+"'"; 
			System.out.println(query);
			ResultSet rs=DBHelper.executeQuery(cn, query);
			return(rs);
		}
		catch(Exception e)
		{
			System.out.println("Error in DisplayEngineersBySCId : "+e);
			return null;
		}
	}
	public static boolean editRecord(Assignment a)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,userid,password);
			String query="update assign set remark='"+a.getRemark()+"', remarkdate='"+a.getRemarkdate()+"',status='"+a.getStatus()+"'";
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
}
