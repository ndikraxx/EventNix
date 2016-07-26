package eventnix.ticket.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.apache.commons.collections.map.HashedMap;

import eventnix.generic.dao.GenericDao;
import eventnix.person.model.Person;
import eventnix.ticket.model.Ticket;

public class TicketDao extends GenericDao<Ticket, Long> implements TicketDaoI {
	
	public List<Object> attendersList (int id){
		List <Object> attendersList = new ArrayList<Object>();
		List <Object []> attendingUsers= em.createNativeQuery("select p.first_name, p.last_name, p.email, p.phone_number, t.ticketsBooked, t.amount, pay.amount as AmountPaid from Ticket t, Person p, Payments pay where p.id=t.userId and t.eventId=:id and t.status = 'confirmed' and pay.amount >= (t.ticketsBooked * t.amount) and pay.trans = t.transactionNumber ").
				setParameter("id", id).getResultList();
		Ticket ticket;
		 
		for (Object  [] attending : attendingUsers){
		ticket = new Ticket ();
		ticket.setFirstName((String) attending[0]);
		ticket.setLastName((String) attending[1]);
		ticket.setEmail((String) attending[2]);
		ticket.setPhoneNumber((String) attending[3]);
		ticket.setTicketsBooked((Integer) attending[4]);
		ticket.setAmount((Integer) attending[5]);
		ticket.setAmountPaid((Integer) attending[6]);
		attendersList.add(ticket);
		}	
		
	List result = em.createNativeQuery("select sum(t.ticketsBooked) from Ticket t, Payments pay where  t.eventId=:id and t.status = 'confirmed' and pay.amount >= (t.ticketsBooked * t.amount) and pay.trans = t.transactionNumber").
				setParameter("id", id).getResultList();
	
	String ticketsBooked =result.get(0).toString();
	
	String query = "update Event e set e.remainingTickets=e.remainingTickets -:ticketsBooked where e.id=:id";
	em.createNativeQuery(query).setParameter("ticketsBooked", ticketsBooked).setParameter("id", id).executeUpdate();
		
		return attendersList;	
	}
	public int countAttendersList (int id){
		List result = em.createQuery("select count(p.firstName) from Person p, Ticket t where p.id=t.userId and t.eventId=:id").
				setParameter("id", id).getResultList();
		System.out.println("The count of attenders is "+result);
		return ((Long) result.get(0)).intValue();
		
	}
	
	public String numberTickets(){
		return null;
	}

	public void updatePayments() {
		em.createNativeQuery("update Payments p, Ticket t set t.status = 'Confirmed', p.status ='Used' where t.transactionNumber = p.trans and p.status = 'NULL' ").executeUpdate();
	}
	public List<Object> confirmedPayments (int id){
		
		@SuppressWarnings("unused")
		List<Object []> amountPaid = em.createNativeQuery("select p.first_name, p.last_name, p.email, p.phone_number, t.ticketsBooked, t.amount from Ticket t, Person p, Payments pay where p.id=t.userId and t.eventId=:id and t.status = 'confirmed' and pay.amount >= (t.ticketsBooked * t.amount) and pay.trans = t.transactionNumber ").
				setParameter("id", id).getResultList();
		List<Object> confirmedPayment = new ArrayList<Object> ();
		
		return null;
	}

}
