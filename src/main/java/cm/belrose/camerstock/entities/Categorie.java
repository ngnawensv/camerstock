package cm.belrose.camerstock.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name="categorie")
public class Categorie implements Serializable {
	/**
	 * @author Ngnawen
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue	
	@Column(name="id_categorie")
	private Long idCategorie;
	
	private String code;
	
	private String designation;
	
	@OneToMany(mappedBy = "categorie")
	private List<Article> articles;	
	

	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(Long id) {
		this.idCategorie = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	

}
