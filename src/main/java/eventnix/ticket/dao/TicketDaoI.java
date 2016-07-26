package eventnix.ticket.dao;

import java.util.List;
import java.util.Map;

import eventnix.generic.dao.GenericDaoI;
import eventnix.ticket.model.Ticket;


public interface TicketDaoI extends GenericDaoI<Ticket, Long>{

	List<Object> attendersList(int id);

	int countAttendersList(int id);

	List<Object> confirmedPayments(int id);

	void updatePayments();

	String numberTickets();


}
