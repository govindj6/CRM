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
 * Servlet implementation class DisplayCompanyById
 */
@WebServlet("/DisplayCompanyById")
public class DisplayCompanyById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayCompanyById() {
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
			ResultSet rs=CompanyController.DisplayCompanyById(request.getParameter("cid"));
			if(rs.next())
			{
				out.println("<html><link href='ui/css/bootstrap.min.css' rel='stylesheet'>");
				
				out.println("<script src=Asset/jquery-2.2.1.min.js></script>");
				out.println("<script src=Asset/states.js></script>");
				out.println("<script src=Asset/pwdmeter.js></script>");
				out.println("<script src=Asset/mchk.js></script>");
				out.println("<link rel='stylesheet' href='Asset/him.css' type='text/css' media='all'/></head>");
				
				out.println("<body class=body2><a href=DisplayAllCompanies class='btn btn-info'>Display All Companies</a><br><center>");
				out.println("<form action=CompanyEditDelete method=post enctype='multipart/form-data'>");
				out.println("<h2><i>Company Register[Update]</i></h2><br><hr>");
				out.println("<table class='table table-bordered'><tr><td>");
				out.print("<table class='table table-bordered'>");
				
				out.println("<tr><td><b><i>Company Id:</i></b></td>");
				out.println("<td><input class='form-control' type=text name=cid size=20 value='"+rs.getString(1)+"'></td></tr>");
				
				out.println("<tr><td><b><i>Company Name:</i></b></td>");
				out.println("<td><input class='form-control' type=text name=cn size=20 value='"+rs.getString(2)+"'></td></tr>");
				
				out.println("<tr><td><b><i>Owner's Name:</i></b></td>");
				out.println("<td><input class='form-control' type=text name=on placeholder='First Name' size=20 value='"+rs.getString(3)+"'>");
		 
		
				out.println("<tr><td><b><i>Address:</i></b></td>");
				out.println("<td><textarea class='form-control' row=3 cols=30 name=address >"+rs.getString(4)+"</textarea></td></tr>");
				
				out.println("<tr><td><b><i>State:</i></b></td>");
				out.println("<td><select class='form-control' name=estate id=estate></select>&nbsp;&nbsp;&nbsp;<input class='form-control' type=text name=estate1 value="+rs.getString(5)+" readonly=true></td></tr>");
				
				out.println("<tr><td><b><i>City:</i></b></td>");
				out.println("<td><select class='form-control' name=ecity id=ecity></select>&nbsp;&nbsp;&nbsp;<input class='form-control' type=text name=ecity1 value="+rs.getString(6)+" readonly=true></td></tr>");
				
				out.println("<tr><td><b><i>Contact Person:</i></b></td>");
				out.println("<td><input class='form-control' type=text name=cp size=30 value='"+rs.getString(7)+"'></td></tr>");
				
				out.println("<tr><td><b><i>Mobile:</i></b></td>");
				out.println("<td><input class='form-control' type=text size=30 name=cpmobile id=txt onkeyup='validation();' value='"+rs.getString(8)+"'>&nbsp;&nbsp;<span id=result></span></td></tr>");
				
				out.println("<tr><td><b><i>Email Id:</i></b></td>");
				out.println("<td><input class='form-control' type=email name=cpem size=30 value='"+rs.getString(9)+"'></td></tr>");
				
				
				out.println("<tr><td><br><input class='btn btn-success' type=submit value=Edit name=btn></td>");
				out.println("<td><br>&nbsp;&nbsp;&nbsp;&nbsp;<input class='btn btn-danger' type=submit value=Delete name=btn></td></tr>");
				
				out.println("</table></td>");
				out.println("<th valign=top></br><img class='img-thumbnail' src='images/company/"+rs.getString(10)+"' width=250 height=250><br><br><input class='form-control' type=file name=epic>&nbsp;&nbsp;<input type=submit class='btn btn-success' value='Edit Picture' name=btn></th>");
				out.println("</table></form></center></body></html>");
				out.flush();
			}
			else
			{
				System.out.println("Record not found");
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in DisplayCompanyById: "+e);
		}
	}

}
