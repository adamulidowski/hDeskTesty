package pl.helpdesk.DataModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pracownicy")
public class EmployeeDataModel {

	@Id
	@GeneratedValue
	@Column(name = "Id_Pracownik")
	private int id;
	@Column(name = "Id_uzytkownika")
	private int id_uzytkownika;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_uzytkownika() {
		return id_uzytkownika;
	}

	public void setId_uzytkownika(int id_uzytkownika) {
		this.id_uzytkownika = id_uzytkownika;
	}
}
