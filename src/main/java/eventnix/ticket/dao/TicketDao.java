package eventnix.ticket.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import eventnix.generic.dao.GenericDao;
import eventnix.person.model.Person;
import eventnix.ticket.model.Ticket;

public class TicketDao extends GenericDao<Ticket, Long> implements TicketDaoI {
	
	public List<Object> attendersList (int id){
		List <Object> attendersList = new ArrayList<Object>();
		List <Object []> attendingUsers= em.createNativeQuery(" select  p.first_name, p.last_name, p.email, p.phone_number, t.ticketsBooked, t.amount  from  Ticket t, Person p where p.id=t.userId and t.eventId=:id").
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
		attendersList.add(ticket);
		}
		
		
		
		System.out.println(attendersList);
		return attendersList;
		
	}

	public int countAttendersList (int id){
		List result = em.createQuery("select count(p.firstName) from Person p, Ticket t where p.id=t.userId and t.eventId=:id").
				setParameter("id", id).getResultList();
	
		
		return ((Long) result.get(0)).intValue();
		
	}

}
