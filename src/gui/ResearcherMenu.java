package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

public class ResearcherMenu extends JPanel {

	/**
	 * Create the panel.
	 */
	public ResearcherMenu() {
		setLayout(null);
		
		JLabel label = new JLabel("Odgers Berndtson");
		label.setFont(new Font("Calibri", Font.BOLD, 36));
		label.setBounds(83, 35, 266, 44);
		add(label);
		
		JButton button = new JButton("Find person");
		button.setBounds(154, 92, 120, 25);
		add(button);
		
		JButton button_2 = new JButton("Opret sag");
		button_2.setBounds(154, 117, 120, 25);
		add(button_2);
		
		JButton button_3 = new JButton("Find sag");
		button_3.setBounds(154, 141, 120, 25);
		add(button_3);
		
		JButton button_4 = new JButton("S\u00F8g Firma");
		button_4.setBounds(154, 166, 120, 25);
		add(button_4);
		
		JButton button_6 = new JButton("Logout");
		button_6.setBounds(154, 191, 120, 25);
		add(button_6);

	}

}
