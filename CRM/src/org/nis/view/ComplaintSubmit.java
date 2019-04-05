package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nis.controller.ComplaintController;
import org.nis.model.Complaints;
import org.nis.model.Employees;

/**
 * Servlet implementation class ComplaintSubmit
 */
@WebServlet("/ComplaintSubmit")
public class ComplaintSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplaintSubmit() {
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
		    Complaints C=new Complaints();
		   C.setCurrentdate(request.getParameter("cd"));
		   C.setCompanyid(request.getParameter("cid"));
		   C.setProductdetails(request.getParameter("pi"));
		   C.setCustomername(request.getParameter("cname"));
		   C.setMobileno(request.getParameter("cmobile"));
		   C.setAddress(request.getParameter("add"));
		   C.setState(request.getParameter("estate"));
		   C.setCity(request.getParameter("ecity"));
		   C.setScid(request.getParameter("sid"));
		   C.setConversation(request.getParameter("cmm"));
		   C.setStatus("Open");
		   
		   HttpSession ses=request.getSession();
		   Employees E=(Employees)ses.getValue("SEMPLOYEES");
		   
		   C.setEmployeeid(E.getEmployeeid());
		   C.setAddress(request.getParameter("cadd"));
		   boolean st=ComplaintController.addNewRecord(C);
		   if(st)
		   {
			 out.println("Complaint Registered....<br>Complaint No:"+ComplaintController.getComplaintNo());   
		   }
		   else
		   {
			   out.println("Fail to Register the Complaint......");
		   }
		}
		catch(Exception e)
		{
			System.out.println("Complaint Submit: "+e);	
		}
	}

}
