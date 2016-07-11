package eventnix.generic.dao;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

public class GenericDao<T, ID> implements GenericDaoI<T, ID> {
	private EntityManager em;
	
	private final Class<T> persistentClass;

	public void setEm(EntityManager em) {
		this.em = em;
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

	public T save(T entity) {
		
		return em.merge(entity);
	}

}
