package test;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import data.DALException;
import data.DataDAO;
import domain.CandidateDTO;
import domain.CaseDTO;
import domain.CompanyDTO;
import domain.PersonDTO;

public class DataDAOTest extends DataDAO {

	// objects needed for the testing
	private static PersonDTO person1;

	private PersonDTO person2;
	private CompanyDTO company1;

	private CompanyDTO company2;
	private CaseDTO case1;

	private CaseDTO case2;
	private DataDAO dataTest;
	private CandidateDTO candidate1;

	private CandidateDTO candidate2;

	@Before
	public void setUp() throws Exception {
		person1 = new PersonDTO("Lars", "borPåEnVej 14", "DTU", "Ingeniør",
				"75847293", "company@Mail.com", "private@mail.com", "75683984",
				"en ligegyldig note", 40, new Date(13, 9, 1989), 23400);
		person2 = new PersonDTO("Peter", "PetersVej 29", "CBS", "Sælger",
				"75847283", "company@mail.com", "private@mail.com", "86980292",
				"En meget værdifuld note", 50, new Date(20, 11, 1983), 85000);
		company1 = new CompanyDTO("Frelsens", "Bager", "frelsensGade 109",
				"86758492", "Line Madsen", "Lotte mogensen");
		company2 = new CompanyDTO("Lydolph", "Bager", "Nakskovvej 48",
				"87968592", "Jørgen", "Maren");
		case1 = new CaseDTO("Frelsen sagen", "Frelsens", 3);
		case2 = new CaseDTO("Lydolph sagen", "Lydolph", 4);
		candidate1 = new CandidateDTO(40, "Frelsen sagen", "Potential prospect");
		candidate2 = new CandidateDTO(50, "Lydolph sagen", "Potential prospect");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void createPersonTest() throws DALException, SQLException {
		dataTest = new DataDAO();

		// first add the persons to the database
		dataTest.createPerson(person1);
		dataTest.createPerson(person2);
		// then test whether they were inserted correctly, if they were they
		// should match the ones put into the database when extracted again

		Assert.assertEquals(person1.getPersonId(),
				dataTest.findPerson(person1.getPersonId()).getPersonId());
		Assert.assertEquals(person2.getPersonId(),
				dataTest.findPerson(person2.getPersonId()).getPersonId());

		// try changing the name of person1 and try to update him in the
		// database.
		person1.setName("Kasper");

		dataTest.updatePerson(person1);

		// see if the update has happened in the database.

		Assert.assertEquals(person1.getName(),
				dataTest.findPerson(person1.getPersonId()).getName());

	}

	@Test
	public void createCompanyTest() throws DALException, SQLException {
		dataTest = new DataDAO();

		// first add the the companies to the database
		dataTest.createCompany(company1);
		dataTest.createCompany(company2);

		// then test whether or not they are added correctly to the database by
		// extracting them again and test whether or not they are equal.

		Assert.assertEquals(company1.getCompanyName(),
				dataTest.findCompany(company1.getCompanyName())
						.getCompanyName());
		Assert.assertEquals(company2.getCompanyName(),
				dataTest.findCompany(company2.getCompanyName())
						.getCompanyName());

	}

	@Test
	public void createCaseTest() throws DALException, SQLException {
		dataTest = new DataDAO();

		// first try and add the new case, it can only be added if the earlier
		// companies were added correctly.
		dataTest.createCase(case1);
		dataTest.createCase(case2);

		// now check whether or not they were added correctly by extracting them
		// again.

		Assert.assertEquals(case1.getCaseName(),
				dataTest.findCase(case1.getCaseName()).getCaseName());
		Assert.assertEquals(case2.getCaseName(),
				dataTest.findCase(case2.getCaseName()).getCaseName());

		// Try adding candidates to one of the created cases

		dataTest.createCandidate(candidate1);
		dataTest.createCandidate(candidate2);

		// See if they were added to the cases.

		Assert.assertEquals(candidate1.getCandidateId(), dataTest
				.findCaseCandidate(candidate1.getCandidateId())
				.getCandidateId());
		Assert.assertEquals(candidate2.getCandidateId(), dataTest
				.findCaseCandidate(candidate2.getCandidateId())
				.getCandidateId());
		try {
			this.tearDown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void tearDown() throws Exception {
		// remove all the candidates again
		dataTest.deleteCandidate(candidate1.getCandidateId(),
				candidate1.getCaseName());
		dataTest.deleteCandidate(candidate2.getCandidateId(),
				candidate2.getCaseName());
		// remove all the cases again
		dataTest.deleteCase(case1);
		dataTest.deleteCase(case2);
		// remove all the companies again
		dataTest.deleteCompany(company1.getCompanyName());
		dataTest.deleteCompany(company2.getCompanyName());
		// remove all the persons again
		dataTest.deletePerson(person1.getPersonId());
		dataTest.deletePerson(person2.getPersonId());

	}

}
