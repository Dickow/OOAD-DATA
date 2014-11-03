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
	public PersonDTO findPerson(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonDTO> findPersons(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonDTO> findPersons(PersonDTO person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePerson(PersonDTO person) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createPerson(PersonDTO person) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateEmployee(EmployeeDTO employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createEmployee(EmployeeDTO employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public EmployeeDTO findEmployee(int EmployeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDTO> findEmployees(String name) {
		// TODO Auto-generated method stub
		return null;
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

}
