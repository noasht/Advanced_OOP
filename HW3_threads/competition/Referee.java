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

/**
 * Responsible for waiting for a specific animal or group and, upon their arrival, updating their arrival data in the competition results
 * by the following field:
 * - name: The name of animal\group that  reached the end of the route
 * - scores: The results of the competition
 */
public class Referee implements Runnable
{
	private String name;
	private Scores scores;
	private Boolean[] finishFlag;
	private Object classLock;

	/**
	 * Constructor with parameters for the Referee class.
	 *
	 * @param name
	 * @param scores
	 */
	public Referee(String name, Scores scores, Boolean[] finishFlag, Object classLock) {
		this.name = name;
		this.scores = scores;
		this.finishFlag = finishFlag;
		this.classLock = classLock;
	}
	/**
	 * When a group reaches the end of the route, the method updates the results
	 */
	@Override
	public void run() {
		synchronized (classLock) {
			while (!finishFlag[0] ) {
				try {
					classLock.wait();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
			scores.add(name);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Refeere "+finishFlag[0]);
			classLock.notifyAll();
		}
	}
}
