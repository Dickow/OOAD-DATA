package domain;

import gui.GUI;

import java.sql.Date;
import java.util.ArrayList;

public class MainController {
	private GUI gui = new GUI();
	private int jobPos;
	private ArrayList<PersonDTO> persons = new ArrayList<PersonDTO>();

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
			System.out.println("menu 0");
			gui.findPersonMenu(persons);
			break;
		case 1:
			System.out.println("menu1");
			gui.createPersonMenu();
			break;
		case 2:
			System.out.println("menu2");
			break;
		case 3:
			System.out.println("menu3");
			break;
		case 4:
			System.out.println("menu4");
			break;
		case 5:
			System.out.println("menu5");
			break;
		case 6:
			System.out.println("menu6");
			gui.login();
			break;
		}

	}
	public void createPerson(PersonDTO person,String date, String salary){
		// look in the database for the last id and create the person with that id + 1
		int day = new Integer(date.substring(0, 1));
		int month = new Integer(date.substring(2, 3));
		int year = new Integer(date.substring(4));
		Date yearOfBirth = new Date(day,month,year); 
		
		int salary1 = new Integer(salary); 
		
		// put the person into the database now!!
		person.setAge(yearOfBirth);
		person.setSalary(salary1);
		
		
		
	}

	public void editChosenPerson(String chosenPerson) {
		System.out.println(chosenPerson);
		

	}

	public int getCurrentEmployee() {
		return jobPos;
	}

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
