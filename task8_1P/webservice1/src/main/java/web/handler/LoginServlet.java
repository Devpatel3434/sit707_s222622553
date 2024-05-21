package web.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.LoginService;


/**
 * HTTP end-point to handle login service.
 */
public class LoginServlet extends HttpServlet{

	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException, ServletException {	 
		System.out.println("[LoginServlet] GET");
		
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException, ServletException {		
		System.out.println("[LoginServlet] POST");
		
		String username = req.getParameter("username");
		String password = req.getParameter("passwd");
		String dob = req.getParameter("dob");
		
		System.out.println("Username/password: " + username + ", " + password + "," + dob);
		
		String loginStatus = "fail";
		
		if (LoginService.login(username, password, dob)) {
			loginStatus = "success";
		}
		
	    // Set content type to text/html which helps Selenium to understand better 
        resp.setContentType("text/html");

        // Create PrintWriter object for sending response
        PrintWriter writer = resp.getWriter();
		
        writer.println("<html>");
        writer.println("<head><title>" + loginStatus + "</title></head>");
        writer.println("<body>");
        writer.println("<h2>Login status: " + loginStatus + "</h2>");
        writer.println("</body>");
        writer.println("</html>");
		
		//PrintWriter writer = resp.getWriter();
		//writer.println(htmlResponse);
		writer.close();

		
	}

	
}
