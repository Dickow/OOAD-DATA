package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import domain.CandidateDTO;
import domain.CaseDTO;
import domain.CompanyDTO;
import domain.EmployeeDTO;
import domain.PersonDTO;

public class GUI {

	private JFrame mainFrame;
	private JLabel companyText, login1, login2, errorLabel;
	private JPasswordField password;
	private JTextField userId;
	private JButton loginButton;
	private String[] loginInfo = new String[2];
	private boolean ready;

	public GUI() {
		this.prepareGUI();
	}

	public void prepareGUI() {
		mainFrame = new JFrame("Odgers Berndtson");
		mainFrame.setSize(800, 600);
		BoxLayout layoutManager = new BoxLayout(mainFrame.getContentPane(),BoxLayout.Y_AXIS);
		mainFrame.setLayout(layoutManager);

		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});

	}

	// TODO
	public String[] login() {
		loginButton = new JButton("Login");
		password = new JPasswordField();
		userId = new JTextField();
		companyText = new JLabel("Odgers Berndtson");
		login1 = new JLabel("bruger id");
		login2 = new JLabel("password");
		errorLabel = new JLabel();
		ready = false;
		loginInfo[0] = "";
		loginInfo[1] = "";

		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (userId.getText() == null
						|| password.getPassword().length == 0) {
					errorLabel
							.setText("Du har glemt at indtaste brugerId eller password");
					errorLabel.setBackground(Color.RED);
					errorLabel.setVisible(true);
				} else {
					loginInfo[0] = userId.getText().trim();
					loginInfo[1] = new String(password.getPassword());
					ready = true;
				}

			}

		});
		errorLabel.setVisible(false);
//		companyText.setSize(500, 300);
		companyText.setFont(new Font("Serif", Font.BOLD, 28));
		login1.setFont(new Font("Calibri",Font.PLAIN,20));
		login2.setFont(new Font("Calibri",Font.PLAIN,20));
		userId.setPreferredSize(new Dimension(100,50));
//		login1.setSize(100, 50);
//		login2.setSize(100, 50);
//		loginButton.setSize(100, 50);
//		userId.setSize(100, 50);
		
		mainFrame.getContentPane().add(errorLabel);
		mainFrame.getContentPane().add(companyText);
		mainFrame.getContentPane().add(login1);
		mainFrame.getContentPane().add(userId);
		mainFrame.getContentPane().add(login2);
		mainFrame.getContentPane().add(password);
		mainFrame.getContentPane().add(loginButton);
		companyText.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainFrame.setVisible(true);
		while (!ready) {
			System.out.println("not done");
		}

		return loginInfo;
	}

	// TODO
	public PersonDTO editPerson(PersonDTO person) {

		return new PersonDTO();
	}

	// TODO
	public PersonDTO findPerson(List<PersonDTO> personer) {
		return new PersonDTO();
	}

	// TODO
	public PersonDTO createPerson() {
		return new PersonDTO();
	}

	// TODO
	public EmployeeDTO createEmployee() {
		return new EmployeeDTO();
	}

	// TODO
	public EmployeeDTO findEmployee(List<EmployeeDTO> employers) {
		return new EmployeeDTO();
	}

	// TODO
	public EmployeeDTO editEmployee(EmployeeDTO employee) {
		return new EmployeeDTO();
	}

	// TODO
	public CaseDTO createCase() {
		return new CaseDTO();
	}

	// TODO
	public CaseDTO findCase(List<CaseDTO> cases) {
		return new CaseDTO();
	}

	// TODO
	public CaseDTO editCase(CaseDTO Case) {
		return new CaseDTO();
	}

	// TODO
	public CompanyDTO createCompany() {
		return new CompanyDTO();
	}

	// TODO
	public CompanyDTO findCompany(List<CompanyDTO> companies) {
		return new CompanyDTO();
	}

	// TODO
	public CompanyDTO editCompany(CompanyDTO company) {
		return new CompanyDTO();
	}

	// TODO
	public CandidateDTO findCandidate(List<CandidateDTO> candidates) {
		return new CandidateDTO();
	}

	// TODO
	public CandidateDTO addCandidate() {
		return new CandidateDTO();
	}

	// TODO
	public CandidateDTO editCandidate(CandidateDTO candidate) {
		return new CandidateDTO();
	}
}
