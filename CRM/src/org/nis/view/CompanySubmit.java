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
 * Servlet implementation class CompanySubmit
 */
@WebServlet("/CompanySubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class CompanySubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanySubmit() {
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
			Companies c=new Companies();
			
			c.setCompanyid(request.getParameter("cid"));
			c.setCompanyname(request.getParameter("cn"));
			c.setOwnername(request.getParameter("on"));
			c.setAddress(request.getParameter("address"));
			c.setState(request.getParameter("estate"));
			c.setCity(request.getParameter("ecity"));
			c.setContactperson(request.getParameter("cp"));
			c.setMobileno(request.getParameter("cpmobile"));
			c.setEmailid(request.getParameter("cpem"));
			c.setLogo(request.getParameter("cph"));
			
			//fileupload
			Part part=request.getPart("cph");
			String path="F:/Java/Eclipse/CRM/WebContent/images/company";
			FileUpload F=new FileUpload(part,path);
			c.setLogo(F.filename);
			
			boolean st=CompanyController.addNewRecord(c);
			if(st)
		    {
				out.println("Record Submitted");
			}
		    else
		    {
			   out.println("Fail to Submit record...");
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in CompanySubmit :"+e);
		}
	}

}
