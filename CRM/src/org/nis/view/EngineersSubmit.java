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


import org.nis.controller.EngineerController;
import org.nis.model.Engineers;
import org.softech.FileUpload;

/**
 * Servlet implementation class EngineersSubmit
 */
@WebServlet("/EngineersSubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class EngineersSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EngineersSubmit() {
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
			Engineers e=new Engineers();
		    
			e.setSCid(request.getParameter("scid"));
			e.setEngineerid(request.getParameter("eid"));
		    e.setEngineername(request.getParameter("efn")+" "+request.getParameter("eln"));
		    e.setFathername(request.getParameter("effn")+" "+request.getParameter("efln"));
		    e.setDob(request.getParameter("ebd"));
		    e.setGender(request.getParameter("eg"));
		    e.setAddress(request.getParameter("eadd"));
			e.setState(request.getParameter("estate"));
			e.setCity(request.getParameter("ecity"));
			e.setMobno(request.getParameter("emobile"));
			e.setEmailid(request.getParameter("em"));
			e.setDesignation(request.getParameter("edes"));
			e.setPassword(request.getParameter("epwd"));
			e.setPhoto(request.getParameter("eph"));
			
			//fileupload
			Part part=request.getPart("eph");
			String path="F:/Java/Eclipse/CRM/WebContent/images/engineer";
			FileUpload F=new FileUpload(part,path);
			e.setPhoto(F.filename);
			
			boolean st=EngineerController.addNewRecord(e);
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
			System.out.println("Error in EngineersSubmit :"+c);
		}
	}

}
