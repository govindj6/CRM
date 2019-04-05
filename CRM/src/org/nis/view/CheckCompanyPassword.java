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
import org.nis.controller.EngineerController;
import org.nis.model.Companies;
import org.nis.model.Engineers;

/**
 * Servlet implementation class CheckCompanyPassword
 */
@WebServlet("/CheckCompanyPassword")
public class CheckCompanyPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckCompanyPassword() {
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
		Companies E=CompanyController.checkPassword(request.getParameter("cid"),request.getParameter("npwd"));	
		out.println("<html>");	
		if(E==null)
			{out.println("<font color=red>Invalid Userid/Password</font>");
			 	
			}
		else
		{ HttpSession ses=request.getSession();
		   ses.putValue("SEMPLOYEE", E);
		   ses.putValue("ELTIME", new java.util.Date());
			response.sendRedirect("CompanyHome");
		}
		}
		catch(Exception e)
		{System.out.println(e);
			
		}
	}


	
	}


