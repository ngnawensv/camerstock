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

import cm.belrose.camerstock.entities.Client;
import cm.belrose.camerstock.services.IClientService;
import cm.belrose.camerstock.services.IFlickrService;

@Controller
@RequestMapping(value = "/client")
public class ClientController {

	@Autowired
	private IClientService clientService;

	@Autowired
	private IFlickrService flickrService;

	@RequestMapping(value = "/")
	public String client(Model model) {
		List<Client> clients = clientService.findByAll(); //fait a la couche metier	en appelant la méthode findAll()	
		for (Client client : clients) {
			System.out.println(client);
		}
		if (clients == null) {
			clients = new ArrayList<Client>();
		}
		model.addAttribute("clients", clients);//stockage des clients  dans le model avec pour nom "clients"
		return "client/client"; //renvoi de la vue
	}

	// fait appel au formulaire d'ajout d'un client
	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterClient(Model model) {
		Client client = new Client();
		model.addAttribute("client", client);
		return "client/ajouterClient";
	}

	@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
	public String enregisterClient(Model model, Client client, MultipartFile file) {
		String photoUrl = null;
		if (client != null) {
			if ((file != null) && (!file.isEmpty())) {
				InputStream stream = null;
				try {
					stream = file.getInputStream();
					photoUrl = flickrService.savePhoto(stream, client.getNom());
					client.setPhoto(photoUrl);
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
			if(client.getIdClient()!=null) {
				clientService.update(client);
			}else {
				clientService.save(client);
			}
			
		}
		return "redirect:/client/";// fait une redirection
	}
	@RequestMapping(value="/modifier/{idClient}")
	public String modifierClient(Model model, @PathVariable Long idClient) {
		
		if(idClient!=null) {
			Client client=clientService.findByd(idClient);
			if(client!=null) {
				model.addAttribute("client", client);
			}
		}
		
		return "client/ajouterClient";

	}
	
	
	@RequestMapping(value="/supprimer/{idClient}")
	public String supprimerClient(Model model, @PathVariable Long idClient) {
		
		if(idClient!=null) {
			Client client=clientService.findByd(idClient);
			if(client!=null) {
				//Verification avant suppression.Impossible de supprimer un client qui à deja des commandes
				clientService.remove(idClient);
			}
		}
		
		return "redirect:/client/";
		
	}
	
	
	
	
}
