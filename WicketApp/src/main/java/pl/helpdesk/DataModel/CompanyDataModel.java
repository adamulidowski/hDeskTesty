package pl.helpdesk.DataModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "firmy")
public class CompanyDataModel {
	// Klasa reprezentująca tabelę firmy

	@Id
	@GeneratedValue
	@Column(name = "Id_Firma")
	private int id;
	@Column(name = "Nazwa")
	private String nazwa;
	@Column(name = "Ulica")
	private String ulica;
	@Column(name = "Numer")
	private String numer;
	@Column(name = "Kod_pocztowy")
	private String kod_pocztowy;
	@Column(name = "Miejscowosc")
	private String miejscowosc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getNumer() {
		return numer;
	}

	public void setNumer(String numer) {
		this.numer = numer;
	}

	public String getKod_pocztowy() {
		return kod_pocztowy;
	}

	public void setKod_pocztowy(String kod_pocztowy) {
		this.kod_pocztowy = kod_pocztowy;
	}

	public String getMiejscowosc() {
		return miejscowosc;
	}

	public void setMiejscowosc(String miejscowosc) {
		this.miejscowosc = miejscowosc;
	}

}
