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
import domain.ResearcherOnCaseDTO;
import domain.EmployeeDTO.JOB;
import domain.PersonDTO;
import domain.PersonPjLaDTO;
import domain.ResearcherDTO;

public class DataDAO implements IDataDAO {

	private JOB job;

	// Ændring af Company

	@Override
	public void createCompany(CompanyDTO company) throws DALException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		Connector.doUpdate("INSERT INTO Company VALUES ("
				+ company.getCompanyName() + "," + company.getMainCode() + ","
				+ company.getCompanyAddress() + "," + company.getCompanyPhone()
				+ "," + company.getCEO() + "," + company.getCFO() + "');");
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
				+ company.getMainCode() + "', CompanyAdress = '"
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

	public void deleteCompany(String compName) throws DALException {
		try {
			Connector.connect();
		} catch (Exception e) {
			throw new DALException(
					"Der kunne ikke oprettes forbindekse til databasen");
		}

		Connector.doQuery("DELETE from Company WHERE companyName ='" + compName
				+ "';");
		Connector.closeConnection();
	}

	// Ændring af person

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
				rs.getString("note"), rs.getInt("id"), age, rs.getInt("salary"));
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
				rs.getString("note"), rs.getInt("id"), age, rs.getInt("salary"));
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
				+ person.getNote() + "', id = '" + person.getPersonId()
				+ "', age = '" + person.getBirthYear() + ", salary = "
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
				+ person.getPersonId() + "," + person.getBirthYear() + ","
				+ person.getSalary() + "');");
		Connector.closeConnection();

	}

	public void deletePerson(int id) throws DALException {
		try {
			Connector.connect();
		} catch (Exception e) {
			throw new DALException(
					"Der kunne ikke oprettes forbindekse til databasen");
		}

		Connector.doQuery("DELETE from person WHERE personId ='" + id + "';");
		Connector.closeConnection();
	}

	// Ændring af Employee

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

	public void deleteEmployee(String employeeName) throws DALException {
		try {
			Connector.connect();
		} catch (Exception e) {
			throw new DALException(
					"Der kunne ikke oprettes forbindekse til databasen");
		}

		Connector.doQuery("DELETE from Employee WHERE name ='" + employeeName
				+ "';");
		Connector.closeConnection();

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

	// Ændring af Candidate
	@Override
	public void createCandidate(CandidateDTO candidate) throws DALException {
		try {
			Connector.connect();
		} catch (Exception e) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		Connector.doUpdate("INSERT INTO Candidate VALUES ("
				+ candidate.getCandidateId() + "," + candidate.getCaseName()
				+ "," + candidate.getStatus() + "');");
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

	public void deleteCandidate(int id) throws DALException {
		try {
			Connector.connect();
		} catch (Exception e) {
			throw new DALException(
					"Der kunne ikke oprettes forbindekse til databasen");
		}

		Connector.doQuery("DELETE from Candidate WHERE canditateId ='" + id
				+ "';");
		Connector.closeConnection();
	}

	public void changeCandidateStatus(CandidateDTO candi, String status)
			throws DALException {
		try {
			Connector.connect();
		} catch (Exception e) {
			throw new DALException("Kan ikke oprette forbindelse til databasen");
		}
		Connector.doQuery("Update Candidate set status ='" + status
				+ "' WHERE candidateId ='" + candi.getCandidateId() + "';");
		Connector.closeConnection();
	}

	// Ændring af Case

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
				+ Case.getCompanyName() + "', Id = '" + Case.getPartnerId()
				+ "', PartnerId = '" + Case.getPartnerId() + ";");
		Connector.closeConnection();

	}

	@Override
	public void createCase(CaseDTO name) throws DALException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		Connector
				.doUpdate("Insert into Case VALUES " + name.getCaseName() + ","
						+ name.getCompanyName() + "," + name.getPartnerId()
						+ ";");
		Connector.closeConnection();

	}

	public void deleteCase(String caseName) throws DALException {
		try {
			Connector.connect();
		} catch (Exception e) {
			throw new DALException(
					"Der kunne ikke oprettes forbindekse til databasen");
		}

		Connector.doQuery("DELETE from Case WHERE caseName ='" + caseName
				+ "';");
		Connector.closeConnection();
	}

	// Ændring af Researcher

	@Override
	public void addResearcherToCase(int rID, String caseName)
			throws DALException {
		try {
			Connector.connect();
		} catch (Exception e) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		try {
			Connector.doQuery("INSERT INTO ResearcherOnCase VALUES" + rID + ","
					+ caseName + ");");
		} catch (Exception e) {
			throw new DALException(
					"Kunne ikke oprettes en ResearcherOnCase, da den allerede eksistere");
		}

		Connector.closeConnection();
	}

	public List<ResearcherDTO> getAllresearcherOnCases(String caseName) // TODO
			throws DALException, SQLException {
		ArrayList<ResearcherDTO> list = new ArrayList<ResearcherDTO>();
		try {
			Connector.connect();
		} catch (Exception e) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}

		ResultSet rs = Connector
				.doQuery("SELECT researcherId FROM ResearchersOnCase WHERE caseName = '"
						+ caseName + "';");

		while (rs.next()) {
			list.add(new ResearcherDTO(rs.getInt("employeeId"), rs
					.getString("name"), rs.getString("password"),
					JOB.RESEARCHER));
		}

		return list;

	}

	public void removeResearcherCase(ResearcherDTO researcher, CaseDTO theCase)
			throws DALException {
		try {
			Connector.connect();
		} catch (Exception e) {
			throw new DALException(
					"Kunne ikke oprette forbindelse til databasen");
		}

		Connector.doQuery("DELETE from researcherOnCase WHERE id ='"
				+ researcher.getEmployeeId() + "' AND caseName ='"
				+ theCase.getCaseName() + "';");

	}

	public List<ResearcherDTO> getAllresearcherNotOnCases(String caseName) // TODO
			throws DALException, SQLException {
		ArrayList<ResearcherDTO> list = new ArrayList<ResearcherDTO>();
		try {
			Connector.connect();
		} catch (Exception e) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}

		ResultSet rs = Connector
				.doQuery("SELECT researcherId FROM ResearchersOnCase WHERE caseName NOT '"
						+ caseName + "';");

		while (rs.next()) {
			list.add(new ResearcherDTO(rs.getInt("employeeId"), rs
					.getString("name"), rs.getString("password"),
					JOB.RESEARCHER));
		}

		return list;

	}

	// Ændring af ContactPerson

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

	public void deleteContactPerson(int contactId) throws DALException {
		try {
			Connector.connect();
		} catch (Exception e) {
			throw new DALException(
					"Der kunne ikke oprettes forbindekse til databasen");
		}

		Connector.doQuery("DELETE from Contactperson WHERE contactId ='"
				+ contactId + "';");
		Connector.closeConnection();
	}

	// Login check
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

	// Ændring af PersonPjLa

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
				+ personpjlaDTO.getPersonId() + ","
				+ personpjlaDTO.getLanguage() + ","
				+ personpjlaDTO.getPreviousJobs() + "');");
		Connector.closeConnection();

	}
}
