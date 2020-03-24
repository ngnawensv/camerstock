package cm.belrose.camerstock.services;

import java.util.List;

import cm.belrose.camerstock.entities.Client;

public interface IClientService {

public Client save (Client entity);
	
	public Client update(Client entity);
	
	public Client findByd(Long id);
	
	public void remove (Long id);
	
	public List<Client> findByAll();
	
	public List<Client> findByAll(String sortField, String sort);
	
	public Client findOne (String paramName, Object paramValue);
	
	public Client findOne (String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);
	

}
