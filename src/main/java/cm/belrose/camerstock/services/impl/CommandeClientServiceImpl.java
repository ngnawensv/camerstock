package cm.belrose.camerstock.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cm.belrose.camerstock.dao.ICommandeClientDao;
import cm.belrose.camerstock.entities.CommandeClient;
import cm.belrose.camerstock.services.ICommandeClientService;

@Transactional
public class CommandeClientServiceImpl implements ICommandeClientService {
	
	private ICommandeClientDao dao;
	
	public void setDao(ICommandeClientDao CommandeClientDao) {
		
		this.dao = CommandeClientDao;
	}

	@Override
	public CommandeClient save(CommandeClient entity) {
		return dao.save(entity);
	}

	@Override
	public CommandeClient update(CommandeClient entity) {
		return dao.update(entity);
	}

	@Override
	public CommandeClient findByd(Long id) {
		return dao.findByd(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
		
	}

	@Override
	public List<CommandeClient> findByAll() {
		return dao.findByAll();
	}

	@Override
	public List<CommandeClient> findByAll(String sortField, String sort) {
		return dao.findByAll(sortField, sort);
	}

	@Override
	public CommandeClient findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public CommandeClient findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

}
