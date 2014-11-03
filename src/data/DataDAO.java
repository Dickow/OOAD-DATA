package data;

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
				+ CompanyDTO.getCompanyName() + ","
				+ CompanyDTO.getBranchCode() + ","
				+ CompanyDTO.getCompanyAddress() + ","
				+ CompanyDTO.getCompanyPhone() + "," + CompanyDTO.getCEO()
				+ "," + CompanyDTO.getCFO() + "');");
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
				+ CompanyDTO.getCompanyName() + "', BanchCode = '"
				+ CompanyDTO.getBranchCode() + "', CompanyAdress = '"
				+ CompanyDTO.getCompanyAddress() + "', CompanyTlf = '"
				+ CompanyDTO.getCompanyPhone() + "', CEO = '"
				+ CompanyDTO.getCEO() + "', CFO = '" + CompanyDTO.getCFO()
				+ "' WHERE companyName = " + CompanyDTO.getCompanyName() + ";");
		Connector.closeConnection();
	}

	@Override
	public CompanyDTO findCompany(String companyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyDTO> findCompanies(BranchDTO branch) {

		return null;
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
