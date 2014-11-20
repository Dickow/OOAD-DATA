package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.CompanyDTO;
import domain.MainController;

@SuppressWarnings("serial")
public class EditCompanyPanel extends JPanel {
	private JTextField companyNameTextField;
	private JTextField mainCodeTextField;
	private JTextField companyAdressTextField;
	private JTextField ceoTextField;
	private JTextField companyphoneTextField;
	private JTextField cfoTextField;

	/**
	 * Create the panel.
	 */
	public EditCompanyPanel() {
		setLayout(null);

		JLabel companyNameLabel = new JLabel("Firma navn");
		companyNameLabel.setBounds(82, 35, 64, 16);
		add(companyNameLabel);

		companyNameTextField = new JTextField();
		companyNameTextField.setColumns(10);
		companyNameTextField.setBounds(81, 53, 116, 22);
		add(companyNameTextField);

		JLabel mainCodeLabel = new JLabel("Hovedkode");
		mainCodeLabel.setBounds(242, 35, 62, 16);
		add(mainCodeLabel);

		mainCodeTextField = new JTextField();
		mainCodeTextField.setColumns(10);
		mainCodeTextField.setBounds(242, 53, 116, 22);
		add(mainCodeTextField);

		JLabel companyAdressLabel = new JLabel("Firma addresse");
		companyAdressLabel.setBounds(82, 88, 89, 16);
		add(companyAdressLabel);

		companyAdressTextField = new JTextField();
		companyAdressTextField.setColumns(10);
		companyAdressTextField.setBounds(82, 106, 116, 22);
		add(companyAdressTextField);

		JLabel ceoLabel = new JLabel("CEO");
		ceoLabel.setBounds(242, 88, 56, 16);
		add(ceoLabel);

		ceoTextField = new JTextField();
		ceoTextField.setColumns(10);
		ceoTextField.setBounds(242, 106, 116, 22);
		add(ceoTextField);

		JLabel companyphoneLabel = new JLabel("Firma Tlf");
		companyphoneLabel.setBounds(82, 141, 56, 16);
		add(companyphoneLabel);

		JLabel cfoLabel = new JLabel("CFO");
		cfoLabel.setBounds(242, 141, 56, 16);
		add(cfoLabel);

		companyphoneTextField = new JTextField();
		companyphoneTextField.setColumns(10);
		companyphoneTextField.setBounds(81, 159, 116, 22);
		add(companyphoneTextField);

		cfoTextField = new JTextField();
		cfoTextField.setColumns(10);
		cfoTextField.setBounds(242, 159, 116, 22);
		add(cfoTextField);

		JButton goBackBtn = new JButton("Gå tilbage");
		goBackBtn.setBounds(82, 194, 97, 25);
		add(goBackBtn);

		JButton logoutBtn = new JButton("Log ud");
		logoutBtn.setBounds(261, 194, 97, 25);
		add(logoutBtn);

		JButton saveBtn = new JButton("Gem");
		saveBtn.setBounds(173, 232, 97, 25);
		add(saveBtn);

		goBackBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainController.getInstance().goBack(
						MainController.getInstance().getCurrentEmployee());

			}
		});

		logoutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainController.getInstance().menuDistributor(6);

			}
		});

		saveBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainController.getInstance().editCompanyInDatabase(
						new CompanyDTO(companyNameTextField.getText(),
								mainCodeTextField.getText(),
								companyAdressTextField.getText(),
								companyphoneTextField.getText(), ceoTextField
										.getText(), cfoTextField.getText()));

			}
		});
	}

	public void fillTextBoxes(CompanyDTO company) {
		companyNameTextField.setText(company.getCompanyName());
		companyAdressTextField.setText(company.getCompanyAddress());
		companyphoneTextField.setText(company.getCompanyPhone());
		mainCodeTextField.setText(company.getMainCode());
		ceoTextField.setText(company.getCEO());
		cfoTextField.setText(company.getCFO());

	}
}
