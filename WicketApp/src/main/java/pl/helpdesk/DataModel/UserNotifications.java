package pl.helpdesk.DataModel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Powiadomienia_uzytkownika")
public class UserNotifications {

	
	@Id
	@GeneratedValue
	@Column(name="Id_Pow_Uzytk", columnDefinition="INTEGER(11) NOT NULL")
	private int id;
	
	@OneToOne
	@JoinColumn(name="Id_powiadomienia", columnDefinition="INTEGER(11) NOT NULL")
	private NotificationDataModel notificationDataModel;
	
	@OneToOne
	@JoinColumn(name="Id_uzytkownika", columnDefinition="INTEGER(11) NOT NULL")
	private UserDataModel userDataModel;
	
	@Column(name="Data_wyslania")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataWyslania;
	
	@Column(name="Email", columnDefinition="VARCHAR(45) NOT NULL")
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public NotificationDataModel getNotificationDataModel() {
		return notificationDataModel;
	}

	public void setNotificationDataModel(NotificationDataModel notificationDataModel) {
		this.notificationDataModel = notificationDataModel;
	}

	public UserDataModel getUserDataModel() {
		return userDataModel;
	}

	public void setUserDataModel(UserDataModel userDataModel) {
		this.userDataModel = userDataModel;
	}

	public Date getDataWyslania() {
		return dataWyslania;
	}

	public void setDataWyslania(Date dataWyslania) {
		this.dataWyslania = dataWyslania;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
