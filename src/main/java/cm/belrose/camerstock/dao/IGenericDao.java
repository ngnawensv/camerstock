package cm.belrose.camerstock.dao;

import java.util.List;

public interface IGenericDao<E> {
	
	public E save (E entity);
	
	public E update(E entity);
	
	public E findByd(Long id);
	
	public void remove (Long id);
	
	public List<E> findByAll();
	
	public List<E> findByAll(String sortField, String sort);
	
	public E findOne (String paramName, Object paramValue);
	
	public E findOne (String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);
	
	
	

}
