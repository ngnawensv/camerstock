package cm.belrose.camerstock.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cm.belrose.camerstock.dao.ICategorieDao;
import cm.belrose.camerstock.entities.Categorie;
import cm.belrose.camerstock.services.ICategorieService;

@Transactional
public class CategorieServiceImpl implements ICategorieService {
	
	private ICategorieDao dao;
	
	public void setDao(ICategorieDao CategorieDao) {
		
		this.dao = CategorieDao;
	}

	@Override
	public Categorie save(Categorie entity) {
		return dao.save(entity);
	}

	@Override
	public Categorie update(Categorie entity) {
		return dao.update(entity);
	}

	@Override
	public Categorie findByd(Long id) {
		return dao.findByd(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
		
	}

	@Override
	public List<Categorie> findByAll() {
		return dao.findByAll();
	}

	@Override
	public List<Categorie> findByAll(String sortField, String sort) {
		return dao.findByAll(sortField, sort);
	}

	@Override
	public Categorie findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Categorie findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

}
