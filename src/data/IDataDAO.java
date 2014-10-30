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
	
	public void createCompany(CompanyDTO company);
	public void updateCompany(CompanyDTO company); 
	public CompanyDTO findCompany(String companyName);
	public List<CompanyDTO> findCompanies(BranchDTO branch); 
	public PersonDTO findPerson(int id); 
	public List<PersonDTO> findPersons(String name);
	public List<PersonDTO> findPersons(PersonDTO person);
	public void updatePerson(PersonDTO person);
	public void createPerson(PersonDTO person); 
	public void updateEmployee(EmployeeDTO employee); 
	public void createEmployee(EmployeeDTO employee); 
	public EmployeeDTO findEmployee(int EmployeeId);
	public List<EmployeeDTO> findEmployees(String name); 
	public void createCandidate(CandidateDTO candidate); 
	public List<CandidateDTO> findCandidates(int id); 
	public List<CandidateDTO> findCaseCandidates(String caseName); 
	public CaseDTO findCase(String caseName); 
	public void updateCase(CaseDTO Case); 
	public void createCase(CaseDTO Case); 
	public void createContact(ContactPersonDTO contact); 
	public void updateContact(ContactPersonDTO contact);
	public ContactPersonDTO findContact(int contactId, String caseName); 
	public List<ContactPersonDTO> findContacts(String caseName);
	public boolean loginExists(String[] loginInfo);
	

}
