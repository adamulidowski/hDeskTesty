package pl.helpdesk.DataAccessObject;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import pl.helpdesk.DataModel.EmployeeDataModel;


public class EmployeeDao {
	
	private EntityManagerFactory entityMF =  Persistence.createEntityManagerFactory("baza");
    private EntityManager entityM =entityMF.createEntityManager();
    private CriteriaBuilder builder = entityM.getCriteriaBuilder();
    private CriteriaQuery<EmployeeDataModel> criteriaQuery = builder.createQuery(EmployeeDataModel.class);
    private Root <EmployeeDataModel> employee=criteriaQuery.from(EmployeeDataModel.class);

    
	public void closeConection(){
		 entityM.close();
	     entityMF.close();
	}
	
	/**
	 * Tworzy listę pracowników Helpdesku.
	 * 
	 * @return Lista pracowników.
	 */
    public List <EmployeeDataModel> createEmployeeList(){
    	
    	criteriaQuery.select(employee);
		
		TypedQuery<EmployeeDataModel> query=entityM.createQuery(criteriaQuery);
		
		List <EmployeeDataModel> employees=query.getResultList();
		return employees;
    }
}

