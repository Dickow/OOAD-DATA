package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domain.CompanyDTO;
import domain.PersonDTO;

public class GUI {

	private JFrame frame;
	private PartnerMenuPanel partnerMenu = new PartnerMenuPanel();
	private ResearcherMenuPanel researcherMenu = new ResearcherMenuPanel();
	private FindPersonPanel findPersonPanel = new FindPersonPanel();
	private CreatePersonPanel createPersonPanel = new CreatePersonPanel(); 
	private CreateCompanyPanel createCompanyPanel = new CreateCompanyPanel(); 
	private FindCompanyPanel findCompanyPanel = new FindCompanyPanel(); 
	private Login loginPanel = new Login();
	private JPanel headPanel;
	private Component horizontalStrut;
	private Component horizontalStrut_1;
	private BorderLayout layout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		initialize();
		login();
	}

	public void initialize() {
		System.out.println("i gui init nu");
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(layout = new BorderLayout(0, 0));

		headPanel = new JPanel();
		headPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		frame.getContentPane().add(headPanel, BorderLayout.NORTH);

		JLabel lblOdgersBerndtson = new JLabel("Odgers Berndtson");
		lblOdgersBerndtson.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC,
				46));
		headPanel.add(lblOdgersBerndtson);

		horizontalStrut = Box.createHorizontalStrut(180);
		frame.getContentPane().add(horizontalStrut, BorderLayout.WEST);

		horizontalStrut_1 = Box.createHorizontalStrut(180);
		frame.getContentPane().add(horizontalStrut_1, BorderLayout.EAST);
		frame.setVisible(true);
	}

	public void login() {
		if (layout.getLayoutComponent(BorderLayout.CENTER) != null) {
			layout.getLayoutComponent(BorderLayout.CENTER).setVisible(false);
			frame.getContentPane().remove(
					layout.getLayoutComponent(BorderLayout.CENTER));
		}
		
		frame.getContentPane().add(loginPanel, BorderLayout.CENTER);
		loginPanel.setVisible(true);
	}

	public void menu(int jobPos) {
		layout.getLayoutComponent(BorderLayout.CENTER).setVisible(false);
		frame.getContentPane().remove(
				layout.getLayoutComponent(BorderLayout.CENTER));
		switch (jobPos) {
		case 0:
			break;
		case 1:
			frame.getContentPane().add(partnerMenu, BorderLayout.CENTER);
			partnerMenu.setVisible(true);
			break;
		case 2:
			frame.getContentPane().add(researcherMenu, BorderLayout.CENTER);
			researcherMenu.setVisible(true);
			break;
		}
	}

	public void findPersonMenu(ArrayList<PersonDTO> persons) {
		findPersonPanel.clearPrevList();
		findPersonPanel.fillList(persons);
		// remove previous panel
		layout.getLayoutComponent(BorderLayout.CENTER).setVisible(false);
		frame.getContentPane().remove(
				layout.getLayoutComponent(BorderLayout.CENTER));
		// add the panel to the frame
		frame.getContentPane().add(findPersonPanel);
		findPersonPanel.setVisible(true);

	}
	
	public void createPersonMenu(){
		// remove previous panel
		layout.getLayoutComponent(BorderLayout.CENTER).setVisible(false);
		frame.getContentPane().remove(
				layout.getLayoutComponent(BorderLayout.CENTER));
		// add the panel to the frame
		frame.getContentPane().add(createPersonPanel);
		createPersonPanel.setVisible(true);
	}
	
	public void createCompanyMenu(){
		// remove previous panel
		layout.getLayoutComponent(BorderLayout.CENTER).setVisible(false);
		frame.getContentPane().remove(
				layout.getLayoutComponent(BorderLayout.CENTER));
		// add the panel to the frame
		frame.getContentPane().add(createCompanyPanel);
		createCompanyPanel.setVisible(true);
	}
	public void findCompanyMenu(ArrayList<CompanyDTO> companies){
		findCompanyPanel.clearPrevList();
		findCompanyPanel.fillList(companies);
		// remove previous panel
		layout.getLayoutComponent(BorderLayout.CENTER).setVisible(false);
		frame.getContentPane().remove(
				layout.getLayoutComponent(BorderLayout.CENTER));
		// add the panel to the frame
		frame.getContentPane().add(findPersonPanel);
		findPersonPanel.setVisible(true);
	}

}
