package domain;

public class CompanyDTO {
	
	private String companyName, mainCode, companyAddress, companyPhone, CEO, CFO;

	public CompanyDTO(String companyName, String branchCode, String companyAddress,
			String companyPhone, String CEO, String CFO) {
		this.companyName = companyName; 
		this.companyAddress = companyAddress; 
		this.companyPhone = companyPhone; 
		this.mainCode = branchCode; 
		this.CEO = CEO; 
		this.CFO = CFO; 
	}
	
	public CompanyDTO(){
		
	}

	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getMainCode() {
		return mainCode;
	}

	public void setMainCode(String mainCode) {
		this.mainCode = mainCode;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyPhone() {
		return companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	public String getCEO() {
		return CEO;
	}

	public void setCEO(String cEO) {
		CEO = cEO;
	}

	public String getCFO() {
		return CFO;
	}

	public void setCFO(String cFO) {
		CFO = cFO;
	}
	
	

}
