package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nis.controller.EngineerController;
import org.nis.model.Engineers;

/**
 * Servlet implementation class CheckEngineersLogin
 */
@WebServlet("/CheckEngineersLogin")
public class CheckEngineersLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckEngineersLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			PrintWriter out=response.getWriter();
			Engineers E=EngineerController.checkPassword(request.getParameter("eid"),request.getParameter("epwd"));	
			out.println("<html>");	
			if(E==null)
			{
				out.println("<font color=red>Invalid Userid/Password</font>");
			}
			else
			{
				HttpSession ses=request.getSession();
				ses.putValue("SENGINEERS", E);
				ses.putValue("SLTIME", new java.util.Date());
				response.sendRedirect("EngineersHome");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);	
		}
	}

}
