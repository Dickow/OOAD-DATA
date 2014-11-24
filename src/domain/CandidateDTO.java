package domain;

public class CandidateDTO {

	private int candidateId, personId; 
	private String caseName, status;
	
	
	
	public CandidateDTO(int candidateId, String caseName, String status, int personId) {
		this.candidateId = candidateId; 
		this.caseName = caseName; 
		this.status = status; 
		this.setPersonId(personId); 
	}
	public int getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}
	public String getCaseName() {
		return caseName;
	}
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	} 
	
	
}
