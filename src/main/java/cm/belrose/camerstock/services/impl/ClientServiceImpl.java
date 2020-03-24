package cm.belrose.camerstock.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cm.belrose.camerstock.dao.IClientDao;
import cm.belrose.camerstock.entities.Client;
import cm.belrose.camerstock.services.IClientService;

@Transactional
public class ClientServiceImpl implements IClientService {
	
	private IClientDao dao;
	
	public void setDao(IClientDao ClientDao) {
		
		this.dao = ClientDao;
	}

	@Override
	public Client save(Client entity) {
		return dao.save(entity);
	}

	@Override
	public Client update(Client entity) {
		return dao.update(entity);
	}

	@Override
	public Client findByd(Long id) {
		return dao.findByd(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
		
	}

	@Override
	public List<Client> findByAll() {
		return dao.findByAll();
	}

	@Override
	public List<Client> findByAll(String sortField, String sort) {
		return dao.findByAll(sortField, sort);
	}

	@Override
	public Client findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Client findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

}
