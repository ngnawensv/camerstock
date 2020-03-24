package cm.belrose.camerstock.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ligne_vente")
public class LigneVente implements Serializable {
	/**
	 * @author Ngnawen
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id_ligne_vente")
	private Long idLigneVente;

	@ManyToOne
	@JoinColumn(name = "idVente")
	private Vente vente;

	@ManyToOne
	@JoinColumn(name = "idArticle")
	private Article article;

	public Long getIdLigneVente() {
		return idLigneVente;
	}

	public void setIdLigneVente(Long id) {
		this.idLigneVente = id;
	}

	public Vente getVente() {
		return vente;
	}

	public void setVente(Vente vente) {
		this.vente = vente;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

}
