package domain;

public class CompanyDTO {
	
	private static String companyName;
	private static String branchCode;
	private static String companyAddress;
	private static String companyPhone;
	private static String CEO;
	private static String CFO;

	public CompanyDTO(String CampanyName, String BranchCode, String CompanyAddress,
			String CompanyPhone, String CEO, String CFO) {
		setCompanyName(CampanyName);
		setCompanyAddress(CompanyAddress);
		setCompanyPhone(CompanyPhone);
		setBranchCode(BranchCode);
		setCEO(CEO);
		setCFO(CFO);
		
	}

	public static String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		CompanyDTO.companyName = companyName;
	}

	public static String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		CompanyDTO.branchCode = branchCode;
	}

	public static String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		CompanyDTO.companyAddress = companyAddress;
	}

	public static String getCompanyPhone() {
		return companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		CompanyDTO.companyPhone = companyPhone;
	}

	public static String getCEO() {
		return CEO;
	}

	public void setCEO(String cEO) {
		CEO = cEO;
	}

	public static String getCFO() {
		return CFO;
	}

	public void setCFO(String cFO) {
		CFO = cFO;
	}
	
	

}
