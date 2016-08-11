package pl.helpdesk.DataModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "klienci")
public class ClientDataModel {
		@Id
		@GeneratedValue
		@Column(name = "Id_Klient",columnDefinition="INTEGER(6) NOT NULL")
		private int id;

		@OneToOne
		@JoinColumn(name = "Id_uzytkownika", nullable=false)
		private UserDataModel userDataModel;

		@OneToOne
		@JoinColumn(name = "Id_firmy", columnDefinition="INTEGER(5)")
		private CompanyDataModel companyDataModel;
		
		@OneToOne
		@JoinColumn(name = "Id_przedstawiciela", columnDefinition="INTEGER(5) NOT NULL")
		private AgentDataModel agentDataModel;

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

		public AgentDataModel getAgentDataModel() {
			return agentDataModel;
		}

		public void setAgentDataModel(AgentDataModel agentDataModel) {
			this.agentDataModel = agentDataModel;
		}
		
		
}
