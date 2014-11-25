package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import domain.MainController;
import domain.PersonDTO;

@SuppressWarnings("serial")
public class FindPersonPanel extends JPanel {
	private JTextField searchPersonTextField;
	private DefaultListModel<String> listModel = new DefaultListModel<String>();
	private JList<String> list = new JList<String>(listModel);

	/**
	 * Create the panel.
	 */
	public FindPersonPanel() {
		setLayout(null);
		JButton editChosenBtn = new JButton("Rediger");
		editChosenBtn.setBounds(12, 262, 83, 25);
		add(editChosenBtn);

		JButton goBackBtn = new JButton("Gå tilbage");
		goBackBtn.setBounds(196, 262, 102, 25);
		add(goBackBtn);

		JButton logOutBtn = new JButton("Log ud");
		logOutBtn.setBounds(107, 262, 77, 25);
		add(logOutBtn);

		searchPersonTextField = new JTextField();
		searchPersonTextField.setBounds(12, 237, 286, 22);
		add(searchPersonTextField);
		searchPersonTextField.setColumns(10);

		JButton searchPersonBtn = new JButton("Søg");
		searchPersonBtn.setBounds(304, 236, 68, 25);
		add(searchPersonBtn);

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(12, 13, 286, 211);
		add(list);

		editChosenBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String chosenPerson = list.getSelectedValue();
				MainController.getInstance().editChosenPerson(chosenPerson);
			}
		});
		goBackBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainController.getInstance().goBack(
						MainController.getInstance().getCurrentEmployee());
			}
		});
		logOutBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int menuChoice = 6;
				MainController.getInstance().menuDistributor(menuChoice);
			}
		});
		searchPersonBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String searchField = searchPersonTextField.getText();
				MainController.getInstance().findPerson(searchField);

			}
		});

	}

	public void clearPrevList() {
		// clear the list
		listModel.clear();
	}

	public void fillList(ArrayList<PersonDTO> personList) {
		// Fill the list with new arguments
		if (!personList.isEmpty()) {
			for (int i = 0; i < personList.size(); i++) {
				listModel.addElement("id: "
						+ personList.get(i).getPersonId() + ", navn: "
						+ personList.get(i).getName());
			}
		}

	}
}
