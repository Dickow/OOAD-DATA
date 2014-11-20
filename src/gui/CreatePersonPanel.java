package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import domain.MainController;
import domain.PersonDTO;

@SuppressWarnings("serial")
public class CreatePersonPanel extends JPanel {
	private JTextField nameTextField;
	private JTextField addressTextField;
	private JTextField educationTextField;
	private JTextField phoneTextField;
	private JTextField cellTextField;
	private JTextField companyEmailTextField;
	private JTextField privateMailTextField;
	private JTextField ageTextField;
	private JTextField salaryTextField;
	private JTextField jobTextField;

	/**
	 * Create the panel.
	 */
	public CreatePersonPanel() {
		setLayout(null);

		JLabel nameLabel = new JLabel("Navn");
		nameLabel.setBounds(50, 38, 56, 16);
		add(nameLabel);

		nameTextField = new JTextField();
		nameTextField.setBounds(12, 56, 116, 22);
		add(nameTextField);
		nameTextField.setColumns(10);

		JLabel addressLabel = new JLabel("Addresse");
		addressLabel.setBounds(50, 91, 56, 16);
		add(addressLabel);

		addressTextField = new JTextField();
		addressTextField.setBounds(12, 109, 116, 22);
		add(addressTextField);
		addressTextField.setColumns(10);

		JLabel educationLabel = new JLabel("Uddannelse");
		educationLabel.setBounds(50, 144, 66, 16);
		add(educationLabel);

		educationTextField = new JTextField();
		educationTextField.setBounds(12, 162, 116, 22);
		add(educationTextField);
		educationTextField.setColumns(10);

		JLabel phoneLabel = new JLabel("TLF");
		phoneLabel.setBounds(50, 197, 56, 16);
		add(phoneLabel);

		phoneTextField = new JTextField();
		phoneTextField.setBounds(12, 217, 116, 22);
		add(phoneTextField);
		phoneTextField.setColumns(10);

		JLabel cellLabel = new JLabel("Mobil");
		cellLabel.setBounds(180, 38, 56, 16);
		add(cellLabel);

		cellTextField = new JTextField();
		cellTextField.setBounds(149, 56, 116, 22);
		add(cellTextField);
		cellTextField.setColumns(10);

		JLabel companyEmailLabel = new JLabel("Firma Email");
		companyEmailLabel.setBounds(180, 91, 68, 16);
		add(companyEmailLabel);

		companyEmailTextField = new JTextField();
		companyEmailTextField.setBounds(149, 109, 116, 22);
		add(companyEmailTextField);
		companyEmailTextField.setColumns(10);

		JLabel privateMail = new JLabel("Privat Email");
		privateMail.setBounds(180, 144, 67, 16);
		add(privateMail);

		privateMailTextField = new JTextField();
		privateMailTextField.setBounds(149, 162, 116, 22);
		add(privateMailTextField);
		privateMailTextField.setColumns(10);

		JLabel ageLabel = new JLabel("Alder");
		ageLabel.setBounds(180, 197, 56, 16);
		add(ageLabel);

		ageTextField = new JTextField("dd-mm-yyyy");
		ageTextField.setBounds(149, 217, 116, 22);
		add(ageTextField);
		ageTextField.setColumns(10);

		JLabel salaryLabel = new JLabel("Løn");
		salaryLabel.setBounds(317, 38, 56, 16);
		add(salaryLabel);

		salaryTextField = new JTextField();
		salaryTextField.setBounds(290, 56, 116, 22);
		add(salaryTextField);
		salaryTextField.setColumns(10);

		JLabel jobLabel = new JLabel("Nuværende Job");
		jobLabel.setBounds(300, 91, 88, 16);
		add(jobLabel);

		jobTextField = new JTextField();
		jobTextField.setBounds(290, 109, 116, 22);
		add(jobTextField);
		jobTextField.setColumns(10);

		JLabel noteLabel = new JLabel("Note");
		noteLabel.setBounds(317, 144, 56, 16);
		add(noteLabel);

		final JTextArea noteTextArea = new JTextArea();
		noteTextArea.setBounds(290, 162, 116, 77);
		add(noteTextArea);

		JButton saveBtn = new JButton("Gem");
		saveBtn.setBounds(168, 251, 97, 25);
		add(saveBtn);

		JButton btnLogUd = new JButton("Log ud");
		btnLogUd.setBounds(12, 252, 97, 25);
		add(btnLogUd);

		JButton btnGTilbage = new JButton("G\u00E5 tilbage");
		btnGTilbage.setBounds(309, 252, 97, 25);
		add(btnGTilbage);

		saveBtn.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String date = ageTextField.getText();
				Date dateOfBirth = new Date(0, 0, 0);

				MainController.getInstance().createPerson(
						new PersonDTO(nameTextField.getText(), addressTextField
								.getText(), educationTextField.getText(),
								jobTextField.getText(), phoneTextField
										.getText(), companyEmailTextField
										.getText(), privateMailTextField
										.getText(), cellTextField.getText(),
								noteTextArea.getText(), -1, dateOfBirth, 0),
						date, salaryTextField.getText());

			}
		});

		btnLogUd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainController.getInstance().menuDistributor(6);

			}
		});
		btnGTilbage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainController.getInstance().goBack(
						MainController.getInstance().getCurrentEmployee());

			}
		});
	}
}
