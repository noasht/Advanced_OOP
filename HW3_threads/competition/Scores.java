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

import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import animals.Animal;

/**
 * Scores class responsible for managing and displaying the results and times of a competition with the following field:
 *
 * - scores: A HashMap where the key is a group data string, and the value is Date:the group's arrival time at the end of the track.
 * - tournamentThread: will serve as an observer so that whenever there is a change in the results of the competition, 
 * it will be updated and the tournamentThread will display the updated results
 */
public class Scores
{
	private Map<String, Date> scores;
	private ArrayList<ListenerForUpdates> observer;
	/**
	 * Initializes the map where data about the results of the competition will be stored
	 */
	public Scores() {
		scores = Collections.synchronizedMap(new HashMap<>());
		observer = new ArrayList<ListenerForUpdates>();
	}

	/**
	 * Copy constructor - creates a new Scores object by copying another Scores object
	 *
	 * @param other the Scores object to copy
	 */
	public Scores(Scores other) {
		// Copy the scores map
		scores = other.scores;

		// Copy the observer list using the built-in copy constructor
		observer = other.observer;
	}

	/**
	 * Adds the group's data and its arrival time (current time)  to the map  (adding of <string, Date>)
	 * @param name represents the name of the group  entering the map
	 */
	public void add(String name) {
		System.out.println(observer.size());
		scores.put(name,  new Date());

		//When changing the results of the competition, the competition trade will be updated and it will display the results
		for (ListenerForUpdates listenerForUpdates : observer) {
			listenerForUpdates.ShowResults();
		}

	}

	/**
	 * Returns the results of all the teams that participated in the competition
	 *
	 * @return scores - competition results
	 */
	public Map<String, Date>  getAll(){
		//return new HashMap<>(scores);
		return scores;
	}

	/**
	 *
	 * @param newObserver is the new observer that join to the list of observers of scores
	 */
	public void addObserver(ListenerForUpdates newObserver) {
		observer.add(newObserver);
	}
}
