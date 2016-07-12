package eventnix.person.bean;

import eventnix.person.model.Person;

public interface PersonBeanI{
	
	void save(Person person);
	
	boolean loginStatus (String username, String password);

	String userType(String username, String password);
	
	String lastName(String username, String password);
}