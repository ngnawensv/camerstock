package cm.belrose.camerstock.services;

import java.util.List;

import cm.belrose.camerstock.entities.Article;

public interface IArticleService {
	public Article save(Article entity);

	public Article update(Article entity);

	public Article findByd(Long id);

	public void remove(Long id);

	public List<Article> findByAll();

	public List<Article> findByAll(String sortField, String sort);

	public Article findOne(String paramName, Object paramValue);

	public Article findOne(String[] paramNames, Object[] paramValues);

	public int findCountBy(String paramName, String paramValue);

}
