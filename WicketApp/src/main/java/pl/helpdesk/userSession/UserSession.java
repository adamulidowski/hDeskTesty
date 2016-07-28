package pl.helpdesk.userSession;

import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

import pl.helpdesk.DataModel.UserDataModel;


public class UserSession extends WebSession {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */


	private UserDataModel uSerDataModel;
	
	public UserSession(Request request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
	
	public static UserSession getInstance(){
		return (UserSession)Session.get();
	}

	public UserDataModel getuSerDataModel() {
		return uSerDataModel;
	}

	public void setuSerDataModel(UserDataModel uSerDataModel) {
		this.uSerDataModel = uSerDataModel;
	}

}
