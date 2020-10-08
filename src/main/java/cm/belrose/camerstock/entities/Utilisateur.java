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
@Table(name="utilisateur")
public class Utilisateur implements Serializable {
	/**
	 * @author Ngnawen Samuel
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue	
	@Column(name="id_utilisateur")
	private Long idUtilisateur;
	
	private String nom;
	
	private String prenom;
	
	private String mail;
	
	@Column(name="mot_de_passe")
	private String motDePasse;
	
	private String photo;
	
	private boolean actived;
	
	@OneToMany(mappedBy = "utilisateur")
	private List<Roles> roles;
	

	public Utilisateur() {}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long id) {
		this.idUtilisateur = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail
				+ ", motDePasse=" + motDePasse + ", actived=" + actived + "]";
	}

	


	
	

}
