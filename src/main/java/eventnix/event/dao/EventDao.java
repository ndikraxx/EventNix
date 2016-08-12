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
	
	public List<Event> getPostedEventAdmin () {
		return em.createQuery(" from Event e where e.status='Approved'").getResultList();
		
	}
	@Override
	public int countofAllPostedEventsAdmin(){
		
		List result = em.createQuery("select count(e.name) from Event e where e.status='Approved' ").getResultList();
		return ((Long) result.get(0)).intValue();
	}
	
	public int countAllUserPostedEvents (long id){
		List result =  em.createQuery("select count(id) from Event where userId=:id").setParameter("id", id).getResultList();
	
		
		return ((Long) result.get(0)).intValue();
		
	}

	@Override
	public List<Event> searchByName(String searchParameter) {
		List <Event>result = em.createQuery("from Event e where e.name like :search")
				.setParameter("search", "%" + searchParameter + "%")
				.getResultList();
		System.out.println("This is the result "+result);
		return result;
		
	}
	
	
	public int countofSearchByName(String searchParameter){
	List result =  em.createQuery("select count (*) from Event e where e.name like :search")
				.setParameter("search", "%" + searchParameter + "%").getResultList();
	System.out.println(((Long) result.get(0)).intValue());
	return ((Long) result.get(0)).intValue();
	}
	public List searchByVenue(String searchParameter) {
		
		List <Event>result = em.createQuery("from Event e where e.venue like :search")
				.setParameter("search", "%" + searchParameter + "%")
				.getResultList();
		System.out.println("This is the result "+result);
		return result;
		
	}

	@Override
	public int countofSearchByVenue(String searchParameter) {
		List result =  em.createQuery("select count (*) from Event e where e.venue like :search")
				.setParameter("search", "%" + searchParameter + "%").getResultList();
	System.out.println(((Long) result.get(0)).intValue());
	return ((Long) result.get(0)).intValue();
	}
	@Override
	public List<Event> searchByDesc(String searchParameter) {
		
		List <Event>result = em.createQuery("from Event e where e.description like :search")
				.setParameter("search", "%" + searchParameter + "%")
				.getResultList();
		System.out.println("This is the result "+result);
		return result;
		
	}

	@Override
	public int countofSearchByDesc(String searchParameter) {
		List result =  em.createQuery("select count (*) from Event e where e.description like :search")
				.setParameter("search", "%" + searchParameter + "%").getResultList();
	System.out.println(((Long) result.get(0)).intValue());
	return ((Long) result.get(0)).intValue();
	}
}
