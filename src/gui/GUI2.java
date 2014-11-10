package gui;

import gui.GUIW.SwingAction;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import domain.GUITest;

public class GUI2 {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPanel loginPane;
	private JPanel HeaderPane;
	private final Action loginAction = new SwingAction();
	private String[] loginInfo = new String[2];
	private boolean readyToSend = false; 

	/**
	 * Create the application.
	 */
	public GUI2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		HeaderPane = new JPanel();
		frame.getContentPane().add(HeaderPane, BorderLayout.NORTH);

		JLabel lblOdgersBerndtson = new JLabel("");
		lblOdgersBerndtson.setIcon(new ImageIcon(GUI2.class
				.getResource("/resources/OdgersBerndtsonLOGO.jpg")));
		lblOdgersBerndtson.setFont(new Font("Tahoma", Font.BOLD, 32));
		HeaderPane.add(lblOdgersBerndtson);
		frame.setVisible(true);
	}

	public String[] login(GUITest controller)  {
		controller.changeOccured = false; 
		loginPane = new JPanel();
		frame.getContentPane().add(loginPane, BorderLayout.CENTER);

		JLabel lblBrugerId = new JLabel("Bruger id");
		lblBrugerId.setFont(new Font("Tahoma", Font.PLAIN, 18));

		textField = new JTextField();
		textField.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLogin.setAction(loginAction);

		passwordField = new JPasswordField();
		GroupLayout gl_loginPane = new GroupLayout(loginPane);
		gl_loginPane
				.setHorizontalGroup(gl_loginPane
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_loginPane
										.createSequentialGroup()
										.addGap(305)
										.addComponent(lblPassword,
												GroupLayout.PREFERRED_SIZE, 83,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(394, Short.MAX_VALUE))
						.addGroup(
								gl_loginPane
										.createSequentialGroup()
										.addGroup(
												gl_loginPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																gl_loginPane
																		.createSequentialGroup()
																		.addGap(306)
																		.addComponent(
																				lblBrugerId,
																				GroupLayout.DEFAULT_SIZE,
																				91,
																				Short.MAX_VALUE))
														.addGroup(
																Alignment.LEADING,
																gl_loginPane
																		.createSequentialGroup()
																		.addGap(281)
																		.addGroup(
																				gl_loginPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								passwordField,
																								GroupLayout.DEFAULT_SIZE,
																								116,
																								Short.MAX_VALUE)
																						.addComponent(
																								textField,
																								GroupLayout.PREFERRED_SIZE,
																								0,
																								Short.MAX_VALUE))))
										.addGap(385))
						.addGroup(
								Alignment.LEADING,
								gl_loginPane.createSequentialGroup()
										.addGap(301).addComponent(btnLogin)
										.addContainerGap(406, Short.MAX_VALUE)));
		gl_loginPane.setVerticalGroup(gl_loginPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_loginPane
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblBrugerId)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblPassword)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(passwordField,
								GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE).addGap(14)
						.addComponent(btnLogin)
						.addContainerGap(315, Short.MAX_VALUE)));
		loginPane.setLayout(gl_loginPane);
		while( !readyToSend){
			
		}
		controller.changeOccured = true; 
		return loginInfo;
	}

	public int partnerMenu(GUITest controller) {
		controller.changeOccured = false; 
		readyToSend = false; 
		int returnValue = 0;
		PartnerMenuPane partnerMenu = new PartnerMenuPane();
		returnValue = partnerMenu.partnerMenuPane(this); 
		frame.getContentPane().add(partnerMenu, BorderLayout.CENTER);
		while (!readyToSend) {

		}
		controller.changeOccured = true; 
		return returnValue;

	}

	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 6239271469732135846L;

		/**
		 * 
		 */

		public SwingAction() {
			putValue(NAME, "Log ind");

		}

		public void actionPerformed(ActionEvent e) {
			loginInfo[0] = textField.getText();
			loginInfo[1] = new String(passwordField.getPassword());
			readyToSend = true; 
		}
	}

	public void setReadyToSend(boolean readyToSend) {
		this.readyToSend = readyToSend;
	}
	
}
