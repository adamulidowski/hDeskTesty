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
@Table(name = "zgloszenia")
public class ProblemDataModel {

	@Id
	@GeneratedValue
	@Column(name = "Id_Zgloszenie", columnDefinition="INTEGER(8) NOT NULL")
	private int id;
	
	@OneToOne
	@JoinColumn(name = "Id_klienta", columnDefinition="INTEGER(6) NOT NULL")
	private ClientDataModel clientDataModel;
	
	
	@OneToOne
	@JoinColumn(name = "Id_typu", columnDefinition="INTEGER(2) NOT NULL")
	private TypeDataModel typeDataModel;
	
	

	@Column(name = "Temat" , columnDefinition="VARCHAR(50) NOT NULL")
	private String temat;
	
	@OneToOne
	@JoinColumn(name="Id_priorytetu", columnDefinition="INTEGER(2) NOT NULL")
	private PriorityDataModel prioritoryDataModel;
	
	@OneToOne
	@JoinColumn(name="Id_firma_produkt", columnDefinition="INTEGER(6) NOT NULL")
	private CompanyProductDataModel companyProductDataModel;
	
	@Column(name="Data_dodania", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDodania;
	
	@Column(name="Data_zakonczenia")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataZakonczenia;
	
	@OneToOne
	@JoinColumn(name="Id_wlasciciela", columnDefinition="INTEGER(5) NOT NULL")
	private EmployeeDataModel employeeDataModel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ClientDataModel getClientDataModel() {
		return clientDataModel;
	}

	public void setClientDataModel(ClientDataModel clientDataModel) {
		this.clientDataModel = clientDataModel;
	}

	public TypeDataModel getTypeDataModel() {
		return typeDataModel;
	}

	public void setTypeDataModel(TypeDataModel typeDataModel) {
		this.typeDataModel = typeDataModel;
	}

	public String getTemat() {
		return temat;
	}

	public void setTemat(String temat) {
		this.temat = temat;
	}

	public PriorityDataModel getPrioritoryDataModel() {
		return prioritoryDataModel;
	}

	public void setPrioritoryDataModel(PriorityDataModel prioritoryDataModel) {
		this.prioritoryDataModel = prioritoryDataModel;
	}

	public CompanyProductDataModel getCompanyProductDataModel() {
		return companyProductDataModel;
	}

	public void setCompanyProductDataModel(CompanyProductDataModel companyProductDataModel) {
		this.companyProductDataModel = companyProductDataModel;
	}

	public Date getDataDodania() {
		return dataDodania;
	}

	public void setDataDodania(Date dataDodania) {
		this.dataDodania = dataDodania;
	}

	public Date getDataZakonczenia() {
		return dataZakonczenia;
	}

	public void setDataZakonczenia(Date dataZakonczenia) {
		this.dataZakonczenia = dataZakonczenia;
	}

	public EmployeeDataModel getEmployeeDataModel() {
		return employeeDataModel;
	}

	public void setEmployeeDataModel(EmployeeDataModel employeeDataModel) {
		this.employeeDataModel = employeeDataModel;
	}
	
	
	
	
}
