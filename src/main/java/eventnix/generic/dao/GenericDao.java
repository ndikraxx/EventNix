package eventnix.generic.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;



public class GenericDao<T, ID extends Serializable> implements GenericDaoI<T, ID> {

	private final Class<T> persistentClass;
	
	protected EntityManager em;
	
	public void setEm(EntityManager em){
		this.em = em;
	}
	
	public EntityManager getEm(){
		return this.em;
	}
	
	@SuppressWarnings("unchecked")
	public GenericDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public GenericDao(final Class<T> persistentClass) {
		super();
		this.persistentClass = persistentClass;
	}
	
	public T save(T entity){
		return em.merge(entity);
	}
	
}
