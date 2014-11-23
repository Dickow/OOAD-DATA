package domain;

import java.util.List;

public class CaseDTO {

	private String caseName, companyName; 
	private int partnerId; 
	
	public CaseDTO(){
	}
	
	public CaseDTO(String caseName, String companyName, int partnerId){
		this.caseName = caseName; 
		this.companyName = companyName; 
		this.partnerId = partnerId; 
		
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
	public int getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(int partnerId) {
		this.partnerId = partnerId;
	}
	
}
