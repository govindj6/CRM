package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nis.controller.AssignmentController;
import org.nis.model.Assignment;
import org.nis.model.Engineers;

/**
 * Servlet implementation class AssignedComplaintSubmit
 */
@WebServlet("/AssignedComplaintSubmit")
public class AssignedComplaintSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignedComplaintSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//session management
		 HttpSession ses=request.getSession();
		 Engineers E=null;
		 try
		 {
			 E=(Engineers)(ses.getValue("SENGINEERS"));
		 }
		 catch(Exception e)
		 {
			 response.sendRedirect("EngineersLogin");
		 }
		 ///////////////
		 
		try
		{
			PrintWriter out=response.getWriter();
			Assignment A=new Assignment();
			A.setRemark(request.getParameter("rem"));
			A.setRemarkdate(request.getParameter("remdate"));
			A.setStatus(request.getParameter("status"));
			
			boolean st=AssignmentController.editRecord(A);
			if(st)
			{
				out.println("Record Updated !");
			}
			else
			{
				out.println("Failed to Update Record !");
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in AssignedComplaintSubmit : "+e);
		}
	}

}
