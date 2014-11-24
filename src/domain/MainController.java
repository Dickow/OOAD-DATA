package domain;

import gui.GUI;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import data.DALException;
import data.DataDAO;

public class MainController {
	private GUI gui = new GUI();
	private int jobPos;
	private ArrayList<PersonDTO> persons = new ArrayList<PersonDTO>();
	private ArrayList<CompanyDTO> companies = new ArrayList<CompanyDTO>();
	private ArrayList<CaseDTO> cases = new ArrayList<CaseDTO>();

	// Bad fix to make the code work Should be remade in future iterations
	private ArrayList<CaseDTO> singleCaseArray = new ArrayList<CaseDTO>();
	private ArrayList<String> researchers;
	private ArrayList<String> candidates;
	private ArrayList<ResearcherDTO> researchersOnCase = new ArrayList<ResearcherDTO>();
	private ArrayList<CandidateDTO> candidatesOnCase = new ArrayList<CandidateDTO>();
	private int employeeId;
	private DataDAO database = new DataDAO();
	private String curCase;
	private String curCompany;

	private static MainController mainController;

	// ######################################################################
	// Private constructor - Singleton
	// ######################################################################
	private MainController() {

	}

	// ######################################################################
	// Connect to single instance of class
	// ######################################################################
	public static MainController getInstance() {
		if (mainController != null) {
			return mainController;
		}
		return (mainController = new MainController());
	}

	public void login(String[] loginInfo) {
		loginInfo[0].trim();
		employeeId = new Integer(loginInfo[0]);

		try {
			database.loginExists(loginInfo);
		} catch (DALException e) {

			System.out.println(e.getMessage()); // TODO exception handling
		} catch (SQLException e) {
			System.out.println(e.getMessage()); // TODO exception handling
		}

		try {
			switch (database.PartnerOrResearcher(employeeId)) {

			case 1:
				break;
			case 2:
				this.jobPos = 1;
				break;
			case 3:
				this.jobPos = 2;
				break;
			}
		} catch (DALException e) {
			System.out.println(e.getMessage()); // TODO exception handling
		} catch (SQLException e) {
			System.out.println(e.getMessage()); // TODO exception handling
		}

		gui.menu(jobPos);

	}

	public void menuDistributor(int menuChoice) {
		switch (menuChoice) {
		case 0:
			gui.findPersonMenu(persons);
			break;
		case 1:
			gui.createPersonMenu();
			break;
		case 2:
			gui.findCaseMenu(cases);
			break;
		case 3:
			gui.createCaseMenu();
			break;
		case 4:
			gui.findCompanyMenu(companies);
			break;
		case 5:
			gui.createCompanyMenu();
			break;
		case 6:
			gui.login();
			break;
		}

	}

	/*
	 * ##########################################################################
	 * Create methods
	 */
	public void createPerson(PersonDTO person, String date, String salary) {

		// look in the database for the last id and create the person with that
		// id + 1
		try {
			int tmpId = database.getLastPerson().getPersonId() + 1;
			System.out.println(tmpId);
			person.setId(tmpId);
		} catch (DALException e) {
			System.out.println(e.getMessage()); // TODO exception handling
		} catch (SQLException e) {
			System.out.println(e.getMessage()); // TODO exception handling
		}
		int day = new Integer(date.substring(0, 2));
		int month = new Integer(date.substring(3, 5));
		int year = new Integer(date.substring(6));
		@SuppressWarnings("deprecation")
		Date yearOfBirth = new Date(day, month, year);

		int salary1 = new Integer(salary);

		// put the integer casted values into the object
		person.setBirthYear(yearOfBirth);
		person.setSalary(salary1);
		System.out.println("jeg når ned til lige inden create");
		// create the person in the database
		try {
			database.createPerson(person);
		} catch (DALException e) {
			System.out.println(e.getMessage()); // TODO exception handling
		}
	}

	public void createCompany(CompanyDTO company) {
		// send the company to the database layer
		System.out.println("created the " + company.getCompanyName());
		try {
			database.createCompany(company);
		} catch (DALException e) {
			System.out.println(e.getMessage()); // TODO exception handling
		}
	}

	public void createCase(CaseDTO casetmp, String researchers,
			String candidates) {

		// set the saved id from the person, because the id can not be edited by
		// anyone
		casetmp.setPartnerId(employeeId);

		// split the arrays by ,
		this.researchers = new ArrayList<String>(Arrays.asList(researchers
				.split(",")));
		this.candidates = new ArrayList<String>(Arrays.asList(candidates
				.split(",")));

		try {
			database.createCase(casetmp);
		} catch (DALException e) {
			System.out.println(e.getMessage()); // TODO exception handling
		}

		System.out.println(casetmp.getCaseName());
		// Bad code, but lacks a better method in the database access layer
		for (int i = 0; i < this.researchers.size(); i++) {
			try {
				database.addResearcherToCase(
						new Integer(this.researchers.get(i)),
						casetmp.getCaseName());
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage()); // TODO exception handling
			} catch (DALException e) {
				System.out.println(e.getMessage()); // TODO exception handling
			}
		}

		// bad code, but without the method in the database layer this is the
		// easiest way of doing it
		for (int i = 0; i < this.candidates.size(); i++) {
			try {
				database.createCandidate(new CandidateDTO(new Integer(
						this.candidates.get(i)), casetmp.getCaseName(),
						"Potential prospect"));
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage()); // TODO exception handling
			} catch (DALException e) {
				System.out.println(e.getMessage()); // TODO exception handling
			}
		}
	}

	/*
	 * ########################################################################
	 * Edit methods
	 */
	public void editChosenPerson(String chosenPerson) {
		String[] tmpStrings = chosenPerson.split(",");
		int id = new Integer(tmpStrings[0].substring(4));
		PersonDTO person;
		try {
			person = database.findPerson(id);
			gui.editPersonMenu(person);
		} catch (DALException e) {
			System.out.println(e.getMessage()); // TODO exception handling
		} catch (SQLException e) {
			System.out.println(e.getMessage()); // TODO exception handling
		}

	}

	public void editChosenCompany(String chosenCompany) {
		String[] tmpStrings = chosenCompany.split(",");
		curCompany = tmpStrings[0].substring(12);

		try {
			gui.editCompanyMenu(database.findCompany(curCompany));
		} catch (DALException e) {
			System.out.println(e.getMessage()); // TODO exception handling
		}
	}

	public void editChosenCase(String chosenCase) {
		String[] tmpStrings = chosenCase.split(",");
		curCase = tmpStrings[0].substring(11);
		// first get all the researchers on a given case and all the researchers
		// not on that given case
		try {
			gui.editCaseMenu(
					new ArrayList<ResearcherDTO>(database
							.getAllresearcherOnCases(curCase)),
					new ArrayList<ResearcherDTO>(database
							.getAllresearcherNotOnCases(curCase)));
		} catch (DALException e) {
			System.out.println(e.getMessage()); // TODO
		} catch (SQLException e) {
			System.out.println(e.getMessage()); // TODO
		}
	}

	public void editChosenCaseForController(String curCase) {
		try {
			gui.editCaseMenu(
					new ArrayList<ResearcherDTO>(database
							.getAllresearcherOnCases(curCase)),
					new ArrayList<ResearcherDTO>(database
							.getAllresearcherNotOnCases(curCase)));
		} catch (DALException e) {
			System.out.println(e.getMessage()); // TODO exception handling
		} catch (SQLException e) {
			System.out.println(e.getMessage()); // TODO exception handling
		}
	}

	/*
	 * ######################################################################
	 * Edit methods that update the data in the database.
	 */

	public void editPersonInDatabase(PersonDTO person) {
		// Take the id from the given person and update him in the database
		try {
			database.updatePerson(person);
		} catch (DALException e) {
			System.out.println(e.getMessage()); // TODO exception handling
		}
	}

	public void editCompanyInDatabase(CompanyDTO company) {
		try {
			database.deleteCompany(curCompany);
		} catch (DALException e) {
			System.out.println(e.getMessage()); // TODO exception handling
		}

		try {
			database.createCompany(company);
		} catch (DALException e) {
			System.out.println(e.getMessage()); // TODO exception handling
		}
	}

	public void addResearcherToCaseInDatabase(String chosenAvailableResearcher) {
		String[] tmpStrings = chosenAvailableResearcher.split(" , ");
		int id = new Integer(tmpStrings[0].substring(4));
		try {
			database.addResearcherToCase(id, curCase);
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
	}

	public void removeResearcherFromCaseInDatabase(String chosenResearcherOnCase) {
		String[] tmpStrings = chosenResearcherOnCase.split(" , ");
		int id = new Integer(tmpStrings[0].substring(4));

		try {
			CaseDTO currentCase = database.findCase(curCase);
			ResearcherDTO researcher = (ResearcherDTO) database
					.findEmployee(id);
			database.removeResearcherCase(researcher, currentCase);
		} catch (DALException e) {
			System.out.println(e.getMessage()); // TODO exception handling
		} catch (SQLException e) {
			System.out.println(e.getMessage()); // TODO exception handling
		}

		MainController.getInstance().editChosenCaseForController(curCase);
	}

	/*
	 * #####################################################################
	 * Find Methods
	 */

	public void findCompany(String searchField) {
		companies.clear();

		try {
			companies.add(database.findCompany(searchField));
		} catch (DALException e) {
			System.out.println(e.getMessage()); // TODO exception handling
		}
		gui.findCompanyMenu(companies);
	}

	public void findPerson(String searchField) {
		persons.clear();

		try {
			persons = (ArrayList<PersonDTO>) database.findPersons(searchField);
		} catch (DALException e) {
			System.out.println(e.getMessage()); // TODO exception handling
		} catch (SQLException e) {
			System.out.println(e.getMessage()); // TODO exception handling
		}

		gui.findPersonMenu(persons);
	}

	public void findCase(String searchField) {
		singleCaseArray.clear();
		// Search for the cases matching something in the searchField String
		try {
			singleCaseArray.add(database.findCase(searchField));
		} catch (DALException e) {
			System.out.println(e.getMessage()); // TODO exception handling
		} catch (SQLException e) {
			System.out.println(e.getMessage()); // TODO exception handling
		}

		gui.findCaseMenu(singleCaseArray);

	}

	public int getCurrentEmployee() {
		return jobPos;
	}

	public void goBack(Object currentEmployee) {
		gui.menu(getCurrentEmployee());

	}

	public void updateStatusOfCandidate(String chosenCandidate) {
		String[] tmpString = chosenCandidate.split(",");
		int candidateId = new Integer(tmpString[0].substring(14));
		try {
			CandidateDTO candi = database.findCaseCandidate(candidateId);

			if (candi.getStatus().equals("Potential prospect")) {
				// Update to prospect
				database.changeCandidateStatus(candi, "Prospect");
			}
			if (candi.getStatus().equals("Prospect")) {
				// Update to Phone interview
				database.changeCandidateStatus(candi, "Phone interview");
			}
			if (candi.getStatus().equals("Personal Meeting")) {
				// Update to presented
				database.changeCandidateStatus(candi, "Presented");
			}
			if (candi.getStatus().equals("Presented")) {
				// Update to placed
				database.changeCandidateStatus(candi, "Placed");
			}
			if (candi.getStatus().equals("Exprospect")) {
				return;
			}
			if (candi.getStatus().equals("Expresented")) {
				return;
			}
		} catch (DALException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public void viewSpecificCase(String chosenCase) {
		// get all the researchers on the case
		// get all the candidates on the case
		// pass them on to the gui along with the current case and the partner
		// working on the case
		String[] tmpString = chosenCase.split(",");
		String ThechosenCase = tmpString[0].substring(11); 
		try {
			researchersOnCase = (ArrayList<ResearcherDTO>) database
					.getAllresearcherOnCases(ThechosenCase);
			System.out.println("den første går godt");
			candidatesOnCase = (ArrayList<CandidateDTO>) database
					.findCaseCandidates(ThechosenCase);
			System.out.println("den anden går godt");
			CaseDTO tmpCase = database.findCase(ThechosenCase);
			System.out.println("den tredje går godt");
			if (employeeId == 1) {
				EmployeeDTO partner = database.findPartner(tmpCase
						.getPartnerId());
				gui.viewCase(tmpCase.getCaseName(), partner.getName(),
						researchersOnCase, candidatesOnCase);
			}
			if (employeeId == 2) {
				EmployeeDTO researcher = database.findResearcher(employeeId);
				gui.viewCase(tmpCase.getCaseName(), researcher.getName(),
						researchersOnCase, candidatesOnCase);
			}

		} catch (DALException e) {
			System.out.println(e.getMessage()); // TODO exception handling
		} catch (SQLException e) {
			System.out.println(e.getMessage()); // TODO exception handling
		}
	}
}
