package pl.helpdesk.DataAccessObject;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import pl.helpdesk.DataModel.CompanyDataModel;
import pl.helpdesk.DataModel.UserDataModel;

public class CompanyDao {

	private EntityManagerFactory entityMF =  Persistence.createEntityManagerFactory("baza");
    private EntityManager entityM =entityMF.createEntityManager();
    private CriteriaBuilder builder = entityM.getCriteriaBuilder();
    private CriteriaQuery<UserDataModel> criteriaQuery = builder.createQuery(UserDataModel.class);
    private Root <UserDataModel> user=criteriaQuery.from(UserDataModel.class);
	
    
    public void closeConection(){
		 entityM.close();
	     entityMF.close();
	}


public void addCompany( String nazwa, String miejscowosc, String ulica, String kod_pocztowy, String numer){
	
    
    CompanyDataModel companyDataModel = new CompanyDataModel();

    companyDataModel.setNazwa(nazwa);
    companyDataModel.setUlica(ulica);
    companyDataModel.setKod_pocztowy(kod_pocztowy);
    companyDataModel.setMiejscowosc(miejscowosc);
    companyDataModel.setNumer(numer);
    
    entityM.getTransaction().begin();
    entityM.persist(companyDataModel);
    entityM.getTransaction().commit();
    
    
}
}