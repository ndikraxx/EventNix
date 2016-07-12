package eventnix.person.bean;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import eventnix.person.dao.PersonDaoI;
import eventnix.person.model.Person;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PersonBean implements PersonBeanI{
	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private PersonDaoI personDao;
	
	@PostConstruct
	public void init(){
		personDao.setEm(em);
	}

	public void save(Person person) {
		personDao.save(person);
		
	}

	public boolean loginStatus(String username, String password) {
		
		if(personDao.login(username, password) == true)
			return true;
		else 
			return false;
	}

	public String userType(String username, String password) {
		return personDao.userType(username, password);
	}

	public String lastName(String username, String password) {
		
		return personDao.userDetails(username, password);
	}

/*	public String userType(String username, String password){
		if(personDao.login(username, password)== true){
		 return personDao.userType(username, password);	
	}
		return null;
}*/
	
	
}