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

import animals.Animal;
import Graphics.CompetitionPanel;

/**
 * Tournament class is abstract class that responsible for setting up a tournament and contains:
 * -  TournamentThread field that responsible for managing and starting the competition
 */
public abstract class Tournament
{
	protected TournamentThread tournamentThread;
	/**
	 * Constructor for the Tournament class, this constructor is responsible for setting up the competition by calling the setup method
	 *
	 * @param animals is a two-dimensional array of animals, divided into groups representing the teams.
	 */
	public Tournament(List<List<Animal>> animals, CompetitionPanel compPanel) {
		setup(animals, compPanel);
	}


	/***
	 * This methos responsible for setting up the competition
	 *
	 * @param animals is a list of lists that containing groups of the animals (each row is a group)
	 */
	protected abstract void setup(List<List<Animal>> animals, CompetitionPanel compPanel );

	/**
	 * Returns the current trade of the competition
	 *
	 * @return tournamentThread field
	 */
	public TournamentThread getTournamentThread()
	{
		return tournamentThread;
	}
}