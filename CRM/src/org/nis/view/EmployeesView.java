package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nis.model.Admin;


/**
 * Servlet implementation class EmployeesView
 */
@WebServlet("/EmployeesView")
public class EmployeesView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeesView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		 
		
		
		
		/////////////////
		out.println("<html><head>");
		out.println("<link href='ui/css/bootstrap.min.css' rel='stylesheet'>");
		out.println("<center>");
		out.println("<script src=Asset/jquery-2.2.1.min.js></script>");
		out.println("<script src=Asset/states.js></script>");
		out.println("<script src=Asset/pwdmeter.js></script>");
		out.println("<script src=Asset/mchk.js></script>");
		out.println("<link rel='stylesheet' href='Asset/him.css' type='text/css' media='all'/></head>");
		
		out.println("<body class=body1><a href=DisplayAllEmployees class='btn btn-success'>Display All Employee</a><br>");
		out.println("<center><form action=EmployeesSubmit method=post enctype='multipart/form-data'>");
		out.println("<h2><i>Employee Register</i></h2><br>");
		out.print("<table align=center class='table table-bordered' >");
		
		out.println("<hr><tr><td><b><i>Employee Id:</i></b></td>");
		out.println("<td><input class='form-control' type=text name=eid size=20></td></tr>");
		
		out.println("<tr><td><b><i>Name:</i></b></td>");
		out.println("<td><input class='form-control' type=text name=efn placeholder='First Name' size=20>&nbsp;&nbsp;<input class='form-control' type=text name=eln placeholder='Last Name' size=20></td></tr>");
	
		out.println("<tr><td><b><i>Father's Name:</i></b></td>");
		out.println("<td><input class='form-control' type=text name=effn placeholder='First Name' size=20>&nbsp;&nbsp;<input class='form-control' type=text name=efln placeholder='Last Name' size=20></td></tr>");
	 
		out.println("<tr><td><b><i>Birth Date:</i></b></td>");
		out.println("<td><input class='form-control' type=date name=ebd size=30></td></tr>");
		
		out.println("<tr><td><b><i>Gender:</i></b></td>");
		out.println("<td><input type=radio name=eg value=Male>Male<input  type=radio name=eg value=Female>Female</td></tr>");
		
		out.println("<tr><td><b><i>Address:</i></b></td>");
		out.println("<td><textarea class='form-control' row=3 cols=30 name=eadd ></textarea></td></tr>");
		
		out.println("<tr><td><b><i>State:</i></b></td>");
		out.println("<td><select class='form-control' name=estate id=estate></select></td></tr>");
		
		out.println("<tr><td><b><i>City:</i></b></td>");
		out.println("<td><select class='form-control' name=ecity id=ecity></select></td></tr>");
		
		out.println("<tr><td><b><i>Email Id:</i></b></td>");
		out.println("<td><input class='form-control' type=email name=em size=30></td></tr>");
		
		out.println("<tr><td><b><i>Mobile:</i></b></td>");
		out.println("<td><input class='form-control' type=text size=30 name=emobile id=txt onkeyup='validation();'>&nbsp;&nbsp;<span id=result></span></td></tr>");
		
		out.println("<tr><td><b><i>Designation:</i></b></td>");
		out.println("<td><input class='form-control' type=text name=edes size=30></td></tr>");
		
		
		out.println("<tr><td><b><i>Password:</i></b></td>");
		out.println("<td><input class='form-control' type=password size=30 name=epwd id=pwd onkeyup='call();'>&nbsp;&nbsp;&nbsp;<img src='' id=img class='img-thumbnail'></td></tr>");
		
		out.println("<tr><td><b><i>Confirm Password:</i></b></td>");
		out.println("<td><input class='form-control' type=password size=30 name=ecpwd id=cpwd onkeyup='check();'>&nbsp;&nbsp;&nbsp;<img src='' id=cimg class='img-thumbnail'></td></tr>");
		
		
		out.println("<tr><td><b><i>Photograph:</i></b></td>");
		out.println("<td><input class='form-control' type=file name=eph size=20></td></tr>");
		
		out.println("<tr><td><br><input class='btn btn-info' type=submit value=Submit></td>");
		out.println("<td><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=reset></td></tr>");
		
		out.println("</table></form></center></body></html>");
		out.flush();
	}

}
