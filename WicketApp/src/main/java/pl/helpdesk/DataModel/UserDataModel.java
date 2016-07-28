package pl.helpdesk.DataModel;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//Klasa reprezentująca tabelę użytkownicy 
@Entity
@Table(name="uzytkownicy")
public class UserDataModel{
	@Id
	@GeneratedValue
	@Column(name="Id_Uzytkownika")
	int id;
	@Column(name="Login")
	String login;
	@Column(name="Haslo")
	String haslo;
	@Column(name="Imie")
	String imie;
	@Column(name="Nazwisko")
	String nazwisko;
	@Column(name="Email")
	String email;
	
	@Column(name="Ostatnie_logowanie")
	@Temporal(TemporalType.DATE)
	Date ost_logowanie;
	
	@Column(name="Czy_blokowany")
	Boolean czy_blokowany;
	
	@Column(name="Czy_usuniety")
	Boolean czy_usuniety;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the haslo
	 */
	public String getHaslo() {
		return haslo;
	}
	/**
	 * @param haslo the haslo to set
	 */
	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}
	/**
	 * @return the imie
	 */
	public String getImie() {
		return imie;
	}
	/**
	 * @param imie the imie to set
	 */
	public void setImie(String imie) {
		this.imie = imie;
	}
	/**
	 * @return the nazwisko
	 */
	public String getNazwisko() {
		return nazwisko;
	}
	/**
	 * @param nazwisko the nazwisko to set
	 */
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the ost_logowanie
	 */

	public Boolean getCzy_blokowany() {
		return czy_blokowany;
	}
	public Date getOst_logowanie() {
		return ost_logowanie;
	}
	public void setOst_logowanie(Date ost_logowanie) {
		this.ost_logowanie = ost_logowanie;
	}
	public void setCzy_blokowany(Boolean czy_blokowany) {
		this.czy_blokowany = czy_blokowany;
	}
	public Boolean getCzy_usuniety() {
		return czy_usuniety;
	}
	public void setCzy_usuniety(Boolean czy_usuniety) {
		this.czy_usuniety = czy_usuniety;
	}




}
