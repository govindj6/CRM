package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nis.controller.EngineerController;

/**
 * Servlet implementation class DisplayAllEngineers
 */
@WebServlet("/DisplayAllEngineers")
public class DisplayAllEngineers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllEngineers() {
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
			ResultSet rs=EngineerController.DisplayAll(); 	
			if(rs.next())
			{out.println("<html><link href='ui/css/bootstrap.min.css' rel='stylesheet'>");
		
				out.println("<center>");
				out.println("<body class=body2>");
				out.println("<link rel='stylesheet' href='Asset/him.css' type='text/css' media='all'/>");
				out.println("<a href=EngineersView class='btn btn-success'>Add New Engineer</a><br>");
				out.println("<center><h2><b><i>List of Engineers</i></b></h2>");
				
				out.println("<table class='table table-bordered'><tr><th>Name</th><th>Gender<br>/DOB</th><th>Address</th><th>Contact<br>Details</th><th>Photograph</th><th>Update</th></tr>");	
			    do
			    {
			    	out.println("<tr><td>Service Center ID:<i>"+rs.getString(1)+"<br>Er.ID: "+rs.getString(2)+"<br>"+rs.getString(3)+"<br>F'Name:"+rs.getString(4)+"</i></td><td><i>"+rs.getString(5)+"<br>"+rs.getString(6)+"</i></td><td><i>"+rs.getString(8)+"<br>"+rs.getString(7)+","+rs.getString(9)+"</i></td><td><i>"+rs.getString(10)+"<br>"+rs.getString(11)+"</i></td><td><i><img class='img-thumbnail' src=images/engineer/"+rs.getString(14)+" width=75 height=75><br>"+rs.getString(12)+"</i></td><td><a class='btn btn-info' href=DisplayEngineerById?eid="+rs.getString(2)+">Edit/Delete</td></tr>");
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
			out.println("Error in Display All enngineers :"+e);	
		}
	}

}
