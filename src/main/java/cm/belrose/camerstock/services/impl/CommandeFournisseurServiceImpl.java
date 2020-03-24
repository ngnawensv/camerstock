package cm.belrose.camerstock.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cm.belrose.camerstock.dao.ICommandeFournisseurDao;
import cm.belrose.camerstock.entities.CommandeFournisseur;
import cm.belrose.camerstock.services.ICommandeFournisseurService;

@Transactional
public class CommandeFournisseurServiceImpl implements ICommandeFournisseurService {
	
	private ICommandeFournisseurDao dao;
	
	public void setDao(ICommandeFournisseurDao CommandeFournisseurDao) {
		
		this.dao = CommandeFournisseurDao;
	}

	@Override
	public CommandeFournisseur save(CommandeFournisseur entity) {
		return dao.save(entity);
	}

	@Override
	public CommandeFournisseur update(CommandeFournisseur entity) {
		return dao.update(entity);
	}

	@Override
	public CommandeFournisseur findByd(Long id) {
		return dao.findByd(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
		
	}

	@Override
	public List<CommandeFournisseur> findByAll() {
		return dao.findByAll();
	}

	@Override
	public List<CommandeFournisseur> findByAll(String sortField, String sort) {
		return dao.findByAll(sortField, sort);
	}

	@Override
	public CommandeFournisseur findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public CommandeFournisseur findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

}
