package domain;

public class ResearcherOnCaseDTO {

	int researcherId;
	String caseName;
	
	public ResearcherOnCaseDTO(int researcherId, String caseName) {
		this.researcherId = researcherId; 
		this.caseName = caseName; 
	}

	public int getResearcherId(){
		return researcherId;
	}
	
	
	public String getcaseName(){
		return caseName;
	}
}
