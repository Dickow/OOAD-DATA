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

public interface IDataDAO {
	
	// PersonPjLa
	
	public List<PersonPjLaDTO> findPersonPreviousJobs(int id) throws DALException; 
	
	public List<PersonPjLaDTO> findPersonLanguage(int id) throws DALException;
	
	public void updatePersonPj(PersonPjLaDTO personPj) throws DALException;
	
	public void updatePersonLa(PersonPjLaDTO personLa) throws DALException;
	
	// Company

	public void createCompany(CompanyDTO company) throws DALException;

	public void updateCompany(CompanyDTO company) throws DALException;

	public CompanyDTO findCompany(String companyName) throws DALException;

	public List<CompanyDTO> findCompanies(BranchDTO branch) throws DALException;
	
	// Person

	public PersonDTO findPerson(int id) throws DALException, SQLException;

	public List<PersonDTO> findPersons(String name) throws DALException,
			SQLException;

	public List<PersonDTO> findPersons(PersonDTO person) throws DALException;

	public void updatePerson(PersonDTO person) throws DALException;

	public void createPerson(PersonDTO person) throws DALException;
	
	// Employee

	public void updateEmployee(EmployeeDTO employee) throws DALException;

	public void createEmployee(EmployeeDTO employee) throws DALException;

	public EmployeeDTO findEmployee(int EmployeeId) throws DALException;

	public List<EmployeeDTO> findEmployees(String name) throws DALException;
	
	// Candidate

	public void createCandidate(CandidateDTO candidate) throws DALException;

	public List<CandidateDTO> findCandidates(int id) throws DALException;

	public List<CandidateDTO> findCaseCandidates(String caseName)
			throws DALException;
	
	// Case

	public CaseDTO findCase(String caseName) throws DALException;

	public void updateCase(CaseDTO Case) throws DALException;

	public void createCase(CaseDTO Case) throws DALException;
	
	// Contact

	public void createContact(ContactPersonDTO contact) throws DALException;

	public void updateContact(ContactPersonDTO contact) throws DALException;

	public ContactPersonDTO findContact(int contactId, String caseName)
			throws DALException;

	public List<ContactPersonDTO> findContacts(String caseName)
			throws DALException;
	
	// login

	public boolean loginExists(String[] loginInfo) throws DALException;

}
