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

import org.nis.controller.EmployeeController;
import org.nis.model.Employees;
import org.softech.FileUpload;

/**
 * Servlet implementation class EmployeesSubmit
 */
@WebServlet("/EmployeesSubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class EmployeesSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeesSubmit() {
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
			Employees e=new Employees();
		    
			e.setEmployeeid(request.getParameter("eid"));
		    e.setEmployeename(request.getParameter("efn")+" "+request.getParameter("eln"));
		    e.setFathername(request.getParameter("effn")+" "+request.getParameter("efln"));
		    e.setDob(request.getParameter("ebd"));
		    e.setGender(request.getParameter("eg"));
		    e.setAddress(request.getParameter("eadd"));
			e.setState(request.getParameter("estate"));
			e.setCity(request.getParameter("ecity"));
			e.setEmailid(request.getParameter("em"));
			e.setMobileno(request.getParameter("emobile"));
			e.setDesignation(request.getParameter("edes"));
			e.setPassword(request.getParameter("epwd"));
			e.setPhotograph(request.getParameter("eph"));
			
			//fileupload
			Part part=request.getPart("eph");
			String path="F:/Java/Eclipse/CRM/WebContent/images/employee";
			FileUpload F=new FileUpload(part,path);
			e.setPhotograph(F.filename);
			
			boolean st=EmployeeController.addNewRecord(e);
			if(st)
		    {
				out.println("Record Submitted");
			}
		    else
		    {
			   out.println("Fail to Submit record...");
			}
		}
		catch(Exception c)
		{
			System.out.println(c);
		}
	}

}
