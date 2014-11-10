package domain;

import gui.GUI2;

public class GUITest implements Runnable {

	public boolean changeOccured = false ; 
	private String[] login; 
	
	public GUITest(){
		run(); 
	}
	@Override
	public void run() {
		GUI2 gui = new GUI2(); 
		login = gui.login(this); 
		while(!changeOccured){
			
		}
		System.out.println(login);
		int menuChoice = gui.partnerMenu(this); 
		
		while(! changeOccured){
			
		}
		
		System.out.println(menuChoice);
	}


}
