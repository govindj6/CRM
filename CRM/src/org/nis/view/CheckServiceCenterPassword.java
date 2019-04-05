package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.nis.controller.ServiceCenterController;
import org.nis.model.ServiceCenter;

/**
 * Servlet implementation class CheckServiceCenterPassword
 */
@WebServlet("/CheckServiceCenterPassword")
public class CheckServiceCenterPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckServiceCenterPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			PrintWriter out=response.getWriter();
		ServiceCenter S=ServiceCenterController.checkPassword(request.getParameter("sid"),request.getParameter("npwd"));	
		out.println("<html>");	
		if(S==null)
			{out.println("<font color=red>Invalid Userid/Password</font>");
			 	
			}
		else
		{ HttpSession ses=request.getSession();
		   ses.putValue("SEMPLOYEE", S);
		   ses.putValue("ELTIME", new java.util.Date());
			response.sendRedirect("ServiceCenterHome");
		}
		}
		catch(Exception e)
		{System.out.println(e);
			
		}
	}

}
