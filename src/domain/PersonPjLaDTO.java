package domain;

public class PersonPjLaDTO {
	PersonDTO personDTO = new PersonDTO();
	private int id;
	private String previousJobs, language;

	public PersonPjLaDTO(String previousJobs, String language, int id) {

	}

	public int getId() {
		return id;
	}

	public void setId() {
		id = personDTO.getId();
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
