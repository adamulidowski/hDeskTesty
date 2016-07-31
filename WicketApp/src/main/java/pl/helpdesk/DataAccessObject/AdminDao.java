package pl.helpdesk.DataAccessObject;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import pl.helpdesk.DataModel.AdminDataModel;
import pl.helpdesk.DataModel.UserDataModel;

public class AdminDao {
	
	private EntityManagerFactory entityMF =  Persistence.createEntityManagerFactory("baza");
    private EntityManager entityM =entityMF.createEntityManager();
    private CriteriaBuilder builder = entityM.getCriteriaBuilder();
    private CriteriaQuery<AdminDataModel> criteriaQuery = builder.createQuery(AdminDataModel.class);
    private Root <AdminDataModel> admin=criteriaQuery.from(AdminDataModel.class);

    
	public void closeConection(){
		 entityM.close();
	     entityMF.close();
	}
	/**
	 * Tworzy listę administratorów.
	 * 
	 * @return lista administratorów.
	 */
    public List <AdminDataModel> createAdminList(){
    	
    	criteriaQuery.select(admin);
		
		TypedQuery<AdminDataModel> query=entityM.createQuery(criteriaQuery);
		
		List <AdminDataModel> admins=query.getResultList();
		return admins;
    }
}
