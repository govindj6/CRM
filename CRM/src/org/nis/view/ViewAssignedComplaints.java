package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewAssignedComplaints
 */
@WebServlet("/ViewAssignedComplaints")
public class ViewAssignedComplaints extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAssignedComplaints() {
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
		out.println("<form action=AssignedComplaintSubmit>");
		out.println("<table class='table table-bordered'>");
		out.println("<tr><td><b><i>Complaint ID :</i></b></td><td><input class='form-control' type=text size=20 name=cmid id=cmid></td>&nbsp;&nbsp;&nbsp;<td><b><i>Complaint date:</i></b></td><td><input class='form-control' type=text size=20 name=cdate id=cdate></td></tr>");
		out.println("<tr><td><b><i>Customer Name:</i></b></td><td><input class='form-control' type=text size=20 name=cname id=cname></td>&nbsp;&nbsp;&nbsp;<td><b><i>Contact Number :</i></b></td><td><input class='form-control' type=text size=20 name=cno id=cno></td></tr>");
		out.println("<tr><td><b><i>Customer Address :</i></b></td><td><textarea class='form-control' name=cadd id=cadd rows=6 col=40></textarea></td></tr>");
		out.println("<tr><td><b><i>Product details:</i></b></td><td><textarea class='form-control' name=pdetails id=pdetails rows=6 col=40></textarea></td></tr>");
		out.println("<tr><td><b><i>Complaint :</i></b></td><td><textarea class='form-control' name=cm id=cm rows=6 col=40></textarea></td></tr>");
		out.println("<tr><td><b><i>Status :</i></b></td><td><select class='form-control' name=status id=status></td></tr>");
		out.println("<tr><td><b><i>Remark :</i></b></td><td><textarea class='form-control' name=rem id=rem rows=6 col=40></textarea></td></tr>");
		out.println("<tr><td><b><i>Assigned On :</i></b></td><td><input class='form-control' type=text size=20 name=adate id=adate></td>&nbsp;&nbsp;&nbsp;<td><b><i>Remark Date :</i></b></td><td><input class='form-control' type=text size=20 name=remdate id=remdate></td></tr>");
		out.println("</br><tr><td><input class='btn btn-info' type=submit></td><td><input class='btn btn-danger' type=reset></td></tr>");
		out.println("</table></form></html>");
		out.flush();
	}

}
