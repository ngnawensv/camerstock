package cm.belrose.camerstock.model;

import cm.belrose.camerstock.entities.Article;
import cm.belrose.camerstock.entities.Client;
import cm.belrose.camerstock.entities.LigneCommandeClient;

public interface ModelCommandeClient {
	
	void creerCommande(Client client);
	
	LigneCommandeClient ajouterLigneCommande(Article article);
	
	LigneCommandeClient supprimerLigneCommande(Article article);
	
	LigneCommandeClient modifierQuantite(Article article, double quantite);
	
	String generateCodeCommande();

}
