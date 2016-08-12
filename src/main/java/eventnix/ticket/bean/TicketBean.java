package eventnix.ticket.bean;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import eventnix.event.model.Event;
import eventnix.ticket.dao.TicketDaoI;
import eventnix.ticket.model.Ticket;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TicketBean implements TicketBeanI {
	
	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private TicketDaoI ticketDao;
	
	@PostConstruct
	public void init(){
		
		ticketDao.setEm(em);
		
	}
	public void save(Ticket ticket) {
		
		ticketDao.save(ticket);
		
	}
	
	public List<Object> AttendersList (int id)
	{
		System.out.println(ticketDao.attendersList(id));
		return ticketDao.attendersList(id);
		
	}
	

	public String attendersListJSON (int id){
		int count1 = ticketDao.countAttendersList(id);
		if (count1==0){
			System.out.println("the number of attenders is  "+count1);
			return null;
		}
		else{
		List<Object> tickets = ticketDao.attendersList(id);
		
		System.out.println(tickets);
		StringBuilder sb = new StringBuilder();
		int count = ticketDao.countAttendersList(id);
		
			System.out.println("the number of attenders is  "+count);
		/*	return null;
		}*/
		/*else{*/
		sb.append("[");
		
		
		for(Object ticket : tickets){
			sb.append(((Ticket) ticket).getattendersListJson());
			
			count--;
			
			if(count >= 1)
				sb.append(",");
		}
		
		
		
		sb.append("]");
	
		return sb.toString();
		
		}
	}
	
	public void updatePayments(){
		ticketDao.updatePayments();
	}
	@Override
	public List<Object> ticketsSoldPerDayPerEvent(int id) {
		System.out.println(ticketDao.ticketsSoldPerDayPerEvent(id));
		return ticketDao.ticketsSoldPerDayPerEvent(id);
	}

	@Override
	public String ticketsPerDay (int id){
		//Map<String, Object> filter = new HashMap<String, Object>();
		List<Object> tickets=  ticketDao.ticketsSoldPerDayPerEvent(id);
		
		
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		int count = ticketDao.countTicketsPerDay(id);
		System.out.println("the count of dates is" +count);
		for(Object ticket : tickets){
			sb.append(((Ticket) ticket).getTicketsSoldPerDayJSN());
			
			count--;
			
			if(count >= 1)
				sb.append(",");
		}
		
		sb.append("]");
	System.out.println(sb);
		return sb.toString();
		
	
	}
	

}
