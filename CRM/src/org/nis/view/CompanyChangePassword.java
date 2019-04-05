package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CompanyChangePassword
 */
@WebServlet("/CompanyChangePassword")
public class CompanyChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		PrintWriter out=response.getWriter();
		out.println("<html><link href='ui/css/bootstrap.min.css' rel='stylesheet'>");
		out.println("<form action=CheckCompanyPassword method=post>");
		 
		out.print("<table class='table table-bordered'>");
		out.println("<caption><b><i>Change Password</i></b></caption>");		
		
		out.println("<tr><td><b><i>Company Id:</i></b></td>");
		out.println("<td><input class='form-control' type=text name=cid size=30></td></tr>");
		
		out.println("<tr><td><b><i>Old Password:</i></b></td>");
		out.println("<td><input class='form-control' type=password name=opwd size=30></td></tr>");
		
		out.println("<tr><td><b><i>New Password:</i></b></td>");
		out.println("<td><input class='form-control' type=password name=npwd size=30></td></tr>");
		
		out.println("<tr><td><b><i> Confirm New Password:</i></b></td>");
		out.println("<td><input class='form-control' type=password name=cnpwd size=30></td></tr>");

		out.println("<tr><td><input type=submit class='btn btn-success' value='Change Password'></td>");
		out.println("<td>&nbsp;</td></tr>");
	}

}

	
	