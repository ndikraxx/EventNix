package eventnix.ticket.bean;

import java.util.List;
import java.util.Map;

import eventnix.ticket.model.Ticket;

public interface TicketBeanI {
	
	void save (Ticket ticket);

	List<Object> AttendersList(int id);

	String attendersListJSON(int id);

}
