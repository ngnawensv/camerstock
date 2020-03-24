package cm.belrose.camerstock.services;

import java.util.List;

import cm.belrose.camerstock.entities.LigneCommandeFournisseur;

public interface ILigneCommandeFournisseurService {
public LigneCommandeFournisseur save (LigneCommandeFournisseur entity);
	
	public LigneCommandeFournisseur update(LigneCommandeFournisseur entity);
	
	public LigneCommandeFournisseur findByd(Long id);
	
	public void remove (Long id);
	
	public List<LigneCommandeFournisseur> findByAll();
	
	public List<LigneCommandeFournisseur> findByAll(String sortField, String sort);
	
	public LigneCommandeFournisseur findOne (String paramName, Object paramValue);
	
	public LigneCommandeFournisseur findOne (String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);

}
