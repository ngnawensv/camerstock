package cm.belrose.camerstock.services.impl;

import java.io.InputStream;

import cm.belrose.camerstock.dao.IFlickrDao;
import cm.belrose.camerstock.services.IFlickrService;

public class FlickrServiceImpl implements IFlickrService {
	
	private IFlickrDao dao;
	
	

	public void setDao(IFlickrDao dao) {
		this.dao = dao;
	}



	@Override
	public String savePhoto(InputStream stream, String fileName) throws Exception {
		return dao.savePhoto(stream, fileName);
	}

}
