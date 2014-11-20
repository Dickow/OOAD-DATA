package domain;

public class PersonPjLaDTO {
	PersonDTO personDTO = new PersonDTO();
	private int personId;
	private String previousJobs, language;

	public PersonPjLaDTO(String previousJobs, String language, int personId) {

	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPreviousJobs() {
		return previousJobs;
	}

	public void setPreviousJobs(String previousJobs) {
		this.previousJobs = previousJobs;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;

	}

}
