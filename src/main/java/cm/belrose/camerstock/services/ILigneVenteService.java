package cm.belrose.camerstock.services;

import java.util.List;

import cm.belrose.camerstock.entities.LigneVente;

public interface ILigneVenteService {
public LigneVente save (LigneVente entity);
	
	public LigneVente update(LigneVente entity);
	
	public LigneVente findByd(Long id);
	
	public void remove (Long id);
	
	public List<LigneVente> findByAll();
	
	public List<LigneVente> findByAll(String sortField, String sort);
	
	public LigneVente findOne (String paramName, Object paramValue);
	
	public LigneVente findOne (String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);

}
