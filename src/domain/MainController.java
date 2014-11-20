package domain;

import gui.GUI;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import data.DALException;
import data.DataDAO;
import domain.EmployeeDTO.JOB;

public class MainController {
	private GUI gui = new GUI();
	private int jobPos;
	private ArrayList<PersonDTO> persons = new ArrayList<PersonDTO>();
	private ArrayList<CompanyDTO> companies = new ArrayList<CompanyDTO>();
	private ArrayList<CaseDTO> cases = new ArrayList<CaseDTO>(); 
	private List<String> researchers;
	private List<String> candidates; 
	private int id; 
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
		id = new Integer(loginInfo[0]); 

		try {
			database.loginExists(loginInfo);
		} catch (DALException e) {
			e.getMessage(); // TODO exception handling
		} catch (SQLException e) {
			e.getMessage(); // TODO exception handling
		} 
		
		try {
			if(database.findEmployee(id).getJob().equals(JOB.PARTNER)){
				this.jobPos = 1; 
			}
			else{
				jobPos = 2; 
			}
		} catch (DALException e) {
			e.getMessage(); // TODO exception handling
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
	 * ################################################################
	 * Create methods
	 */
	public void createPerson(PersonDTO person,String date, String salary){

		// look in the database for the last id and create the person with that id + 1
		try {
			int tmpId = database.getLastPerson().getPersonId()+1;
			person.setId(tmpId);
		} catch (DALException e) {
			e.getMessage(); //TODO exception handling
		} catch (SQLException e) {
			e.getMessage(); //TODO exception handling
		}
		int day = new Integer(date.substring(0, 1));
		int month = new Integer(date.substring(2, 3));
		int year = new Integer(date.substring(4));
		@SuppressWarnings("deprecation")
		Date yearOfBirth = new Date(day,month,year); 
		
		int salary1 = new Integer(salary); 
		
		// put the int casted values into the object
		person.setBirthYear(yearOfBirth);
		person.setSalary(salary1);
		
		//create the person in the database
		try {
			database.createPerson(person);
		} catch (DALException e) {
			e.getMessage(); //TODO exception handling
		}
	}
	
	public void createCompany(CompanyDTO company){
		// send the company to the database layer 
		System.out.println("created the " + company.getCompanyName());
		try {
			database.createCompany(company);
		} catch (DALException e) {
			e.getMessage();//TODO exception handling
		}
	}
	
	public void createCase(CaseDTO casetmp, String researchers, String candidates){
		
		// set the saved id from the person, because the id can not be edited by anyone
		casetmp.setPartnerId(id);
		
		// split the arrays by ,
		this.researchers = new ArrayList<String>(Arrays.asList(researchers.split(" , ")));
		this.candidates = new ArrayList<String>(Arrays.asList(candidates.split(" , "))); 
		
		try {
			database.createCase(casetmp);
		} catch (DALException e) {
			e.getMessage(); // TODO exception handling
		}
		
	}
	

	/*
	 * ###########################################################
	 * Edit methods
	 */
	public void editChosenPerson(String chosenPerson) {
		System.out.println(chosenPerson + " will be edited");
		String[] tmpStrings = chosenPerson.split(" , "); 
		int id = new Integer(tmpStrings[0].substring(4));
		PersonDTO person;
		try {
			person = database.findPerson(id);
			gui.editPersonMenu(person);
		} catch (DALException e) {
			e.getMessage(); //TODO exception handling
		} catch (SQLException e) {
			e.getMessage(); //TODO exception handling
		} 
		
	}
	
	public void editChosenCompany(String chosenCompany){
		curCompany = chosenCompany; 
		
		try {
			gui.editCompanyMenu(database.findCompany(chosenCompany));
		} catch (DALException e) {
			e.getMessage(); // TODO exception handling 
		}
	}
	
	public void editChosenCase(String chosenCase){
		String[] tmpStrings = chosenCase.split(" , "); 
		curCase = tmpStrings[0].substring(11);
		// first get all the researchers on a given case and all the researchers not on that given case
		//TODO get the available researchers
		try {
			gui.editCaseMenu(database.getAllresearcherOnCases(curCase), database.getAllresearcherNotOnCases(curCase));
		} catch (DALException e) {
			e.getMessage(); // TODO
		} catch (SQLException e) {
			e.getMessage(); // TODO
		}	
	}
	public void editChosenCaseForController(String curCase){
		
	}
	
	/*
	 * ###################################################
	 * Edit methods that update the data in the database.
	 */
	
	public void editPersonInDatabase(PersonDTO person){
		// Take the id from the given person and update him in the database
		try {
			database.updatePerson(person);
		} catch (DALException e) {
			e.getMessage(); //TODO exception handling
		}
	}
	
	public void editCompanyInDatabase(CompanyDTO company){
		try {
			database.deleteCompany(curCompany);
		} catch (DALException e) {
			e.getMessage(); // TODO exception handling
		}
		
		try {
			database.createCompany(company);
		} catch (DALException e) {
			e.getMessage(); // TODO exception handling
		}
	}
	
	public void addResearcherToCaseInDatabase(String chosenAvailableResearcher){
		String[] tmpStrings = chosenAvailableResearcher.split(" , "); 
		int id = new Integer(tmpStrings[0].substring(4));
		try {
			database.addResearcherToCase(id, curCase);
		} catch (DALException e) {
			e.getMessage();
		}
	}
	
	public void removeResearcherFromCaseInDatabase(String chosenResearcherOnCase){
		String[] tmpStrings = chosenResearcherOnCase.split(" , "); 
		int id = new Integer(tmpStrings[0].substring(4));
		//TODO mangler en metode til at fjerne researchere fra en eksisterende case
		
		
		MainController.getInstance().editChosenCaseForController(curCase);
	}
	
	/*
	 * ############################################################
	 * Find Methods
	 */
	
	public void findCompany(String searchField){
		// Search for the companies matching something in the searchField String
		companies.add(new CompanyDTO("Kagefabrikken", "Kage", "Kagevej 46", "12345678", "stor mand", "lille mand"));
		gui.findCompanyMenu(companies);
	}
	
	@SuppressWarnings("deprecation")
	public void findPerson(String searchField) {
		// Test data for the JList
		persons.add(new PersonDTO("Jeppe", "Address", "DTU", "Sejt job", "TLF", "mobil telefon", "privat mail", "Mobil", "lol note", 1, new Date(0,0,0), 50000000));
		
		gui.findPersonMenu(persons);
	}

	public void findCase(String searchField){
		// Search for the cases matching something in the searchField String
		
		// Test data for the JList
		cases.add(new CaseDTO("god case", "Kagefabrikken", 2, 1));
		
		gui.findCaseMenu(cases);
		
	}
	
	
	
	public int getCurrentEmployee() {
		return jobPos;
	}

	public void goBack(Object currentEmployee) {
		gui.menu(getCurrentEmployee());

	}
}
