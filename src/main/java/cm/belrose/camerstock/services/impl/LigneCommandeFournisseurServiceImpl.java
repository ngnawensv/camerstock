package cm.belrose.camerstock.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cm.belrose.camerstock.dao.ILigneCommandeFournisseurDao;
import cm.belrose.camerstock.entities.LigneCommandeFournisseur;
import cm.belrose.camerstock.services.ILigneCommandeFournisseurService;

@Transactional
public class LigneCommandeFournisseurServiceImpl implements ILigneCommandeFournisseurService {
	
	private ILigneCommandeFournisseurDao dao;
	
	public void setDao(ILigneCommandeFournisseurDao LigneCommandeFournisseurDao) {
		
		this.dao = LigneCommandeFournisseurDao;
	}

	//@Override
	public LigneCommandeFournisseur save(LigneCommandeFournisseur entity) {
		return dao.save(entity);
	}

	//@Override
	public LigneCommandeFournisseur update(LigneCommandeFournisseur entity) {
		return dao.update(entity);
	}

	//@Override
	public LigneCommandeFournisseur findByd(Long id) {
		return dao.findByd(id);
	}

	//@Override
	public void remove(Long id) {
		dao.remove(id);
		
	}

	//@Override
	public List<LigneCommandeFournisseur> findByAll() {
		return dao.findByAll();
	}

	//@Override
	public List<LigneCommandeFournisseur> findByAll(String sortField, String sort) {
		return dao.findByAll(sortField, sort);
	}

	//@Override
	public LigneCommandeFournisseur findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	//@Override
	public LigneCommandeFournisseur findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	//@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

}
