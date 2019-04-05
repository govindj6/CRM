package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EngineersLogin
 */
@WebServlet("/EngineersLogin")
public class EngineersLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EngineersLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		 
		
		out.println("<html lang='en'>");
		out.println("<head>");
		out.println("    <link rel='shortcut icon' href='img/faicon.jpg'>");
		out.println("    <title>CRM </title>");
		out.println("    <link href='ui/css/bootstrap.min.css' rel='stylesheet'>");
		out.println("    <link href='ui/css/bootstrap-reset.css' rel='stylesheet'>");
		out.println("    <link href='ui/assets/font-awesome/css/font-awesome.css' rel='stylesheet' />");
		out.println("    <link href='ui/css/style.css' rel='stylesheet'>");
		out.println("    <link href='ui/css/style-responsive.css' rel='stylesheet' />");
		out.println("</head>");
		out.println("  <body class='login-body'>");
		out.println("      <header class='header white-bg'>");
		out.println("          <div class='sidebar-toggle-box'>");
		out.println("          </div>");
		out.println("          <a href='#' class='logo' style='margin-top:5px;' ><img src='ui/img/logo.png' class='img-thumbnail'></a>");
		out.println("          <div class='nav notify-row' id='top_menu'>");
		out.println("            <ul class='nav top-menu'>");
		
		out.println("          </ul>");
		out.println("          </div>");
		out.println("          <div class='top-nav '>");
		out.println("              <ul class='nav pull-right top-menu'>");
		out.println("                  <li class='dropdown'>");
		out.println("                          <li><a href='AdminLogin'> Admin Login</a></li>");
		 out.println("                          <li><a href='EngineersLogin'> Engineer Login</a></li>");
		 out.println("                          <li><a href='SCLogin'> Service Center Login</a></li>");
		 out.println("                          <li><a href='EmployeesLogin'> Employees Login</a></li>");
		 out.println("                          <li><a href='CompanyLogin'> Company Login</a></li>");
	 
		out.println("                  </li>");
		out.println("              </ul>");
		out.println("          </div>");
		out.println("      </header>");
		out.println("    <div class='container'>");
		out.println("<div class='col-lg-7'><!-- Product #3 Starts -->");
		out.println("					<div class='col-md-12' style='padding-top:90px;'>");
		out.println("						<div class='product-col list clearfix'>");
		//out.println("						 <font size='5' color='#33CCCC'>CUSTOMER RELATIONSHIP MANAGEMENT (CRTP)</font><hr>");
		out.println("							<div class='caption'>");
		out.println("<br><br><h2><a href='#'>CUSTOMER RELATIONSHIP MANAGEMENT</a></h2>");

		out.println("								<div class='description'>");
		out.println("<p><img src='ui/img/home.jpg' class='img-thumbnail'>	</p>");
		out.println("								</div>");
		out.println("							</div>");
		out.println("						</div>");
		out.println("					</div>");
		out.println("				<!-- Product #3 Ends --></div>");
		out.println("<br><div class='col-lg-5'><form class='form-signin' action=CheckEngineersLogin method=post>");
		out.println("        <h2 class='form-signin-heading'>Engineers Login</h2>");
		out.println("        <div class='login-wrap'>");
		out.println("            <input type='text' class='form-control' name=eid placeholder='Engineers ID' autofocus>");
		out.println("            <input type='password' class='form-control' name=epwd placeholder='Password'>");
		
		out.println("            <button class='btn btn-lg btn-login btn-block' type='submit'>Sign in</button>");
		
		
		out.println("            <div class='registration'>");

		out.println("            </div>");
		out.println("        </div>");
		out.println("          <div aria-hidden='true' aria-labelledby='myModalLabel' role='dialog' tabindex='-1' id='myModal' class='modal fade'>");
		out.println("              <div class='modal-dialog'>");
		out.println("                  <div class='modal-content'>");
		out.println("                      <div class='modal-header'>");
		out.println("                          <button type='button' class='close' data-dismiss='modal' aria-hidden='true'>&times;</button>");
		out.println("                          <h4 class='modal-title'>Forgot Password ?</h4>");
		out.println("                      </div>");
		out.println("                      <div class='modal-body'>");
		out.println("                          <p>Enter your e-mail address below to reset your password.</p>");
		out.println("                          <input type='text' name='email' placeholder='Email' autocomplete='off' class='form-control placeholder-no-fix'>");
		out.println("                      </div>");
		out.println("                      <div class='modal-footer'>");
		out.println("                          <button data-dismiss='modal' class='btn btn-default' type='button'>Cancel</button>");
		out.println("                          <button class='btn btn-success' type='button'>Submit</button>");
		out.println("                      </div>");
		out.println("                  </div>");
		out.println("              </div>");
		out.println("          </div></form></div>");
		out.println("    </div>");
		out.println("    <script src='ui/js/jquery.js'></script>");
		out.println("    <script src='ui/js/bootstrap.min.js'></script>");
		out.println("  </body>");
		out.println("</html>");

		
		
		
		
	}

}
