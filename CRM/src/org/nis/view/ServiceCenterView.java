package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServiceCenterView
 */
@WebServlet("/ServiceCenterView")
public class ServiceCenterView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceCenterView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<html><link href='ui/css/bootstrap.min.css' rel='stylesheet'>");
		 out.println("<script src=Asset/jquery-2.2.1.min.js></script>");
		out.println("<script src=Asset/states.js></script>");
		out.println("<script src=Asset/company.js></script>");
	
		out.println("<form action=ServiceCenterSubmit>");
		out.println("<center>");
		out.println("<body class=body2>");
		out.println("<a class='btn btn-success' href=DisplayAllServiceCenters>Display All Service Centers</a><br>");
		out.println("<center><h2><i>Service Center Register</i></h2>");
		out.print("<table class='table table-bordered'>");
		
		out.println("<tr><td><b><i>Company Id:</i></b></td>");
		out.println("<td><select class='form-control' name=cid id=cid></select></td></tr>");
		
		out.println("<tr><td><b><i>Service Center Id:</i></b></td>");
		out.println("<td><input class='form-control' type=text name=sid size=30></td></tr>");
		
		out.println("<tr><td><b><i>Service Center Owner Name:</i></b></td>");
		out.println("<td><input class='form-control' type=text name=sofn placeholder='First Name' size=30>&nbsp;&nbsp;<input class='form-control' type=text name=soln placeholder='Second Name' size=30></td></tr>");
		out.println("<tr><td><b><i>Firm Name:</i></b></td>");
		out.println("<td><input class='form-control' type=text name=sn  size=30></td></tr>");
	
		out.println("<tr><td><b><i>Address:</i></b></td>");
		out.println("<td><textarea class='form-control' row=3 cols=30 name=sadd ></textarea></td></tr>");
		
		out.println("<tr><td><b><i>State:</i></b></td>");
		out.println("<td><select class='form-control' name=sstate id=estate></select></td></tr>");
		
		out.println("<tr><td><b><i>City:</i></b></td>");
		out.println("<td><select class='form-control' name=scity id=ecity></select></td></tr>");
		
		out.println("<tr><td><b><i>Email Id:</i></b></td>");
		out.println("<td><input class='form-control' type=email name=sm size=30></td></tr>");
		
		out.println("<tr><td><b><i>Mobile:</i></b></td>");
		out.println("<td><input class='form-control' type=text name=smobile size=30></td></tr>");
		
		out.println("<tr><td><input type=submit class='btn btn-success'></td>");
		out.println("<td><input type=reset class='btn btn-danger'></td></tr>");
				out.println("</table></center></form></html>");
				out.flush();
	 	}
	}

	


