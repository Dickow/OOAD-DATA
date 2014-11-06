package domain;

import java.util.List;

public class PersonPjLaDTO {
	
	 private List<String> previousJobs, language;
	 
	 public PersonPjLaDTO(List<String> previousJobs, List<String> language){
		 
	 }
	 
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
	 
}
