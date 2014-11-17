package domain;

import java.util.List;

public class CaseDTO {

	private String caseName, companyName; 
	private int candidateId,partnerId; 
	private List researcherIds;
	
	public CaseDTO(){
	}
	
	public CaseDTO(String caseName, String companyName, int candidateId, int partnerId){
		
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
	public int getcandidateId() {
		return candidateId;
	}
	public void setId(int candidateId) {
		this.candidateId = candidateId;
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
	
}
