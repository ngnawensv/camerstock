package cm.belrose.camerstock.services;

import java.util.List;

import cm.belrose.camerstock.entities.Fournisseur;

public interface IFournisseurService {
public Fournisseur save (Fournisseur entity);
	
	public Fournisseur update(Fournisseur entity);
	
	public Fournisseur findByd(Long id);
	
	public void remove (Long id);
	
	public List<Fournisseur> findByAll();
	
	public List<Fournisseur> findByAll(String sortField, String sort);
	
	public Fournisseur findOne (String paramName, Object paramValue);
	
	public Fournisseur findOne (String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);

}
