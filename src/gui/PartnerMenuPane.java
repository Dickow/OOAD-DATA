package gui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PartnerMenuPane extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2590945360683354862L;
	private final Action MenuAction = new SwingAction();
	private int menuChoice; 
	private boolean readyToSend = false; 

	/**
	 * Create the panel.
	 */
	public int partnerMenuPane(GUI2 gui) {
		setLayout(null);
		
		JButton btnFindPerson = new JButton("Find Person");
		btnFindPerson.setAction(MenuAction);
		btnFindPerson.setActionCommand("FindPerson");
		btnFindPerson.setBounds(171, 95, 107, 25);
		
		
		JButton btnOpretPerson = new JButton("Opret Person");
		btnOpretPerson.setAction(MenuAction);
		btnFindPerson.setActionCommand("OpretPerson");
		btnOpretPerson.setBounds(171, 135, 107, 25);
		
		JButton btnFindSag = new JButton("Find sag");
		btnFindSag.setAction(MenuAction);
		btnFindPerson.setActionCommand("FindSag");
		btnFindSag.setBounds(171, 55, 107, 25);
		
	
		JButton btnOpretSag = new JButton("Opret Sag");
		btnOpretSag.setHideActionText(true);
		btnOpretSag.setAction(MenuAction);
		btnFindPerson.setActionCommand("OpretSag");
		btnOpretSag.setBounds(171, 15, 107, 25);
		
		
		JButton btnFindFirma = new JButton("Find Firma");
		btnFindFirma.setAction(MenuAction);
		btnFindPerson.setActionCommand("FindFirma");
		btnFindFirma.setBounds(171, 175, 107, 25);
		
		
		JButton btnOpretFirma = new JButton("Opret Firma");
		btnOpretFirma.setAction(MenuAction);
		btnFindPerson.setActionCommand("OpretFirma");
		btnOpretFirma.setBounds(171, 215, 107, 25);
		
		
		JButton btnLogUd = new JButton("Log ud");
		btnLogUd.setAction(MenuAction);
		btnFindPerson.setActionCommand("LogUd");
		btnLogUd.setBounds(171, 255, 107, 25);
	
		add(btnOpretSag);
		add(btnFindSag);
		add(btnFindPerson);
		add(btnOpretPerson);
		add(btnFindFirma);
		add(btnOpretFirma);
		add(btnLogUd);
		this.setVisible(true);
		
		while(!readyToSend){
			
		}
		
		return menuChoice; 
	}

	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 3107286302206219130L;

		public SwingAction() {
		    putValue(NAME, "fuck");

		}

		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()){
			
			case "FindPerson": 
				System.out.println("Find Person");
				menuChoice = 0; 
				break; 
			case "OpretPerson": 
				System.out.println("Opret Person");
				menuChoice = 1; 
				break; 
			case "FindSag": 
				System.out.println("Find Sag");
				menuChoice = 2; 
				break ;
			case "OpretSag": 
				System.out.println("Opret Sag");
				menuChoice = 3; 
				break; 
			case "FindFirma": 
				System.out.println("Find Firma");
				menuChoice = 4; 
				break; 
			case "OpretFirma": 
				System.out.println("Opret Firma");
				menuChoice = 5; 
				break; 
			case "LogUd": 
				System.out.println("Log Ud");
				menuChoice = 6; 
				break; 
			}
		}
	}
}
