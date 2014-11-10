package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import domain.GUITest;

public class GUIW {

	private JFrame frame;
	private JTextField userIdField;
	private JPasswordField passwordField;
	private final Action action = new SwingAction();
	// private final Action action_7 = new SwingAction_7();
	// private final Action action_1 = new SwingAction_1();
	// private final Action action_2 = new SwingAction_2();
	// private final Action action_3 = new SwingAction_3();
	// private final Action action_4 = new SwingAction_4();
	// private final Action action_5 = new SwingAction_5();
	// private final Action action_6 = new SwingAction_6();
	private GUITest test = new GUITest();

	/**
	 * Create the application.
	 */
	public GUIW() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 800, 600);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void login() {
		final String[] loginInfo = new String[2];
		JPanel panel = new JPanel();
		getFrame().getContentPane().add(panel, BorderLayout.CENTER);
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
				test.login(loginInfo);
			}
		});
		btnLogin.setAction(action);
		btnLogin.setBounds(352, 275, 63, 25);
		panel.add(btnLogin);
	}

	public void menu(int jobPosition) {
		frame.removeAll();
		
		if (jobPosition == 0) {
			frame.getContentPane().add(new PartnerMenu(), BorderLayout.CENTER);
			frame.validate();
			frame.repaint();
		} else {
			frame.setContentPane(new ResearcherMenu());
			frame.validate();
			frame.repaint();
		}
	}

	class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Login");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
