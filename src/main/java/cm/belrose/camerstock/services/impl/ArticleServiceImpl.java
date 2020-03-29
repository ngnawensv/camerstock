package cm.belrose.camerstock.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cm.belrose.camerstock.dao.IArticleDao;
import cm.belrose.camerstock.entities.Article;
import cm.belrose.camerstock.services.IArticleService;

@Transactional
public class ArticleServiceImpl implements IArticleService {
	
	private IArticleDao dao;
	
	public void setDao(IArticleDao articleDao) {
		
		this.dao = articleDao;
	}

	//@Override
	public Article save(Article entity) {
		return dao.save(entity);
	}

	//@Override
	public Article update(Article entity) {
		return dao.update(entity);
	}

	//@Override
	public Article findByd(Long id) {
		return dao.findByd(id);
	}

	//@Override
	public void remove(Long id) {
		dao.remove(id);
		
	}

	//@Override
	public List<Article> findByAll() {
		return dao.findByAll();
	}

	//@Override
	public List<Article> findByAll(String sortField, String sort) {
		return dao.findByAll(sortField, sort);
	}

	//@Override
	public Article findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	//@Override
	public Article findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	//@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

}
