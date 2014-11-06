package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class GUIW {

	private JFrame frame;
	private JTextField userIdField;
	private JPasswordField passwordField;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIW window = new GUIW();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIW() {
		initialize();
		login();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public String[] login() {
		final String[] loginInfo = new String[2];
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblOdgersBerndtson = new JLabel("Odgers Berndtson");
		lblOdgersBerndtson.setFont(new Font("Calibri", Font.BOLD, 36));
		lblOdgersBerndtson.setBounds(257, 127, 271, 37);
		panel.add(lblOdgersBerndtson);

		JLabel lblBrugerId = new JLabel("Bruger id");
		lblBrugerId.setBounds(359, 177, 56, 16);
		panel.add(lblBrugerId);

		userIdField = new JTextField();
		userIdField.setBounds(329, 195, 116, 22);
		panel.add(userIdField);
		userIdField.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(359, 224, 56, 16);
		panel.add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(329, 243, 116, 22);
		panel.add(passwordField);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = userIdField.getText();
				String pw = new String(passwordField.getPassword());
				loginInfo[0] = id;
				loginInfo[1] = pw;
				System.out.println(loginInfo[0]);
				System.out.println(loginInfo[1]);
			}
		});
		btnLogin.setAction(action);
		btnLogin.setBounds(352, 275, 63, 25);
		panel.add(btnLogin);
		return loginInfo;
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Login");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}
}
