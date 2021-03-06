package pl.helpdesk.employeePages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;

import pl.helpdesk.DataAccessObject.UserDao;
import pl.helpdesk.logging.Logowanie;
import pl.helpdesk.userSession.UserSession;

public class EmployeePanel extends WebPage{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public EmployeePanel(){
			String result = ""; 
			String result2= "";
			result = String.valueOf(UserSession.getInstance().getuSerDataModel().getLogin());
			
			result2=String.valueOf(UserSession.getInstance().getAttribute("id"));
			add(new Label("SendedParam",result)); 
			add(new Label("SendedParam2",result2)); 
			Form<?> form = new Form<Void>("form") ;
			Button logOut=new Button("logOut"){
				
				private static final long serialVersionUID = -1800911970905016411L;
				@Override
				public void onSubmit() {
					super.onSubmit();
					UserDao userDao= new UserDao();
					userDao.closeConection();
					UserSession.getInstance().invalidate();
					setResponsePage(Logowanie.class); 
				}
			};
			
			add(form);

			
			form.add(logOut);
		}

	}