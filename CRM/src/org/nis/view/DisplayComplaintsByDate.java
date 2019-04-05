package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nis.model.ServiceCenter;

/**
 * Servlet implementation class DisplayComplaintsByDate
 */
@WebServlet("/DisplayComplaintsByDate")
public class DisplayComplaintsByDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayComplaintsByDate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		HttpSession ses=request.getSession();
		//////////////////
		 ServiceCenter S=null;
		 try
		 {
			
			 S=(ServiceCenter)(ses.getValue("SSERVICECENTER"));	
		 }
		 catch(Exception e)
		 {
			response.sendRedirect("SCLogin");
		 }
		 ////////////////////
		 out.println("<html><link href='ui/css/bootstrap.min.css' rel='stylesheet'>");
		out.println("<script src=Asset/jquery-2.2.1.min.js></script>");
		out.println("<script src=Asset/DisplayComplaint.js></script>");
		out.println("<table class='table table-bordered'>");
		out.println("<caption><b><i>Display Complaints</i></b></caption>");
		out.println("<input type=hidden class='form-control' name=scid id=scid value='"+S.getSCid()+"'>");
		out.println("<tr><td><b><i>Date from :</i></b></td><td><input class='form-control' type=date name=date1 id=date1></td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<td><b><i>Date To :</i></b></td><td><input class='form-control' type=date name=date2 id=date2></td><td><input type=button id=btn class='btn btn-info' value=Search></td></tr></table>");
		out.println("<br>");
		out.println("<div id=cresult></div>");
		out.println("</html>");
		out.flush();
	}

}
