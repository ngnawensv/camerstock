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

import cm.belrose.camerstock.entities.CommandeClient;
import cm.belrose.camerstock.services.ICommandeClientService;
@Controller
@RequestMapping(value = "/commandeClient")
public class CommandeClientController {

	@Autowired
	private ICommandeClientService commandeClientService;

	@RequestMapping(value = "/")
	public String commandeClient(Model model) {
		List<CommandeClient> commandeClients = commandeClientService.findByAll();
		for (CommandeClient commandeClient : commandeClients) {
			System.out.println(commandeClient);
		}
		if (commandeClients == null) {
			commandeClients = new ArrayList<CommandeClient>();
		}
		model.addAttribute("commandeClients", commandeClients);
		return "commandeClient/commandeClient";
	}

	// fait appel au formulaire d'ajout d'un commandeClient
	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterCommandeClient(Model model) {
		CommandeClient commandeClient = new CommandeClient();
		model.addAttribute("commandeClient", commandeClient);
		return "commandeClient/ajouterCommandeClient";
	}

	@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
	public String enregisterCommandeClient(Model model, CommandeClient commandeClient, MultipartFile file) {
		if (commandeClient != null) {
			if(commandeClient.getIdCommandeClient()!=null) {
				commandeClientService.update(commandeClient);
			}else {
				commandeClientService.save(commandeClient);
			}
			
		}
		return "redirect:/commandeClient/";// fait une redirection
	}
	@RequestMapping(value="/modifier/{idCommandeClient}")
	public String modifierCommandeClient(Model model, @PathVariable Long idCommandeClient) {
		
		if(idCommandeClient!=null) {
			CommandeClient commandeClient=commandeClientService.findByd(idCommandeClient);
			if(commandeClient!=null) {
				model.addAttribute("commandeClient", commandeClient);
			}
		}
		
		return "commandeClient/ajouterCommandeClient";

	}
	
	
	@RequestMapping(value="/supprimer/{idCommandeClient}")
	public String supprimerCommandeClient(Model model, @PathVariable Long idCommandeClient) {
		
		if(idCommandeClient!=null) {
			CommandeClient commandeClient=commandeClientService.findByd(idCommandeClient);
			if(commandeClient!=null) {
				//Verification avant suppression.Impossible de supprimer un commandeClient qui à deja des commandes
				commandeClientService.remove(idCommandeClient);
			}
		}
		
		return "redirect:/commandeClient/";
		
	}
	
	
	
	
}
