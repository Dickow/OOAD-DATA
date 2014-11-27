package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.CandidateDTO;
import domain.CaseDTO;
import domain.CompanyDTO;
import domain.PartnerDTO;
import domain.EmployeeDTO.JOB;
import domain.PersonDTO;
import domain.ResearcherDTO;

public class DataDAO implements IDataDAO {

	private JOB job;

	// Ændring af Company TODO

	@Override
	public void createCompany(CompanyDTO company) throws DALException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		Connector.doUpdate("INSERT INTO Company VALUES ('"
				+ company.getCompanyName() + "','" + company.getMainCode()
				+ "','" + company.getCompanyAddress() + "','"
				+ company.getCompanyPhone() + "','" + company.getCEO() + "','"
				+ company.getCFO() + "');");
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
				.doQuery("SELECT * FROM company WHERE companyName = '"
						+ companyName + "';");
		Connector.closeConnection();

		try {
			if (!rs.first()) {
				throw new DALException("firmaet med firma navn = "
						+ companyName + " eksisterer ikke");
			}
			return new CompanyDTO(rs.getString("companyName"),
					rs.getString("mainCode"), rs.getString("companyAddress"),
					rs.getString("companyPhone"), rs.getString("CEO"),
					rs.getString("CFO"));
		} catch (SQLException e) {
			throw new DALException(
					"Der skete en fejl i Commodity i metoden getCommodity()"
							+ e.getMessage());
		}
	}

	public void deleteCompany(String compName) throws DALException {
		try {
			Connector.connect();
		} catch (Exception e) {
			throw new DALException(
					"Der kunne ikke oprettes forbindekse til databasen");
		}

		Connector.doUpdate("DELETE from Company WHERE companyName ='"
				+ compName + "';");
		Connector.closeConnection();
	}

	// Ændring af person TODO

	public PersonDTO getLastPerson() throws DALException, SQLException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		ResultSet rs = Connector
				.doQuery("SELECT * FROM person ORDER BY personId DESC LIMIT 1;");
		Connector.closeConnection();

		if (!rs.first()) {
			throw new DALException("There is no persons in the database");
		}
		System.out.println("jeg n�r ned til lige inden retur");
		return new PersonDTO(rs.getString("name"), rs.getString("address"),
				rs.getString("education"), rs.getString("currentJob"),
				rs.getString("personPhone"), rs.getString("companyMail"),
				rs.getString("privateMail"), rs.getString("personCell"),
				rs.getString("note"), rs.getInt("personId"),
				rs.getDate("birthYear"), rs.getInt("salary"));
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
				rs.getString("note"), rs.getInt("personId"),
				rs.getDate("birthYear"), rs.getInt("salary"));
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
		ResultSet rs = Connector.doQuery("SELECT * FROM person WHERE name = '"
				+ name + "';");
		Connector.closeConnection();

		while (rs.next()) {
			list.add(new PersonDTO(rs.getString("name"), rs
					.getString("address"), rs.getString("education"), rs
					.getString("currentJob"), rs.getString("companyMail"), rs
					.getString("privateMail"), rs.getString("personCell"), rs
					.getString("personPhone"), rs.getString("note"), rs
					.getInt("personId"), rs.getDate("birthYear"), rs
					.getInt("salary")));
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
		Connector.doUpdate("UPDATE Person " + "SET" + " personId = "
				+ person.getPersonId() + ", name = '" + person.getName()
				+ "', address = '" + person.getAddress() + "', education = '"
				+ person.getEducation() + "', currentJob = '"
				+ person.getCurrentJob() + "', personPhone = '"
				+ person.getPersonPhone() + "', companyMail = '"
				+ person.getCompanyMail() + "', privateMail = '"
				+ person.getPrivateMail() + "', personCell = '"
				+ person.getPersonCell() + "', note = '" + person.getNote()
				+ "', birthYear = '" + person.getBirthYear() + "', salary = "
				+ person.getSalary() + " WHERE personId = "
				+ person.getPersonId() + ";");
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
		Connector.doUpdate("INSERT INTO person VALUES (" + person.getPersonId()
				+ ",'" + person.getName() + "','" + person.getAddress() + "','"
				+ person.getEducation() + "','" + person.getCurrentJob()
				+ "','" + person.getPersonPhone() + "','"
				+ person.getCompanyMail() + "','" + person.getPrivateMail()
				+ "','" + person.getPersonCell() + "','" + person.getNote()
				+ "','" + person.getBirthYear() + "'," + person.getSalary()
				+ ");");
		Connector.closeConnection();

	}

	public ResearcherDTO findResearcher(int researcherId) throws DALException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		ResultSet rs = Connector
				.doQuery("SELECT * FROM Researcher WHERE researcherId = "
						+ researcherId + ";");
		Connector.closeConnection();

		try {
			if (!rs.first()) {
				throw new DALException("the employee with the id = "
						+ researcherId + " does not exist");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		job = ResearcherDTO.JOB.RESEARCHER;
		try {
			return new ResearcherDTO(rs.getInt("researcherId"),
					rs.getString("name"), rs.getString("password"), job);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// wont ever reach this code
		return null;
	}

	public PartnerDTO findPartner(int partnerId) throws DALException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		ResultSet rs = Connector
				.doQuery("SELECT * FROM partner WHERE partnerId = " + partnerId
						+ ";");
		Connector.closeConnection();

		try {
			if (!rs.first()) {
				throw new DALException("the partner with the id = " + partnerId
						+ " does not exist");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		job = PartnerDTO.JOB.PARTNER;
		try {
			int ID = rs.getInt("partnerId");
			String name = rs.getString("name");
			String password = rs.getString("password");

			return new PartnerDTO(ID, name, password, job);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// wont ever reach this code
		return null;
	}

	public int PartnerOrResearcher(int employeeId, String password)
			throws DALException, SQLException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		ResultSet rs = Connector
				.doQuery("SELECT * FROM Partner WHERE partnerId = "
						+ employeeId + " AND password = '" + password + "';");
		Connector.closeConnection();

		if (!rs.first()) {
			rs = Connector
					.doQuery("SELECT * FROM researcher WHERE researcherId = "
							+ employeeId + " AND password = '" + password
							+ "' ;");
			Connector.closeConnection();
			if (!rs.first()) {
				return 1;
				// Vi har intet
			}
			return 3;
			// Vi har en Researcher
		}

		return 2;
		// Vi får en researcher
	}

	// Ændring af Candidate TODO
	@Override
	public void createCandidate(CandidateDTO candidate) throws DALException {
		try {
			Connector.connect();
		} catch (Exception e) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		Connector.doUpdate("INSERT INTO candidate VALUES ("
				+ candidate.getCandidateId() + ",'" + candidate.getCaseName()
				+ "','" + candidate.getStatus() + "');");
		Connector.closeConnection();
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
		ResultSet rs = Connector
				.doQuery("SELECT * FROM Candidate WHERE personId = " + id + ";");
		Connector.closeConnection();

		if (!rs.first()) {
			throw new DALException("the candidate with the id = " + id
					+ " does not exist");
		}

		return new CandidateDTO(rs.getInt("personId"),
				rs.getString("caseName"), rs.getString("status"));
	}

	@Override
	public List<CandidateDTO> findCaseCandidates(String caseName)
			throws DALException, SQLException {
		System.out.println(caseName);
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}

		List<CandidateDTO> list = new ArrayList<CandidateDTO>();
		ResultSet rs = Connector
				.doQuery("SELECT * FROM candidate WHERE caseName = '"
						+ caseName + "';");
		Connector.closeConnection();

		while (rs.next()) {
			list.add(new CandidateDTO(rs.getInt("personId"), rs
					.getString("caseName"), rs.getString("status")));
		}
		return list;
	}

	public void changeCandidateStatus(CandidateDTO candi, String status)
			throws DALException {
		try {
			Connector.connect();
		} catch (Exception e) {
			throw new DALException("Kan ikke oprette forbindelse til databasen");
		}
		Connector.doUpdate("UPDATE candidate SET status ='" + status
				+ "' WHERE personId =" + candi.getCandidateId() + ";");
		Connector.closeConnection();
	}

	// Ændring af Case TODO

	@Override
	public CaseDTO findCase(String caseName) throws DALException, SQLException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		ResultSet rs = Connector
				.doQuery("SELECT * FROM cases WHERE CaseName = '" + caseName
						+ "';");
		Connector.closeConnection();

		if (!rs.first()) {
			throw new DALException("the case with the name = " + caseName
					+ " does not exist");
		}

		return new CaseDTO(rs.getString("caseName"),
				rs.getString("companyName"), rs.getInt("partnerId"));
	}

	@Override
	public void createCase(CaseDTO name) throws DALException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		Connector.doUpdate("INSERT INTO cases VALUES ('" + name.getCaseName()
				+ "','" + name.getCompanyName() + "', " + name.getPartnerId()
				+ " );");
		Connector.closeConnection();

	}

	// Ændring af Researcher TODO

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
			Connector.doUpdate("INSERT INTO researcheroncase VALUES(" + rID
					+ ",'" + caseName + "');");
		} catch (Exception e) {
			throw new DALException(
					"Kunne ikke oprettes en ResearcherOnCase, da den allerede eksisterer");
		}

		Connector.closeConnection();
	}

	public List<ResearcherDTO> getAllresearcherOnCases(String caseName)
			throws DALException, SQLException {
		ArrayList<ResearcherDTO> list = new ArrayList<ResearcherDTO>();
		try {
			Connector.connect();
		} catch (Exception e) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}

		ResultSet rs = Connector
				.doQuery("SELECT * FROM ResearcherOnCase NATURAL JOIN researcher WHERE caseName = '"
						+ caseName + "';");
		Connector.closeConnection();
		while (rs.next()) {
			list.add(new ResearcherDTO(rs.getInt("researcherId"), rs
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

		Connector.doUpdate("DELETE from researcherOnCase WHERE researcherId ="
				+ researcher.getEmployeeId() + " AND caseName ='"
				+ theCase.getCaseName() + "';");

	}

	public List<ResearcherDTO> getAllresearcherNotOnCases(String caseName)
			throws DALException, SQLException {
		ArrayList<ResearcherDTO> list = new ArrayList<ResearcherDTO>();
		try {
			Connector.connect();
		} catch (Exception e) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}

		ResultSet rs = Connector
				.doQuery("SELECT * FROM researcher WHERE researcherId "
						+ "NOT IN (SELECT researcherId FROM researcheroncase "
						+ "WHERE caseName = '" + caseName + "');");
		Connector.closeConnection();
		while (rs.next()) {
			list.add(new ResearcherDTO(rs.getInt("researcherId"), rs
					.getString("name"), rs.getString("password"),
					JOB.RESEARCHER));
		}

		return list;

	}

	// Login check TODO
	@Override
	public boolean loginExists(String[] loginInfo) throws DALException,
			SQLException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}

		switch (PartnerOrResearcher(Integer.parseInt(loginInfo[0]),
				loginInfo[1])) {

		case 1:
			throw new DALException("Der findes ikke en ansat med indtastede ID");

		case 2:
			PartnerDTO tempEmployee = findPartner(Integer
					.parseInt(loginInfo[0]));
			if (tempEmployee.getPassword().equals(loginInfo[1])) {
				return true;
			}

		case 3:
			ResearcherDTO tempResearcher = findResearcher(Integer
					.parseInt(loginInfo[0]));
			if (tempResearcher.getPassword().equals(loginInfo[1])) {
				return true;

			}
		}
		return false;

	}

	public boolean worksOnCase(int employeeId, String caseName, int jobPos)
			throws DALException {
		try {
			Connector.connect();
		} catch (Exception e1) {
			throw new DALException(
					"Der kunne ikke oprettes forbindelse til databasen");
		}
		if (jobPos == 1) {
			// Find
			ResultSet rs = Connector
					.doQuery("SELECT * FROM partner NATURAL JOIN cases WHERE partnerId = "
							+ employeeId
							+ " AND caseName = '"
							+ caseName
							+ "';");
			try {
				if (!rs.first()) {
					return false;
				}
			} catch (SQLException e1) {
				return false;
			}
		}
		if (jobPos == 2) {
			ResultSet rs1 = Connector
					.doQuery("SELECT * FROM researcheroncase NATURAL JOIN cases WHERE researcherId = "
							+ employeeId
							+ " AND caseName = '"
							+ caseName
							+ "'; ");
			try {

				if (!rs1.first()) {
					return false;
				}
			} catch (SQLException e) {
				return false;
			}
		}
		return true;
	}
}
