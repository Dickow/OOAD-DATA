package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import data.Connector;
import data.DALException;

public class CaseDTO {

	private String caseName, companyName; 
	private int id,partnerId; 
	private List researcherIds;
	
	public CaseDTO(String caseName, String companyName, int id, int partnerId){
		
	}
	
	public String getCaseName() {
		return caseName;
	}
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(int partnerId) {
		this.partnerId = partnerId;
	}
	public List getResearcherIds() {
		return researcherIds;
	}
	public void setResearcherIds(List researcherIds) {
		this.researcherIds = researcherIds;
	}
	
	/*
	 * public void createCase(CaseDTO Case) throws DALException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		Connector.doUpdate("UPDATE Case " + "SET" + " caseName = '"
				+ Case.getCaseName() + "', CompanyName = '"
				+ Case.getCompanyName()+ "', id = '"
				+ Case.getId() + "', partnerId = '"
				+ Case.getPartnerId() + ";");
		Connector.closeConnection();

	}
	 * 
	 */
	
	/*
	 * public void updateCase(CaseDTO Case) throws DALException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		Connector.doUpdate("UPDATE Case " + "SET" + " CaseName = '"
				+ Case.getCaseName() + "', CompanyName = '"
				+ Case.getCompanyName() + "', Id = '"
				+ Case.getId() + "', PartnerId = '"
				+ Case.getPartnerId()  + ";");
		Connector.closeConnection();

	}
	 * 
	 */
	
	
	/*
	 * public CaseDTO findCase(String caseName) throws DALException, SQLException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		ResultSet rs = Connector
				.doQuery("SELECT * FROM Case WHERE CaseName = " + caseName + ";");
		Connector.closeConnection();

		if (!rs.first()) {
			throw new DALException("the case with the name = " + caseName
					+ " does not exist");
		}

		return new CaseDTO(rs.getString("caseName"), rs.getString("CompanyName"),
				rs.getInt("id"), rs.getInt("PartnerId"));
	}
	 * 
	 */
	
}
