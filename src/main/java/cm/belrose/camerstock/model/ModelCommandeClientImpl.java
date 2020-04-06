package cm.belrose.camerstock.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;

import cm.belrose.camerstock.entities.Article;
import cm.belrose.camerstock.entities.Client;
import cm.belrose.camerstock.entities.CommandeClient;
import cm.belrose.camerstock.entities.LigneCommandeClient;

/*
 * Cette annotation va nous permettre d'utiliser l'inversion de controle est l'injection de dependence de spring
 * En cas de plusieurs implementations il faut lui donner un nom
 */
@Component
public class ModelCommandeClientImpl implements ModelCommandeClient {
	
	private CommandeClient commande;
	
	private Map<Long,LigneCommandeClient> ligneCommande=new HashMap<Long, LigneCommandeClient>();

	public void creerCommande(Client client) {
		if(client==null) {
			return;
		}
		commande=new CommandeClient();
		commande.setClient(client);
		commande.setDateCommande(new Date());
		commande.setCode(generateCodeCommande());
		
	}

	public LigneCommandeClient ajouterLigneCommande(Article article) {
		if(article==null) {
			return null;
		}
		LigneCommandeClient lc=ligneCommande.get(article.getIdArticle());
		if(lc!=null) {
			BigDecimal qte=lc.getQuantite().add(BigDecimal.ONE);
			lc.setQuantite(qte);
			ligneCommande.put(article.getIdArticle(), lc);
		}else {
			LigneCommandeClient ligne=new LigneCommandeClient();
			ligne.setCommandeClient(commande);
			ligne.setQuantite(BigDecimal.ONE);
			ligne.setPrixUnitaire(article.getPrixUnitaireTTC());
			ligne.setArticle(article);
			ligneCommande.put(article.getIdArticle(),ligne);
			return ligne;
		}
				return null;
	}

	public LigneCommandeClient supprimerLigneCommande(Article article) {
		if(article==null) {
			return null;
		}
		return ligneCommande.remove(article.getIdArticle());
	}

	public LigneCommandeClient modifierQuantite(Article article, double quantite) {
		if(article==null) {
			return null;
		}
		LigneCommandeClient lc=ligneCommande.get(article.getIdArticle());
		if(lc==null) {
			return null;
		}
		lc.setQuantite(BigDecimal.valueOf(quantite));
		return lc;
	}

	public String generateCodeCommande() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}

	public CommandeClient getCommande() {
		return commande;
	}

	public void setCommande(CommandeClient commande) {
		this.commande = commande;
	}

	public Map<Long, LigneCommandeClient> getLigneCommande() {
		return ligneCommande;
	}

	public void setLigneCommande(Map<Long, LigneCommandeClient> ligneCommande) {
		this.ligneCommande = ligneCommande;
	}

	
}
