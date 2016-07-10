package eventnix.person.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("./login/action/*")

public class LoginAction extends HttpServlet{
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		 PrintWriter out = resp.getWriter();
		 out.println("<head>");
		 out.print("<h2> you are now here </h2>");
		 
		
	}
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 String username = (req.getParameter("username"));
		 String password = (req.getParameter("password"));
		 System.out.println(username);
		 System.out.println(password);
	}

}
