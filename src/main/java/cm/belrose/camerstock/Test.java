package cm.belrose.camerstock;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import cm.belrose.camerstock.dao.impl.FlickrDaoImpl;

public class Test {

	public static void main(String[] args) {
		
		FlickrDaoImpl flickr = new FlickrDaoImpl();
		//flickr.auth();
		
		try {
			InputStream stream = new FileInputStream(new File("C:\\Users\\PC-NGNAWEN\\Pictures\\img.jpg"));
			String url = flickr.savePhoto(stream, "myImage");
			System.out.println(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
