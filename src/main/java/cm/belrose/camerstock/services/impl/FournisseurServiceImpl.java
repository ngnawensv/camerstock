package cm.belrose.camerstock.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cm.belrose.camerstock.dao.IFournisseurDao;
import cm.belrose.camerstock.entities.Fournisseur;
import cm.belrose.camerstock.services.IFournisseurService;

@Transactional
public class FournisseurServiceImpl implements IFournisseurService {
	
	private IFournisseurDao dao;
	
	public void setDao(IFournisseurDao FournisseurDao) {
		
		this.dao = FournisseurDao;
	}

	@Override
	public Fournisseur save(Fournisseur entity) {
		return dao.save(entity);
	}

	@Override
	public Fournisseur update(Fournisseur entity) {
		return dao.update(entity);
	}

	@Override
	public Fournisseur findByd(Long id) {
		return dao.findByd(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
		
	}

	@Override
	public List<Fournisseur> findByAll() {
		return dao.findByAll();
	}

	@Override
	public List<Fournisseur> findByAll(String sortField, String sort) {
		return dao.findByAll(sortField, sort);
	}

	@Override
	public Fournisseur findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Fournisseur findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

}
