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
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel brugerId = new JLabel("Bruger id");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 6;
		gbc_label.gridy = 3;
		add(brugerId, gbc_label);
		
		brugerIdTextField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 6;
		gbc_textField.gridy = 4;
		add(brugerIdTextField, gbc_textField);
		brugerIdTextField.setColumns(10);
		
		JLabel password = new JLabel("Password");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 6;
		gbc_lblNewLabel.gridy = 5;
		add(password, gbc_lblNewLabel);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.anchor = GridBagConstraints.NORTH;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 6;
		gbc_passwordField.gridy = 6;
		add(passwordField, gbc_passwordField);
		
		JButton loginButton = new JButton("Log ind");
		loginButton.setAction(action);
		loginButton.setActionCommand("login");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 6;
		gbc_btnNewButton.gridy = 7;
		add(loginButton, gbc_btnNewButton);
		this.add(loginButton);
		this.add(password);
		this.add(brugerId);
		this.add(brugerIdTextField);
		this.add(passwordField);
		

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
