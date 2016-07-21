package eventnix.person.bean;

import eventnix.person.model.Person;

public interface PersonBeanI{
	
	void save(Person person);
	
	boolean loginStatus (String phone, String password);

	String userType(String phone, String password);
	
	String lastName(String phone, String password);

	String userId(String phone, String password);
}