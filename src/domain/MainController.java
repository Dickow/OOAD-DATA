package domain;

import gui.GUI;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainController {
	private GUI gui = new GUI();
	private int jobPos;
	private ArrayList<PersonDTO> persons = new ArrayList<PersonDTO>();
	private ArrayList<CompanyDTO> companies = new ArrayList<CompanyDTO>();
	private ArrayList<CaseDTO> cases = new ArrayList<CaseDTO>(); 
	private List<String> researchers;
	private List<String> candidates; 
	private int id; 

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
		id = new Integer(loginInfo[0]); 
		System.out.println("du er logget ind");
		System.out.println(loginInfo[0]);
		System.out.println(loginInfo[1]);

		// TODO check if the one that logs in acctually exists
		this.jobPos = 1;
		gui.menu(1);

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
		int day = new Integer(date.substring(0, 1));
		int month = new Integer(date.substring(2, 3));
		int year = new Integer(date.substring(4));
		@SuppressWarnings("deprecation")
		Date yearOfBirth = new Date(day,month,year); 
		
		int salary1 = new Integer(salary); 
		
		// put the person into the database now!!
		person.setBirthYear(yearOfBirth);
		person.setSalary(salary1);
	}
	
	public void createCompany(CompanyDTO company){
		// send the company to the database layer 
		// TODO
		System.out.println("created the " + company.getCompanyName());
	}
	
	public void createCase(CaseDTO casetmp, String researchers, String candidates){
		casetmp.setPartnerId(id);
		
		this.researchers = new ArrayList<String>(Arrays.asList(researchers.split(" , ")));
		this.candidates = new ArrayList<String>(Arrays.asList(candidates.split(" , "))); 
		
		// create everything in the database now. 
		// TODO
		
	}
	

	/*
	 * ###########################################################
	 * Edit methods
	 */
	public void editChosenPerson(String chosenPerson) {
		System.out.println(chosenPerson + " will be edited");
	}
	
	public void editChosenCompany(String chosenCompany){
		System.out.println(chosenCompany+ " will be edited");
	}
	
	public void editChosenCase(String chosenCase){
		System.out.println(chosenCase + "will be edited");
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
