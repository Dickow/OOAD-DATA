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

import domain.CaseDTO;
import domain.MainController;

@SuppressWarnings("serial")
public class FindCasePanel extends JPanel {
	private JTextField searchTextField;
	private DefaultListModel<String> listModel = new DefaultListModel<String>();
	private JList<String> list = new JList<String>(listModel);

	/**
	 * Create the panel.
	 */
	public FindCasePanel() {
		setLayout(null);

		JButton editBtn = new JButton("Rediger");
		editBtn.setBounds(10, 259, 83, 25);
		add(editBtn);

		JButton goBackBtn = new JButton("G\u00E5 tilbage");
		goBackBtn.setBounds(194, 259, 89, 25);
		add(goBackBtn);

		JButton logoutBtn = new JButton("Log ud");
		logoutBtn.setBounds(105, 259, 77, 25);
		add(logoutBtn);

		searchTextField = new JTextField();
		searchTextField.setColumns(10);
		searchTextField.setBounds(10, 234, 273, 22);
		add(searchTextField);

		JButton searchBtn = new JButton("S\u00F8g");
		searchBtn.setBounds(295, 233, 68, 25);
		add(searchBtn);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 273, 214);
		add(scrollPane);

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		
		JButton viewCaseBtn = new JButton("Se sag");
		viewCaseBtn.setBounds(295, 259, 97, 25);
		add(viewCaseBtn);
		
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
				String chosenCase = list.getSelectedValue();
				MainController.getInstance().editChosenCase(chosenCase);
				;

			}
		});
		searchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String searchField = searchTextField.getText();
				MainController.getInstance().findCase(searchField);

			}
		});
		viewCaseBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String chosenCase = list.getSelectedValue(); 
				MainController.getInstance().viewSpecificCase(chosenCase);
			}
		});
	}

	public void clearPrevList() {
		// clear the list
		listModel.clear();
	}

	public void fillList(ArrayList<CaseDTO> personList) {
		// Fill the list with new arguments
		if (!personList.isEmpty()) {
			for (int i = 0; i < personList.size(); i++) {
				listModel.addElement("Sags navn: "
						+ personList.get(i).getCaseName() + ", firma navn: "
						+ personList.get(i).getCompanyName());
			}
		}

	}

}
