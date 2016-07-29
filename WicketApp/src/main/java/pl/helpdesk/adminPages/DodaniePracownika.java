package pl.helpdesk.adminPages;

import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import pl.helpdesk.DataAccessObject.UserDao;
import pl.helpdesk.DataModel.UserDataModel;
import pl.helpdesk.logging.Logowanie;
import pl.helpdesk.userSession.UserSession;

public class DodaniePracownika extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DodaniePracownika() {
		Form<?> form = new Form<Void>("form");
		Button logOut = new Button("logOut") {

			private static final long serialVersionUID = -1800911970905016411L;

			@Override
			public void onSubmit() {
				super.onSubmit();
				UserSession.getInstance().invalidate();
				setResponsePage(Logowanie.class);
			}
		};
		add(form);
		form.add(logOut);

		String message="error";
		final Label error=new Label("error", message);
		error.setVisible(false);
			
		
			UserDataModel userDataModel = new UserDataModel();
			final UserDao userDao = new UserDao();

			final TextField<String> imie = new TextField<String>("imie",
					new PropertyModel<String>(userDataModel, "imie"));
			final TextField<String> nazwisko = new TextField<String>("nazwisko",
					new PropertyModel<String>(userDataModel, "nazwisko"));
			final TextField<String> email = new TextField<String>("email",
					new PropertyModel<String>(userDataModel, "email"));
			final TextField<String> login = new TextField<String>("login",
					new PropertyModel<String>(userDataModel, "login"));

			final PasswordTextField haslo = new PasswordTextField("haslo",
					new PropertyModel<String>(userDataModel, "haslo"));

			Form<?> creating = new Form("creating") {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public void onSubmit() {					
					super.onSubmit();
					
					UserDao user = new UserDao();
					String imie2 = imie.getInput();
					String nazwisko2 = nazwisko.getInput();
					String email2 = email.getInput();
					String login2 = login.getInput();
					String haslo2 = haslo.getInput();
					
					
					error.setVisible(false);
					if (userDao.emailValidate(email2) == false) {
						error.setVisible(true);
						
					} else if (login2.length() < 4 || haslo2.length() < 4 || login2.length() > 15 || haslo2.length() > 15
							|| login2.isEmpty() || haslo2.isEmpty()) {
						error.setVisible(true);
						
					} else if (user.userType(login2) != 0) {
						error.setVisible(true);
						
					} else {

						try {
							user.addUser(login2, haslo2, email2 ,imie2, nazwisko2,  1);
						} catch (NoSuchAlgorithmException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						setResponsePage(Logowanie.class);

					}
					
					//error.setVisible(true);
				}
			};


			//PageParameters pageParameters = new PageParameters();
			//System.out.println(pageParameters.get("number"));
			//System.out.println(UserSession.getInstance().getAttribute("nick"));
			add(creating);
			//add(userExist);
			//add(length);
			//add(userAdded);
			add(error);
			creating.add(login);
			creating.add(imie);
			creating.add(nazwisko);
			creating.add(email);
			creating.add(haslo);
		

	}

}
