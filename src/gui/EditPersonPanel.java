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
public class EditPersonPanel extends JPanel {
	private JTextField nameTextField;
	private JTextField adressTextField;
	private JTextField educationTextField;
	private JTextField tlfTextField;
	private JTextField cellTextField;
	private JTextField companyMailTextField;
	private JTextField privateMailTextField;
	private JTextField salaryTextField;
	private JTextField jobTextField;
	private JTextArea noteTextArea;
	// 2 variables that cannot be edited but needs to be saved for later return
	// values.
	private int personId;
	private Date dateOfBirth;

	/**
	 * Create the panel.
	 */
	public EditPersonPanel() {
		setLayout(null);

		JLabel nameLabel = new JLabel("Navn");
		nameLabel.setBounds(61, 27, 56, 16);
		add(nameLabel);

		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(23, 45, 116, 22);
		add(nameTextField);

		JLabel adressLabel = new JLabel("Addresse");
		adressLabel.setBounds(61, 80, 56, 16);
		add(adressLabel);

		adressTextField = new JTextField();
		adressTextField.setColumns(10);
		adressTextField.setBounds(23, 98, 116, 22);
		add(adressTextField);

		JLabel educationLabel = new JLabel("Uddannelse");
		educationLabel.setBounds(61, 133, 66, 16);
		add(educationLabel);

		educationTextField = new JTextField();
		educationTextField.setColumns(10);
		educationTextField.setBounds(23, 151, 116, 22);
		add(educationTextField);

		JLabel tlfLabel = new JLabel("TLF");
		tlfLabel.setBounds(61, 186, 56, 16);
		add(tlfLabel);

		tlfTextField = new JTextField();
		tlfTextField.setColumns(10);
		tlfTextField.setBounds(23, 206, 116, 22);
		add(tlfTextField);

		JLabel cellLabel = new JLabel("Mobil");
		cellLabel.setBounds(191, 27, 56, 16);
		add(cellLabel);

		cellTextField = new JTextField();
		cellTextField.setColumns(10);
		cellTextField.setBounds(160, 45, 116, 22);
		add(cellTextField);

		JLabel companyMailLabel = new JLabel("Firma Email");
		companyMailLabel.setBounds(191, 80, 68, 16);
		add(companyMailLabel);

		companyMailTextField = new JTextField();
		companyMailTextField.setColumns(10);
		companyMailTextField.setBounds(160, 98, 116, 22);
		add(companyMailTextField);

		JLabel privateMailLabel = new JLabel("Privat Email");
		privateMailLabel.setBounds(191, 133, 67, 16);
		add(privateMailLabel);

		privateMailTextField = new JTextField();
		privateMailTextField.setColumns(10);
		privateMailTextField.setBounds(160, 151, 116, 22);
		add(privateMailTextField);

		JLabel salaryLabel = new JLabel("Løn");
		salaryLabel.setBounds(328, 27, 56, 16);
		add(salaryLabel);

		salaryTextField = new JTextField();
		salaryTextField.setColumns(10);
		salaryTextField.setBounds(301, 45, 116, 22);
		add(salaryTextField);

		JLabel jobLabel = new JLabel("Nuværende Job");
		jobLabel.setBounds(191, 186, 88, 16);
		add(jobLabel);

		jobTextField = new JTextField();
		jobTextField.setColumns(10);
		jobTextField.setBounds(160, 206, 116, 22);
		add(jobTextField);

		JLabel noteLabel = new JLabel("Note");
		noteLabel.setBounds(328, 80, 56, 16);
		add(noteLabel);

		noteTextArea = new JTextArea();
		noteTextArea.setBounds(301, 98, 116, 130);
		add(noteTextArea);

		JButton saveBtn = new JButton("Gem");
		saveBtn.setBounds(179, 240, 97, 25);
		add(saveBtn);

		JButton logoutBtn = new JButton("Log ud");
		logoutBtn.setBounds(23, 241, 97, 25);
		add(logoutBtn);

		JButton goBackBtn = new JButton("Gå tilbage");
		goBackBtn.setBounds(320, 241, 97, 25);
		add(goBackBtn);

		saveBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				// Save all the values to be used in the method call 
				String tmpName = nameTextField.getText();
				String tmpAdress = adressTextField.getText();
				String tmpEducation = educationTextField.getText();
				String tmpTLF = tlfTextField.getText();
				String tmpCell = cellTextField.getText();
				String tmpCompanyMail = companyMailTextField.getText();
				String tmpPrivateMail = privateMailTextField.getText();
				int tmpSalary = new Integer(salaryTextField.getText());
				String tmpCurJob = jobTextField.getText();
				String tmpNote = noteTextArea.getText();
				
				// remove all the previous values 
				nameTextField.setText("");
				adressTextField.setText("");
				educationTextField.setText("");
				tlfTextField.setText("");
				cellTextField.setText("");
				companyMailTextField.setText("");
				privateMailTextField.setText("");
				salaryTextField.setText("");
				jobTextField.setText("");
				noteTextArea.setText("");

				MainController.getInstance().editPersonInDatabase(
						new PersonDTO(tmpName, tmpAdress, tmpEducation,
								tmpCurJob, tmpTLF, tmpCompanyMail,
								tmpPrivateMail, tmpCell, tmpNote, personId,
								dateOfBirth, tmpSalary));

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

	public void fillTextBoxes(PersonDTO personInfo) {
		nameTextField.setText(personInfo.getName());
		adressTextField.setText(personInfo.getAddress());
		educationTextField.setText(personInfo.getEducation());
		tlfTextField.setText(personInfo.getPersonPhone());
		cellTextField.setText(personInfo.getPersonCell());
		companyMailTextField.setText(personInfo.getCompanyMail());
		privateMailTextField.setText(personInfo.getPrivateMail());
		salaryTextField.setText(personInfo.getSalary() + "");
		jobTextField.setText(personInfo.getCurrentJob());
		noteTextArea.setText(personInfo.getNote());
		personId = personInfo.getPersonId();
		dateOfBirth = personInfo.getBirthYear();

	}
}
