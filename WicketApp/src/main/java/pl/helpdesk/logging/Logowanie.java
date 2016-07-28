package pl.helpdesk.logging;



import java.security.NoSuchAlgorithmException;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;

import org.apache.wicket.model.PropertyModel;


import pl.helpdesk.userSession.UserSession;

import pl.helpdesk.DataAccessObject.UserDao;
import pl.helpdesk.DataModel.UserDataModel;


import pl.helpdesk.userpanel.Panel;


public class Logowanie extends WebPage {


	 private static final long serialVersionUID = 1L;

	 
	private UserDao userDao;
	
	private UserDataModel userDataModel = new UserDataModel();

	public Logowanie() {

		final TextField<String> login = new TextField<String>("login", new PropertyModel<String>(userDataModel, "login"));

		PasswordTextField haslo = new PasswordTextField("haslo", new PropertyModel<String>(userDataModel, "haslo"));
		
		final Label badInfo=new Label("message", "Złe dane!");
		
		badInfo.setVisible(Boolean.FALSE);

		Form<?> form = new Form<Void>("form") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
			
				super.onSubmit();
				
				userDao = new UserDao();
				try {
					if((userDao.findUserByLoginAndPassword(userDataModel.getLogin(), userDataModel.getHaslo()).equals("none"))){
						badInfo.setVisible(Boolean.TRUE);
					}
					else{
					UserSession.getInstance().setuSerDataModel(userDataModel);
					UserSession.getInstance().getuSerDataModel().getLogin();
					UserSession.getInstance().setAttribute("id", userDao.findUserId(UserSession.getInstance().getuSerDataModel().getLogin()));
					UserSession.getInstance().setAttribute("haslo", userDataModel.getHaslo());
					UserSession.getInstance().setAttribute("blok", userDao.czyBlokowany(UserSession.getInstance().getuSerDataModel().getLogin()));
//				try {
//					userDao.addUser("user2", "user2");
//				} catch (NoSuchAlgorithmException e) {
//	
//					e.printStackTrace();
//				}
					userDao.closeConection();
					setResponsePage(Panel.class); 
					}
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

		};
		form.add(login);
		form.add(haslo); 
		add(form);
		add(badInfo);
	}
}
