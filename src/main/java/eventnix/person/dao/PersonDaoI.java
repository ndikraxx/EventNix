package eventnix.person.dao;

import java.util.List;

import eventnix.common.model.Login;
import eventnix.generic.dao.GenericDaoI;
import eventnix.person.model.Person;

public interface PersonDaoI extends GenericDaoI<Person, Long>{
	 
	boolean login(String username, String password);

	String userDetails(String username, String password);

	String userType(String username, String password);

}
