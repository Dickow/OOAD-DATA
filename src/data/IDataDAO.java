package data;

import java.sql.SQLException;
import java.util.List;

import domain.CandidateDTO;
import domain.CaseDTO;
import domain.CompanyDTO;
import domain.PersonDTO;
import domain.ResearcherDTO;


interface IDataDAO {

	// PersonPjLa


	// Company

	public void createCompany(CompanyDTO company) throws DALException;

	public CompanyDTO findCompany(String companyName) throws DALException;

	// Person

	public PersonDTO findPerson(int id) throws DALException, SQLException;

	public PersonDTO getLastPerson() throws DALException, SQLException;

	public List<PersonDTO> findPersons(String name) throws DALException,
			SQLException;

	public void updatePerson(PersonDTO person) throws DALException;

	public void createPerson(PersonDTO person) throws DALException;

	// Candidate

	public void createCandidate(CandidateDTO candidate) throws DALException;

	public CandidateDTO findCaseCandidate(int id) throws DALException,
			SQLException;

	public List<CandidateDTO> findCaseCandidates(String caseName)
			throws DALException, SQLException;

	// Case

	public CaseDTO findCase(String caseName) throws DALException, SQLException;

	public void createCase(CaseDTO name) throws DALException;

	public List<ResearcherDTO> getAllresearcherOnCases(String caseName)
			throws DALException, SQLException;

	public List<ResearcherDTO> getAllresearcherNotOnCases(String caseName)
			throws DALException, SQLException;

	public void addResearcherToCase(int rID, String caseName) throws DALException;


	// login

	public boolean loginExists(String[] loginInfo) throws DALException,
			SQLException;
}
