package eventnix.person.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import eventnix.person.dao.PersonDaoI;
import eventnix.person.model.Person;
import eventnix.ticket.model.Ticket;

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

	public boolean loginStatus(String phone, String password) {
		
		if(personDao.login(phone, password) == true)
			return true;
		else 
			return false;
	}

	public String userType(String phone, String password) {
		return personDao.userType(phone, password);
	}

	public String lastName(String phone, String password) {
		
		return personDao.userDetails(phone, password);
	}

	public String userId(String phone, String password){

		 return personDao.userId(phone, password);	
	}
	
	public String attendersListJSON (int id){
		int count1 = personDao.countUserEvents(id);
		if (count1==0){
			System.out.println("the number of attenders is  "+count1);
			return null;
		}
		else{
		List<Object> persons = personDao.userBookedTickets(id);
		
		System.out.println(persons);
		StringBuilder sb = new StringBuilder();
		int count =  personDao.countUserEvents(id);
		
			System.out.println("the number of attenders is  "+count);
		
		sb.append("[");
		
		
		for(Object person : persons){
			sb.append(((Person) person).getUserEventsJson());
			
			count--;
			
			if(count >= 1)
				sb.append(",");
		}
		
		
		
		sb.append("]");
	
		return sb.toString();
		
		}
	}
	
	
}