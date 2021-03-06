package eventnix.event.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import eventnix.event.dao.EventDaoI;
import eventnix.event.model.Event;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class EventBean implements EventBeanI{
	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private EventDaoI eventDao;
	
	@PostConstruct
	public void init(){
		eventDao.setEm(em);
	}

	public void save(Event event) {
		eventDao.save(event);
	}

	public List<Event> list() {
		return eventDao.list(new Event ());
		
	}

 
	public String listInJson() {
		Map<String, Object> filter = new HashMap<String, Object>();
		List<Event> events = eventDao.list(filter);
		
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		int count = eventDao.countAll();
		for(Event event : events){
			sb.append(event.getEvent());
			
			count--;
			
			if(count >= 1)
				sb.append(",");
		}
		
		sb.append("]");
	
		return sb.toString();
		
	}

	public void approve(int id) {
		eventDao.approve(id);
		
	}

	public void disapprove (int id){
		eventDao.disapprove(id);
	}

	public String getEventDetails(int id) {
		Event event = eventDao.getEventDetailsById(id);
		 return event.getEvent();
		
	}
	
	public String userPostedEventsJSON (long id){
		//Map<String, Object> filter = new HashMap<String, Object>();
		List<Event> events = eventDao.getUserPostedEvent(id);
		
		System.out.println(events);
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		int count = eventDao.countAllUserPostedEvents(id);
	
		for(Event event : events){
			sb.append(event.getEvent());
			
			count--;
			
			if(count >= 1)
				sb.append(",");
		}
		
		sb.append("]");
	
		return sb.toString();
		
	
	}


	public String searchByName(String searchParameter) {
		
	List<Event> events = eventDao.searchByName(searchParameter);
		
	
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		int count = eventDao.countofSearchByName(searchParameter);
	
		for(Event event : events){
			sb.append(event.getEvent());
			
			count--;
			
			if(count >= 1)
				sb.append(",");
		}
		
		sb.append("]");
	System.out.println(sb);
		return sb.toString();
		

	}


	public String searchByVenue(String searchParameter) {
		List<Event> events = eventDao.searchByVenue(searchParameter);
		
		
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		int count = eventDao.countofSearchByVenue(searchParameter);
	
		for(Event event : events){
			sb.append(event.getEvent());
			
			count--;
			
			if(count >= 1)
				sb.append(",");
		}
		
		sb.append("]");
	System.out.println(sb);
		return sb.toString();
		

	}

	
	public String searchByDesc(String searchParameter) {
		List<Event> events = eventDao.searchByDesc(searchParameter);
		
		
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		int count = eventDao.countofSearchByDesc(searchParameter);
	
		for(Event event : events){
			sb.append(event.getEvent());
			
			count--;
			
			if(count >= 1)
				sb.append(",");
		}
		
		sb.append("]");
	System.out.println(sb);
		return sb.toString();
		

	}
	@Override
	public String allPostedEvents (){
		//Map<String, Object> filter = new HashMap<String, Object>();
		List<Event> events = eventDao.getPostedEventAdmin();
		
		System.out.println(events);
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		int count = eventDao.countofAllPostedEventsAdmin();
	
		for(Event event :  events){
			sb.append(event.getEvent());
			
			count--;
			
			if(count >= 1)
				sb.append(",");
		}
		
		sb.append("]");
	
		return sb.toString();
		
	
	}

	

}
