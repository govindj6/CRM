package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nis.controller.CompanyController;


/**
 * Servlet implementation class DisplayAllCompanies
 */
@WebServlet("/DisplayAllCompanies")
public class DisplayAllCompanies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllCompanies() {
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
			ResultSet rs=CompanyController.DisplayAll(); 	
			if(rs.next())
			{
				out.println(" <html>   <link href='ui/css/bootstrap.min.css' rel='stylesheet'>");
				out.println("<center>");
				out.println("<body class=body2>");
				out.println("<link rel='stylesheet' href='Asset/him.css' type='text/css' media='all'/>");
				out.println("<a href=CompanyView  class='btn btn-info'>Add New Company</a><br>");
				out.println("<center><h2><b><i>List of Companies</i></b></h2>");
				
				out.println("<table class='table table-bordered'><tr><th>Company Name</th><th>CEO<br>President</th><th>Address</th><th> Contact <br> Details </th><th>LOGO</th><th>Update</th></tr>");	
			    do
			    {
			    	out.println("<tr><td> ID:<i>"+rs.getString(1)+"<br>"+rs.getString(2)+"<br></i></td><td><i>"+rs.getString(3)+"</td><td><i>"+rs.getString(4)+"<br>"+rs.getString(6)+"<br>"+rs.getString(5)+"</i></td><td><i>"+rs.getString(7)+"<br>"+rs.getString(8)+"<br>"+rs.getString(9)+"</i></td><td><img class='img-thumbnail' src=images/company/"+rs.getString(10)+" width=75 height=75></td><td><a href=DisplayCompanyById?cid="+rs.getString(1)+" class='btn btn-info'>Edit/Delete</td></tr>");
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
			out.println("Error in Display All Companies :"+e);	
		}
	}

}
