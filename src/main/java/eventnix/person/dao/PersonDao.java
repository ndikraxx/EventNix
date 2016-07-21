package eventnix.person.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import eventnix.common.model.Login;
import eventnix.generic.dao.GenericDao;
import eventnix.person.model.Person;

public class PersonDao extends GenericDao<Person, Long> implements PersonDaoI {
	public boolean login(String phone, String password) {
		String sql = "from Person p where p.phoneNumber=:phoneNumber and p.password=:password";
		Query query = em.createQuery(sql).setParameter("phoneNumber", phone)
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

	public String userDetails(String phone, String password) {
		String lastname = "";
		String sql = "from Person p where p.phoneNumber=:phoneNumber and p.password=:password";
		Query query = em.createQuery(sql).setParameter("phoneNumber", phone)
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

	public String userType(String phone, String password) {
		String usertype = "";
		String sql = "from Person p where p.phoneNumber=:phoneNumber and p.password=:password";
		Query query = em.createQuery(sql).setParameter("phoneNumber", phone)
				.setParameter("password", password);
		List <Person> list = query.getResultList();
		 if (list.isEmpty()){
			 return null;
		 }
		 else{
			 for (Person p : list){
				usertype = p.getUserType().toString();
			 }
		 }
		 return usertype;
	}
	
	public String userId(String phone, String password) {
		String userId = "";
		String sql = "from Person p where p.phoneNumber=:phoneNumber and p.password=:password";
		Query query = em.createQuery(sql).setParameter("phoneNumber", phone)
				.setParameter("password", password);
		List <Person> list = query.getResultList();
		 if (list.isEmpty()){
			 return null;
		 }
		 else{
			 for (Person p : list){
				 userId = p.getId().toString();
			 }
		 }
		 return userId;
	}
	
	
	

	


	



}
