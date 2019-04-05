package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import org.nis.controller.ServiceCenterController;

import org.nis.model.ServiceCenter;
import org.softech.FileUpload;

/**
 * Servlet implementation class SCEditDelete
 */
@WebServlet("/SCEditDelete")
public class SCEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SCEditDelete() {
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
		    String btn=request.getParameter("btn");
		    if(btn.equals("Edit"))
		    {
		    	ServiceCenter s=new ServiceCenter();
				
				s.setCompanyId(request.getParameter("cid"));
				s.setSCid(request.getParameter("sid"));
				s.setOwnername(request.getParameter("sofn")+" "+request.getParameter("soln"));
				s.setFirmName(request.getParameter("sn"));
				s.setAddress(request.getParameter("address"));
				if(request.getParameter("estate").equals("-Select-"))
		   			s.setState(request.getParameter("estate1"));
		   		else
		   			s.setState(request.getParameter("estate"));

		   		if(request.getParameter("ecity").equals("-Select-"))
		   			s.setCity(request.getParameter("ecity1"));
		   		else
			 		s.setCity(request.getParameter("ecity"));
				
				s.setMobileno(request.getParameter("smobile"));
				s.setEmailid(request.getParameter("sm"));
				boolean st=ServiceCenterController.editRecord(s);
		 		response.sendRedirect("DisplayAllServiceCenters");
		    }
		    else if(btn.equals("Delete"))
		    {
		    	 boolean st=ServiceCenterController.deleteRecord(request.getParameter("sid"));
				 response.sendRedirect("DisplayAllServiceCenters");
		    }
		 }
		 catch(Exception e)
		 {
			 System.out.println("Error in SCEditDelete :"+e);
		 }
	}

}
