package cm.belrose.camerstock.services;

import java.util.List;

import cm.belrose.camerstock.entities.Utilisateur;

public interface IUtilisateurService {
public Utilisateur save (Utilisateur entity);
	
	public Utilisateur update(Utilisateur entity);
	
	public Utilisateur findByd(Long id);
	
	public void remove (Long id);
	
	public List<Utilisateur> findByAll();
	
	public List<Utilisateur> findByAll(String sortField, String sort);
	
	public Utilisateur findOne (String paramName, Object paramValue);
	
	public Utilisateur findOne (String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);

}
