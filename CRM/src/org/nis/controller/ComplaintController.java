package org.nis.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.nis.model.Companies;
import org.nis.model.Complaints;

 

public class ComplaintController {
	private static String path="jdbc:mysql://localhost:3306/CRM";
	private static String user="root";
	private static String password="123";
	
	
	public static boolean addNewRecord(Complaints C)
	{	try{
		   Class.forName("com.mysql.jdbc.Driver").newInstance();	
			Connection cn=DriverManager.getConnection(path,user,password);
		     String query="insert into complaint(currentdate,companyid,productdetails,customername,mobileno,state,city,scid,conversation,status,employeeid,address) values('"+C.getCurrentdate()+"','"+C.getCompanyid()+"','"+C.getProductdetails()+"','"+C.getCustomername()+"','"+C.getMobileno()+"','"+C.getState()+"','"+C.getCity()+"','"+C.getScid()+"','"+C.getConversation()+"','"+C.getStatus()+"','"+C.getEmployeeid()+"','"+C.getAddress()+"')";
		      
		     System.out.println(query);
		     boolean st=DBHelper.executeUpdate(cn, query);
		     return(st);
		   }
		catch(Exception e)
		{System.out.println("addNewRecord:"+e);
		 return(false);
		}
	}
	
 public static int getComplaintNo()
{
	 try
	 {
		 Class.forName("com.mysql.jdbc.Driver").newInstance();	
		 Connection cn=DriverManager.getConnection(path,user,password);
		 String query="select max(complaintid) from complaint";
		 System.out.println(query);
		 ResultSet rs=DBHelper.executeQuery(cn, query);
	     if(rs.next())
	     {
	    	 return(rs.getInt(1));
	     }
	     return(-1);
	 }
	 catch(Exception e)
	 {
		 System.out.println("addNewRecord:"+e);
		 return(-1);
	 }
	
	
}
	
 public static ResultSet searchByComplaintNo(String cmid)
 {
 	 try
 	 {
 		 Class.forName("com.mysql.jdbc.Driver").newInstance();	
 		 Connection cn=DriverManager.getConnection(path,user,password);
 		 String query="select C.complaintid,C.currentdate,(select CM.companyname from company CM where CM.companyid=C.companyid) as cname,C.productdetails,C.customername,C.mobileno,(Select S.statename from states S where S.stateid=C.state)as sname,(select CI.cityname from Cities CI where CI.cityid=C.city) as city,(select SC.firmname from servicecenters SC where SC.scid=C.scid) as fname ,C.conversation,C.status,(select E.employeename from Employees E where E.employeeid=C.employeeid) as ename,C.address  from complaint C where C.complaintid='"+cmid+"'";
 		 System.out.println(query);
 		 ResultSet rs=DBHelper.executeQuery(cn, query);
 	     return(rs);
 	 }
	catch(Exception e)
	{
		System.out.println("Search by comaplaint id :"+e);
		return(null);
	}
 	
 }
 
 public static ResultSet DisplayComplaintByDate(String scid, String fd, String td)
 {
 	 try
 	 {
 		 Class.forName("com.mysql.jdbc.Driver").newInstance();	
 		 Connection cn=DriverManager.getConnection(path,user,password);
 		 String query="select C.complaintid,C.currentdate,(select CM.companyname from company CM where CM.companyid=C.companyid) as cname,C.productdetails,C.customername,C.mobileno,(Select S.statename from states S where S.stateid=C.state)as sname,(select CI.cityname from Cities CI where CI.cityid=C.city) as city,(select SC.firmname from servicecenters SC where SC.scid=C.scid) as fname ,C.conversation,C.status  from complaint C where C.currentdate between '"+fd+"' and '"+td+"' and C.scid='"+scid+"'";
 		 System.out.println(query);
 		 ResultSet rs=DBHelper.executeQuery(cn, query);
 	     return(rs);
 	 }
	catch(Exception e)
	{
		System.out.println("Search by comaplaint id :"+e);
		return(null);
	}
 	
 }
 
}
