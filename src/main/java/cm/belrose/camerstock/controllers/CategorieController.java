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

import cm.belrose.camerstock.entities.Categorie;
import cm.belrose.camerstock.services.ICategorieService;
import cm.belrose.camerstock.services.IFlickrService;

@Controller
@RequestMapping(value = "/categorie")
public class CategorieController {

	@Autowired
	private ICategorieService categorieService;

	@Autowired
	private IFlickrService flickrService;

	@RequestMapping(value = "/")
	public String categorie(Model model) {
		List<Categorie> categories = categorieService.findByAll();
		for (Categorie categorie : categories) {
			System.out.println(categorie);
		}
		if (categories == null) {
			categories = new ArrayList<Categorie>();
		}
		model.addAttribute("categories", categories);
		return "categorie/categorie";
	}

	// fait appel au formulaire d'ajout d'un categorie
	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterCategorie(Model model) {
		Categorie categorie = new Categorie();
		model.addAttribute("categorie", categorie);
		return "categorie/ajouterCategorie";
	}

	@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
	public String enregisterCategorie(Model model, Categorie categorie) {
		if (categorie != null) {			
			if(categorie.getIdCategorie()!=null) {
				categorieService.update(categorie);
			}else {
				categorieService.save(categorie);
			}
			
		}
		return "redirect:/categorie/";// fait une redirection
	}
	@RequestMapping(value="/modifier/{idCategorie}")
	public String modifierCategorie(Model model, @PathVariable Long idCategorie) {
		
		if(idCategorie!=null) {
			Categorie categorie=categorieService.findByd(idCategorie);
			if(categorie!=null) {
				model.addAttribute("categorie", categorie);
			}
		}
		
		return "categorie/ajouterCategorie";

	}
	
	
	@RequestMapping(value="/supprimer/{idCategorie}")
	public String supprimerCategorie(Model model, @PathVariable Long idCategorie) {
		
		if(idCategorie!=null) {
			Categorie categorie=categorieService.findByd(idCategorie);
			if(categorie!=null) {
				//Verification avant suppression.Impossible de supprimer un categorie qui à deja des commandes
				categorieService.remove(idCategorie);
			}
		}
		
		return "redirect:/categorie/";
		
	}
	
	
	
	
}
