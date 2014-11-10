package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class ResearcherMenu extends JPanel {
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private final Action action_4 = new SwingAction_4();

	/**
	 * Create the panel.
	 */
	public ResearcherMenu() {
		create();
	}

	public void create() {
		setLayout(null);

		JLabel label = new JLabel("Odgers Berndtson");
		label.setFont(new Font("Calibri", Font.BOLD, 36));
		label.setBounds(83, 35, 266, 44);
		add(label);

		JButton button = new JButton("Find person");
		button.setAction(action);
		button.setBounds(154, 92, 120, 25);
		add(button);

		JButton button_2 = new JButton("Opret sag");
		button_2.setAction(action_1);
		button_2.setBounds(154, 117, 120, 25);
		add(button_2);

		JButton button_3 = new JButton("Find sag");
		button_3.setAction(action_2);
		button_3.setBounds(154, 141, 120, 25);
		add(button_3);

		JButton button_4 = new JButton("S\u00F8g Firma");
		button_4.setAction(action_3);
		button_4.setBounds(154, 166, 120, 25);
		add(button_4);

		JButton button_6 = new JButton("Logout");
		button_6.setAction(action_4);
		button_6.setBounds(154, 191, 120, 25);
		add(button_6);

	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "SwingAction_1");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "SwingAction_2");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "SwingAction_3");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "SwingAction_4");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
