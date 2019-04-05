package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nis.controller.ServiceCenterController;

/**
 * Servlet implementation class DisplayAllServiceCenters
 */
@WebServlet("/DisplayAllServiceCenters")
public class DisplayAllServiceCenters extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllServiceCenters() {
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
			ResultSet rs=ServiceCenterController.DisplayAll(); 	
			if(rs.next())
			{
				out.println(" <html>   <link href='ui/css/bootstrap.min.css' rel='stylesheet'>");
				out.println("<center>");
				out.println("<body class=body2>");
				out.println("<link rel='stylesheet' href='Asset/him.css' type='text/css' media='all'/>");
				out.println("<a class='btn btn-info' href=ServiceCenterView>Add New ServiceCenter</a><br>");
				out.println("<center><h2><b><i>List of Service Centers</i></b></h2>");
				
				out.println("<table class='table table-bordered'><tr><th>Description</th><th>Owner & <br> Frim Name</th><th>Address</th><th>Contact<br>Details</th><th>Update</th></tr>");	
			    do
			    {
			    	out.println("<tr><td>Service Center ID:<i>"+rs.getString(2)+"</i><br>Company Name: <i>"+rs.getString(1)+"</i></td><td>Owner :<i>"+rs.getString(3)+"<br>"+rs.getString(4)+"</i></td><td><i>"+rs.getString(5)+"<br>"+rs.getString(7)+" "+rs.getString(6)+"</i></td><td>"+rs.getString(9)+"<br>"+rs.getString(8)+"</td><td><a class='btn btn-info' href=DisplaySCById?scid="+rs.getString(2)+">Edit/Delete</td></tr>");
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
			out.println("Error in Display All Service Centers :"+e);	
		}
	}

}
