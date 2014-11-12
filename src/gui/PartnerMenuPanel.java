package gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class PartnerMenuPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -789221947986118945L;
	private final Action action = new SwingAction();

	/**
	 * Create the panel.
	 */
	public PartnerMenuPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{99, 0, 47, 55, 39, 45, 81, 0};
		gridBagLayout.rowHeights = new int[]{25, 25, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton findPerson = new JButton("Find person");
		findPerson.setAction(action);
		findPerson.setActionCommand("findPerson");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.HORIZONTAL;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 3;
		gbc_button.gridy = 1;
		add(findPerson, gbc_button);
		
		JButton opretPerson = new JButton("Opret person");
		opretPerson.setAction(action);
		opretPerson.setActionCommand("opretPerson");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 3;
		gbc_button_1.gridy = 2;
		add(opretPerson, gbc_button_1);
		
		JButton findSag = new JButton("Find sag");
		findSag.setAction(action);
		findSag.setActionCommand("findSag");
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_3.insets = new Insets(0, 0, 5, 5);
		gbc_button_3.gridx = 3;
		gbc_button_3.gridy = 3;
		add(findSag, gbc_button_3);
		
		JButton opretSag = new JButton("Opret sag");
		opretSag.setAction(action);
		opretSag.setActionCommand("opretSag");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_2.gridx = 3;
		gbc_button_2.gridy = 4;
		add(opretSag, gbc_button_2);
		
		JButton findFirma = new JButton("Find Firma");
		findFirma.setAction(action);
		findFirma.setActionCommand("findFirma");
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_4.insets = new Insets(0, 0, 5, 5);
		gbc_button_4.gridx = 3;
		gbc_button_4.gridy = 5;
		add(findFirma, gbc_button_4);
		
		JButton opretFirma = new JButton("Opret firma");
		opretFirma.setAction(action);
		opretFirma.setActionCommand("opretFirma");
		opretFirma.setName("");
		opretFirma.setForeground(Color.BLACK);
		opretFirma.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_5.insets = new Insets(0, 0, 5, 5);
		gbc_button_5.gridx = 3;
		gbc_button_5.gridy = 6;
		add(opretFirma, gbc_button_5);
		
		JButton logOut = new JButton("Logout");
		logOut.setAction(action);
		logOut.setActionCommand("logout");
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_6.insets = new Insets(0, 0, 5, 5);
		gbc_button_6.gridx = 3;
		gbc_button_6.gridy = 7;
		add(logOut, gbc_button_6);
		this.setVisible(true);

	}
	
	/* A collection of all the actions commands that the buttons can trigger 
	 * collected in a switch statement, where the actions command is gathered through the
	 * acionPerformed method. 
	*/

	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 2849057626039315237L;
		public SwingAction() {
			putValue(NAME, "SwingAction");
		}
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()){
			
			case "findPerson": 
				break; 
			
			case "opretPerson": 
				break; 
			case "findSag": 
				break; 
			case "opretSag": 
				break; 
			case "findFirma": 
				break; 
			case "opretFirma": 
				break; 
			case "logout": 
				break; 
			
			}
		}
	}
}
