package cm.belrose.camerstock.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cm.belrose.camerstock.dao.ILigneVenteDao;
import cm.belrose.camerstock.entities.LigneVente;
import cm.belrose.camerstock.services.ILigneVenteService;

@Transactional
public class LigneVenteServiceImpl implements ILigneVenteService {
	
	private ILigneVenteDao dao;
	
	public void setDao(ILigneVenteDao LigneVenteDao) {
		
		this.dao = LigneVenteDao;
	}

	@Override
	public LigneVente save(LigneVente entity) {
		return dao.save(entity);
	}

	@Override
	public LigneVente update(LigneVente entity) {
		return dao.update(entity);
	}

	@Override
	public LigneVente findByd(Long id) {
		return dao.findByd(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
		
	}

	@Override
	public List<LigneVente> findByAll() {
		return dao.findByAll();
	}

	@Override
	public List<LigneVente> findByAll(String sortField, String sort) {
		return dao.findByAll(sortField, sort);
	}

	@Override
	public LigneVente findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public LigneVente findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

}
