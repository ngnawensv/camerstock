package cm.belrose.camerstock.dao;

import java.util.List;

import cm.belrose.camerstock.entities.LigneCommandeClient;

public interface ILigneCommandeClientDao extends IGenericDao<LigneCommandeClient>{
	
	public List<LigneCommandeClient> findByIdCommande(Long idCommandeClient);

}
