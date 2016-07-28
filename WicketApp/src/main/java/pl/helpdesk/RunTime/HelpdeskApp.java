package pl.helpdesk.RunTime;

import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;



import pl.helpdesk.logging.Logowanie;
import pl.helpdesk.userSession.UserSession;

//Klasa startowa w niej definiujemy z jakiej klasy startujemy aplikacje
public class HelpdeskApp extends WebApplication{

	//Startujemy z klasy i stronki "Logowanie"
	@Override
	public Class<Logowanie> getHomePage() {
		// TODO Auto-generated method stub
		return Logowanie.class;
	}
	
	@Override
	public Session newSession(Request request, Response response) {
		// TODO Auto-generated method stub
		return new UserSession(request);
	}
	
	//Tu wczytanie konfiguracji springowych ale to potem... xd
	@Override
	public void init()
	{
		super.init();
		getComponentInstantiationListeners().add(new SpringComponentInjector(this));
		// add your configuration here
	}
}
