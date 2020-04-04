package cm.belrose.camerstock.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import cm.belrose.camerstock.entities.Vente;
import cm.belrose.camerstock.services.IVenteService;

@Controller
@RequestMapping(value = "/vente")
public class VenteController {

	@Autowired
	private IVenteService venteService;

	@RequestMapping(value = "/")
	public String vente(Model model) {
		List<Vente> ventes = venteService.findByAll();
		for (Vente vente : ventes) {
			System.out.println(vente);
		}
		if (ventes == null) {
			ventes = new ArrayList<Vente>();
		}
		model.addAttribute("ventes", ventes);
		return "vente/vente";
	}

	// fait appel au formulaire d'ajout d'un vente
	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterVente(Model model) {
		Vente vente = new Vente();
		model.addAttribute("vente", vente);
		return "vente/ajouterVente";
	}

	@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
	public String enregisterVente(Model model, Vente vente, MultipartFile file) {
		if (vente != null) {
			if(vente.getIdVente()!=null) {
				venteService.update(vente);
			}else {
				venteService.save(vente);
			}
			
		}
		return "redirect:/vente/";// fait une redirection
	}
	@RequestMapping(value="/modifier/{idVente}")
	public String modifierVente(Model model, @PathVariable Long idVente) {
		
		if(idVente!=null) {
			Vente vente=venteService.findByd(idVente);
			if(vente!=null) {
				model.addAttribute("vente", vente);
			}
		}
		
		return "vente/ajouterVente";

	}
	
	
	@RequestMapping(value="/supprimer/{idVente}")
	public String supprimerVente(Model model, @PathVariable Long idVente) {
		
		if(idVente!=null) {
			Vente vente=venteService.findByd(idVente);
			if(vente!=null) {
				//Verification avant suppression.Impossible de supprimer un vente qui à deja des commandes
				venteService.remove(idVente);
			}
		}
		
		return "redirect:/vente/";
		
	}
	
	
	
	
}
