package eventnix.event.bean;

import java.util.List;

import eventnix.event.model.Event;

public interface EventBeanI {
	
	 void save(Event event);
	 
	 String listInJson();
	 
	 void approve (int id);

	void disapprove(int id);
	
	String getEventDetails(int id);

	String userPostedEventsJSON(long id);

	String searchByName(String searchParameter);

	String searchByVenue(String searchParameter);

	String searchByDesc(String searchParameter);

	String allPostedEvents();

}
