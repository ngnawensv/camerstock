package cm.belrose.camerstock.services;

import java.util.List;

import cm.belrose.camerstock.entities.Categorie;

public interface ICategorieService {
	
public Categorie save (Categorie entity);
	
	public Categorie update(Categorie entity);
	
	public Categorie findByd(Long id);
	
	public void remove (Long id);
	
	public List<Categorie> findByAll();
	
	public List<Categorie> findByAll(String sortField, String sort);
	
	public Categorie findOne (String paramName, Object paramValue);
	
	public Categorie findOne (String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);

}
