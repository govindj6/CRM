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
 * Servlet implementation class EmployeeEditDelete
 */
@WebServlet("/EmployeeEditDelete")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class EmployeeEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeEditDelete() {
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
		    	Employees E=new Employees();
		   		E.setEmployeeid(request.getParameter("eid"));
		   		E.setEmployeename(request.getParameter("efn")+" "+request.getParameter("eln"));
		   		E.setFathername(request.getParameter("effn")+" "+request.getParameter("efln"));
		   		E.setDob(request.getParameter("ebd"));
		   		E.setGender(request.getParameter("eg"));
		   		E.setAddress(request.getParameter("eadd"));
		   		
		   		if(request.getParameter("estate").equals("-Select-"))
		   			E.setState(request.getParameter("estate1"));
		   		else
		   			E.setState(request.getParameter("estate"));

		   		if(request.getParameter("ecity").equals("-Select-"))
		   			E.setCity(request.getParameter("ecity1"));
		   		else
			 		E.setCity(request.getParameter("ecity"));
				
		   		E.setEmailid(request.getParameter("em"));
				E.setMobileno(request.getParameter("emobile"));
				E.setDesignation(request.getParameter("edes"));
		 		boolean st=EmployeeController.editRecord(E);
		 		response.sendRedirect("DisplayAllEmployees");
		    }
		    
		    else if(btn.equals("Edit Picture"))
		    {
				//fileupload
				Part part=request.getPart("epic");
				String path="F:/Java/Eclipse/CRM/WebContent/images/employee";
				FileUpload F=new FileUpload(part,path);
			 	boolean st=EmployeeController.editPicture(F.filename, request.getParameter("eid"));
			 	response.sendRedirect("DisplayAllEmployees");
		    }
		    
		    else if(btn.equals("Delete"))
		    {
			    boolean st=EmployeeController.deleteRecord(request.getParameter("eid"));
			    response.sendRedirect("DisplayAllEmployees");
		    }
		 }
		 catch(Exception e)
		 {
			 System.out.println("Error in EmployeeEditDelete :"+e);
		 }




	}

}
