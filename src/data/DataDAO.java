package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.Connector;
import data.DALException;
import domain.BranchDTO;
import domain.CandidateDTO;
import domain.CaseDTO;
import domain.CompanyDTO;
import domain.ContactPersonDTO;
import domain.EmployeeDTO;
import domain.PersonDTO;
import domain.PersonPjLaDTO;

public class DataDAO implements IDataDAO {

	@Override
	public void createCompany(CompanyDTO company) throws DALException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		Connector.doUpdate("INSERT INTO Company VALUES ("
				+ company.getCompanyName() + "," + company.getBranchCode()
				+ "," + company.getCompanyAddress() + ","
				+ company.getCompanyPhone() + "," + company.getCEO() + ","
				+ company.getCFO() + "');");
		Connector.closeConnection();
	}

	@Override
	public void updateCompany(CompanyDTO company) throws DALException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		Connector.doUpdate("UPDATE Company " + "SET" + " companyName = '"
				+ company.getCompanyName() + "', BanchCode = '"
				+ company.getBranchCode() + "', CompanyAdress = '"
				+ company.getCompanyAddress() + "', CompanyTlf = '"
				+ company.getCompanyPhone() + "', CEO = '" + company.getCEO()
				+ "', CFO = '" + company.getCFO() + "' WHERE companyName = "
				+ company.getCompanyName() + ";");
		Connector.closeConnection();
	}

	@Override
	public CompanyDTO findCompany(String companyName) throws DALException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		ResultSet rs = Connector
				.doQuery("SELECT * FROM company WHERE companyName = "
						+ companyName + ";");
		Connector.closeConnection();

		try {
			if (!rs.first()) {
				throw new DALException("the commodity with the id = "
						+ companyName + " does not exist");
			}
			return new CompanyDTO(rs.getString("companyNAme"),
					rs.getString("branchCode"), rs.getString("companyAddress"),
					rs.getString("companyPhone"), rs.getString("CEO"),
					rs.getString("CFO"));
		} catch (SQLException e) {
			throw new DALException(
					"Der skete en fejl i Commodity i metoden getCommodity()"
							+ e.getMessage());
		}
	}

	@Override
	public List<CompanyDTO> findCompanies(BranchDTO branch) throws DALException {

		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}

		List<CompanyDTO> list = new ArrayList<CompanyDTO>();
		ResultSet rs = Connector
				.doQuery("SELECT * FROM Company WHERE BrancheCode = " + branch);
		Connector.closeConnection();
		try {
			while (rs.next()) {
				list.add(new CompanyDTO(rs.getString("CompanyName"), rs
						.getString("BranchCode"), rs
						.getString("companyAddress"), rs
						.getString("companyPhone"), rs.getString("CEO"), rs
						.getString("CFO")));
			}
		} catch (SQLException e) {
			throw new DALException(
					"Der skete en fejl i Commodity i metoden getComList()"
							+ e.getMessage());
		}
		return list;
	}

	@Override
	public PersonDTO findPerson(int id) throws DALException, SQLException {

		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		ResultSet rs = Connector
				.doQuery("SELECT * FROM person WHERE personId = " + id + ";");
		Connector.closeConnection();

		if (!rs.first()) {
			throw new DALException("the person with the id = " + id
					+ " does not exist");
		}

		return new PersonDTO(rs.getString("name"), rs.getString("address"),
				rs.getString("education"), rs.getString("currentJob"),
				rs.getString("personPhone"), rs.getString("companyMail"),
				rs.getString("privateMail"), rs.getString("personCell"),
				rs.getString("note"), rs.getInt("id"), rs.getInt("age"),
				rs.getInt("salary"));
	}

	@Override
	public List<PersonDTO> findPersons(String name) throws DALException,
			SQLException {

		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}

		List<PersonDTO> list = new ArrayList<PersonDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM person WHERE name = "
				+ name);
		Connector.closeConnection();

		while (rs.next()) {
			list.add(new PersonDTO(rs.getString("name"), rs
					.getString("address"), rs.getString("education"), rs
					.getString("currentJob"), rs.getString("companyMail"), rs
					.getString("privateMail"), rs.getString("personCell"), rs
					.getString("personPhone"), rs.getString("note"), rs
					.getInt("id"), rs.getInt("age"), rs.getInt("salary")));
		}
		return list;
	}

	@Override
	public void updatePerson(PersonDTO person) throws DALException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		Connector.doUpdate("UPDATE Person " + "SET" + " " + "name = '"
				+ person.getName() + "', address = '" + person.getAddress()
				+ "', education = '" + person.getAddress()
				+ "', currentJob = '" + person.getCurrentJob()
				+ "', personPhone = '" + person.getPersonPhone()
				+ "', companyMail = '" + person.getCompanyMail()
				+ "', privateMail = '" + person.getPrivateMail()
				+ "', personCell = '" + person.getPersonCell() + "', note = '"
				+ person.getNote() + "', id = '" + person.getId()
				+ "', age = '" + person.getAge() + ", salary = "
				+ person.getSalary() +

				"' WHERE name = " + person.getName() + ";");
		Connector.closeConnection();

	}

	@Override
	public void createPerson(PersonDTO person) throws DALException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		Connector.doUpdate("INSERT INTO Person VALUES (" + person.getName()
				+ "," + person.getAddress() + "," + person.getEducation() + ","
				+ person.getCurrentJob() + "," + person.getPersonPhone() + ","
				+ person.getCompanyMail() + "," + person.getPrivateMail() + ","
				+ person.getPersonCell() + "," + person.getNote() + ","
				+ person.getId() + "," + person.getAge() + ","
				+ person.getSalary() + "');");
		Connector.closeConnection();

	}

	@Override
	public void updateEmployee(EmployeeDTO employee) throws DALException {
		try {
			Connector.connect();
		} catch (Exception e) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		Connector.doUpdate("Update Employee SET name = '" + employee.getName()
				+ "', SET employeeId = '" + employee.getEmployeeId()
				+ "', SET password = '" + employee.getPassword()
				+ "', SET job = '" + employee.getJob() + "');");
		Connector.closeConnection();

	}

	@Override
	public void createEmployee(EmployeeDTO employee) throws DALException {
		try {
			Connector.connect();
		} catch (Exception e) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		Connector.doUpdate("INSERT INTO employee VALUES ("
				+ employee.getEmployeeId() + "," + employee.getName() + ","
				+ employee.getPassword() + "," + employee.getJob() + "');");

	}

	@Override
	public EmployeeDTO findEmployee(int employeeId) {

		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		ResultSet rs = Connector
				.doQuery("SELECT * FROM Employee WHERE employeeId = "
						+ employeeId + ";");
		Connector.closeConnection();

		if (!rs.first()) {
			throw new DALException("the employee with the id = " + employeeId
					+ " does not exist");
		}

		return new EmployeeDTO(rs.getInt("employeeId"), rs.getString("name"),
				rs.getString("password"), rs.get("job"));

	}

	@Override
	public List<EmployeeDTO> findEmployees(String name) throws DALException,
			SQLException {

		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}

		List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM Employee WHERE name = "
				+ name);
		Connector.closeConnection();

		while (rs.next()) {
			list.add(new EmployeeDTO(rs.getInt("employeeId"), rs.getString("name"),
					rs.getString("password"), rs.get("job")););
		}
		return list;
	}

	@Override
	public void createCandidate(CandidateDTO candidate) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CandidateDTO> findCandidates(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CandidateDTO> findCaseCandidates(String caseName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CaseDTO findCase(String caseName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCase(CaseDTO Case) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createCase(CaseDTO Case) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createContact(ContactPersonDTO contact) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateContact(ContactPersonDTO contact) {
		// TODO Auto-generated method stub

	}

	@Override
	public ContactPersonDTO findContact(int contactId, String caseName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContactPersonDTO> findContacts(String caseName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean loginExists(String[] loginInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PersonDTO> findPersons(PersonDTO person) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonPjLaDTO> findPersonPreviousJobs(int id)
			throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonPjLaDTO> findPersonLanguage(int id) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePersonPj(PersonPjLaDTO personPj) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePersonLa(PersonPjLaDTO personLa) throws DALException {
		// TODO Auto-generated method stub

	}

}
