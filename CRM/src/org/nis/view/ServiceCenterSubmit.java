package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.nis.controller.ServiceCenterController;
import org.nis.model.ServiceCenter;

/**
 * Servlet implementation class ServiceCenterSubmit
 */
@WebServlet("/ServiceCenterSubmit")
public class ServiceCenterSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceCenterSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 try{
		    	PrintWriter out=response.getWriter();
		    ServiceCenter S=new ServiceCenter();
		   S.setCompanyId(request.getParameter("cid"));
		   S.setSCid(request.getParameter("sid"));
		   S.setOwnername(request.getParameter("sofn")+" "+request.getParameter("soln"));
		   S.setFirmName(request.getParameter("sn"));
		   S.setAddress(request.getParameter("sadd"));
		   S.setState(request.getParameter("sstate"));
		   S.setCity(request.getParameter("scity"));
		   S.setEmailid(request.getParameter("sm"));
		   S.setMobileno(request.getParameter("smobile"));
		  
		   boolean st=ServiceCenterController.addNewRecord(S);
		   if(st)
		   {
			   
			   out.println("<font color=green><b>Record Submitted<br><a href=ServiceCenterView>Add More Servive Center</a></b></font>");
			   
		   }
		   else
		   {
			   out.println("<font color=red><b>Fail to Submit Record<br><a href=ServiceCenterView>Add More Service Center</a></b></font>");	   
		   }
		      
		    	
		    	
		    	
		    	
		    }catch(Exception e)
		    {System.out.println(e);
		    	
		    }
	}

	
}
