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

import org.nis.controller.CompanyController;
import org.nis.model.Companies;
import org.softech.FileUpload;

/**
 * Servlet implementation class CompanyEditDelete
 */
@WebServlet("/CompanyEditDelete")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class CompanyEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyEditDelete() {
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
		    	Companies c=new Companies();
				
				c.setCompanyid(request.getParameter("cid"));
				c.setCompanyname(request.getParameter("cn"));
				c.setOwnername(request.getParameter("on"));
				c.setAddress(request.getParameter("address"));
				if(request.getParameter("estate").equals("-Select-"))
		   			c.setState(request.getParameter("estate1"));
		   		else
		   			c.setState(request.getParameter("estate"));

		   		if(request.getParameter("ecity").equals("-Select-"))
		   			c.setCity(request.getParameter("ecity1"));
		   		else
			 		c.setCity(request.getParameter("ecity"));
				
		   		c.setContactperson(request.getParameter("cp"));
				c.setMobileno(request.getParameter("cpmobile"));
				c.setEmailid(request.getParameter("cpem"));
				boolean st=CompanyController.editRecord(c);
		 		response.sendRedirect("DisplayAllCompanies");
		    }
		    else if(btn.equals("Delete"))
		    {
		    	 boolean st=CompanyController.deleteRecord(request.getParameter("cid"));
				 response.sendRedirect("DisplayAllCompanies");
		    }
		    else if(btn.equals("Edit Picture"))
		    {
				//fileupload
				Part part=request.getPart("epic");
				String path="F:/Java/Eclipse/CRM/WebContent/images/company";
				FileUpload F=new FileUpload(part,path);
			 	boolean st=CompanyController.editLogo(F.filename, request.getParameter("cid"));
			 	response.sendRedirect("DisplayAllCompanies");
		    }
		 }
		 catch(Exception e)
		 {
			 System.out.println("Error in CompanyEditDelete :"+e);
		 }
	}
}
