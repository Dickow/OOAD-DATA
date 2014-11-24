package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import domain.MainController;
import domain.ResearcherDTO;

@SuppressWarnings("serial")
public class EditCaseResearchersPanel extends JPanel {
	private DefaultListModel<String> listModelOnCase = new DefaultListModel<String>();
	private DefaultListModel<String> listModelAvailable = new DefaultListModel<String>();
	private JList<String> researchersOnCaseList = new JList<String>(
			listModelOnCase);
	private JList<String> availableResearchersList = new JList<String>(
			listModelAvailable);

	/**
	 * Create the panel.
	 */
	public EditCaseResearchersPanel() {
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 40, 206, 197);
		add(scrollPane);

		researchersOnCaseList
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(researchersOnCaseList);

		JButton addResearchersBtn = new JButton("Tilføj");
		addResearchersBtn.setBounds(230, 250, 61, 25);
		add(addResearchersBtn);

		JButton removeResearcherBtn = new JButton("Fjern");
		removeResearcherBtn.setBounds(155, 250, 63, 25);
		add(removeResearcherBtn);

		JButton logoutBtn = new JButton("Log ud");
		logoutBtn.setBounds(12, 250, 71, 25);
		add(logoutBtn);

		JButton goBackBtn = new JButton("Gå tilbage");
		goBackBtn.setBounds(349, 250, 89, 25);
		add(goBackBtn);

		JLabel researchersOnCaseLabel = new JLabel("Researchers på sagen");
		researchersOnCaseLabel.setBounds(44, 11, 127, 16);
		add(researchersOnCaseLabel);

		JLabel researchersAvailable = new JLabel("Tilgængelige Researchers");
		researchersAvailable.setBounds(260, 11, 148, 16);
		add(researchersAvailable);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(232, 40, 206, 197);
		add(scrollPane_1);

		scrollPane_1.setViewportView(availableResearchersList);
		availableResearchersList
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		addResearchersBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String chosenAvailableResearcher = availableResearchersList
						.getSelectedValue();
				if (chosenAvailableResearcher != null) {
					MainController.getInstance().addResearcherToCaseInDatabase(
							chosenAvailableResearcher);
				}
			}
		});

		removeResearcherBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String chosenResearcherOnCase = researchersOnCaseList
						.getSelectedValue();
				if (chosenResearcherOnCase != null) {
					MainController.getInstance()
							.removeResearcherFromCaseInDatabase(
									chosenResearcherOnCase);
				}
			}
		});

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
	}

	public void clearLists() {
		listModelOnCase.clear();
		listModelAvailable.clear();
	}

	public void fillLists(ArrayList<ResearcherDTO> researchersOnCase,
			ArrayList<ResearcherDTO> researchersAvailable) {
		for (int i = 0; i < researchersOnCase.size(); i++) {
			listModelOnCase.addElement("id : "
					+ researchersOnCase.get(i).getEmployeeId() + ", navn : "
					+ researchersOnCase.get(i).getName());
		}
		for (int i = 0; i < researchersAvailable.size(); i++) {
			listModelAvailable.addElement("id : "
					+ researchersAvailable.get(i).getEmployeeId() + ", navn : "
					+ researchersAvailable.get(i).getName());
		}

	}
}
