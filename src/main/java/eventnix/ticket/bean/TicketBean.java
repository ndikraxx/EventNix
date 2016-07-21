package eventnix.ticket.bean;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	

}
