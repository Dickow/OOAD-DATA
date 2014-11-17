package domain;

import gui.GUI;

import java.util.ArrayList;

import domain.EmployeeDTO.JOB;

public class MainController {
	private GUI gui = new GUI();
	private int jobPos;
	private ArrayList<EmployeeDTO> employees = new ArrayList<EmployeeDTO>();

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

		this.jobPos = 1;
		gui.menu(1);

	}

	public void menuDistributor(int menuChoice) {
		switch (menuChoice) {
		case 0:
			System.out.println("menu 0");
			gui.findPersonMenu(employees);
			break;
		case 1:
			System.out.println("menu1");
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

	public void editChosenPerson(String chosenPerson) {
		// TODO Auto-generated method stub

	}

	public int getCurrentEmployee() {
		return jobPos;
	}

	public void findPerson(String searchField) {
		// Test data for the JList
		employees.add(new EmployeeDTO(10, "Lars", "adadawd", JOB.PARTNER));
		employees.add(new EmployeeDTO(11, "Jeppe", "oaidaod", JOB.PARTNER));
		employees
				.add(new EmployeeDTO(12, "Nikolaj", "AOdiadoa", JOB.RESEARCHER));

		gui.findPersonMenu(employees);
	}

	public void goBack(Object currentEmployee) {
		gui.menu(getCurrentEmployee());

	}
}
