package eventnix.event.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import eventnix.event.model.Event;
import eventnix.generic.dao.GenericDao;

public class EventDao extends GenericDao<Event, Long> implements EventDaoI {

	public void approve(int id) {
		String hql = "update Event e set e.status = 'Approved' where e.id=:id";
		Query query = em.createQuery(hql).setParameter("id", id);
		query.executeUpdate();
	}

	public void disapprove(int id) {
		String hql = "update Event e set e.status = 'Disapproved' where e.id=:id";
		Query query = em.createQuery(hql).setParameter("id", id);
		query.executeUpdate();
	}

	public Event getEventDetailsById(int id) {

		List<Event> events = getEm().createQuery("from Event where id=:id")
				.setParameter("id", id).getResultList();
		 System.out.println(events.get(0));
	 return events.get(0);
	

	}
	/*public List <Object> updateAvailableTickets(){
		List <Object> availableTickets = new ArrayList <Object>();
		List <Object []> result = em.createNativeQuery("select count(ticke");
		return null;
		
	}*/
	public List <Event> getUserPostedEvent (long id) {
		return em.createQuery("from Event e where e.userId=:id").setParameter("id", id).getResultList();
		
	}
	
	public int countAllUserPostedEvents (long id){
		List result =  em.createQuery("select count(id) from Event where userId=:id").setParameter("id", id).getResultList();
	
		
		return ((Long) result.get(0)).intValue();
		
	}
}
