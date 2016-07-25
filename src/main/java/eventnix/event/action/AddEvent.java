package eventnix.event.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.HttpConstraintElement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eventnix.event.bean.EventBeanI;
import eventnix.event.model.Event;

@WebServlet("/addEvent/*")
public class AddEvent extends HttpServlet {
	
	@EJB
	private EventBeanI eventBean;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		
		String [] pathCmp = req.getRequestURI().split("/");
		String path = pathCmp[pathCmp.length-1];
		System.out.println(path);
		if(path.equalsIgnoreCase("approve")){
			int id = Integer.parseInt(req.getParameter("id"));
			eventBean.approve(id);
			
		}
		else if (path.equalsIgnoreCase("disapprove")){
			int id = Integer.parseInt(req.getParameter("id"));
			eventBean.disapprove(id);
		}
		else if (path.equalsIgnoreCase("loadOrganizerEvent"))
		{
			HttpSession session = req.getSession();
			Long id = Long.parseLong(session.getAttribute("uid").toString());
			PrintWriter out = resp.getWriter();
	        out.println(eventBean.userPostedEventsJSON(id));
		}
		else {
			this.list(resp);
		}
		
		
	}


	public void list(HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
        out.println(eventBean.listInJson());
	
			}
	
	public void action(HttpServletResponse resp, HttpServletRequest req)
			throws ServletException, IOException {
		
		
	}
}
