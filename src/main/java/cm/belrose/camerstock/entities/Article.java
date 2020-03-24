package cm.belrose.camerstock.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "article")
public class Article implements Serializable {
	/**
	 * @author Ngnawen
	 * @since
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id_article")
	private Long idArticle;

	@Column(name="code_article")
	private String codeArticle;

	private String designation;

	@Column(name = "prix_unitaire_ht")
	private BigDecimal prixUnitaireHT;

	@Column(name = "taux_tva")
	private BigDecimal tauxTva;

	@Column(name = "prix_unitaire_ttc")
	private BigDecimal prixUnitaireTTC;

	private String photo;
	
	@ManyToOne //Plusieurs articles appartiennent a une seule categorie
	@JoinColumn(name="idCategorie") //idCategorie ici est celui de catégorie
	private Categorie categorie;

	
	
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Long id) {
		this.idArticle = id;
	}

	public String getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(String code) {
		this.codeArticle = code;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public BigDecimal getPrixUnitaireHT() {
		return prixUnitaireHT;
	}

	public void setPrixUnitaireHT(BigDecimal prixUnitaireHT) {
		this.prixUnitaireHT = prixUnitaireHT;
	}

	public BigDecimal getTauxTva() {
		return tauxTva;
	}

	public void setTauxTva(BigDecimal tauxTva) {
		this.tauxTva = tauxTva;
	}

	public BigDecimal getPrixUnitaireTTC() {
		return prixUnitaireTTC;
	}

	public void setPrixUnitaireTTC(BigDecimal prixUnitaireTTC) {
		this.prixUnitaireTTC = prixUnitaireTTC;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

}
