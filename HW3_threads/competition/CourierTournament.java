/**
 * @authors Noa Shem Tov  , Linoy Nisim Pur
 * This package provides a comprehensive framework for organizing and managing different types of competitions,
 * ensuring that each competition type can be set up, managed, and its results recorded by including the following classes:
 * - Scores class
 * - Referee class that implements Runnable
 * - TournamentThread class that implements Runnable
 * - Tournament abstract class
 * - CourierTournament that extends Tournament
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
 * CourierTournament represents a relay competition that extends the Tournament class.
 * This class is responsible for setting up the specific details of a relay tournament,
 * including defining the rules and structure for the participating teams of animals.
 *
 * The CourierTournament class overrides the abstract setup method from the Tournament class,
 * providing the implementation necessary to initialize the competition with the given groups
 * of animals and any other required information.
 *
 * This class will manage the flow of the relay competition, including starting the race,
 * coordinating the interactions between teams, and updating the results as teams complete their segments of the relay.
 */
public class CourierTournament extends Tournament {

	/**
	 * Constructor with parameters for the CourierTournament class.
	 *
	 * @param animals   A two-dimensional array of animals, divided into groups representing the teams.
	 * @param compPanel The panel where the competition will be displayed.
	 */
	public CourierTournament(List<List<Animal>> animals, CompetitionPanel compPanel) {
		super(animals, compPanel);
	}

	/**
	 * This method is responsible for setting up the competition.
	 * It initializes the necessary flags and creates threads for each animal in the competition.
	 *
	 * @param animals   A list of lists containing groups of animals. Each row represents a group.
	 * @param compPanel The panel where the competition will be displayed.
	 */
	@Override
	protected void setup(List<List<Animal>> animals, CompetitionPanel compPanel) {
		Boolean[] startFlag = {false};
		List<Scores> scores = Collections.synchronizedList(new ArrayList<Scores>(animals.size()));
		Object classLock = new Object();

		double lengthOfRoute;
		// Check the type of competition by checking the type of one of the animals in the group
		if (animals.getFirst().getFirst().Category().equals("Terrestrial"))
			lengthOfRoute = 2 * (compPanel.getWidth() - (Drawable.SIZE_PICTURE * 3 + 115))
					+ 2 * (compPanel.getHeight() - Drawable.SIZE_PICTURE - 25);
		else
			lengthOfRoute = compPanel.getWidth() - Drawable.SIZE_PICTURE * 3 + 17;

		// Iterate over the entire list, iterating over all the groups participating in the competition
		for (int i = 0; i < animals.size(); i++) {
			scores.add(new Scores());
			List<Animal> groupAnimals = animals.get(i); // Get list that contains the group
			Boolean[][] startFlagForEach = null;
			startFlagForEach = new Boolean[groupAnimals.size()][1]; // Assign an array of flags for a specific group
			startFlagForEach[0][0] = false; // Initialize the flag for the first animal

			// Create a thread pool the size of the group
			double needDistance = lengthOfRoute / groupAnimals.size();

			// Create a thread for the animal that is in the first place in the group
			Animal animal = groupAnimals.getFirst();
			AnimalThread animalThread = new AnimalThread(animal, needDistance, startFlag, startFlagForEach[0], compPanel, classLock, 250 * (i + 1));
			Thread animalThreadE = new Thread(animalThread);
			animalThreadE.start();

			// Iterate over each animal in group i and create Animal threads for them
			for (int j = 1; j < groupAnimals.size(); j++) {
				startFlagForEach[j][0] = false;
				animal = groupAnimals.get(j);
				animalThread = new AnimalThread(animal, needDistance, startFlagForEach[j - 1], startFlagForEach[j], compPanel, classLock, 1000);
				animalThreadE = new Thread(animalThread);
				animalThreadE.start();
			}

			Referee refereeForEachGroup = new Referee("group number " + (i + 1), scores.get(i), startFlagForEach[groupAnimals.size() - 1], classLock);
			Thread refereeThread = new Thread(refereeForEachGroup);
			refereeThread.start();
		}

		super.tournamentThread = new TournamentThread(scores, startFlag, animals.size(), classLock);
		Thread compThread = new Thread(tournamentThread);
		compThread.start();
	}
}
