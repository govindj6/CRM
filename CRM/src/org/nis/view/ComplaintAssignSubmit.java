package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nis.controller.AssignmentController;
import org.nis.model.Assignment;

/**
 * Servlet implementation class ComplaintAssignSubmit
 */
@WebServlet("/ComplaintAssignSubmit")
public class ComplaintAssignSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplaintAssignSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		try
		{
			PrintWriter out=response.getWriter();
			Assignment A=new Assignment();
			A.setComplaintid(request.getParameter("cmid"));
			A.setEngineerid(request.getParameter("eid"));
			A.setAssigndate(request.getParameter("adate"));
			
			boolean st=AssignmentController.addNewRecord(A);
			if(st)
			{
				out.println("Record Submitted !");
			}
			else
			{
				out.println("Failed to Submit Record !");
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in CA submit :"+e);
		}
		
	}

}
