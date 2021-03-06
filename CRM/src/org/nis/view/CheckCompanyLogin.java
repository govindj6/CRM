package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nis.controller.CompanyController;
import org.nis.model.Companies;

/**
 * Servlet implementation class CheckCompanyLogin
 */
@WebServlet("/CheckCompanyLogin")
public class CheckCompanyLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckCompanyLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try
		{
			Companies C=CompanyController.checkPassword(request.getParameter("cid"),request.getParameter("email"));	
			out.println("<html>");	
			if(C==null)
			{
				out.println("<font color=red>Invalid Userid/Password</font>");
			}	
			else
			{
				HttpSession ses=request.getSession();
				ses.putValue("SCOMPANY", C);
				ses.putValue("SLTIME", new java.util.Date());
				response.sendRedirect("CompanyHome");
			}
		}
		catch(Exception e)
		{
			System.out.println("CheckCompanyLogin"+e);			
		}
	}

}
