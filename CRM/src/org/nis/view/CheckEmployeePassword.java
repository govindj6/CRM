package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nis.controller.EmployeeController;
import org.nis.controller.EngineerController;
import org.nis.model.Employees;
import org.nis.model.Engineers;

/**
 * Servlet implementation class CheckEmployeePassword
 */
@WebServlet("/CheckEmployeePassword")
public class CheckEmployeePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckEmployeePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			PrintWriter out=response.getWriter();
		Employees E=EmployeeController.checkPassword(request.getParameter("eid"),request.getParameter("npwd"));	
		out.println("<html>");	
		if(E==null)
			{out.println("<font color=red>Invalid Userid/Password</font>");
			 	
			}
		else
		{ HttpSession ses=request.getSession();
		   ses.putValue("SEMPLOYEE", E);
		   ses.putValue("ELTIME", new java.util.Date());
			response.sendRedirect("EmployeesHome");
		}
		}
		catch(Exception e)
		{System.out.println(e);
			
		}
	}

}
