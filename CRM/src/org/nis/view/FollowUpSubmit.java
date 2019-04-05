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

import org.nis.controller.FollowUpController;
import org.nis.model.Employees;
import org.nis.model.FollowUp;

/**
 * Servlet implementation class FollowUpSubmit
 */
@WebServlet("/FollowUpSubmit")
public class FollowUpSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FollowUpSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession ses=request.getSession();
		Employees E=null;
		try
		{
			E=(Employees)(ses.getValue("SEMPLOYEES"));	
		}
		catch(Exception e)
		 {
			response.sendRedirect("EmployeesLogin");
		 }
		try
		{
	    	PrintWriter out=response.getWriter();	
	    	FollowUp F=new FollowUp();
	    	F.setComplaintid(request.getParameter("cmid"));
	    	Calendar C=Calendar.getInstance();
	    	String cd=C.get(Calendar.YEAR)+"/"+(C.get(Calendar.MONTH)+1)+"/"+C.get(Calendar.DATE);
	    	F.setCurrentdate(cd);
	    	F.setConversation(request.getParameter("ec"));
	    	F.setEmployeeid(E.getEmployeeid());
	    	boolean st=FollowUpController.addNewRecord(F);
	    	if(st)
			   {
				   
				   out.println("<font color=green><b>Record Submitted <br> <a href=ComplaintFollowUp>More Complaints...</a></b></font>");
				   
			   }
			   else
			   {
				   out.println("<font color=red><b>Fail to Submit Record <br> <a href=ComplaintFollowUp>More Complaints...</a></b></font>");	   
			   }
	    	
	    	
	    }catch(Exception e){
	    	
	    System.out.println("FollowUp:"+e);	
	    }		 
	}

}
