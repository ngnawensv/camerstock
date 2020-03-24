package cm.belrose.camerstock.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
@Table(name="mouvement_stock")
public class MouvementStock implements Serializable {
	/**
	 * @author Ngnawen
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int ENTREE=1;
	public static final int SORTIE=1;
	
	@Id
	@GeneratedValue	
	@Column(name="id_mouvement_stock")
	private Long idMouvementStock;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_mouvement_stock")
	private Date dateMouvementStock;
	
	private BigDecimal quantite;
	
	@Column(name="type_mouvement_stock")
	private int typeMouvementStock;
	
	@ManyToOne
	@JoinColumn(name = "idArticle")
	private Article article;
	
	

	public MouvementStock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdMouvementStock() {
		return idMouvementStock;
	}

	public void setIdMouvementStock(Long id) {
		this.idMouvementStock = id;
	}

	public Date getDateMouvementStock() {
		return dateMouvementStock;
	}

	public void setDateMouvementStock(Date dateMouvementStock) {
		this.dateMouvementStock = dateMouvementStock;
	}

	public BigDecimal getQuantite() {
		return quantite;
	}

	public void setQuantite(BigDecimal quantite) {
		this.quantite = quantite;
	}

	public int getTypeMouvementStock() {
		return typeMouvementStock;
	}

	public void setTypeMouvementStock(int typeMouvementStock) {
		this.typeMouvementStock = typeMouvementStock;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
	

}
