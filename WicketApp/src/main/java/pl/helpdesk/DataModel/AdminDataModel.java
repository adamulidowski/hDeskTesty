package pl.helpdesk.DataModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "administratorzy")
public class AdminDataModel {

	@Id
	@GeneratedValue
	@Column(name = "Id_Administrator", columnDefinition="INTEGER(4) NOT NULL")
	private int id;

	
	@OneToOne
	@JoinColumn(name = "Id_uzytkownika", nullable=false)
	private UserDataModel userDataModel;
	
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



}
