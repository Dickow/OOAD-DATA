package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import domain.CaseDTO;
import domain.MainController;

@SuppressWarnings("serial")
public class CreateCasePanel extends JPanel {
	private JTextField caseNameTextField;
	private JTextField companyNameTextField;

	/**
	 * Create the panel.
	 */
	public CreateCasePanel() {
		setLayout(null);

		JLabel caseNameLabel = new JLabel("Sags navn");
		caseNameLabel.setBounds(75, 54, 59, 16);
		add(caseNameLabel);

		JLabel companyNameLabel = new JLabel("Firma navn");
		companyNameLabel.setBounds(203, 54, 64, 16);
		add(companyNameLabel);

		caseNameTextField = new JTextField();
		caseNameTextField.setBounds(75, 74, 116, 22);
		add(caseNameTextField);
		caseNameTextField.setColumns(10);

		companyNameTextField = new JTextField();
		companyNameTextField.setBounds(203, 74, 116, 22);
		add(companyNameTextField);
		companyNameTextField.setColumns(10);

		JLabel researcherLabel = new JLabel("Researcher id'er");
		researcherLabel.setBounds(75, 109, 94, 16);
		add(researcherLabel);

		JLabel candidateLabel = new JLabel("Kandidater id'er");
		candidateLabel.setBounds(203, 109, 90, 16);
		add(candidateLabel);

		final JTextArea researcherTextArea = new JTextArea(
				"input id'er\r\nsepareret med \",\"");
		researcherTextArea.setBounds(75, 126, 116, 77);
		add(researcherTextArea);

		final JTextArea candidateTextArea = new JTextArea(
				"input id'er \r\nsepareret med \",\"");
		candidateTextArea.setBounds(203, 126, 116, 77);
		add(candidateTextArea);

		JButton logoutBtn = new JButton("Log ud");
		logoutBtn.setBounds(75, 216, 97, 25);
		add(logoutBtn);

		JButton goBackBtn = new JButton("Gå tilbage");
		goBackBtn.setBounds(75, 243, 97, 25);
		add(goBackBtn);

		JButton saveBtn = new JButton("Gem");
		saveBtn.setBounds(203, 216, 97, 25);
		add(saveBtn);

		logoutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int menuChoice = 6;
				MainController.getInstance().menuDistributor(menuChoice);
			}
		});

		goBackBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainController.getInstance().goBack(
						MainController.getInstance().getCurrentEmployee());

			}
		});

		saveBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				MainController.getInstance().createCase(
						new CaseDTO(caseNameTextField.getText(),
								companyNameTextField.getText(), 0),
						researcherTextArea.getText(),
						candidateTextArea.getText());
			}
		});
	}

}
