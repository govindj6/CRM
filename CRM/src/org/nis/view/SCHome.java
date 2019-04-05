package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nis.model.Admin;
import org.nis.model.ServiceCenter;

/**
 * Servlet implementation class SCHome
 */
@WebServlet("/SCHome")
public class SCHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SCHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		 out.println("<html>");
		 //session management
		 HttpSession ses=request.getSession();
		 
		 try
		 {
			String ltime=ses.getValue("SLTIME").toString();	
			ServiceCenter S=(ServiceCenter)(ses.getValue("SSERVICECENTER"));	
			
		 ////////////////////
		 
		 
		 
		 out.println("<html lang='en'>");
		 out.println("<head>");
		 out.println("    <link href='ui/css/bootstrap.min.css' rel='stylesheet'>");
		 out.println("    <link href='ui/css/bootstrap-reset.css' rel='stylesheet'>");
		 out.println("    <link href='ui/assets/font-awesome/css/font-awesome.css' rel='stylesheet' />");
		 out.println("    <link rel='stylesheet' type='text/css' href='ui/assets/bootstrap-datepicker/css/datepicker.css' />");
		 out.println("    <link rel='stylesheet' type='text/css' href='ui/assets/bootstrap-colorpicker/css/colorpicker.css' />");
		 out.println("    <link rel='stylesheet' type='text/css' href='ui/assets/bootstrap-daterangepicker/daterangepicker.css' />");
		 out.println("     <link href='ui/css/slidebars.css' rel='stylesheet'>");
		 out.println("    <link href='ui/css/style.css' rel='stylesheet'>");
		 out.println("    <link href='ui/css/style-responsive.css' rel='stylesheet' />");
		 out.println("  </head>");
		 out.println("  <body>");
		 out.println("  <section id='container' class=''>");
		 out.println("      <header class='header white-bg'>");
		 out.println("          <div class='sidebar-toggle-box'>");
		 out.println("              <i class='fa fa-bars'></i>");
		 out.println("          </div>");
		 out.println("          <!--logo start-->");
		 out.println("          <a href='#' class='logo' >CRM<span></span></a>");
		 out.println("          <!--logo end-->");
		 out.println("          <div class='nav notify-row' id='top_menu'>");
		 String nav="<i>Firm Name:"+S.getFirmName()
			+"["+S.getSCid()+"]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;City :"+S.getCity()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Company : "+S.getCompanyId()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ltime+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=SCLogout class='btn btn-danger btn-xs'>Logout</a></i>";		 
			out.println(nav);
		 }
		 catch(Exception e)
		 {
			response.sendRedirect("SCLogin");
		 }
		 out.println("    </div>      <div class='top-nav '>");
		 out.println("              <ul class='nav pull-right top-menu'>");
		 out.println("                  <li>");
		
		 out.println("                  </li>");
		 out.println("                  <!-- user login dropdown start-->");
		 out.println("                  <li class='dropdown'>");
		 out.println("                      <a data-toggle='dropdown' class='dropdown-toggle' href='#'>");
		 out.println("                          <img alt='' src='ui/img/avatar-mini.jpg'>");
		 out.println("                          <span class='username'>CRM</span>");
		 out.println("                          <b class='caret'></b>");
		 out.println("                      </a>");
		 out.println("                      <ul class='dropdown-menu extended logout'>");
		 out.println("                          <li><a href='AdminLogin'><i class='fa fa-key'></i> Log Out</a></li>");
		 out.println("                      </ul>");
		 out.println("                  </li>");
		
		 out.println("              </ul>");
		 out.println("          </div>");
		 out.println("      </header>");
		 out.println("      <aside>");
		 out.println("          <div id='sidebar'  class='nav-collapse '>");
		 out.println("              <!-- sidebar menu start-->");
		 out.println(" <ul class='sidebar-menu' id='nav-accordion'>");
		
		 
		 out.println("<li class='sub-menu'><a href=DisplayComplaintsByDate target=mw><i class='fa fa-laptop'></i><span>Display Complaints</span></a>");
		
		 out.println("</li>");
		 
		 out.println("<li class='sub-menu'><a href='SCChangePassword' target=mw><i class='fa fa-laptop'></i><span>Change Password</span></a>");
			
		 out.println("</li>");
		 
		 
		
		 out.println("         </ul> </div>");
		 out.println("      </aside>");
		 out.println("      <section id='main-content'>");
		 out.println("          <section class='wrapper'>");
		 out.println("              <!-- page start-->");
		 out.println("              <div class='row'>");
		 out.println("                  <div class='col-lg-12'>");
		 out.println("                      <section class='panel'>");
		 out.println("                          <header class='panel-heading'>");
		 out.println("<center>SERVICE CENTER HOME</center><hr>");
		 out.println("  <iframe width=100% height=890 frameborder=0 name=mw></iframe>                        </header>");
		 out.println("</div>");
		 out.println("                      </section>");
		 out.println("");
		 out.println("                  </div>");
		 out.println("              </div>");
		 out.println("          </section>");
		 out.println("      </section>");
		 
		 out.println("  </section>");
		 out.println("    <script src='ui/js/jquery.js'></script>");
		 out.println("    <script src='ui/js/bootstrap.min.js'></script>");
		 out.println("    <script src='ui/js/jquery.scrollTo.min.js'></script>");
		 out.println("    <script src='ui/js/jquery.nicescroll.js' type='text/javascript'></script>");
		 out.println("    <script src='ui/js/jquery-ui-1.9.2.custom.min.js'></script>");
		 out.println("    <script class='include' type='text/javascript' src='ui/js/jquery.dcjqaccordion.2.7.js'></script>");
		 out.println("  <script src='ui/js/bootstrap-switch.js'></script>");
		 out.println("  <script src='ui/js/jquery.tagsinput.js'></script>");
		 out.println("  <script type='text/javascript' src='ui/js/ga.js'></script>");
		 out.println("  <script type='text/javascript' src='ui/assets/bootstrap-datepicker/js/bootstrap-datepicker.js'></script>");
		 out.println("  <script type='text/javascript' src='ui/assets/bootstrap-daterangepicker/date.js'></script>");
		 out.println("  <script type='text/javascript' src='ui/assets/bootstrap-daterangepicker/daterangepicker.js'></script>");
		 out.println("  <script type='text/javascript' src='ui/assets/bootstrap-colorpicker/js/bootstrap-colorpicker.js'></script>");
		 out.println("  <script type='text/javascript' src='ui/assets/ckeditor/ckeditor.js'></script>");
		 out.println("  <script type='text/javascript' src='ui/assets/bootstrap-inputmask/bootstrap-inputmask.min.js'></script>");
		 out.println("  <script src='ui/js/respond.min.js' ></script>");
		 out.println("  <script src='ui/js/slidebars.min.js'></script>");
		 out.println("  <script src='ui/js/common-scripts.js'></script>");
		 out.println("  <script src='ui/js/form-component.js'></script>");
		 out.println("  </body>");
		 out.println("</html>");
		 
		 
		 
		 
		 
		 
		 
		 
	


	}

}
