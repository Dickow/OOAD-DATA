package gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class ResearcherMenuPanel extends JPanel {
	private final Action action = new SwingAction();

	/**
	 * Create the panel.
	 */
	public ResearcherMenuPanel() {
		setLayout(null);
		
		JButton button = new JButton("Find person");
		button.setAction(action);
		button.setActionCommand("findPerson");
		button.setBounds(173, 35, 115, 25);
		add(button);
		
		JButton button_1 = new JButton("Opret person");
		button_1.setAction(action);
		button_1.setActionCommand("opretPerson");
		button_1.setBounds(173, 65, 115, 25);
		add(button_1);
		
		JButton button_2 = new JButton("Find sag");
		button_2.setAction(action);
		button_2.setActionCommand("findSag");
		button_2.setBounds(173, 95, 115, 25);
		add(button_2);
		
		JButton button_4 = new JButton("Find Firma");
		button_4.setAction(action);
		button_4.setActionCommand("findFirma");
		button_4.setBounds(173, 125, 115, 25);
		add(button_4);
		
		JButton button_6 = new JButton("Logout");
		button_6.setAction(action);
		button_6.setActionCommand("logout");
		button_6.setBounds(173, 156, 115, 25);
		add(button_6);
		
		
		
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
