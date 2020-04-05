package cm.belrose.camerstock.dao.impl;


import java.util.List;

import javax.persistence.Query;

import cm.belrose.camerstock.dao.ILigneCommandeClientDao;
import cm.belrose.camerstock.entities.LigneCommandeClient;

public class LigneCommandeClientDaoImpl extends GenericDaoImpl<LigneCommandeClient>  implements ILigneCommandeClientDao{

	/*
	 * Cette methode permet de recuperer les listes des lignes de commande client
	 */
	@SuppressWarnings("unchecked")
	public List<LigneCommandeClient> findByIdCommande(Long idCommandeClient) {
		String queryString="select lc from "+LigneCommandeClient.class.getSimpleName()+" lc where lc.commandeClient.idCommandeClient=:x";
		Query query=em.createQuery(queryString);
		query.setParameter("x", idCommandeClient);
		return query.getResultList();
	}

}
