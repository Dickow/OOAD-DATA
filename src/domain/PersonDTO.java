package domain;

import java.util.List;

public class PersonDTO {

	private String name, address, education, currentJob, personPhone,
			companyMail, privateMail, personCell, note;
	private int id, age, salary;
	// private List<String> previousJobs, language;

	public PersonDTO(String name, String address, String education,
			String currentJob, String personPhone, String companyMail,
			String privateMail, String personCell, String note, int id, int age, int salary) {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

 /*
	public List<String> getPreviousJobs() {
		return previousJobs;
	}

	public void setPreviousJobs(List<String> previousJobs) {
		this.previousJobs = previousJobs;
	}

	public List<String> getLanguage() {
		return language;
	}

	public void setLanguage(List<String> language) {
		this.language = language;
	}
 */
}
