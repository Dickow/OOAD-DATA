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


/* public List<ContactPersonDTO> findContacts(String caseName) throws DALException, SQLException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}

		List<ContactPersonDTO> list = new ArrayList<ContactPersonDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM Contactperson WHERE Casename = "
				+ caseName);
		Connector.closeConnection();

		while (rs.next()) {
			list.add(new ContactPersonDTO(rs.getString("caseName"), rs
					.getString("name"), rs.getString("email"), rs
					.getString("contactPhone"), rs.getString("contactcell"), rs.getInt("contactId")));
		}
		return list;
	}
 
 */

/*
 * 
 * public void createContact(ContactPersonDTO contact) throws DALException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		Connector.doUpdate("INSERT INTO Company VALUES ("
				+ contact.getCaseName() + "," + contact.getName()
				+ "," + contact.getEmail() + ","
				+ contact.getContactPhone() + "," + contact.getContactCell() + ","
				 + "');");
		Connector.closeConnection();

	}
 */


/*
*public void updateContact(ContactPersonDTO contact) throws DALException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		Connector.doUpdate("UPDATE Contact " + "SET" + " caseName = '"
				+ contact.getCaseName() + "', BanchCode = '"
				+ contact.getName() + "', CompanyAdress = '"
				+ contact.getEmail() + "', CompanyTlf = '"
				+ contact.getContactPhone() + "', CEO = '" + contact.getContactCell()
				 + ";");
		Connector.closeConnection();

	}
	
*/

/*
 * public ContactPersonDTO findContact(int contactId, String caseName) throws DALException, SQLException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		ResultSet rs = Connector
				.doQuery("SELECT * FROM Contact WHERE contactId = " + contactId + ";");
		Connector.closeConnection();

		if (!rs.first()) {
			throw new DALException("the contactperson with the id = " + contactId
					+ " does not exist");
		}

		return new ContactPersonDTO(rs.getString("caseName"), rs.getString("name"),
				rs.getString("email"), rs.getString("contactPhone"),
				rs.getString("contactcell"), rs.getInt("contactId"));
	}
 * 
 */


 */
*/