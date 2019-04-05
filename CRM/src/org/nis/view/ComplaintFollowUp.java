package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ComplaintFollowUp
 */
@WebServlet("/ComplaintFollowUp")
public class ComplaintFollowUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplaintFollowUp() {
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
		out.println("<script src=Asset/jquery-ui.min.js></script>");
		out.println("<link rel=stylesheet href=Asset/jquery-ui.min.css>");
 
		out.println("<script src=Asset/complaint.js></script>");
		out.println("<html><link href='ui/css/bootstrap.min.css' rel='stylesheet'>");
		out.println("<table class='table table-bordered'>");
		out.println("<caption><b><i>Follow Up Complaints</i></b></caption>");
		out.println("<tr><td><b><i>Complaint Id:</i></b></td><td><input class='form-control' type=text name=cmid id=cmid></td><td><input type=button id=btn value=Search class='btn btn-info'></td><td><span id=more>More</span></td></tr></table>");
		out.println("<br>");
		out.println("<div id=cresult></div>");
		out.println("</html>");
		out.flush();
	}

}
