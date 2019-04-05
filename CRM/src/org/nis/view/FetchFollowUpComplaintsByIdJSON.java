package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.nis.controller.DBHelper;
import org.nis.controller.FollowUpController;
import org.nis.controller.ServiceCenterController;

/**
 * Servlet implementation class FetchFollowUpComplaintsByIdJSON
 */
@WebServlet("/FetchFollowUpComplaintsByIdJSON")
public class FetchFollowUpComplaintsByIdJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchFollowUpComplaintsByIdJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		try{
	   ResultSet rs=FollowUpController.displayComplaintsById(request.getParameter("cmid")); 
	   String html="";
	   if(rs.next())
	   {html+="<table border=1 width=100%>";
	    html+="<tr><th>Transaction Id</th><th>Conversation</th></tr>";
		do{
			html+="<tr><td>"+rs.getString(1)+"</td><td><b><i>Date:"+rs.getString(3)+"</i></b><br><b><i>Employee:"+rs.getString(5)+"</i></b><br><i>"+rs.getString(4)+"</i></th></tr>";	
			
		}while(rs.next());   
		 html+="</table>";  
	   }
	   else
	   {
		 html="Record Not Found...";  
	   }
		 
	   JSONObject obj=new JSONObject();
	   obj.put("MSG",html);
	   out.println(obj); 
	   
		}
		catch(Exception e)
		{out.println(e);
			
		}
	}

}
