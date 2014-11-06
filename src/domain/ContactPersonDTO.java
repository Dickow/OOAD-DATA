package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.Connector;
import data.DALException;

public class ContactPersonDTO {

	private String caseName, name, email, contactPhone, contactCell;

	public ContactPersonDTO(String caseName, String name, String email,
			String contactPhone, String contactcell, int contactId) {

	}

	public String getCaseName() {
		return caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
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
