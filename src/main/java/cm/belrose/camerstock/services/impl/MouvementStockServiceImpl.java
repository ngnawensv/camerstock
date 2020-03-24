package cm.belrose.camerstock.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cm.belrose.camerstock.dao.IMouvementStockDao;
import cm.belrose.camerstock.entities.MouvementStock;
import cm.belrose.camerstock.services.IMouvementStockService;

@Transactional
public class MouvementStockServiceImpl implements IMouvementStockService {
	
	private IMouvementStockDao dao;
	
	public void setDao(IMouvementStockDao MouvementStockDao) {
		
		this.dao = MouvementStockDao;
	}

	@Override
	public MouvementStock save(MouvementStock entity) {
		return dao.save(entity);
	}

	@Override
	public MouvementStock update(MouvementStock entity) {
		return dao.update(entity);
	}

	@Override
	public MouvementStock findByd(Long id) {
		return dao.findByd(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
		
	}

	@Override
	public List<MouvementStock> findByAll() {
		return dao.findByAll();
	}

	@Override
	public List<MouvementStock> findByAll(String sortField, String sort) {
		return dao.findByAll(sortField, sort);
	}

	@Override
	public MouvementStock findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public MouvementStock findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

}
