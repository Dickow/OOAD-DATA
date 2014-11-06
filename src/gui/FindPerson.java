package gui;

import javax.swing.AbstractListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JScrollBar;

public class FindPerson extends JPanel {
	private final Action action = new SwingAction();

	/**
	 * Create the panel.
	 */
	public FindPerson() {
		setLayout(null);
		
		JLabel label = new JLabel("Odgers Berndtson");
		label.setFont(new Font("Calibri", Font.BOLD, 36));
		label.setBounds(76, 13, 266, 44);
		add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(76, 98, 266, 173);
		add(scrollPane);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Jeppe", "Nikolaj", "Morten", "Fedt", "Hahaha", "adadad", "grgrgawda", "adfadawda", "faefdsrgtdg", "adfsrgtgsgasg", "srgdtrgdgh", "tfhfthfth", "fyhfyhfhfhfh"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setColumnHeaderView(list);
		
		JButton btnNewButton = new JButton("RedigerPerson");
		btnNewButton.setAction(action);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		scrollPane.setViewportView(btnNewButton);

	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Rediger");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
