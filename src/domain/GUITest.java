package domain;

import gui.GUI;

public class GUITest {

	private static String[] login; 
	public static void main(String[] args) {
		GUI gui = new GUI(); 
		
		login = gui.login();
		
		System.out.println(login[0]);
		System.out.println(login[1]);
		
	}

}
