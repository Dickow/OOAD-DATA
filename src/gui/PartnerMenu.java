package gui;

import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Color;
import java.awt.Component;

public class PartnerMenu extends JPanel {
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private final Action action_4 = new SwingAction_4();
	private final Action action_5 = new SwingAction_5();
	private final Action action_6 = new SwingAction_6();
	
	/**
	 * Create the panel.
	 */
	public PartnerMenu() {
		create(); 
	}
		
	public void create() {
		setLayout(null);
		
		JButton findPerson = new JButton("Find person");
		findPerson.setAction(action);
		findPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		findPerson.setBounds(165, 75, 120, 25);
		add(findPerson);
		
		JButton btnNewButton_1 = new JButton("Opret person");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setAction(action_1);
		btnNewButton_1.setBounds(165, 99, 120, 25);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Opret sag");
		btnNewButton_2.setAction(action_2);
		btnNewButton_2.setBounds(165, 123, 120, 25);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Find sag");
		btnNewButton_3.setAction(action_3);
		btnNewButton_3.setBounds(165, 147, 120, 25);
		add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("S\u00F8g Firma");
		btnNewButton_4.setAction(action_4);
		btnNewButton_4.setBounds(165, 171, 120, 25);
		add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Opret firma");
		btnNewButton_5.setName("");
		btnNewButton_5.setForeground(new Color(0, 0, 0));
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_5.setAction(action_5);
		btnNewButton_5.setBounds(165, 195, 120, 25);
		add(btnNewButton_5);
		
		JLabel lblOdgersBerndtson = new JLabel("Odgers Berndtson");
		lblOdgersBerndtson.setFont(new Font("Calibri", Font.BOLD, 36));
		lblOdgersBerndtson.setBounds(102, 27, 266, 44);
		add(lblOdgersBerndtson);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setAction(action_6);
		btnLogout.setBounds(165, 220, 120, 25);
		add(btnLogout);

	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Find person");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Opret person");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Opret sag");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Find sag");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "Find firma");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_5 extends AbstractAction {
		public SwingAction_5() {
			putValue(NAME, "Opret firma");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_6 extends AbstractAction {
		public SwingAction_6() {
			putValue(NAME, "Log ud");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
