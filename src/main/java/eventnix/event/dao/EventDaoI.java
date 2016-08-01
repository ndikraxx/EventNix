package eventnix.event.dao;

import java.util.List;
import java.util.Map;

import eventnix.event.model.Event;
import eventnix.generic.dao.GenericDaoI;

public interface EventDaoI extends GenericDaoI<Event, Long> {

	void approve(int id);

	void disapprove(int id);
	
	Event getEventDetailsById(int id);

	List<Event> getUserPostedEvent(long id);

	int countAllUserPostedEvents(long id);

	List<Event> searchByName(String searchParameter);

	List<Event> searchByVenue(String searchParameter);

	int countofSearchByName(String searchParamter);

	int countofSearchByVenue(String searchParameter);

	List<Event> searchByDesc(String searchParameter);

	int countofSearchByDesc(String searchParameter);
	
	
}
