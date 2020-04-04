package cm.belrose.camerstock.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Roles {
	
	@Id
	@GeneratedValue
	@Column(name="id_role")
	private Long idRole;
	
	@Column(name="role_name")
	private String roleName;
	
	@ManyToOne()
	@JoinColumn(name = "idUtilisateur")
	private Utilisateur utilisateur;

	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	

}
