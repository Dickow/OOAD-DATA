package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.Connector;
import data.DALException;

public class PersonPjLaDTO {

	private int id;
	private String previousJobs, language;

	public PersonPjLaDTO(String previousJobs, String language, int id) {

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
	/*
	 * public List<PersonPjLaDTO> findPersonPjLa(int id) throws DALException, SQLException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}

		List<PersonPjLaDTO> list = new ArrayList<PersonPjLaDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM PersonPjLa WHERE Id = "
				+ id);
		Connector.closeConnection();

		while (rs.next()) {
			list.add(new PersonPjLaDTO(rs.getString("previousJobs"), rs
					.getString("language"), rs.getInt("id")));
		}
		return list;
	}
	 */
	
}


