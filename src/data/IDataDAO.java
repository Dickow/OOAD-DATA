package data;

import java.util.List;

import domain.BranchDTO;
import domain.CandidateDTO;
import domain.CaseDTO;
import domain.CompanyDTO;
import domain.ContactPersonDTO;
import domain.EmployeeDTO;
import domain.PersonDTO;

public interface IDataDAO {

	public void createCompany(CompanyDTO company) throws DALException;

	public void updateCompany(CompanyDTO company) throws DALException;

	public CompanyDTO findCompany(String companyName) throws DALException;

	public List<CompanyDTO> findCompanies(BranchDTO branch) throws DALException;

	public PersonDTO findPerson(int id) throws DALException;

	public List<PersonDTO> findPersons(String name) throws DALException;

	public List<PersonDTO> findPersons(PersonDTO person) throws DALException;

	public void updatePerson(PersonDTO person) throws DALException;

	public void createPerson(PersonDTO person) throws DALException;

	public void updateEmployee(EmployeeDTO employee) throws DALException;

	public void createEmployee(EmployeeDTO employee) throws DALException;

	public EmployeeDTO findEmployee(int EmployeeId) throws DALException;

	public List<EmployeeDTO> findEmployees(String name) throws DALException;

	public void createCandidate(CandidateDTO candidate) throws DALException;

	public List<CandidateDTO> findCandidates(int id) throws DALException;

	public List<CandidateDTO> findCaseCandidates(String caseName)
			throws DALException;

	public CaseDTO findCase(String caseName) throws DALException;

	public void updateCase(CaseDTO Case) throws DALException;

	public void createCase(CaseDTO Case) throws DALException;

	public void createContact(ContactPersonDTO contact) throws DALException;

	public void updateContact(ContactPersonDTO contact) throws DALException;

	public ContactPersonDTO findContact(int contactId, String caseName)
			throws DALException;

	public List<ContactPersonDTO> findContacts(String caseName)
			throws DALException;

	public boolean loginExists(String[] loginInfo) throws DALException;

}
