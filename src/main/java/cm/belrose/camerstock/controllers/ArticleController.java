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

import cm.belrose.camerstock.entities.Article;
import cm.belrose.camerstock.entities.Categorie;
import cm.belrose.camerstock.services.IArticleService;
import cm.belrose.camerstock.services.ICategorieService;
import cm.belrose.camerstock.services.IFlickrService;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {

	@Autowired
	private IArticleService articleService;
	
	@Autowired
	private ICategorieService categorieService;

	@Autowired
	private IFlickrService flickrService;

	@RequestMapping(value = "/")
	public String article(Model model) {
		List<Article> articles = articleService.findByAll();
		for (Article article : articles) {
			System.out.println(article);
		}
		if (articles == null) {
			articles = new ArrayList<Article>();
		}
		model.addAttribute("articles", articles);
		return "article/article";
	}

	// fait appel au formulaire d'ajout d'un article
	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterArticle(Model model) {
		Article article = new Article();
		List<Categorie> categories=categorieService.findByAll();
		if(categories==null) {
			categories=new ArrayList<Categorie>();
		}
		model.addAttribute("article", article);
		model.addAttribute("categories", categories);
		return "article/ajouterArticle";
	}

	@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
	public String enregisterArticle(Model model, Article article, MultipartFile file) {
		String photoUrl = null;
		if (article != null) {
			if ((file != null) && (!file.isEmpty())) {
				InputStream stream = null;
				try {
					stream = file.getInputStream();
					photoUrl = flickrService.savePhoto(stream, article.getDesignation());
					article.setPhoto(photoUrl);
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
			if(article.getIdArticle()!=null) {
				articleService.update(article);
			}else {
				articleService.save(article);
			}
			
		}
		return "redirect:/article/";// fait une redirection
	}
	@RequestMapping(value="/modifier/{idArticle}")
	public String modifierArticle(Model model, @PathVariable Long idArticle) {
		
		if(idArticle!=null) {
			Article article=articleService.findByd(idArticle);
			List<Categorie> categories=categorieService.findByAll();
			if(categories==null) {
				categories=new ArrayList<Categorie>();
			}
			model.addAttribute("categories", categories);
			if(article!=null) {
				model.addAttribute("article", article);
			}
		}
		
		return "article/ajouterArticle";

	}
	
	
	@RequestMapping(value="/supprimer/{idArticle}")
	public String supprimerArticle(Model model, @PathVariable Long idArticle) {
		
		if(idArticle!=null) {
			Article article=articleService.findByd(idArticle);
			if(article!=null) {
				//Verification avant suppression.Impossible de supprimer un article qui à deja des commandes
				articleService.remove(idArticle);
			}
		}
		
		return "redirect:/article/";
		
	}
	
	
	
	
}
