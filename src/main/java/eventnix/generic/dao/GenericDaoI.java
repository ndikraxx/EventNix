package eventnix.generic.dao;

import javax.persistence.EntityManager;

public interface GenericDaoI<T, ID> {
	
	void setEm(EntityManager em);
	
	T save (T entity);

}
