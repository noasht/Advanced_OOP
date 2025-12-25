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

import animals.Animal;
import animals.AnimalThread;
import Graphics.CompetitionPanel;
import Graphics.Drawable;

/**
 * Represents a standard competition where only one participant can compete.
 * This class extends the Tournament class and is responsible for setting up the
 * specific details of a single-participant tournament.
 *
 * The RegularTournament class overrides the abstract setup method from the Tournament class,
 * providing the implementation necessary to initialize the competition with the given animal
 * and any other required information.
 *
 * This class will manage the flow of the competition, including starting the race
 * and updating the results as the participant completes the course.
 */
public class RegularTournament extends Tournament
{
	/**
	 * Constructor with parameters for the RegularTournament class.
	 *
	 * @param animals is a list of lists of animals, where each list contains only one animal.
	 */
	public RegularTournament(List<List<Animal>> animals, CompetitionPanel panel) {
		super(animals, panel);
	}
	/**
	 *
	 */
	@Override
	protected void setup(List<List<Animal>> animals, CompetitionPanel panel) {
		Boolean[] startFlag = { false};
		Boolean [][] finishFlag = new Boolean [animals.size()][1]; //Each team has its own finishing flag
		List<Scores>  scores = Collections.synchronizedList(new ArrayList<Scores>(animals.size()));
		Object classLock = new Object();

		double lengthOfRoute;
		//check type of competition by checking the type of one of the animals in the group
		if (animals.getFirst().getFirst().Category().equals("Terrestrial" ))
			lengthOfRoute = 2*(panel.getWidth() - (Drawable.SIZE_PICTURE * 3 + 115)) + 2*(panel.getHeight() - Drawable.SIZE_PICTURE -25);
		else lengthOfRoute = panel.getWidth() - Drawable.SIZE_PICTURE * 3 + 17;
//Iterating over the entire list, that is, iterating over all the groups participating in the competition.
		for (int i = 0; i < animals.size(); i++)
		{
			scores.add(new Scores());
			Animal animal = animals.get(i).get(0);
			finishFlag[i][0] = false;

			AnimalThread animalThread = new AnimalThread(animal,lengthOfRoute , startFlag, finishFlag[i],panel, classLock,1000);
			Thread anialThreadE = new Thread(animalThread);
			anialThreadE.start();

			Referee refereeForEachGroup = new Referee(animal.getName(), scores.get(i), finishFlag[i],classLock);
			Thread referreThread = new Thread(refereeForEachGroup);
			referreThread.start();
		}
		super.tournamentThread = new TournamentThread(scores, startFlag, animals.size(),classLock) ;
		Thread compThread = new Thread(tournamentThread);
		compThread.start();
	}
}