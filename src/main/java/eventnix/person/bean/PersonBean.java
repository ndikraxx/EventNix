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
	@Inject
	PersonDaoI personDao;
	
	@PersistenceContext
	EntityManager em;
	
	@PostConstruct
	public void init(){
		personDao.setEm(em);
	}

	public Person save(Person person) {
		
		return personDao.save(person);
	}

	
	

}
