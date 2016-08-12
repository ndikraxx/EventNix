package eventnix.person.dao;

import java.util.List;

import eventnix.common.model.Login;
import eventnix.generic.dao.GenericDaoI;
import eventnix.person.model.Person;

public interface PersonDaoI extends GenericDaoI<Person, Long>{
	 
	boolean login(String phone, String password);

	String userDetails(String phone, String password);

	String userType(String phone, String password);

	String userId(String phone, String password);

	List<Object> userBookedTickets(int id);

	int countUserEvents(int id);

}
