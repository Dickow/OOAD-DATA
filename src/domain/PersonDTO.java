package domain;

import java.sql.Date;

public class PersonDTO {

	private String name, address, education, currentJob, personPhone,
			companyMail, privateMail, personCell, note;
	private int personId, salary;
	private Date birthYear; 
	
	public PersonDTO(){
		
	}
	
	public PersonDTO(String name, String address, String education,
			String currentJob, String personPhone, String companyMail,
			String privateMail, String personCell, String note, int personId, Date birthYear, int salary) {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getCurrentJob() {
		return currentJob;
	}

	public void setCurrentJob(String currentJob) {
		this.currentJob = currentJob;
	}

	public String getPersonPhone() {
		return personPhone;
	}

	public void setPersonPhone(String personPhone) {
		this.personPhone = personPhone;
	}

	public String getCompanyMail() {
		return companyMail;
	}

	public void setCompanyMail(String companyMail) {
		this.companyMail = companyMail;
	}

	public String getPrivateMail() {
		return privateMail;
	}

	public void setPrivateMail(String privateMail) {
		this.privateMail = privateMail;
	}

	public String getPersonCell() {
		return personCell;
	}

	public void setPersonCell(String personCell) {
		this.personCell = personCell;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getPersonId() {
		return personId;
	}

	public void setId(int personId) {
		this.personId = personId;
	}

	public Date getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(Date birthYear) {
		this.birthYear = birthYear;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
