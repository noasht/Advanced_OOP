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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Creates a new class named TournamentThread that implements the Runnable interface. The required fields are:
 * - scores: Holds the final results of each group.
 * - startSignal: A special flag that starts all the animals.
 * - groups: The number of competing groups.
 * This thread's role is to start the competition
 */
public class TournamentThread implements Runnable, ListenerForUpdates
{
	private List<Scores>  ScoresTeams =Collections.synchronizedList(new ArrayList<Scores>());
	private Boolean[] startSignal;
	private Object lockStartSignal=new Object();
	private int group;
	private ResultsDisplay resultsTable;//display the updtaeTable
	/**
	 * Constructor with parameters for the TournamentThread class.
	 *
	 * @param scores
	 * @param startSignal
	 * @param group
	 */
	public TournamentThread( List<Scores> scores, Boolean[] startSignal, int group, Object classLock) {
		for (Scores score : scores) {
			ScoresTeams.add(new Scores(score));
		}
		this.startSignal = startSignal;
		this.lockStartSignal = classLock;
		this.group = group;
		resultsTable = new ResultsDisplay(scores);
		for (Scores score : ScoresTeams) {
			score.addObserver(this);
		}
	}
	/**
	 * Responsible for starting the competition and displaying the competition results each time there are changes
	 */
	@Override
	public void run() {
		startComp(); //starting the competition
		ShowResults();
	}
	/**
	 * Starting the competition by putting true in startSignal
	 */
	private void startComp() {
		synchronized(lockStartSignal) {
			startSignal[0] = true;
			lockStartSignal.notifyAll();
		}
	}
	@Override
	public void ShowResults() {
		synchronized(lockStartSignal) {
			for (Scores score : ScoresTeams) {
				resultsTable.addingToTable(score.getAll());
			}
			lockStartSignal.notifyAll();
		}
		resultsTable.updateTable();
	}
}
