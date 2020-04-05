package cm.belrose.camerstock.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cm.belrose.camerstock.dao.ILigneCommandeClientDao;
import cm.belrose.camerstock.entities.LigneCommandeClient;
import cm.belrose.camerstock.services.ILigneCommandeClientService;

@Transactional
public class LigneCommandeClientServiceImpl implements ILigneCommandeClientService {
	
	private ILigneCommandeClientDao dao;
	
	public void setDao(ILigneCommandeClientDao LigneCommandeClientDao) {
		
		this.dao = LigneCommandeClientDao;
	}

	//@Override
	public LigneCommandeClient save(LigneCommandeClient entity) {
		return dao.save(entity);
	}

	//@Override
	public LigneCommandeClient update(LigneCommandeClient entity) {
		return dao.update(entity);
	}

	//@Override
	public LigneCommandeClient findByd(Long id) {
		return dao.findByd(id);
	}

	//@Override
	public void remove(Long id) {
		dao.remove(id);
		
	}

	//@Override
	public List<LigneCommandeClient> findByAll() {
		return dao.findByAll();
	}

	//@Override
	public List<LigneCommandeClient> findByAll(String sortField, String sort) {
		return dao.findByAll(sortField, sort);
	}

	//@Override
	public LigneCommandeClient findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	//@Override
	public LigneCommandeClient findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	//@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

	public List<LigneCommandeClient> findByIdCommande(Long idCommandeClient) {
		// TODO Auto-generated method stub
		return dao.findByIdCommande(idCommandeClient);
	}

}
