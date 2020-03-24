package cm.belrose.camerstock.services;

import java.util.List;

import cm.belrose.camerstock.entities.CommandeClient;

public interface ICommandeClientService {
public CommandeClient save (CommandeClient entity);
	
	public CommandeClient update(CommandeClient entity);
	
	public CommandeClient findByd(Long id);
	
	public void remove (Long id);
	
	public List<CommandeClient> findByAll();
	
	public List<CommandeClient> findByAll(String sortField, String sort);
	
	public CommandeClient findOne (String paramName, Object paramValue);
	
	public CommandeClient findOne (String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);
}
