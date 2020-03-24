package cm.belrose.camerstock.services;

import java.util.List;

import cm.belrose.camerstock.entities.MouvementStock;

public interface IMouvementStockService {
public MouvementStock save (MouvementStock entity);
	
	public MouvementStock update(MouvementStock entity);
	
	public MouvementStock findByd(Long id);
	
	public void remove (Long id);
	
	public List<MouvementStock> findByAll();
	
	public List<MouvementStock> findByAll(String sortField, String sort);
	
	public MouvementStock findOne (String paramName, Object paramValue);
	
	public MouvementStock findOne (String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);

}
