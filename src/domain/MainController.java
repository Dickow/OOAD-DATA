package domain;

import gui.GUI;

public class MainController {
	private GUI gui =  new GUI(); 
	private int jobPos; 

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
	
	public void menuDistributor(int menuChoice){
		switch(menuChoice){
		case 0: 
			System.out.println("menu 0");
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
		// TODO Auto-generated method stub
		
	}

	public void goBack(Object currentEmployee) {
		gui.menu(getCurrentEmployee());
		
	}
}
