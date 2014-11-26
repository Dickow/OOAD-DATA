package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import domain.MainController;
import domain.PersonDTO;

@SuppressWarnings("serial")
public class AddCandidatePanel extends JPanel {
	private JTextField textField;
	private DefaultListModel<String> listModel = new DefaultListModel<String>();
	private JList<String> list = new JList<String>(listModel);

	/**
	 * Create the panel.
	 */
	public AddCandidatePanel() {
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 317, 205);
		add(scrollPane);

		scrollPane.setViewportView(list);

		JButton logoutBtn = new JButton("Log ud");
		logoutBtn.setBounds(12, 246, 97, 25);
		add(logoutBtn);

		JButton goBackBtn = new JButton("Menu");
		goBackBtn.setBounds(121, 246, 97, 25);
		add(goBackBtn);

		textField = new JTextField();
		textField.setBounds(12, 220, 206, 25);
		add(textField);
		textField.setColumns(10);

		JButton searchBtn = new JButton("Søg");
		searchBtn.setBounds(230, 220, 97, 25);
		add(searchBtn);

		JButton addBtn = new JButton("Tilføj");
		addBtn.setBounds(230, 246, 97, 25);
		add(addBtn);

		goBackBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainController.getInstance().goBack(
						MainController.getInstance().getCurrentEmployee());

			}
		});

		logoutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainController.getInstance().menuDistributor(6);

			}
		});

		searchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String chosenPerson = textField.getText();
				MainController.getInstance().findAvailableCandidates(
						chosenPerson);

			}
		});

		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String chosenCandidate = list.getSelectedValue();
				MainController.getInstance().addCandidateToCaseInDatabase(
						chosenCandidate);

			}
		});

	}

	public void clearList() {
		listModel.clear();
	}

	public void fillList(ArrayList<PersonDTO> availableCandidates) {

		if (!availableCandidates.isEmpty()) {
			for (int i = 0; i < availableCandidates.size(); i++) {
				listModel.addElement("id: " +availableCandidates.get(i).getPersonId()+ ", navn: "
						+ availableCandidates.get(i).getName()
						+ ", Nuværende job: "
						+ availableCandidates.get(i).getCurrentJob());
			}
		}
	}
}
