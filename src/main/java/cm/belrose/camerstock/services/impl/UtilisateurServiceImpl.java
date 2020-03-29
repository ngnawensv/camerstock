package cm.belrose.camerstock.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cm.belrose.camerstock.dao.IUtilisateurDao;
import cm.belrose.camerstock.entities.Utilisateur;
import cm.belrose.camerstock.services.IUtilisateurService;

@Transactional
public class UtilisateurServiceImpl implements IUtilisateurService {
	
	private IUtilisateurDao dao;
	
	public void setDao(IUtilisateurDao UtilisateurDao) {
		
		this.dao = UtilisateurDao;
	}

	//@Override
	public Utilisateur save(Utilisateur entity) {
		return dao.save(entity);
	}

	//@Override
	public Utilisateur update(Utilisateur entity) {
		return dao.update(entity);
	}

	//@Override
	public Utilisateur findByd(Long id) {
		return dao.findByd(id);
	}

	//@Override
	public void remove(Long id) {
		dao.remove(id);
		
	}

	//@Override
	public List<Utilisateur> findByAll() {
		return dao.findByAll();
	}

	//@Override
	public List<Utilisateur> findByAll(String sortField, String sort) {
		return dao.findByAll(sortField, sort);
	}

	//@Override
	public Utilisateur findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	//@Override
	public Utilisateur findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	//@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

}
