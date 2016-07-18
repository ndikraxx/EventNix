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
		System.out.println(sb.toString());
		return sb.toString();
		
	}
	
	

}
