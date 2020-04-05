package cm.belrose.camerstock.services;

import java.util.List;

import cm.belrose.camerstock.entities.LigneCommandeClient;

public interface ILigneCommandeClientService {
public LigneCommandeClient save (LigneCommandeClient entity);
	
	public LigneCommandeClient update(LigneCommandeClient entity);
	
	public LigneCommandeClient findByd(Long id);
	
	public void remove (Long id);
	
	public List<LigneCommandeClient> findByAll();
	
	public List<LigneCommandeClient> findByAll(String sortField, String sort);
	
	public LigneCommandeClient findOne (String paramName, Object paramValue);
	
	public LigneCommandeClient findOne (String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);

	public List<LigneCommandeClient> findByIdCommande(Long idCommandeClient);

}
