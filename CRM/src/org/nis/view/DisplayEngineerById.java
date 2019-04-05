package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nis.controller.EngineerController;

/**
 * Servlet implementation class DisplayEngineerById
 */
@WebServlet("/DisplayEngineerById")
public class DisplayEngineerById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayEngineerById() {
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
			ResultSet rs=EngineerController.DisplayEngineerById(request.getParameter("eid"));
			if(rs.next())
			{
				out.println("<html><link href='ui/css/bootstrap.min.css' rel='stylesheet'>");
				
				out.println("<script src=Asset/jquery-2.2.1.min.js></script>");
				out.println("<script src=Asset/states.js></script>");
				out.println("<script src=Asset/pwdmeter.js></script>");
				out.println("<script src=Asset/mchk.js></script>");
				out.println("<link rel='stylesheet' href='Asset/him.css' type='text/css' media='all'/></head>");
				
				out.println("<body class=body2><a href=DisplayAllEngineers class='btn btn-danger'>Display All Engineers</a><br><center>");
				out.println("<form action=EngineerEditDelete method=post enctype='multipart/form-data'>");
				out.println("<h2><i>Engineer Register[Update]</i></h2><br><hr>");
				out.println("<table class='table table-bordered'><tr><td>");
				out.print("<table class='table table-bordered'>");
				
				out.println("<tr><td><b><i>Service Center Id:</i></b></td>");
				out.println("<td><input class='form-control' type=text name=scid size=20 value='"+rs.getString(1)+"'></td></tr>");
				
				out.println("<tr><td><b><i>Engineer Id:</i></b></td>");
				out.println("<td><input class='form-control' type=text name=eid size=20 value='"+rs.getString(2)+"'></td></tr>");
				
				out.println("<tr><td><b><i>Name:</i></b></td>");
				String n=rs.getString(3);
				String en[]=n.split(" ");
				out.println("<td><input class='form-control' type=text name=efn placeholder='First Name' size=20 value='"+en[0]+"'>&nbsp;&nbsp;<input class='form-control' type=text name=eln placeholder='Last Name' size=20 value='"+en[1]+"'></td></tr>");
				
				String fn=rs.getString(4);
				String efn[]=fn.split(" ");
				out.println("<tr><td><b><i>Father's Name:</i></b></td>");
				out.println("<td><input class='form-control' type=text name=effn placeholder='First Name' size=20 value='"+efn[0]+"'>&nbsp;&nbsp;<input class='form-control' type=text name=efln placeholder='Last Name' size=20 value='"+efn[1]+"'></td></tr>");
			 
				out.println("<tr><td><b><i>Birth Date:</i></b></td>");
				out.println("<td><input class='form-control' type=date name=ebd size=30 value='"+rs.getString(5)+"'></td></tr>");
				
				if(rs.getString(6).equals("Male"))
				{
					out.println("<tr><td><b><i>Gender:</i></b></td>");
					out.println("<td><input type=radio name=eg value=Male checked>Male<input type=radio name=eg value=Female>Female</td></tr>");
				}
				else
				{
					out.println("<tr><td><b><i>Gender:</i></b></td>");
					out.println("<td><input type=radio name=eg value=Male>Male<input type=radio name=eg value=Female checked>Female</td></tr>");	
				}
				
				out.println("<tr><td><b><i>Address:</i></b></td>");
				out.println("<td><textarea class='form-control' row=3 cols=30 name=eadd >"+rs.getString(7)+"</textarea></td></tr>");
				
				out.println("<tr><td><b><i>State:</i></b></td>");
				out.println("<td><select class='form-control' name=estate id=estate></select>&nbsp;&nbsp;&nbsp;<input class='form-control' type=text name=estate1 value="+rs.getString(8)+" readonly=true></td></tr>");
				
				out.println("<tr><td><b><i>City:</i></b></td>");
				out.println("<td><select class='form-control' name=ecity id=ecity></select>&nbsp;&nbsp;&nbsp;<input class='form-control' type=text name=ecity1 value="+rs.getString(9)+" readonly=true></td></tr>");
				
				out.println("<tr><td><b><i>Mobile:</i></b></td>");
				out.println("<td><input type=text class='form-control' size=30 name=emobile id=txt onkeyup='validation();' value='"+rs.getString(10)+"'>&nbsp;&nbsp;<span id=result></span></td></tr>");
				
				out.println("<tr><td><b><i>Email Id:</i></b></td>");
				out.println("<td><input type=email class='form-control' name=em size=30 value='"+rs.getString(11)+"'></td></tr>");
				
				out.println("<tr><td><b><i>Designation:</i></b></td>");
				out.println("<td><input type=text class='form-control' name=edes size=30 value='"+rs.getString(12)+"'></td></tr>");
				
				
				out.println("<tr><td><br><input type=submit class='btn btn-info' value=Edit name=btn></td>");
				out.println("<td><br>&nbsp;&nbsp;&nbsp;&nbsp;<input type=submit class='btn btn-danger' value=Delete name=btn></td></tr>");
				
				out.println("</table></td>");
				out.println("<th valign=top></br><img class='img-thumbnail' src='images/engineer/"+rs.getString(14)+"' width=250 height=250><br><br><input class='form-control' type=file name=epic>&nbsp;&nbsp;<input class='btn btn-info' type=submit value='Edit Picture' name=btn></th>");
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
			System.out.println("Error in DisplayEngineerById: "+e);
		}
	}

}
