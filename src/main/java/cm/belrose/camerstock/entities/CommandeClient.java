package cm.belrose.camerstock.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 
@Table(name="commande_client")
public class CommandeClient implements Serializable {
	/**
	 * @author Ngnawen
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue	
	@Column(name="id_commande_client")
	private Long idCommandeClient;
	
	private String code;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_commande")
	private Date dateCommande;
	
	@ManyToOne
	@JoinColumn(name = "idClient")
	private Client client;
	
	/*
	 * @Transient: annotation pour dire a hibernate de ne pas persiste cet attribut dans la base de donnée
	 */
	@Transient
	private BigDecimal totalCommande;
	
	
	/*
	 * Annotation @JsonIgnore permmet a hibernate d'ignorer cet attribut lors de la recupération des données
	 * car cet attribut pourait creer le lazyloardException
	 */
	@JsonIgnore
	@OneToMany(mappedBy = "commandeClient")
	private List<LigneCommandeClient> ligneCommandeClients;
	
	

	public CommandeClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdCommandeClient() {
		return idCommandeClient;
	}

	public void setIdCommandeClient(Long id) {
		this.idCommandeClient = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<LigneCommandeClient> getLigneCommandeClients() {
		return ligneCommandeClients;
	}

	public void setLigneCommandeClients(List<LigneCommandeClient> ligneCommandeClients) {
		this.ligneCommandeClients = ligneCommandeClients;
	}

	public BigDecimal getTotalCommande() {
		if(!ligneCommandeClients.isEmpty()) {
			for (LigneCommandeClient ligneCommandeClient : ligneCommandeClients) {
				BigDecimal totalLigne=ligneCommandeClient.getQuantite().multiply(ligneCommandeClient.getPrixUnitaire());
				totalCommande=totalCommande.add(totalLigne);
			}
		}
		return totalCommande;
	}
	
	
	

}
