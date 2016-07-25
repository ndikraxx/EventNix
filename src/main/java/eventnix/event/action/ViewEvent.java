package eventnix.event.action;
import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eventnix.event.bean.EventBeanI;
import eventnix.ticket.bean.TicketBeanI;
import eventnix.ticket.model.Ticket;

@WebServlet("/viewEvent/*")
public class ViewEvent extends HttpServlet{
	@EJB
	private TicketBeanI ticketBean;
	
	@EJB
	private EventBeanI eventBean;

	 String eventId, ticketQuantity, eventPrice;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		String [] pathCmp = req.getRequestURI().split("/");
		String path = pathCmp[pathCmp.length-1];
		
		 if(path.equalsIgnoreCase("eventid")){
			eventId = req.getParameter("id");
			ticketQuantity =req.getParameter("tickets");
			eventPrice =req.getParameter("price");
			
		}
		 else if(path.equalsIgnoreCase("seemore")){
			 PrintWriter  out = resp.getWriter();
				int id =Integer.parseInt(req.getParameter("id"));
				out.print(eventBean.getEventDetails(id));
				}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Ticket ticket = new Ticket ();
		String userId=  req.getSession().getAttribute("uid").toString ();
		System.out.println(userId);
		ticket.setUserId(Long.parseLong(userId));
		ticket.setEventId(Integer.parseInt(eventId));
		ticket.setAmount(Integer.parseInt(eventPrice));
		ticket.setTicketsBooked(Integer.parseInt(ticketQuantity));
		ticket.setPhoneNumber(req.getParameter("phone"));
		ticket.setTransactionNumber(req.getParameter("transaction"));
		ticketBean.save(ticket);
	}

}
