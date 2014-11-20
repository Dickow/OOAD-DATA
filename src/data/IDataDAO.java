package data;

import java.sql.SQLException;
import java.util.List;

import domain.BranchDTO;
import domain.CandidateDTO;
import domain.CaseDTO;
import domain.CompanyDTO;
import domain.ContactPersonDTO;
import domain.EmployeeDTO;
import domain.PersonDTO;
import domain.PersonPjLaDTO;
import domain.ResearcherDTO;

public interface IDataDAO {

	// PersonPjLa

	public List<PersonPjLaDTO> findPersonPjLa(int id) throws DALException,
			SQLException;

	public void createPersonPjLa(PersonPjLaDTO personpjlaDTO)
			throws DALException;

	// Company

	public void createCompany(CompanyDTO company) throws DALException;

	public void updateCompany(CompanyDTO company) throws DALException;

	public CompanyDTO findCompany(String companyName) throws DALException;

	public List<CompanyDTO> findCompanies(BranchDTO branch) throws DALException;

	// Person

	public PersonDTO findPerson(int id) throws DALException, SQLException;

	public PersonDTO getLastPerson() throws DALException, SQLException;

	public List<PersonDTO> findPersons(String name) throws DALException,
			SQLException;

	public void updatePerson(PersonDTO person) throws DALException;

	public void createPerson(PersonDTO person) throws DALException;

	// Employee

	public void updateEmployee(EmployeeDTO employee) throws DALException;

	public void createEmployee(EmployeeDTO employee) throws DALException;

	public EmployeeDTO findEmployee(int EmployeeId) throws DALException;

	public List<EmployeeDTO> findEmployees(String name) throws DALException,
			SQLException;

	// Candidate

	public void createCandidate(CandidateDTO candidate) throws DALException;

	public CandidateDTO findCaseCandidate(int id) throws DALException,
			SQLException;

	public List<CandidateDTO> findCaseCandidates(String caseName)
			throws DALException, SQLException;

	// Case

	public CaseDTO findCase(String caseName) throws DALException, SQLException;

	public void updateCase(CaseDTO Case) throws DALException;

	void createCase(String caseName, String firmaNavn, int kandidatId,
			int PartnerId) throws DALException;

	public List<ResearcherDTO> findResearchersOnCase(CaseDTO Case)
			throws DALException, SQLException;

	// Contact

	public void createContact(ContactPersonDTO contact) throws DALException;

	public void updateContact(ContactPersonDTO contact) throws DALException;

	public ContactPersonDTO findContact(int contactId, String caseName)
			throws DALException, SQLException;

	public List<ContactPersonDTO> findContacts(String caseName)
			throws DALException, SQLException;

	// login

	public boolean loginExists(String[] loginInfo) throws DALException,
			SQLException;

}
