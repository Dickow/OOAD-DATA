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
import java.awt.event.ActionListener;

import javax.swing.Action;

import domain.MainController;

public class PartnerMenuPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -789221947986118945L;

	/**
	 * Create the panel.
	 */
	public PartnerMenuPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 99, 0, 47, 55, 39, 45, 81, 0 };
		gridBagLayout.rowHeights = new int[] { 25, 25, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JButton findPerson = new JButton("Find person");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.HORIZONTAL;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 3;
		gbc_button.gridy = 1;
		add(findPerson, gbc_button);

		JButton createPerson = new JButton("Opret person");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 3;
		gbc_button_1.gridy = 2;
		add(createPerson, gbc_button_1);

		JButton findCase = new JButton("Find sag");
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_3.insets = new Insets(0, 0, 5, 5);
		gbc_button_3.gridx = 3;
		gbc_button_3.gridy = 3;
		add(findCase, gbc_button_3);

		JButton createCase = new JButton("Opret sag");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_2.gridx = 3;
		gbc_button_2.gridy = 4;
		add(createCase, gbc_button_2);

		JButton findFirm = new JButton("Find Firma");
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_4.insets = new Insets(0, 0, 5, 5);
		gbc_button_4.gridx = 3;
		gbc_button_4.gridy = 5;
		add(findFirm, gbc_button_4);

		JButton createFirm = new JButton("Opret firma");
		createFirm.setName("");
		createFirm.setForeground(Color.BLACK);
		createFirm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_5.insets = new Insets(0, 0, 5, 5);
		gbc_button_5.gridx = 3;
		gbc_button_5.gridy = 6;
		add(createFirm, gbc_button_5);

		JButton logOut = new JButton("Logout");
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_6.insets = new Insets(0, 0, 5, 5);
		gbc_button_6.gridx = 3;
		gbc_button_6.gridy = 7;
		add(logOut, gbc_button_6);

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
		createCase.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int menuChoice = 3;
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
		createFirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int menuChoice = 5;
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
