package cm.belrose.camerstock.services;

import java.util.List;

import cm.belrose.camerstock.entities.Vente;

public interface IVenteService {
public Vente save (Vente entity);
	
	public Vente update(Vente entity);
	
	public Vente findByd(Long id);
	
	public void remove (Long id);
	
	public List<Vente> findByAll();
	
	public List<Vente> findByAll(String sortField, String sort);
	
	public Vente findOne (String paramName, Object paramValue);
	
	public Vente findOne (String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);

}
