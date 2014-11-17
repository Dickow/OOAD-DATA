package data;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.BranchDTO;
import domain.CandidateDTO;
import domain.CaseDTO;
import domain.CompanyDTO;
import domain.ContactPersonDTO;
import domain.EmployeeDTO;
import domain.EmployeeDTO.JOB;
import domain.PersonDTO;
import domain.PersonPjLaDTO;
import domain.ResearcherDTO;

public class DataDAO implements IDataDAO {

	private JOB job;

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

	public PersonDTO getLastPerson() throws DALException, SQLException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		ResultSet rs = Connector
				.doQuery("SELECT personId FROM person ORDER BY personId DESC LIMIT 1;");
		Connector.closeConnection();

		if (!rs.first()) {
			throw new DALException("There is no persons in the database");
		}
		Date age = rs.getDate("date");
		
		return new PersonDTO(rs.getString("name"), rs.getString("address"),
				rs.getString("education"), rs.getString("currentJob"),
				rs.getString("personPhone"), rs.getString("companyMail"),
				rs.getString("privateMail"), rs.getString("personCell"),
				rs.getString("note"), rs.getInt("id"), age,
				rs.getInt("salary"));
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
		Date age = rs.getDate("date");
		
		return new PersonDTO(rs.getString("name"), rs.getString("address"),
				rs.getString("education"), rs.getString("currentJob"),
				rs.getString("personPhone"), rs.getString("companyMail"),
				rs.getString("privateMail"), rs.getString("personCell"),
				rs.getString("note"), rs.getInt("id"), age,
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
			Date age = rs.getDate("date");
			list.add(new PersonDTO(rs.getString("name"), rs
					.getString("address"), rs.getString("education"), rs
					.getString("currentJob"), rs.getString("companyMail"), rs
					.getString("privateMail"), rs.getString("personCell"), rs
					.getString("personPhone"), rs.getString("note"), rs
					.getInt("id"), age, rs.getInt("salary")));
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
	public EmployeeDTO findEmployee(int employeeId) throws DALException {

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

		try {
			if (!rs.first()) {
				throw new DALException("the employee with the id = "
						+ employeeId + " does not exist");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			if (rs.getString("job").equals("PARTNER")) {
				job = EmployeeDTO.JOB.PARTNER;
			} else {
				job = EmployeeDTO.JOB.RESEARCHER;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			return new EmployeeDTO(rs.getInt("employeeId"),
					rs.getString("name"), rs.getString("password"), job);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// wont ever reach this code
		return null;
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

		if (!rs.next()) {
			throw new DALException("Der findes ikke nogle ansatte med navnet"
					+ name);
		}

		while (rs.next()) {
			if (rs.getString("job").equals("PARTNER")) {
				job = EmployeeDTO.JOB.PARTNER;
			} else {
				job = EmployeeDTO.JOB.RESEARCHER;
			}
			list.add(new EmployeeDTO(rs.getInt("employeeId"), rs
					.getString("name"), rs.getString("password"), job));
		}
		return list;
	}

	@Override
	public void createCandidate(CandidateDTO candidate) throws DALException {
		try {
			Connector.connect();
		} catch (Exception e) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		Connector.doUpdate("INSERT INTO Candidate VALUES (" + candidate.getId()
				+ "," + candidate.getCaseName() + "," + candidate.getStatus()
				+ "');");
	}

	@Override
	public CandidateDTO findCaseCandidate(int id) throws DALException,
			SQLException {

		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		ResultSet rs = Connector.doQuery("SELECT * FROM Candidate WHERE id = "
				+ id + ";");
		Connector.closeConnection();

		if (!rs.first()) {
			throw new DALException("the candidate with the id = " + id
					+ " does not exist");
		}

		return new CandidateDTO(rs.getInt("id"), rs.getString("caseName"),
				rs.getString("status"));
	}

	@Override
	public List<CandidateDTO> findCaseCandidates(String caseName)
			throws DALException, SQLException {

		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}

		List<CandidateDTO> list = new ArrayList<CandidateDTO>();
		ResultSet rs = Connector
				.doQuery("SELECT * FROM Candidate WHERE caseName = " + caseName);
		Connector.closeConnection();

		if (!rs.first()) {
			throw new DALException("the case" + caseName
					+ " does not have any candidate");
		}
		while (rs.next()) {
			list.add(new CandidateDTO(rs.getInt("id"),
					rs.getString("caseName"), rs.getString("status")));
		}
		return list;
	}

	@Override
	public CaseDTO findCase(String caseName) throws DALException, SQLException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		ResultSet rs = Connector.doQuery("SELECT * FROM Case WHERE CaseName = "
				+ caseName + ";");
		Connector.closeConnection();

		if (!rs.first()) {
			throw new DALException("the case with the name = " + caseName
					+ " does not exist");
		}

		return new CaseDTO(rs.getString("caseName"),
				rs.getString("CompanyName"), rs.getInt("id"),
				rs.getInt("PartnerId"));
	}

	@Override
	public void updateCase(CaseDTO Case) throws DALException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		Connector.doUpdate("UPDATE Case " + "SET" + " CaseName = '"
				+ Case.getCaseName() + "', CompanyName = '"
				+ Case.getCompanyName() + "', Id = '" + Case.getId()
				+ "', PartnerId = '" + Case.getPartnerId() + ";");
		Connector.closeConnection();

	}

	@Override
	public void createCase(CaseDTO Case) throws DALException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		Connector.doUpdate("UPDATE Case " + "SET" + " caseName = '"
				+ Case.getCaseName() + "', CompanyName = '"
				+ Case.getCompanyName() + "', id = '" + Case.getId()
				+ "', partnerId = '" + Case.getPartnerId() + ";");
		Connector.closeConnection();

	}

	@Override
	public List<ResearcherDTO> findResearchersOnCase(CaseDTO Case)
			throws DALException, SQLException {

		List<ResearcherDTO> list = new ArrayList<ResearcherDTO>();

		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		ResultSet rs = Connector
				.doQuery("SELECT Researcherid, Name, Password FROM Case NATURAL JOIN Researcher WHERE CaseName = "
						+ Case.getCaseName() + ";");
		Connector.closeConnection();

		if (!rs.first()) {
			throw new DALException(
					"There is currently no researchers on the case with this name: "
							+ Case.getCaseName());
		}

		while (rs.next()) {
			if (rs.getString("job").equals("PARTNER")) {
				job = EmployeeDTO.JOB.PARTNER;
			} else {
				job = EmployeeDTO.JOB.RESEARCHER;
			}
			list.add(new ResearcherDTO(rs.getInt("researcherId"), rs
					.getString("name"), rs.getString("password"), job));
		}
		return list;
	}

	@Override
	public void createContact(ContactPersonDTO contact) throws DALException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		Connector.doUpdate("INSERT INTO Contact VALUES ("
				+ contact.getCaseName() + "," + contact.getName() + ","
				+ contact.getEmail() + "," + contact.getContactPhone() + ","
				+ contact.getContactCell() + "," + "');");
		Connector.closeConnection();

	}

	@Override
	public void updateContact(ContactPersonDTO contact) throws DALException {
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
				+ contact.getContactPhone() + "', CEO = '"
				+ contact.getContactCell() + ";");
		Connector.closeConnection();

	}

	@Override
	public ContactPersonDTO findContact(int contactId, String caseName)
			throws DALException, SQLException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		ResultSet rs = Connector
				.doQuery("SELECT * FROM Contact WHERE contactId = " + contactId
						+ ";");
		Connector.closeConnection();

		if (!rs.first()) {
			throw new DALException("the contactperson with the id = "
					+ contactId + " does not exist");
		}

		return new ContactPersonDTO(rs.getString("caseName"),
				rs.getString("name"), rs.getString("email"),
				rs.getString("contactPhone"), rs.getString("contactcell"),
				rs.getInt("contactId"), rs.getString("CompanyName"));
	}

	@Override
	public List<ContactPersonDTO> findContacts(String caseName)
			throws DALException, SQLException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}

		List<ContactPersonDTO> list = new ArrayList<ContactPersonDTO>();
		ResultSet rs = Connector
				.doQuery("SELECT * FROM Contactperson WHERE Casename = "
						+ caseName);
		Connector.closeConnection();
		if (!rs.next()) {
			throw new DALException("Der er ikke nogen kontaktperson på sagen:"
					+ caseName);
		}
		while (rs.next()) {
			list.add(new ContactPersonDTO(rs.getString("caseName"), rs
					.getString("name"), rs.getString("email"), rs
					.getString("contactPhone"), rs.getString("contactcell"), rs
					.getInt("contactId"), rs.getString("companyName")));
		}
		return list;
	}

	@Override
	public boolean loginExists(String[] loginInfo) throws DALException,
			SQLException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}

		EmployeeDTO tempEmployee = findEmployee(Integer.parseInt(loginInfo[0]));
		if (tempEmployee.getPassword().equals(loginInfo[1])) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<PersonPjLaDTO> findPersonPjLa(int id) throws DALException,
			SQLException {
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

	@Override
	public void createPersonPjLa(PersonPjLaDTO personpjlaDTO)
			throws DALException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		Connector.doUpdate("INSERT INTO PersonPjLa VALUES ("
				+ personpjlaDTO.getId() + "," + personpjlaDTO.getLanguage()
				+ "," + personpjlaDTO.getPreviousJobs() + "');");
		Connector.closeConnection();

	}
}
