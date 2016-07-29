package pl.helpdesk.DataAccessObject;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import javax.persistence.criteria.Root;

import pl.helpdesk.DataModel.AdminDataModel;
import pl.helpdesk.DataModel.EmployeeDataModel;
import pl.helpdesk.DataModel.UserDataModel;


public class UserDao implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private EntityManagerFactory entityMF =  Persistence.createEntityManagerFactory("baza");
    private EntityManager entityM =entityMF.createEntityManager();
    private CriteriaBuilder builder = entityM.getCriteriaBuilder();
    private CriteriaQuery<UserDataModel> criteriaQuery = builder.createQuery(UserDataModel.class);
    private Root <UserDataModel> user=criteriaQuery.from(UserDataModel.class);
    
    public UserDao(){

	}
    
	public void closeConection(){
		 entityM.close();
	     entityMF.close();
	}
    
    public List <UserDataModel> createUserList(){
    	
    	criteriaQuery.select(user);
		
		TypedQuery<UserDataModel> query=entityM.createQuery(criteriaQuery);
		
		List <UserDataModel> users=query.getResultList();
		return users;
    }
    
	public String findUserByLoginAndPassword(String Login,String Passw) throws NoSuchAlgorithmException{
	
	
		createUserList();
		for (UserDataModel userDM : createUserList()) {
			if(userDM.getLogin().equals(Login) && userDM.getHaslo().equals(PasswordHash(Passw))){
				return Login;
			}		
		}	
		return "none";
		
	}

	public int findUserId(String Login){

	 
	    createUserList();
        for (UserDataModel users2 : createUserList()) {
			if(users2.getLogin().equals(Login)){
				return users2.getId();
			}
		}
		return 0; 
	}
	
public boolean czyBlokowany(String Login){
		

	
	    createUserList();
        for (UserDataModel users2 :createUserList()) {
			if(users2.getLogin().equals(Login)){
				if(users2.getCzy_blokowany()==true){
				return true;
				}
			}
		}
		return false; 
	}



	
	
	public String PasswordHash(String password) throws NoSuchAlgorithmException{
		 
		MessageDigest md = MessageDigest.getInstance("SHA-256");
	        md.update(password.getBytes());
	        
	        byte byteData[] = md.digest();
	 
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        return sb.toString();
	}
	
	
	
	public void addUser( String name, String pass, String email, String imie, String nazwisko, int rodzaj) throws NoSuchAlgorithmException{
		
        
        UserDataModel userDataModel = new UserDataModel();

        userDataModel.setLogin(name);
        userDataModel.setHaslo(PasswordHash(pass));
        userDataModel.setEmail(email);
        userDataModel.setImie(imie);
        userDataModel.setNazwisko(nazwisko);
        userDataModel.setCzy_blokowany(false);
        userDataModel.setCzy_usuniety(false);
        //userDataModel.setOst_logowanie(new Date());
        
        //EmployeeDataModel employeeDataModel = new EmployeeDataModel();

        //employeeDataModel.setId_uzytkownika(userDataModel.getId());
        
        entityM.getTransaction().begin();
        entityM.persist(userDataModel);
        entityM.getTransaction().commit();
        
        
        
        if(rodzaj==1){
        EmployeeDataModel employeeDataModel = new EmployeeDataModel();
        employeeDataModel.setId_uzytkownika(userDataModel.getId());
        
        entityM.getTransaction().begin();
        entityM.persist(employeeDataModel);
        entityM.getTransaction().commit();
        } else if(rodzaj == 2){
        	//tworzy przedstawiciela
        } else if(rodzaj ==3){
        	//tworzy klienta
        } else if(rodzaj == 4){
        	AdminDataModel adminDataModel = new AdminDataModel();
        	adminDataModel.setId_uzytkownika(userDataModel.getId());
        	
            entityM.getTransaction().begin();
            entityM.persist(adminDataModel);
            entityM.getTransaction().commit();
        }
        

        
	}
	
//    public void addEmployee(int id_uzytkownika){
//		
//   	 EmployeeDataModel employeeDataModel = new EmployeeDataModel();
//
//   	 employeeDataModel.setId_uzytkownika(id_uzytkownika);
//        
//        entityM.getTransaction().begin();
//        entityM.persist(employeeDataModel);
//        entityM.getTransaction().commit();
//        
//	}
	
	
	
	
	
	
	
	
	//Wersja inna:
//	public String findUserByLoginAndPassword(String Login,String Passw){
//		//EntityManagerFactory entityMF= Persistence.createEntityManagerFactory("baza");
//		//EntityManager entityM=entityMF.createEntityManager();
//		//CriteriaBuilder builder = entityM.getCriteriaBuilder();
//		//CriteriaQuery <UserDataModel> criteriaQuery = builder.createQuery(UserDataModel.class);
//		
//		//Root <UserDataModel> user=criteriaQuery.from(UserDataModel.class);
//		//Wersja z dluzzym selectem:
//		////Path <String> name=user.get("login");
//		////criteriaQuery.select(user).where(builder.like(name, Login));
//		criteriaQuery.select(user);
//		
//		TypedQuery<UserDataModel> query=entityM.createQuery(criteriaQuery);
//		
//		List <UserDataModel> users=query.getResultList();
//		
//		//entityM.close();
//		//entityMF.close();
//		
//		for (UserDataModel userDM : users) {
//			if(userDM.getLogin().equals(Login) && userDM.getHaslo().equals(Passw)){
//				return Login;
//			}		
//		}
//		
//		return "none";
//		
//	}
	
	

	
}
