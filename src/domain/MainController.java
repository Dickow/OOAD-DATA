package domain;

import gui.GUI;

import java.sql.Date;
import java.util.ArrayList;

public class MainController {
	private GUI gui = new GUI();
	private int jobPos;
	private ArrayList<PersonDTO> persons = new ArrayList<PersonDTO>();
	private ArrayList<CompanyDTO> companies = new ArrayList<CompanyDTO>();

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
			System.out.println("menu2"); // TODO
			break;
		case 3:
			System.out.println("menu3"); // TODO
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
	public void createPerson(PersonDTO person,String date, String salary){
		// look in the database for the last id and create the person with that id + 1
		int day = new Integer(date.substring(0, 1));
		int month = new Integer(date.substring(2, 3));
		int year = new Integer(date.substring(4));
		@SuppressWarnings("deprecation")
		Date yearOfBirth = new Date(day,month,year); 
		
		int salary1 = new Integer(salary); 
		
		// put the person into the database now!!
		person.setAge(yearOfBirth);
		person.setSalary(salary1);
		
		
		
	}

	public void editChosenPerson(String chosenPerson) {
		System.out.println(chosenPerson);
		

	}
	
	public void editChosenCompany(String chosenCompany){
		System.out.println(chosenCompany+ " will be edited");
	}
	
	public void createCompany(CompanyDTO company){
		// send the company to the database layer 
		// TODO
		System.out.println("created the " + company.getCompanyName());
	}
	
	public void findCompany(String searchField){
		// Search for the companies matching something in the searchField String
		companies.add(new CompanyDTO("Kagefabrikken", "Kage", "Kagevej 46", "12345678", "stor mand", "lille mand"));
		gui.findCompanyMenu(companies);
	}

	public int getCurrentEmployee() {
		return jobPos;
	}

	@SuppressWarnings("deprecation")
	public void findPerson(String searchField) {
		// Test data for the JList
		persons.add(new PersonDTO("Jeppe", "Address", "DTU", "Sejt job", "TLF", "mobil telefon", "privat mail", "Mobil", "lol note", 1, new Date(0,0,0), 50000000));
		System.out.println(searchField);
		
		gui.findPersonMenu(persons);
	}

	public void goBack(Object currentEmployee) {
		gui.menu(getCurrentEmployee());

	}
}
