package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class Login extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1356130532571861530L;
	private JTextField brugerIdTextField;
	private JPasswordField passwordField;
	private final Action action = new SwingAction();

	/**
	 * Create the panel.
	 */
	public Login() {
		setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(150, 126, 116, 22);
		add(passwordField);
		this.add(passwordField);
		
		brugerIdTextField = new JTextField();
		brugerIdTextField.setBounds(150, 79, 116, 22);
		add(brugerIdTextField);
		brugerIdTextField.setColumns(10);
		this.add(brugerIdTextField);
		
		JButton loginButton = new JButton("Log ind");
		loginButton.setBounds(170, 161, 73, 25);
		loginButton.setAction(action);
		loginButton.setActionCommand("login");
		add(loginButton);
		this.add(loginButton);
		
		JLabel brugerId = new JLabel("Bruger id");
		brugerId.setBounds(177, 60, 52, 16);
		add(brugerId);
		this.add(brugerId);
		
		JLabel password = new JLabel("Password");
		password.setBounds(177, 110, 55, 16);
		add(password);
		this.add(password);
		

	}

	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 3084895223404715946L;
		public SwingAction() {
			putValue(NAME, "Log ind");
		}
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("login")) {
				String[] loginInfo = new String[2]; 
				loginInfo[0] = brugerIdTextField.getText(); 
				loginInfo[1] = new String(passwordField.getPassword());
				
				GUI.controller.login(loginInfo);
			}
		}
	}
}
