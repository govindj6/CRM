package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CompanyView
 */
@WebServlet("/CompanyView")
public class CompanyView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyView() {
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
		out.println("<script src=Asset/pwdmeter.js></script>");
		out.println("<script src=Asset/mchk.js></script>");
		out.println("<center>");
		out.println("<body class=body2>");
		out.println("<link rel='stylesheet' href='Asset/him.css' type='text/css' media='all'/></head>");
		
		out.println("<body class=body2><a href=DisplayAllCompanies class='btn btn-success'>Display All Companies</a><br>");
		out.println("<center><form action=CompanySubmit method=post enctype='multipart/form-data'>");
		out.println("<h2><i>Company Register</i></h2><br><hr>");
		
		out.print("<table class='table table-bordered' align=center >");
		
		out.println("<tr><td><b><i>Company Id:</i></b></td>");
		out.println("<td><input class='form-control' type=text name=cid size=20></td></tr>");
		
		out.println("<tr><td><b><i>Name:</i></b></td>");
		out.println("<td><input class='form-control' type=text name=cn placeholder='Company Name' size=20></td></tr>");
	
		out.println("<tr><td><b><i>Owner's Name:</i></b></td>");
		out.println("<td><input class='form-control' type=text name=on placeholder='CEO' size=20></td></tr>");
		
		out.println("<tr><td><b><i>Address:</i></b></td>");
		out.println("<td><textarea class='form-control' row=3 cols=30 name=address ></textarea></td></tr>");
		
		out.println("<tr><td><b><i>State:</i></b></td>");
		out.println("<td><select class='form-control' name=estate id=estate></select></td></tr>");
		
		out.println("<tr><td><b><i>City:</i></b></td>");
		out.println("<td><select class='form-control' name=ecity id=ecity></select></td></tr>");
		
		out.println("<tr><td><b><i>Contact Person:</i></b></td>");
		out.println("<td><input class='form-control' type=text name=cp placeholder='Name' size=20></td></tr>");
		
		out.println("<tr><td><b><i>Mobile:</i></b></td>");
		out.println("<td><input class='form-control' type=text size=30 name=cpmobile id=txt onkeyup='validation();'>&nbsp;&nbsp;<span id=result></span></td></tr>");
		
		out.println("<tr><td><b><i>Email Id:</i></b></td>");
		out.println("<td><input class='form-control' type=email name=cpem size=30></td></tr>");
		
		out.println("<tr><td><b><i>Company Logo:</i></b></td>");
		out.println("<td><input class='form-control' type=file name=cph size=20></td></tr>");
		
		out.println("<tr><td><br><input class='btn btn-info' type=submit value=Submit></td>");
		out.println("<td><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class='btn btn-danger' type=reset></td></tr>");
		
		out.println("</table></form></center></body></html>");
		out.flush();
	}
}
