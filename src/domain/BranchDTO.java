package domain;

public class BranchDTO {
	private String mainCode, subCode;
	
	public BranchDTO(String mainCode, String subCode){
		this.mainCode = mainCode; 
		this.subCode = subCode; 
	}

	public String getMainCode() {
		return mainCode;
	}

	public void setMainCode(String mainCode) {
		this.mainCode = mainCode;
	}

	public String getSubCode() {
		return subCode;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
	} 
	
	
}
