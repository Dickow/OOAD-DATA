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

import domain.CandidateDTO;
import domain.CaseDTO;
import domain.CompanyDTO;
import domain.PersonDTO;
import domain.ResearcherDTO;

public class GUI {

	private JFrame frame;
	private PartnerMenuPanel partnerMenu = new PartnerMenuPanel();
	private ResearcherMenuPanel researcherMenu = new ResearcherMenuPanel();
	private FindPersonPanel findPersonPanel = new FindPersonPanel();
	private CreatePersonPanel createPersonPanel = new CreatePersonPanel();
	private CreateCompanyPanel createCompanyPanel = new CreateCompanyPanel();
	private FindCompanyPanel findCompanyPanel = new FindCompanyPanel();
	private FindCasePanel findCasePanel = new FindCasePanel();
	private CreateCasePanel createCasePanel = new CreateCasePanel();
	private EditCompanyPanel editCompanyPanel = new EditCompanyPanel();
	private EditPersonPanel editPersonPanel = new EditPersonPanel();
	private EditCaseResearchersPanel editCaseResearchersPanel = new EditCaseResearchersPanel();
	private ViewCasePanel viewCasePanel = new ViewCasePanel();
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

	/**
	 * Initialize the GUI frame
	 */
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

		horizontalStrut = Box.createHorizontalStrut(140);
		frame.getContentPane().add(horizontalStrut, BorderLayout.WEST);

		horizontalStrut_1 = Box.createHorizontalStrut(140);
		frame.getContentPane().add(horizontalStrut_1, BorderLayout.EAST);
		frame.setVisible(true);
	}

	/**
	 * the login menu of the GUI.
	 */
	public void login() {
		if (layout.getLayoutComponent(BorderLayout.CENTER) != null) {
			layout.getLayoutComponent(BorderLayout.CENTER).setVisible(false);
			frame.getContentPane().remove(
					layout.getLayoutComponent(BorderLayout.CENTER));
		}

		frame.getContentPane().add(loginPanel, BorderLayout.CENTER);
		loginPanel.setVisible(true);
	}

	/**
	 * The main menu of the GUI, it distributes the user.
	 * 
	 * @param jobPos
	 */
	public void menu(int jobPos) {
		layout.getLayoutComponent(BorderLayout.CENTER).setVisible(false);
		frame.getContentPane().remove(
				layout.getLayoutComponent(BorderLayout.CENTER));
		switch (jobPos) {
		case 0:
			// for the sysadmin when it gets implemented
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

	/**
	 * Find persons windows of the GUI.
	 * 
	 * @param persons
	 */

	public void createPersonMenu() {
		// remove previous panel
		layout.getLayoutComponent(BorderLayout.CENTER).setVisible(false);
		frame.getContentPane().remove(
				layout.getLayoutComponent(BorderLayout.CENTER));
		// add the panel to the frame
		frame.getContentPane().add(createPersonPanel);
		createPersonPanel.setVisible(true);
	}
	
	/**
	 * The menu to create a new company in the database
	 */
	public void createCompanyMenu() {
		// remove previous panel
		layout.getLayoutComponent(BorderLayout.CENTER).setVisible(false);
		frame.getContentPane().remove(
				layout.getLayoutComponent(BorderLayout.CENTER));
		// add the panel to the frame
		frame.getContentPane().add(createCompanyPanel);
		createCompanyPanel.setVisible(true);
	}

	/**
	 * The menu to create a new case in the database
	 */
	public void createCaseMenu() {
		// remove previous panel
		layout.getLayoutComponent(BorderLayout.CENTER).setVisible(false);
		frame.getContentPane().remove(
				layout.getLayoutComponent(BorderLayout.CENTER));
		// add the panel to the frame
		frame.getContentPane().add(createCasePanel);
		createCasePanel.setVisible(true);
	}

	/**
	 * The menu to find a person from the database, takes an ArrayList<PersonDTO> as parameter
	 * to show the found persons from the database
	 * @param persons
	 */
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

	/**
	 * The menu to find a company from the database, takes an ArrayList<CompanyDTO> as parameter
	 * to show the found companies from the database
	 * @param companies
	 */
	public void findCompanyMenu(ArrayList<CompanyDTO> companies) {
		findCompanyPanel.clearPrevList();
		findCompanyPanel.fillList(companies);
		// remove previous panel
		layout.getLayoutComponent(BorderLayout.CENTER).setVisible(false);
		frame.getContentPane().remove(
				layout.getLayoutComponent(BorderLayout.CENTER));
		// add the panel to the frame
		frame.getContentPane().add(findCompanyPanel);
		findCompanyPanel.setVisible(true);
	}

	/**
	 * The menu to find a case from the database, takes an ArrayList<CaseDTO> as parameter
	 * to show the found cases from the database
	 * @param cases
	 */
	public void findCaseMenu(ArrayList<CaseDTO> cases) {
		findCasePanel.clearPrevList();
		findCasePanel.fillList(cases);
		// remove previous panel
		layout.getLayoutComponent(BorderLayout.CENTER).setVisible(false);
		frame.getContentPane().remove(
				layout.getLayoutComponent(BorderLayout.CENTER));
		// add the panel to the frame
		frame.getContentPane().add(findCasePanel);
		findCasePanel.setVisible(true);
	}

	public void editPersonMenu(PersonDTO person) {
		editPersonPanel.fillTextBoxes(person);
		// remove previous panel
		layout.getLayoutComponent(BorderLayout.CENTER).setVisible(false);
		frame.getContentPane().remove(
				layout.getLayoutComponent(BorderLayout.CENTER));

		// Add the new panel to the frame
		frame.getContentPane().add(editPersonPanel);
		editPersonPanel.setVisible(true);
	}

	public void editCaseMenu(ArrayList<ResearcherDTO> researchersOnCase,
			ArrayList<ResearcherDTO> researchersAvailable) {
		editCaseResearchersPanel.clearLists();
		editCaseResearchersPanel.fillLists(researchersOnCase,
				researchersAvailable);
		// remove previous panel
		layout.getLayoutComponent(BorderLayout.CENTER).setVisible(false);
		frame.getContentPane().remove(
				layout.getLayoutComponent(BorderLayout.CENTER));

		// Add the new panel to the frame
		frame.getContentPane().add(editCaseResearchersPanel);
		editCaseResearchersPanel.setVisible(true);

	}

	public void editCompanyMenu(CompanyDTO company) {
		editCompanyPanel.fillTextBoxes(company);
		// remove previous panel
		layout.getLayoutComponent(BorderLayout.CENTER).setVisible(false);
		frame.getContentPane().remove(
				layout.getLayoutComponent(BorderLayout.CENTER));

		// Add the new panel to the frame
		frame.getContentPane().add(editCompanyPanel);
		editCompanyPanel.setVisible(true);

	}

	public void viewCase(String caseName, String partnerName,
			ArrayList<ResearcherDTO> researchersOnCase,
			ArrayList<CandidateDTO> candidates) {
		viewCasePanel.clearLists();
		viewCasePanel.fillListsAndLabels(caseName, partnerName, researchersOnCase,
				candidates);
		// remove previous panel
		layout.getLayoutComponent(BorderLayout.CENTER).setVisible(false);
		frame.getContentPane().remove(
				layout.getLayoutComponent(BorderLayout.CENTER));

		// Add the new panel to the frame
		frame.getContentPane().add(viewCasePanel);
		viewCasePanel.setVisible(true);

	}


}
