package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import domain.CandidateDTO;
import domain.MainController;
import domain.ResearcherDTO;

@SuppressWarnings("serial")
public class ViewCasePanel extends JPanel {
	private DefaultListModel<String> researcherListModel = new DefaultListModel<String>();
	private JList<String> researcherList = new JList<String>(
			researcherListModel);
	private DefaultListModel<String> candidateListModel = new DefaultListModel<String>();
	private JList<String> candidatesList = new JList<String>(candidateListModel);
	private JLabel caseNameLabel = new JLabel("Sags navn");
	private JLabel partnerNameLabel = new JLabel("Partner navn");

	/**
	 * Create the panel.
	 */
	public ViewCasePanel() {
		setLayout(null);

		caseNameLabel.setBounds(22, 196, 134, 16);
		add(caseNameLabel);

		partnerNameLabel.setBounds(168, 196, 74, 16);
		add(partnerNameLabel);

		researcherList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		researcherList.setBounds(12, 42, 183, 141);
		add(researcherList);

		JLabel researchersLabel = new JLabel("Researchers");
		researchersLabel.setBounds(57, 13, 71, 16);
		add(researchersLabel);

		candidatesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		candidatesList.setBounds(207, 43, 203, 141);
		add(candidatesList);

		JLabel candidateLabel = new JLabel("Kandidater");
		candidateLabel.setBounds(261, 13, 61, 16);
		add(candidateLabel);

		JButton logoutBtn = new JButton("Log ud");
		logoutBtn.setBounds(131, 236, 97, 25);
		add(logoutBtn);

		JButton goBackBtn = new JButton("Gå tilbage");
		goBackBtn.setBounds(22, 236, 97, 25);
		add(goBackBtn);

		JButton updateStatusBtn = new JButton("Opdater status");
		updateStatusBtn.setBounds(293, 192, 117, 25);
		add(updateStatusBtn);
		
		JButton addCandidateBtn = new JButton("Tilføj kandidat");
		addCandidateBtn.setBounds(293, 236, 117, 25);
		add(addCandidateBtn);

		logoutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainController.getInstance().menuDistributor(6);

			}
		});

		goBackBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainController.getInstance().goBack(
						MainController.getInstance().getCurrentEmployee());

			}
		});

		updateStatusBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String chosenCandidate = candidatesList.getSelectedValue();
				MainController.getInstance().updateStatusOfCandidate(
						chosenCandidate);

			}
		});
		addCandidateBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	public void clearLists() {
		researcherListModel.clear();
		candidateListModel.clear();
	}

	public void fillListsAndLabels(String caseName, String partnerName,
			ArrayList<ResearcherDTO> researchers,
			ArrayList<CandidateDTO> candidates) {
		caseNameLabel.setText("Sags navn: " +caseName);
		partnerNameLabel.setText("Partner navn: " +partnerName);

		for (int i = 0; i < researchers.size(); i++) {
			researcherListModel.addElement("Researcher ID : "
					+ researchers.get(i).getEmployeeId());
		}
		for (int i = 0; i < candidates.size(); i++) {
			candidateListModel.addElement("Kandidat ID : "
					+ candidates.get(i).getCandidateId() + ", Status : "
					+ candidates.get(i).getStatus());
		}
	}
}
