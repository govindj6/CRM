package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ComplaintView
 */
@WebServlet("/ComplaintView")
public class ComplaintView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplaintView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<script src=Asset/jquery-2.2.1.min.js></script>");
		out.println("<script src=Asset/states.js></script>");
		out.println("<script src=Asset/company.js></script>");
		out.println("<script src=Asset/servicecenter.js></script>");
		out.println("<html><link href='ui/css/bootstrap.min.css' rel='stylesheet'>");
		out.println("<form action=ComplaintSubmit >");
		 
		out.print("<table class='table table-bordered'>");
		out.println("<caption><b><i>Complaint Register</i></b></caption>");
		Calendar C=Calendar.getInstance();
		String cd=C.get(Calendar.YEAR)+"/"+(C.get(Calendar.MONTH)+1)+"/"+C.get(Calendar.DATE);

		String ct=C.get(Calendar.HOUR)+":"+C.get(Calendar.MINUTE)+":"+C.get(Calendar.SECOND);
	
		String cdd=cd+" "+ct;
		out.println("<tr><td><b><i>Current Date:</i></b></td>");
		out.println("<td><input class='form-control' type=text name=cd size=30 value='"+cdd+"'></td></tr>");
		
		out.println("<tr><td><b><i>Comapany:</i></b></td>");
		out.println("<td><select class='form-control' id=cid name=cid></select></td></tr>");
	
		out.println("<tr><td><b><i>Product<br>Information:</i></b></td>");
		out.println("<td><textarea class='form-control' name=pi rows=6 cols=30></textarea></td></tr></table>");
		out.println("<br><b><i>Customer Details</i><b><br><table>");
	 
		out.println("<tr><td><b><i>Name:</i></b></td>");
		out.println("<td><input class='form-control' type=text name=cname size=30></td></tr>");
	
		out.println("<tr><td><b><i>Mobile:</i></b></td>");
		out.println("<td><input class='form-control' type=text name=cmobile size=30></td></tr>");
	
		out.println("<tr><td><b><i>Address:</i></b></td>");
		out.println("<td><textarea class='form-control' name=add rows=6 cols=30></textarea></td></tr>");
		
		out.println("<tr><td><b><i>State:</i></b></td>");
		out.println("<td><select class='form-control' name=estate id=estate></select></td></tr>");
		
		out.println("<tr><td><b><i>City:</i></b></td>");
		out.println("<td><select class='form-control' name=ecity id=ecity></select></td></tr>");
				
		out.println("<tr><td><b><i>Service Center:</i></b></td>");
		out.println("<td><select class='form-control' id=sid name=sid></select></td></tr>");
		
		out.println("<tr><td><b><i>Communication<br>details:</i></b></td>");
		out.println("<td><textarea class='form-control' name=cmm rows=6 cols=30></textarea></td></tr>");
		 
		out.println("<tr><td><input class='btn btn-success' type=submit></td>");
		out.println("<td><input type=reset class='btn btn-info'></td></tr>");
		out.println("</table></form></html>");
		out.flush();
	}

}
