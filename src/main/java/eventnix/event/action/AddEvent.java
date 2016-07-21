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

import eventnix.event.bean.EventBeanI;
import eventnix.event.model.Event;

@WebServlet("/addEvent/*")
public class AddEvent extends HttpServlet {
	
	@EJB
	private EventBeanI eventBean;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.list(resp);
		
		
		String [] pathCmp = req.getRequestURI().split("/");
		String path = pathCmp[pathCmp.length-1];
		
		if(path.equalsIgnoreCase("approve")){
			int id = Integer.parseInt(req.getParameter("id"));
			eventBean.approve(id);
			
		}
		else if (path.equalsIgnoreCase("disapprove")){
			int id = Integer.parseInt(req.getParameter("id"));
			eventBean.disapprove(id);
		}
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	Event event = new Event ();
	event.setName(req.getParameter("name"));
	event.setVenue(req.getParameter("venue"));
	event.setPrice(req.getParameter("price"));
	String tickets = req.getParameter("ticketsAvailable");
	event.setTickets(Integer.parseInt(tickets));
	event.setCategory(req.getParameter("category"));
	event.setDescription(req.getParameter("description"));
	eventBean.save(event);
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
