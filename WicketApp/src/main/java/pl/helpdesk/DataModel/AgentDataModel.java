package pl.helpdesk.DataModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "przedstawiciele")
public class AgentDataModel {

	@Id
	@GeneratedValue
	@Column(name = "Id_Pzedstawiciel",columnDefinition="INTEGER(5) NOT NULL")
	private int id;

	@OneToOne
	@JoinColumn(name = "Id_uzytkownika", nullable=false)
	private UserDataModel userDataModel;

	@OneToOne
	@JoinColumn(name = "Id_firmy", columnDefinition="INTEGER(5) NOT NULL")
	private CompanyDataModel companyDataModel;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserDataModel getUserDataModel() {
		return userDataModel;
	}

	public void setUserDataModel(UserDataModel userDataModel) {
		this.userDataModel = userDataModel;
	}

	public CompanyDataModel getCompanyDataModel() {
		return companyDataModel;
	}

	public void setCompanyDataModel(CompanyDataModel companyDataModel) {
		this.companyDataModel = companyDataModel;
	}

	
	
}
