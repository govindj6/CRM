package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nis.controller.EmployeeController;

/**
 * Servlet implementation class DisplayAllEmployees
 */
@WebServlet("/DisplayAllEmployees")
public class DisplayAllEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllEmployees() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try
		{
			ResultSet rs=EmployeeController.DisplayAll(); 	
			if(rs.next())
			{
				out.println(" <html>   <link href='ui/css/bootstrap.min.css' rel='stylesheet'>");
				out.println("<center>");
				
				
				out.println("<body class=body1><a href=EmployeesView class='btn btn-info'>Add New Employee</a><br>");
				out.println("<link rel='stylesheet' href='Asset/him.css' type='text/css' media='all'/></head>");
				out.println("<center><h2><b><i>List of Employees</i></b></h2><table class='table table-bordered'>");
			    out.println("<tr><th>Name</th><th>Gender<br>/DOB</th><th>Address</th><th>Contact<br>Details</th><th>Photograph</th><th>Edit</th></tr>");	
			    do
			    {
			    	out.println("<tr><td><i>"+rs.getString(1)+"<br>"+rs.getString(2)+"<br>F'Name:"+rs.getString(3)+"</i></td><td><i>"+rs.getString(4)+"<br>"+rs.getString(5)+"</i></td><td><i>"+rs.getString(6)+"<br>"+rs.getString(8)+","+rs.getString(7)+"</i></td><td><i>"+rs.getString(9)+"<br>"+rs.getString(10)+"</i></td><td><i><img src=images/employee/"+rs.getString(13)+" width=50 height=50 class='img-thumbnail'><br>"+rs.getString(11)+"</i></td><td><a class='btn btn-info' href=DisplayEmployeeById?eid="+rs.getString(1)+">Edit/Delete</td></tr>");
			    }while(rs.next());
			    out.println("</table></center></body></html>");				
			}
			else
			{
				out.println("Record Not Found...");	
			}
		}
		catch(Exception e)
		{
			out.println("Error in DisplayAllEmployees :"+e);	
		}
		
	}

}
