package eventnix.event.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eventnix.event.bean.EventBeanI;
@WebServlet("/search/*")


public class SearchEvent  extends HttpServlet{

	@EJB
	private EventBeanI eventBean;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	 String checkbox = req.getParameter("searchvalue");
	 String searchParameter = req.getParameter("parameter");
	  PrintWriter out = resp.getWriter();
	 if (checkbox.equals("Name")){
		eventBean.searchByName(searchParameter);
		out.println(eventBean.searchByName(searchParameter));
		
	 }
	 else  if (checkbox.equals("Venue")){
		 eventBean.searchByVenue(searchParameter);
		 out.println(eventBean.searchByVenue(searchParameter));
	 }
	 else if (checkbox.equals("Description")){
		 eventBean.searchByDesc(searchParameter);
		 out.println(eventBean.searchByDesc(searchParameter));
	 }
	 
	}
}
