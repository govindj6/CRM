package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nis.model.ServiceCenter;

/**
 * Servlet implementation class ComplaintAssign
 */
@WebServlet("/ComplaintAssign")
public class ComplaintAssign extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplaintAssign() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		/////Session Management
		HttpSession ses=request.getSession();
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
		out.println("<script src=Asset/engineers.js></script>");
		out.println("<form action=ComplaintAssignSubmit>");
		Calendar C=Calendar.getInstance();
		String cd=C.get(Calendar.YEAR)+"/"+(C.get(Calendar.MONTH)+1)+"/"+C.get(Calendar.DATE);
		String ct=C.get(Calendar.HOUR)+":"+C.get(Calendar.MINUTE)+":"+C.get(Calendar.SECOND);
		String cdd=cd+" "+ct;
		out.println("<input type=hidden class='form-control' name=scid id=scid value='"+S.getSCid()+"'>");
		out.println("<table  class='table table-bordered'><center><caption>Assigning Complaints</caption>");
		out.println("<tr><td><b><i>Complaint ID: </b></i></td><td><input class='form-control' type=text name=cmid id=cmid size=20 value='"+request.getParameter("cmid")+"'></td></tr>");
		out.println("<tr><td><b><i>Engineer ID:</b></i></td><td><select class='form-control' name=eid id=eid ></td></tr>");
		out.println("<tr><td><b><i>Assign Date :</td><td><input class='form-control' type=text name=adate id=adate value='"+cdd+"'></td></tr><br><br>");
		out.println("<tr><td><input class='btn btn-success' type=submit></td></tr>");
		out.println("</center></table><form></html>");
		out.flush();
	}

}
