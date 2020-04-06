package cm.belrose.camerstock.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cm.belrose.camerstock.dao.IGenericDao;

@SuppressWarnings("unchecked")
public class GenericDaoImpl<E> implements IGenericDao<E> {

	@PersistenceContext
	EntityManager em;

	private Class<E> type;

	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class<E>) pt.getActualTypeArguments()[0];

	}
	

	public Class<E> getType() {
		return type;
	}

	//@Override
	public E save(E entity) {
		em.persist(entity);
		return entity;

	}

	//@Override
	public E update(E entity) {
		em.merge(entity);
		return entity;
	}

	//@Override
	public E findByd(Long id) {
		return em.find(type, id);
	}

	//@Override
	public void remove(Long id) {
		E tab = em.getReference(type, id);
		em.remove(tab);

	}

	//@Override
	public List<E> findByAll() {
		Query query = em.createQuery("select t from " + type.getSimpleName() + " t");
		return query.getResultList();
	}

	//@Override
	public List<E> findByAll(String sortField, String sort) {
		Query query = em.createQuery("select t from " + type.getSimpleName() + " t order by " + sortField + " " + sort);
		return query.getResultList();
	}

	//@Override
	public E findOne(String paramName, Object paramValue) {
		Query query = em.createQuery("select t from " + type.getSimpleName() + " t where " + paramName + " =:x");
		query.setParameter("x", paramValue);
		return query.getResultList().size() > 0 ? (E) query.getResultList().get(0) : null;
	}

	//@Override
	public E findOne(String[] paramNames, Object[] paramValues) {
		if(paramNames.length!=paramValues.length) {
			return null;
		}
		String queryString="select e from "+type.getName()+" e where ";
		for(int i=0; i<paramNames.length; i++) {
			queryString+="e."+paramNames[i]+"=:x"+i;
			if((i+1)<paramNames.length) {
				queryString+= "and";
			}
		}
		Query query=em.createQuery(queryString);
		for(int i=0; i<paramNames.length;i++) {
			query.setParameter("x"+i, paramValues[i]);
		}
		return query.getResultList().size()>0?(E)query.getResultList().get(0):null;
	}

	//@Override
	public int findCountBy(String paramName, String paramValue) {
		Query query = em.createQuery("select t from " + type.getSimpleName() + " t where " + paramName + " =:x");
		query.setParameter(paramName, paramValue);
		return query.getResultList().size() > 0 ? ((Long) query.getSingleResult()).intValue():0;
	}


}
