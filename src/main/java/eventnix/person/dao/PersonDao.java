package eventnix.person.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import eventnix.common.model.Login;
import eventnix.generic.dao.GenericDao;
import eventnix.person.model.Person;

public class PersonDao extends GenericDao<Person, Long> implements PersonDaoI {
	public boolean login(String username, String password) {
		String sql = "from Person p where p.login.username=:username and p.login.password=:password";
		Query query = em.createQuery(sql).setParameter("username", username)
				.setParameter("password", password);
		Person person = new Person ();
		List <Person> list = query.getResultList();
		
		 if (list.isEmpty()){
			 return false;
		 }
		 else{
			 return true; 
		 }
	}

	public String userDetails(String username, String password) {
		String lastname = "";
		String sql = "from Person p where p.login.username=:username and p.login.password=:password";
		Query query = em.createQuery(sql).setParameter("username", username)
				.setParameter("password", password);
		List <Person> list = query.getResultList();
		 if (list.isEmpty()){
			 return null;
		 }
		 else{
			 for (Person p : list){
				lastname = p.getLastName();
			 }
		 }
		 return lastname;
	
	}

	public String userType(String username, String password) {
		String usertype = "";
		String sql = "from Person p where p.login.username=:username and p.login.password=:password";
		Query query = em.createQuery(sql).setParameter("username", username)
				.setParameter("password", password);
		List <Person> list = query.getResultList();
		 if (list.isEmpty()){
			 return null;
		 }
		 else{
			 for (Person p : list){
				usertype = p.getLogin().getUserType().toString();
			 }
		 }
		 return usertype;
	}
	
	
	

	


	



}
