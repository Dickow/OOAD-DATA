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
import javax.swing.ListSelectionModel;

import domain.CompanyDTO;
import domain.MainController;

@SuppressWarnings("serial")
public class FindCompanyPanel extends JPanel {
	private JTextField searchTextField;
	private DefaultListModel<String> listModel = new DefaultListModel<String>();
	private JList<String> list = new JList<String>(listModel);

	/**
	 * Create the panel.
	 */
	public FindCompanyPanel() {
		setLayout(null);

		JButton editBtn = new JButton("Rediger");
		editBtn.setBounds(12, 262, 83, 25);
		add(editBtn);

		JButton goBackBtn = new JButton("G\u00E5 tilbage");
		goBackBtn.setBounds(196, 262, 102, 25);
		add(goBackBtn);

		JButton logoutBtn = new JButton("Log ud");
		logoutBtn.setBounds(107, 262, 77, 25);
		add(logoutBtn);

		searchTextField = new JTextField();
		searchTextField.setColumns(10);
		searchTextField.setBounds(12, 237, 286, 22);
		add(searchTextField);

		JButton searchBtn = new JButton("S\u00F8g");
		searchBtn.setBounds(306, 236, 68, 25);
		add(searchBtn);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 286, 214);
		add(scrollPane);

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);

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
		editBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String chosenCompany = list.getSelectedValue(); 
				MainController.getInstance().editChosenCompany(chosenCompany);; 

			}
		});
		searchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String searchField = searchTextField.getText();
				MainController.getInstance().findCompany(searchField);

			}
		});
	}

	public void clearPrevList() {
		// clear the list
		listModel.clear();
	}

	public void fillList(ArrayList<CompanyDTO> personList) {
		// Fill the list with new arguments
		if (!personList.isEmpty()) {
			for (int i = 0; i < personList.size(); i++) {
				listModel.addElement("Firma navn: "
						+ personList.get(i).getCompanyName() + ", addresse: "
						+ personList.get(i).getCompanyAddress());
			}
		}

	}

}
