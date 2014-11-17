package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import domain.CompanyDTO;
import domain.MainController;

@SuppressWarnings("serial")
public class CreateCompanyPanel extends JPanel {
	private JTextField companyNameTextField;
	private JTextField mainCodeTextField;
	private JTextField companyAddressTextField;
	private JTextField CEOTextField;
	private JTextField companyPhoneTextField;
	private JTextField CFOTextField;

	/**
	 * Create the panel.
	 */
	public CreateCompanyPanel() {
		setLayout(null);

		JLabel companyNameLabel = new JLabel("Firma navn");
		companyNameLabel.setBounds(76, 38, 64, 16);
		add(companyNameLabel);

		companyNameTextField = new JTextField();
		companyNameTextField.setBounds(75, 56, 116, 22);
		add(companyNameTextField);
		companyNameTextField.setColumns(10);

		JLabel mainCodeLabel = new JLabel("Hovedkode");
		mainCodeLabel.setBounds(236, 38, 62, 16);
		add(mainCodeLabel);

		mainCodeTextField = new JTextField();
		mainCodeTextField.setBounds(236, 56, 116, 22);
		add(mainCodeTextField);
		mainCodeTextField.setColumns(10);

		JLabel companyAddressLabel = new JLabel("Firma addresse");
		companyAddressLabel.setBounds(76, 91, 89, 16);
		add(companyAddressLabel);

		companyAddressTextField = new JTextField();
		companyAddressTextField.setBounds(76, 109, 116, 22);
		add(companyAddressTextField);
		companyAddressTextField.setColumns(10);

		JLabel CEOLabel = new JLabel("CEO");
		CEOLabel.setBounds(236, 91, 56, 16);
		add(CEOLabel);

		CEOTextField = new JTextField();
		CEOTextField.setBounds(236, 109, 116, 22);
		add(CEOTextField);
		CEOTextField.setColumns(10);

		JLabel companyPhoneLabel = new JLabel("Firma Tlf");
		companyPhoneLabel.setBounds(76, 144, 56, 16);
		add(companyPhoneLabel);

		JLabel CFOLabel = new JLabel("CFO");
		CFOLabel.setBounds(236, 144, 56, 16);
		add(CFOLabel);

		companyPhoneTextField = new JTextField();
		companyPhoneTextField.setBounds(75, 162, 116, 22);
		add(companyPhoneTextField);
		companyPhoneTextField.setColumns(10);

		CFOTextField = new JTextField();
		CFOTextField.setBounds(236, 162, 116, 22);
		add(CFOTextField);
		CFOTextField.setColumns(10);

		JButton goBackBtn = new JButton("Gå tilbage");
		goBackBtn.setBounds(76, 197, 97, 25);
		add(goBackBtn);

		JButton logoutBtn = new JButton("Log ud");
		logoutBtn.setBounds(255, 197, 97, 25);
		add(logoutBtn);

		JButton saveBtn = new JButton("Gem");
		saveBtn.setBounds(167, 235, 97, 25);
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

				MainController.getInstance().createCompany(
						new CompanyDTO(companyNameTextField.getText(),
								mainCodeTextField.getText(),
								companyAddressTextField.getText(),
								companyPhoneTextField.getText(), CEOTextField
										.getText(), CFOTextField.getText()));

			}
		});
	}

}
