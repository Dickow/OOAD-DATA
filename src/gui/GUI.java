package gui;

import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;

import domain.CandidateDTO;
import domain.CaseDTO;
import domain.CompanyDTO;
import domain.EmployeeDTO;
import domain.PersonDTO;

public class GUI {

	private JFrame mainFrame;

	public GUI() {
		this.prepareGUI();
	}

	public void prepareGUI() {
		GridBagLayout layoutManager = new GridBagLayout();
		mainFrame = new JFrame("Odgers Berndtson");
		mainFrame.setSize(400, 400);
		mainFrame.setLayout(layoutManager);

		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		
		mainFrame.setVisible(true);
	}

	// TODO
	public String[] login() {
		String[] loginInfo = new String[2];
		loginInfo[0] = "";
		loginInfo[1] = "";

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
