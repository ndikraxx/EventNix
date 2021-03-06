package eventnix.ticket.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eventnix.ticket.bean.TicketBeanI;


@WebServlet ("/ticket/*")
public class TicketAction extends HttpServlet {
	@EJB
	
	private TicketBeanI ticketBean;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		String comp [] = req.getRequestURI().split("/");
		
		String path = comp [comp.length-1];
		
		if (path.equalsIgnoreCase("viewAttendersList")){
			
			int eventId =  Integer.parseInt(req.getParameter("eventid"));
			
			
			if (ticketBean.attendersListJSON(eventId) != null)
			out.println(ticketBean.attendersListJSON(eventId));
			else
			
				out.println("[]");
		}
		else if(path.equalsIgnoreCase("ticketsperday")){
			
			int id =  Integer.parseInt(req.getParameter("id"));
			
			System.out.println(ticketBean.ticketsPerDay(id));
			out.println(ticketBean.ticketsPerDay(id));
		}
		
		ticketBean.updatePayments();
	}

}
