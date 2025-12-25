/**
 * @authors Noa Shem Tov    , Linoy Nisim Pur
 * This package provides a comprehensive framework for organizing and managing different types of competitions, 
 * ensuring that each competition type can be set up, managed, and its results recorded by including the following classes
 * - Scores class
 * - Referee class that implements Runnable 
 * - TournamentThread class that implements Runnable
 * - Tournament abstract class 
 * -  CourierTournament that extends Tournament 
 * - RegularTournament that extends Tournament
 */
package competition;

import java.util.List;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 * The purpose of a department is to display the results of a specific competition whenever there is a change in the competition
 *  (such as reaching the finish line)
 */
public class ResultsDisplay extends JTable
{
	DefaultTableModel model;
	private JDialog resultDialog;
	public ResultsDisplay(List<Scores> competitionScores) {
		//Creating a table as the size of the data saved for the competition
		super(competitionScores.size(), 2);
		model = new DefaultTableModel(new Object [] [] {}, new String[] {"Name", "Date"});
		setModel(model);
		setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);


		resultDialog = new JDialog();
		resultDialog.setLocationRelativeTo(null);
		resultDialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);


		JScrollPane scrollPane = new JScrollPane(this);
		resultDialog.add(scrollPane);
		resultDialog.pack();
		resultDialog.setVisible(false);
	}
	/**
	 * Responsible for updating the changes in the table and thus will reflect any change in the data that is saved
	 */
	public void updateTable()
	{
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				model.fireTableDataChanged();
			}
		});
	}
	/**
	 * Responsible for adding to the table groups that reach the end and presenting it
	 * @param map thar contains the animal in the competition
	 */
	public void addingToTable(Map<String, java.util.Date> map) {
		System.out.println("Add to table");
		resultDialog.setVisible(true);
		boolean isInMap;
		for (String key : map.keySet()) {
			isInMap=false;
			for (int i = 0; i < model.getRowCount(); i++) {
				if (model.getValueAt(i, 0).equals(key)) {
					isInMap = true;
					break;
				}
			}
			if (!isInMap) {
				model.addRow(new Object[]{key, map.get(key)});
			}
		}
	}
}

