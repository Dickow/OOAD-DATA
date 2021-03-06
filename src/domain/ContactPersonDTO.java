package domain;

public class ContactPersonDTO {

	private String caseName, name, email, contactPhone, contactCell,
			companyName;
	private int contactId;

	public ContactPersonDTO(String caseName, String name, String email,
			String contactPhone, String contactcell, int contactId,
			String companyName) {
		this.caseName = caseName;
		this.name = name;
		this.email = email;
		this.contactPhone = contactPhone;
		this.contactCell = contactcell;
		this.companyName = companyName;
		this.contactId = contactId;
	}

	public ContactPersonDTO() {

	}

	public String getCaseName() {
		return caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	public int getcontactId() {
		return contactId;
	}

	public void setcontactId(int contactId) {
		this.contactId = contactId;
	}

	public String getcompanyName() {
		return companyName;
	}

	public void setcompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactCell() {
		return contactCell;
	}

	public void setContactCell(String contactCell) {
		this.contactCell = contactCell;
	}

}
