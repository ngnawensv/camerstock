package cm.belrose.camerstock.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import cm.belrose.camerstock.entities.Utilisateur;
import cm.belrose.camerstock.services.IUtilisateurService;
import cm.belrose.camerstock.services.IFlickrService;

@Controller
@RequestMapping(value = "/utilisateur")
public class UtilisateurController {

	@Autowired
	private IUtilisateurService utilisateurService;

	@Autowired
	private IFlickrService flickrService;

	@RequestMapping(value = "/")
	public String utilisateur(Model model) {
		List<Utilisateur> utilisateurs = utilisateurService.findByAll();
		for (Utilisateur utilisateur : utilisateurs) {
			System.out.println(utilisateur);
		}
		if (utilisateurs == null) {
			utilisateurs = new ArrayList<Utilisateur>();
		}
		model.addAttribute("utilisateurs", utilisateurs);
		return "utilisateur/utilisateur";
	}

	// fait appel au formulaire d'ajout d'un utilisateur
	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterUtilisateur(Model model) {
		Utilisateur utilisateur = new Utilisateur();
		model.addAttribute("utilisateur", utilisateur);
		return "utilisateur/ajouterUtilisateur";
	}

	@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
	public String enregisterUtilisateur(Model model, Utilisateur utilisateur, MultipartFile file) {
		String photoUrl = null;
		if (utilisateur != null) {
			if ((file != null) && (!file.isEmpty())) {
				InputStream stream = null;
				try {
					stream = file.getInputStream();
					photoUrl = flickrService.savePhoto(stream, utilisateur.getNom());
					utilisateur.setPhoto(photoUrl);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						stream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			}
			if(utilisateur.getIdUtilisateur()!=null) {
				utilisateurService.update(utilisateur);
			}else {
				utilisateurService.save(utilisateur);
			}
			
		}
		return "redirect:/utilisateur/";// fait une redirection
	}
	@RequestMapping(value="/modifier/{idUtilisateur}")
	public String modifierUtilisateur(Model model, @PathVariable Long idUtilisateur) {
		
		if(idUtilisateur!=null) {
			Utilisateur utilisateur=utilisateurService.findByd(idUtilisateur);
			if(utilisateur!=null) {
				model.addAttribute("utilisateur", utilisateur);
			}
		}
		
		return "utilisateur/ajouterUtilisateur";

	}
	
	
	@RequestMapping(value="/supprimer/{idUtilisateur}")
	public String supprimerUtilisateur(Model model, @PathVariable Long idUtilisateur) {
		
		if(idUtilisateur!=null) {
			Utilisateur utilisateur=utilisateurService.findByd(idUtilisateur);
			if(utilisateur!=null) {
				//Verification avant suppression.Impossible de supprimer un utilisateur qui à deja des commandes
				utilisateurService.remove(idUtilisateur);
			}
		}
		
		return "redirect:/utilisateur/";
		
	}
	
	
	
	
}
