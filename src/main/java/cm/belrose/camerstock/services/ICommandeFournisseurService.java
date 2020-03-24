package cm.belrose.camerstock.services;

import java.util.List;

import cm.belrose.camerstock.entities.CommandeFournisseur;

public interface ICommandeFournisseurService {
public CommandeFournisseur save (CommandeFournisseur entity);
	
	public CommandeFournisseur update(CommandeFournisseur entity);
	
	public CommandeFournisseur findByd(Long id);
	
	public void remove (Long id);
	
	public List<CommandeFournisseur> findByAll();
	
	public List<CommandeFournisseur> findByAll(String sortField, String sort);
	
	public CommandeFournisseur findOne (String paramName, Object paramValue);
	
	public CommandeFournisseur findOne (String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);

}
