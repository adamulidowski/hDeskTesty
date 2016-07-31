package pl.helpdesk.logging;

import java.security.NoSuchAlgorithmException;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;

import org.apache.wicket.model.PropertyModel;

import pl.helpdesk.userSession.UserSession;
import pl.helpdesk.DataAccessObject.CompanyDao;
import pl.helpdesk.DataAccessObject.UserDao;
import pl.helpdesk.DataModel.UserDataModel;
import pl.helpdesk.adminPages.AdminPanel;
import pl.helpdesk.employeePages.EmployeePanel;
import pl.helpdesk.userpanel.Panel;

public class Logowanie extends WebPage {

	private static final long serialVersionUID = 1L;

	private UserDao userDao;

	// private CompanyDao companyDao;

	private UserDataModel userDataModel = new UserDataModel();

	public Logowanie() {

		final TextField<String> login = new TextField<String>("login",
				new PropertyModel<String>(userDataModel, "login"));
		
		PasswordTextField haslo = new PasswordTextField("haslo", new PropertyModel<String>(userDataModel, "haslo"));

		final Label badInfo = new Label("message", "Złe dane!");
		badInfo.setVisible(Boolean.FALSE);
		
		final Label userBlocked = new Label("blocked", "Konto zablokowane!");
		userBlocked.setVisible(Boolean.FALSE);
		
		

		Form<?> form = new Form<Void>("form") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {

				super.onSubmit();
				
				userDao = new UserDao();
				badInfo.setVisible(Boolean.FALSE);
				userBlocked.setVisible(Boolean.FALSE);
				try {
					if ((userDao.findUserByLoginAndPassword(userDataModel.getLogin(), userDataModel.getHaslo())
							.equals("none"))) {
						badInfo.setVisible(Boolean.TRUE);
					} else if(userDao.czyBlokowany(userDataModel.getLogin())==true){						
						userBlocked.setVisible(Boolean.TRUE);
					} else {
						UserSession.getInstance().setuSerDataModel(userDataModel);
						UserSession.getInstance().setAttribute("id",
								userDao.findUserId(UserSession.getInstance().getuSerDataModel().getLogin()));
						UserSession.getInstance().setAttribute("blok",
								userDao.czyBlokowany(UserSession.getInstance().getuSerDataModel().getLogin()));
						if (userDao.userType(UserSession.getInstance().getuSerDataModel().getLogin()) == 4) {
							setResponsePage(AdminPanel.class);
						} else if (userDao.userType(UserSession.getInstance().getuSerDataModel().getLogin()) == 1){
							setResponsePage(EmployeePanel.class);
						} else {
							setResponsePage(Panel.class);
						}
					}
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}

			}

		};
		form.add(login);
		form.add(haslo);
		add(form);
		add(badInfo);
		add(userBlocked);
	}
}
