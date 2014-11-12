package domain;

import gui.GUI;

public class GUITest {
	
	private GUI gui = new GUI(); 
	
	public void init(){
		gui.initialize();
		gui.login();
	}
	
	public void login(String[] loginInfo){
		System.out.println("du er logget ind");
		System.out.println(loginInfo[0]);
		System.out.println(loginInfo[1]);
		
		gui.menu(1);
		return; 
	}
}
