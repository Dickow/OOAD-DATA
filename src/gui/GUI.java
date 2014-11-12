package gui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domain.GUITest;
import java.awt.Component;
import javax.swing.Box;

public class GUI {

	private JFrame frame;
	private PartnerMenuPanel partnerMenu;
	private Login loginPanel;
	public static GUITest controller = new GUITest();
	private JPanel headPanel;
	private Component horizontalStrut;
	private Component horizontalStrut_1;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// GUI window = new GUI();
	// window.frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public void initialize() {
		System.out.println("i gui init nu");
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		headPanel = new JPanel();
		frame.getContentPane().add(headPanel, BorderLayout.NORTH);

		JLabel lblOdgersBerndtson = new JLabel("Odgers Berndtson");
		lblOdgersBerndtson.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC,
				46));
		headPanel.add(lblOdgersBerndtson);
		
		horizontalStrut = Box.createHorizontalStrut(200);
		frame.getContentPane().add(horizontalStrut, BorderLayout.WEST);
		
		horizontalStrut_1 = Box.createHorizontalStrut(200);
		frame.getContentPane().add(horizontalStrut_1, BorderLayout.EAST);
		frame.setVisible(true);
	}

	public void login() {
		loginPanel = new Login();
		frame.getContentPane().add(headPanel, BorderLayout.NORTH);
		frame.getContentPane().add(loginPanel, BorderLayout.CENTER);
		loginPanel.setVisible(true);
		frame.setVisible(true);
		frame.revalidate();
		frame.repaint();
	}

	public void menu(int jobPos) {

		switch (jobPos) {
		case 0:
			break;
		case 1:
			partnerMenu = new PartnerMenuPanel();
			frame.removeAll();
			frame.getContentPane().add(headPanel, BorderLayout.NORTH);
			frame.getContentPane().add(partnerMenu, BorderLayout.CENTER);
			partnerMenu.setVisible(true);
			frame.setVisible(true);
			frame.revalidate();
			frame.repaint();
			break;
		case 2:
			break;
		}

	}

}
