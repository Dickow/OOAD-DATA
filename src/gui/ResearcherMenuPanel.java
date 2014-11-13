package gui;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;

import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream.GetField;

import javax.swing.Action;

import domain.MainController;

public class ResearcherMenuPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ResearcherMenuPanel() {
		setLayout(null);
		
		JButton findPerson = new JButton("Find person");
		findPerson.setName("Find person");
		findPerson.setActionCommand("findPerson");
		findPerson.setBounds(173, 35, 115, 25);
		add(findPerson);
		
		JButton createPerson = new JButton("Opret person");
		createPerson.setActionCommand("opretPerson");
		createPerson.setBounds(173, 65, 115, 25);
		add(createPerson);
		
		JButton findCase = new JButton("Find sag");
		findCase.setActionCommand("findSag");
		findCase.setBounds(173, 95, 115, 25);
		add(findCase);
		
		JButton findFirm = new JButton("Find Firma");
		findFirm.setActionCommand("findFirma");
		findFirm.setBounds(173, 125, 115, 25);
		add(findFirm);
		
		JButton logOut = new JButton("Logout");
		logOut.setActionCommand("logout");
		logOut.setBounds(173, 156, 115, 25);
		add(logOut);
		
		findPerson.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int menuChoice = 0; 
				MainController.getInstance().menuDistributor(menuChoice);
				
			}
		});
		createPerson.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int menuChoice = 1; 
				MainController.getInstance().menuDistributor(menuChoice);
				
			}
		});
		findCase.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int menuChoice = 2; 
				MainController.getInstance().menuDistributor(menuChoice);
				
			}
		});
		findFirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int menuChoice = 4; 
				MainController.getInstance().menuDistributor(menuChoice);
				
			}
		});
		logOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int menuChoice = 6; 
				MainController.getInstance().menuDistributor(menuChoice);
				
			}
		});
	}

}
