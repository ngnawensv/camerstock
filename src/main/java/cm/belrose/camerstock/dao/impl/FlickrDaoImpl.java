package cm.belrose.camerstock.dao.impl;

import java.io.InputStream;

import javax.swing.JOptionPane;



import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.AuthInterface;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.model.OAuth1Token;
import com.github.scribejava.core.model.Token;

import cm.belrose.camerstock.dao.IFlickrDao;

public class FlickrDaoImpl implements IFlickrDao{

	private Flickr flickr;

    private UploadMetaData uploadMetaData = new UploadMetaData();

    private String apiKey = "f1c51b7baf0c5da6b151966f0ec82795";

    private String sharedSecret = "a3db69ac5e61689c";

    

    private void connect(){
        flickr = new Flickr(apiKey, sharedSecret, new REST());
        Auth auth = new Auth();
        auth.setPermission(Permission.READ);
        auth.setToken("72157713614532132-3e31f890eae3e009");
        auth.setTokenSecret("c4035ee57f743d60");
        RequestContext requestContext = RequestContext.getRequestContext();
        requestContext.setAuth(auth);
        flickr.setAuth(auth);
    }

    //@Override
    public String savePhoto(InputStream photo, String title) throws Exception{
        connect();
        uploadMetaData.setTitle(title);
        String photoId = flickr.getUploader().upload(photo, uploadMetaData);
        return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
    }

    public void auth(){
        flickr = new Flickr(apiKey, sharedSecret, new REST());

        AuthInterface authInterface = flickr.getAuthInterface();

        Token token = authInterface.getRequestToken();
        System.out.println("token: " + token.toString());

        //String url = authInterface.getAuthorizationUrl(token, Permission.DELETE);
        String url = authInterface.getAuthorizationUrl((OAuth1RequestToken) token, Permission.DELETE);
        System.out.println("Follow this URL to authorise yourself on Flickr");
        System.out.println(url);
        System.out.println("Paste in the token it gives you:");
        System.out.print(">>");

        String tokenKey = JOptionPane.showInputDialog(null);

        //Token requestToken = authInterface.getAccessToken(token, new Verifier(tokenKey));
        Token requestToken = authInterface.getAccessToken((OAuth1RequestToken) token, tokenKey);
        System.out.println("Authentication success");

        Auth auth = null;
        try {
            auth = authInterface.checkToken((OAuth1Token) requestToken);
        } catch (FlickrException e) {
            e.printStackTrace();
        }

        // This token can be used until the user revokes it.
        System.out.println("Token: " + requestToken.getRawResponse().toString());
        System.out.println("Secret: " + requestToken.getRawResponse().toString());
        System.out.println("nsid: " + auth.getUser().getId());
        System.out.println("Realname: " + auth.getUser().getRealName());
        System.out.println("Username: " + auth.getUser().getUsername());
        System.out.println("Permission: " + auth.getPermission().getType());

    }

	public FlickrDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}


}
