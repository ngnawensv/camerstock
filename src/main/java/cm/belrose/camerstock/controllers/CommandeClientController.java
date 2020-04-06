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

import cm.belrose.camerstock.entities.Client;
import cm.belrose.camerstock.entities.CommandeClient;
import cm.belrose.camerstock.entities.LigneCommandeClient;
import cm.belrose.camerstock.services.IArticleService;
import cm.belrose.camerstock.services.IClientService;
import cm.belrose.camerstock.services.ICommandeClientService;
import cm.belrose.camerstock.services.ILigneCommandeClientService;

@Controller
@RequestMapping(value = "/commandeclient")
public class CommandeClientController {

	@Autowired
	private ICommandeClientService commandeClientService;

	@Autowired
	private ILigneCommandeClientService ligneCommandeClientService;

	@Autowired
	private IClientService clientService;

	@Autowired
	private IArticleService articleService;

	@RequestMapping(value = "/")
	public String index(Model model) {

		List<CommandeClient> commandesClient = commandeClientService.findByAll();
		if (commandesClient.isEmpty()) {
			commandesClient = new ArrayList<CommandeClient>();
		} else {
			for (CommandeClient commandeClient : commandesClient) {
				List<LigneCommandeClient> ligneCommandeClients = ligneCommandeClientService
						.findByIdCommande(commandeClient.getIdCommandeClient());

				commandeClient.setLigneCommandeClients(ligneCommandeClients);
			}
		}
		model.addAttribute("commandesClient", commandesClient);
		return "commandeclient/commandeclient";
	}

	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String nouvelleCommande(Model model) {
		List<Client> clients=clientService.findByAll();
		if(clients.isEmpty()) {
			clients=new ArrayList<Client>();
		}
		model.addAttribute("clients", clients);
		return "commandeclient/nouvellecommande";
	}
//
//	@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
//	public String enregisterCommandeClient(Model model, CommandeClient commandeClient, MultipartFile file) {
//		if (commandeClient != null) {
//			if(commandeClient.getIdCommandeClient()!=null) {
//				commandeClientService.update(commandeClient);
//			}else {
//				commandeClientService.save(commandeClient);
//			}
//			
//		}
//		return "redirect:/commandeClient/";// fait une redirection
//	}
//	@RequestMapping(value="/modifier/{idCommandeClient}")
//	public String modifierCommandeClient(Model model, @PathVariable Long idCommandeClient) {
//		
//		if(idCommandeClient!=null) {
//			CommandeClient commandeClient=commandeClientService.findByd(idCommandeClient);
//			if(commandeClient!=null) {
//				model.addAttribute("commandeClient", commandeClient);
//			}
//		}
//		
//		return "commandeClient/ajouterCommandeClient";
//
//	}
//	
//	
//	@RequestMapping(value="/supprimer/{idCommandeClient}")
//	public String supprimerCommandeClient(Model model, @PathVariable Long idCommandeClient) {
//		
//		if(idCommandeClient!=null) {
//			CommandeClient commandeClient=commandeClientService.findByd(idCommandeClient);
//			if(commandeClient!=null) {
//				//Verification avant suppression.Impossible de supprimer un commandeClient qui à deja des commandes
//				commandeClientService.remove(idCommandeClient);
//			}
//		}
//		
//		return "redirect:/commandeClient/";
//		
//	}

}
