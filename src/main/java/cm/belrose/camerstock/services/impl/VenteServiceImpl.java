package cm.belrose.camerstock.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cm.belrose.camerstock.dao.IVenteDao;
import cm.belrose.camerstock.entities.Vente;
import cm.belrose.camerstock.services.IVenteService;

@Transactional
public class VenteServiceImpl implements IVenteService {
	
	private IVenteDao dao;
	
	public void setDao(IVenteDao VenteDao) {
		
		this.dao = VenteDao;
	}

	@Override
	public Vente save(Vente entity) {
		return dao.save(entity);
	}

	@Override
	public Vente update(Vente entity) {
		return dao.update(entity);
	}

	@Override
	public Vente findByd(Long id) {
		return dao.findByd(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
		
	}

	@Override
	public List<Vente> findByAll() {
		return dao.findByAll();
	}

	@Override
	public List<Vente> findByAll(String sortField, String sort) {
		return dao.findByAll(sortField, sort);
	}

	@Override
	public Vente findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Vente findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

}
