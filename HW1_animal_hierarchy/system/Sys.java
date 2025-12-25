/**
 * @author Noa Shem Tov
 */
package system;

import java.util.Scanner;

import Olympics.Medal;
import Olympics.typeOfMedals;
import animals.Alligator;
import animals.Animal;
import animals.Cat;
import animals.Dog;
import animals.Dolphin;
import animals.Eagle;
import animals.Genders;
import animals.IReptile;
import animals.Pigeon;
import animals.Snake;
import animals.SnakeToxicityLevel;
import animals.TypeOfWater;
import animals.Whale;
import mobility.Point;

/**
 * This class represents a system for managing various types of animals.
 * It allows users to create different animals, view their information, and hear their sounds.
 */
public class Sys {
	/**
     * The main method that initializes the animal creation system.
     * @param args Command-line arguments (not used)
     * if the user type wrong number the program will end
     */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		initialize(scanner);
		System.out.println("\nHave a wonderful day\nGoodbye");
		scanner.close();
	}
	 /**
     * Initializes the animal creation process.
     * @param scanner Scanner object to read user input
     */
	public static void initialize(Scanner scanner) {
		System.out.println(
				"Hello user, welcome to the system.\nPlease enter the number of animals you would like to create\n");
		int numberOfAnimals = scanner.nextInt();
		if (numberOfAnimals <= 0) {/** check the input if it's valid*/
			System.out.println("Invalid input, please try again next time.");
			return;
		}
		CreateMenu(numberOfAnimals, scanner);
	}
	 /**
     * Creates the specified number of animals based on user input.
     * @param numberOfAnimals Number of animals to create
     * @param scanner Scanner object to read user input
     */
	/** */
	public static void CreateMenu(int numberOfAnimals, Scanner scanner) {
		Animal[] Arr = new Animal[numberOfAnimals];/**it will be the array of all the animals the user want's to create */
		for (int i = 0; i < numberOfAnimals; i = i + 1) {
			Arr[i] = CreatAnimal(scanner);/** every cell will hold a reference to an object */
		}
		MenuUser(Arr, scanner);/** After all the objects have been created, the second menu will be displayed*/
	}
	 /**
     * Displays a menu to the user and handles their choices.
     * @param Arr Array of Animal objects created
     * @param scanner Scanner object to read user input
     */
	public static void MenuUser(Animal[] Arr, Scanner scanner) {
		int TypeAnimal = 0;
		/**until the user will type the valid input*/
		while (TypeAnimal != 3)
		{
			do {
				System.out.println("\nPlease select an option from the menu:\r\n" + "1. Information about all animals\r\n"
						+ "2. Animals sound \r\n" + "3. Exit the system.");
				TypeAnimal = scanner.nextInt();
				scanner.nextLine();
			} while (TypeAnimal < 1 || TypeAnimal > 3);	/**until the user will type the valid input*/
			switch (TypeAnimal) {
			case 1: {
				Infromation(Arr);
				break;
					}
			case 2: {
				MakeSound(Arr);
				break;
					}
			case 3: {
				System.out.println("You have chosen to exit the system.");
				break;
					}
								}
		}
	}
	 /**
     * Displays information about all animals created.
     * @param Arr Array of Animal objects
     */
	public static void Infromation(Animal[] Arr) {
		System.out.println();
			for(int i = 0; i < Arr.length ; i = i + 1) {
				System.out.println(Arr[i].toString());
			}
	}
	/**
     * Makes all animals created to make their respective sounds.
     * @param Arr Array of Animal objects
     */
	public static void MakeSound(Animal[] Arr) {
		for(int i = 0; i < Arr.length ; i = i + 1) {
			Arr[i].makeSound();
		}
	}
	 /**
     * Creates a specific type of animal based on user input.
     * @param scanner Scanner object to read user input
     * @return Animal object created
     */
	public static Animal CreatAnimal(Scanner scanner) {
		int TypeAnimal = 0;
		Animal objAnimal = null;
		do {
			System.out.println("\nWhich type of animal would you like to create?\nThere are 3 options\n"
					+ "Please type:\n1 for Terrestrial animal\n2 for Water animal\n3 for Air animal.");
			TypeAnimal = scanner.nextInt();
			scanner.nextLine();
		} while (TypeAnimal < 1 || TypeAnimal > 3);/**until the user will type the valid input*/
		switch (TypeAnimal) {
		case 1: {
			objAnimal = TerrestrialAnimal(scanner);
			break;
		}
		case 2: {
			objAnimal = WaterAnimal(scanner);
			break;
		}
		case 3: {
			objAnimal = AirAnimal(scanner);
			break;
		}
		}
		return objAnimal;
	}
	/**
     * Creates a terrestrial animal based on user input.
     * @param scanner Scanner object to read user input
     * @return Terrestrial Animal object created
     */

	public static Animal TerrestrialAnimal(Scanner scanner) {
		int TypeAnimal = 0;
		Animal objAnimal = null;
		do {
			System.out.println("\nWhich animal would you like to create?\nThere are 3 options\n"
					+ "Please type:\n1 for Dog\n2 for Cat\n3 for Snake.");
			TypeAnimal = scanner.nextInt();
			scanner.nextLine();
		} while (TypeAnimal < 1 || TypeAnimal > 3);
		switch (TypeAnimal) {
		case 1: {
			/**public Dog(String name,Genders gender,double weight,double speed,Medal []
			// medals,Point location,String breed )*/
			objAnimal = createDog(Name(scanner), Gender(scanner), WeightChoice(scanner), SpeedFun(scanner),
					ArrMedals(scanner), PositionChoice(scanner), BreedFun(scanner));
			break;
		}
		case 2: {
			/**Cat(String name,Genders gender,double weight,double speed,Medal []
			// medals,Point location,boolean Castrated)*/
			objAnimal = createCat(Name(scanner), Gender(scanner), WeightChoice(scanner), SpeedFun(scanner),
					ArrMedals(scanner), PositionChoice(scanner), CastratedFun(scanner));
			break;
		}
		case 3: {
			/**Snake(String name,Genders gender,double weight,double speed,Medal []
			// medals,Point location, SnakeToxicityLevel type, double length)*/
			objAnimal = createSnake(Name(scanner), Gender(scanner), WeightChoice(scanner), SpeedFun(scanner),
					ArrMedals(scanner), PositionChoice(scanner), SnakeToxicityLevelFun(scanner), LengthFun(scanner));
			break;
		}
		}
		return objAnimal;
	}
	 /**
     * Creates a water animal based on user input.
     * @param scanner Scanner object to read user input
     * @return Water Animal object created
     */
	public static Animal WaterAnimal(Scanner scanner) {
		int TypeAnimal = 0;
		Animal objAnimal = null;
		do {
			System.out.println("\nWhich animal would you like to create?\nThere are 3 options\n"
					+ "Please type:\n1 for Alligator\n2 for Whale\n3 for Dolphin.");
			TypeAnimal = scanner.nextInt();
			scanner.nextLine();
		} while (TypeAnimal < 1 || TypeAnimal > 3);
		switch (TypeAnimal) {
		case 1: {
			/**Alligator(String name,Genders gender,double weight,double speed,Medal []
			// medals,Point location,double diveDept,String AreaOfLiving )*/
			objAnimal = createAlligator(Name(scanner), Gender(scanner), WeightChoice(scanner), SpeedFun(scanner),
					ArrMedals(scanner), PositionChoice(scanner), DiveDeptFun(scanner), AreaOfLivingFun(scanner));
			break;
		}
		case 2: {
			/**Whale(String name,Genders gender,double weight,double speed,Medal []
			// medals,Point location,double diveDept, String foodType)*/
			objAnimal = createWhale(Name(scanner), Gender(scanner), WeightChoice(scanner), SpeedFun(scanner),
					ArrMedals(scanner), PositionChoice(scanner), DiveDeptFun(scanner), FoodTypeFun(scanner));
			break;
		}
		case 3: {
			/**Dolphin(String name,Genders gender,double weight,double speed,Medal []
			// medals,Point location,double diveDept, TypeOfWater WaterType)*/
			objAnimal = createDolphin(Name(scanner), Gender(scanner), WeightChoice(scanner), SpeedFun(scanner),
					ArrMedals(scanner), PositionChoice(scanner), DiveDeptFun(scanner), WaterTypeFun(scanner));
			break;
		}
		}
		return objAnimal;

	}

    /**
     * Creates an air animal based on user input.
     * @param scanner Scanner object to read user input
     * @return Air Animal object created
     */
	public static Animal AirAnimal(Scanner scanner) {
		int TypeAnimal = 0;
		Animal objAnimal = null;
		do {
			System.out.println("Which type of animal would you like to create?\nThere are 2 options\n"
					+ "Please type:\n1 for Eagle\n2 for Pigeon\n");
			TypeAnimal = scanner.nextInt();
			scanner.nextLine();
		} while (TypeAnimal < 1 || TypeAnimal > 2);
		switch (TypeAnimal) {
		case 1: {
			// Eagle(String name,Genders gender,double weight,double speed,Medal []
			// medals,Point location,double wingspan,double altitudeOfFligh)
			objAnimal = createEagle(Name(scanner), Gender(scanner), WeightChoice(scanner), SpeedFun(scanner),
					ArrMedals(scanner), PositionChoice(scanner), WingspanFun(scanner), AltitudeFun(scanner));
			break;
		}
		case 2: {
			// Pigeon(String name,Genders gender,double weight,double speed,Medal []
			// medals,Point location,double wingspan,String family)
			objAnimal = createPigeon(Name(scanner), Gender(scanner), WeightChoice(scanner), SpeedFun(scanner),
					ArrMedals(scanner), PositionChoice(scanner), WingspanFun(scanner), PigeonFamily(scanner));
			break;
		}
		}
		return objAnimal;
	}
	/**
     * Checks if a string contains only letters.
     * @param name String to check
     * @return True if the string contains only letters, otherwise false
     */
	public static boolean isAllLetters(String name) {
		boolean onlyLetters = true;
		char tav = '.';
		for (int i = 0; i < name.length(); i = i + 1) {
			tav = name.charAt(i);
			onlyLetters = Character.isLetter(tav);
			if (!onlyLetters)
				return false;
		}
		return true;
	}
	/**
     * Prompts the user for the animal's name and validates it.
     * @param scanner Scanner object to read user input
     * @return Validated name of the animal
     */
	public static String Name(Scanner scanner) {
		String name = null;
		boolean onlyLetters = false;
		do {
			System.out.println("What will the animal's name be?");
			name = scanner.nextLine();
			onlyLetters = isAllLetters(name);
		} while (!onlyLetters);
		return name;
	}
	 /**
     * Prompts the user to input the animal's gender and returns the corresponding Genders enum value.
     *
     * @param scanner The Scanner object used to read user input.
     * @return The gender of the animal as a Genders enum value (MALE, FEMALE, or HERMAPHRODITE).
     */
	public static Genders Gender(Scanner scanner) {
		Genders gen = null;
		int choice;
		do {
			System.out.println(
					"What is the animal's gender?\n1 for MALE\n2 for FEMALE\n3 for HERMAPHRODITE\n please type a number");
			choice = scanner.nextInt();
			scanner.nextLine();
		} while (choice < 1 || choice > 3);/**until the user will type the valid input*/
		switch (choice) {
		case 1: {
			gen = Genders.MALE;
			break;
		}
		case 2: {
			gen = Genders.FEMALE;
			break;
		}
		case 3: {
			gen = Genders.HERMAPHRODITE;
			break;
		}
		}
		return gen;
	}
	/**
     * Prompts the user to input the animal's weight.
     *
     * @param scanner The Scanner object used to read user input.
     * @return The weight of the animal as a double value.
     */
	public static double WeightChoice(Scanner scanner) {
		double weight = 0;
		do {
			System.out.println("What is the animal's weight?");
			weight = scanner.nextDouble();
			scanner.nextLine();
		} while (weight <= 0.0);/**until the user will type the valid input*/
		return weight;
	}
	 /**
     * Prompts the user to input the animal's speed.
     *
     * @param scanner The Scanner object used to read user input.
     * @return The speed of the animal as a double value.
     */
	public static double SpeedFun(Scanner scanner) {
		double speed = -1;
		do {
			System.out.println("What is the animal's speed?");
			speed = scanner.nextDouble();
			scanner.nextLine();
		} while (speed < 0);/**until the user will type the valid input*/
		return speed;
	}
	/**
     * Prompts the user to input the number of medals an animal has won and details for each medal.
     *
     * @param scanner The Scanner object used to read user input.
     * @return An array of Medal objects representing the medals won by the animal.
     */
	public static Medal[] ArrMedals(Scanner scanner) {
		int num_of_medals;
		System.out.println("How many medals the animal has?");
		num_of_medals = scanner.nextInt();
		scanner.nextLine();
		Medal[] arr = null;
		if (num_of_medals < 1) {
			arr = new Medal[1];
			arr[0] = new Medal();
			return arr;
		}
		arr = new Medal[num_of_medals];
		for (int j = 0; j < num_of_medals; j += 1) {
			typeOfMedals type = null;
			int TypeMedal = 0;
			do {
				System.out
						.println("What the type of the medal?\n1 for BRONZE\n2 for SILVER\n3 for GOLD\n please type number");
				TypeMedal = scanner.nextInt();
				scanner.nextLine();
			} while (TypeMedal < 1 || TypeMedal > 3);/**until the user will type the valid input*/
			switch (TypeMedal) {
			case 1: {
				type = typeOfMedals.BRONZE;
				break;
			}
			case 2: {
				type = typeOfMedals.SILVER;
				break;
			}
			case 3: {
				type = typeOfMedals.GOLD;
				break;
			}
			}

			String tournament = null;
			System.out.println("Which tournament did the animal participate in?");
			tournament = scanner.next().trim();
			scanner.nextLine();

			int year;
			do {
				System.out.println("In what year did the eagle participate in the tournament");
				year = scanner.nextInt();
				scanner.nextLine();
			} while (year < 1);/**until the user will type the valid input*/
			arr[j] = new Medal(type, tournament, year);
		}
		return arr;
	}
	 /**
     * Prompts the user to input the x and y coordinates of the animal's position and returns a Point object.
     *
     * @param scanner The Scanner object used to read user input.
     * @return A Point object representing the coordinates of the animal's position.
     */
	public static Point PositionChoice(Scanner scanner) {
		int x, y;
		System.out.println("What is the x coordinate of the animal's position");
		x = scanner.nextInt();
		scanner.nextLine();
		System.out.println("What is the y coordinate of the animal's position");
		y = scanner.nextInt();
		scanner.nextLine();
		Point dot = new Point(x, y);
		return dot;
	}
	 /**
     * Prompts the user to input the animal's wingspan.
     *
     * @param scanner The Scanner object used to read user input.
     * @return The wingspan of the animal as a double value.
     */
	public static double WingspanFun(Scanner scanner) {
		double wing;
		System.out.println("What is the animal's wingspan?");
		wing = scanner.nextDouble();
		scanner.nextLine();
		return wing;
	}
	/**
     * Prompts the user to input how high the eagle can fly.
     *
     * @param scanner The Scanner object used to read user input.
     * @return The altitude of flight for the eagle as a double value.
     */
	public static double AltitudeFun(Scanner scanner) {
		double altitudeOfFlight;
		System.out.println("How high can the eagle fly?");
		altitudeOfFlight = scanner.nextDouble();
		scanner.nextLine();
		return altitudeOfFlight;
	}
	/**
     * Prompts the user to input the family of the pigeon.
     *
     * @param scanner The Scanner object used to read user input.
     * @return The family of the pigeon as a String value.
     */
	public static String PigeonFamily(Scanner scanner) {
		String family;
		System.out.println("What family is the pigeon from?");
		family = scanner.nextLine().trim();
		return family;

	}
	/**
     * Prompts the user to input the diving depth of the animal.
     *
     * @param scanner The Scanner object used to read user input.
     * @return The diving depth of the animal as a double value.
     */
	public static double DiveDeptFun(Scanner scanner) {
		double diveDepth = 0;
		System.out.println(
				"What is the diving depth that the animal is able to dive?\n the number should be negetive or zero");
		diveDepth = scanner.nextDouble();
		scanner.nextLine();
		return diveDepth;
	}
	 /**
     * Prompts the user to input the area where the alligator lives.
     *
     * @param scanner The Scanner object used to read user input.
     * @return The area of living for the alligator as a String value.
     */
	public static String AreaOfLivingFun(Scanner scanner) {
		String AreaOfLiving;
		System.out.println("What is the area where the alligator lives?");
		AreaOfLiving = scanner.nextLine().trim();
		return AreaOfLiving;
	}
	 /**
     * Prompts the user to input the type of food the whale eats.
     *
     * @param scanner The Scanner object used to read user input.
     * @return The type of food for the whale as a String value.
     */
	public static String FoodTypeFun(Scanner scanner) {
		String FoodType;
		System.out.println("What is the type of food of the whale?");
		FoodType = scanner.nextLine().trim();
		return FoodType;
	}
	 /**
     * Prompts the user to input the type of water the dolphin lives in.
     *
     * @param scanner The Scanner object used to read user input.
     * @return The type of water for the dolphin as a TypeOfWater enum value (SEA or SWEET).
     */
	public static TypeOfWater WaterTypeFun(Scanner scanner) {
		TypeOfWater WaterType = null;
		int choice = 0;
		do {
			System.out.println("What type of water is the dolphin in? \nType 1 for SEA and 2 for SWEET");
			choice = scanner.nextInt();
			scanner.nextLine();
		} while (choice < 1 || choice > 2);/**until the user will type the valid input*/
		switch (choice) {
		case 1: {
			WaterType = TypeOfWater.SEA;
			break;
		}
		case 2: {
			WaterType = TypeOfWater.SWEET;
			break;
		}
		}
		return WaterType;
	}
	  /**
     * Prompts the user to input the breed of the dog.
     *
     * @param scanner The Scanner object used to read user input.
     * @return The breed of the dog as a String value.
     */
	public static String BreedFun(Scanner scanner) {
		String breed;
		System.out.println("What breed is the dog from?");
		breed = scanner.nextLine().trim();
		return breed;
	}
	/**
     * Prompts the user to input whether the cat is castrated.
     *
     * @param scanner The Scanner object used to read user input.
     * @return True if the cat is castrated, false otherwise.
     */
	public static boolean CastratedFun(Scanner scanner) {
		boolean cas;
		int ans;
		System.out.println("Is the cat castrated? type 1 for yes and type 2 for no");
		ans = scanner.nextInt();
		scanner.nextLine();
		if (ans == 1)
			cas = true;
		else
			cas = false;
		return cas;
	}
	 /**
     * Prompts the user to input the toxicity level of the snake's venom.
     *
     * @param scanner The Scanner object used to read user input.
     * @return The toxicity level of the snake's venom as a SnakeToxicityLevel enum value (NON, POISONOUS, or LETHAL).
     */
	public static SnakeToxicityLevel SnakeToxicityLevelFun(Scanner scanner) {
		SnakeToxicityLevel PoisonLevel = null;
		int choice = 0;
		do {
			System.out.println(
					"What is the venom level of the snake? \nType 1 for NON\nType 2 for POISONOUS\n Type3 for LETHAL");
			choice = scanner.nextInt();
			scanner.nextLine();
		} while (choice < 1 || choice > 3);/**until the user will type the valid input*/
		switch (choice) {
		case 1: {
			PoisonLevel = SnakeToxicityLevel.NON;
			break;
		}
		case 2: {
			PoisonLevel = SnakeToxicityLevel.POISONOUS;
			break;
		}
		case 3: {
			PoisonLevel = SnakeToxicityLevel.LETHAL;
			break;
		}
		}
		return PoisonLevel;
	}
	 /**
     * Prompts the user to input the length of the snake.
     *
     * @param scanner The Scanner object used to read user input.
     * @return The length of the snake as a double value.
     */
	public static double LengthFun(Scanner scanner) {
		double length = 0;
		System.out.println("what is the length of the snake?");
		length = scanner.nextDouble();
		scanner.nextLine();
		return length;
	}
	 /**
     * Creates a new Eagle object with the specified attributes.
     *
     * @param name           The name of the eagle.
     * @param gender         The gender of the eagle.
     * @param weight         The weight of the eagle.
     * @param speed          The speed of the eagle.
     * @param medals         The array of medals won by the eagle.
     * @param location       The location (Point object) of the eagle.
     * @param wingspan       The wingspan of the eagle.
     * @param altitudeOfFligh The altitude of flight for the eagle.
     * @return The created Eagle object.
     */
	public static Eagle createEagle(String name, Genders gender, double weight, double speed, Medal[] medals,
			Point location, double wingspan, double altitudeOfFligh) {
		Eagle EagleObj = new Eagle(name, gender, weight, speed, medals, location, wingspan, altitudeOfFligh);
		System.out.println("A Eagle has been created");
		return EagleObj;
	}
	/**
     * Creates a new Pigeon object with the specified attributes.
     *
     * @param name           The name of the pigeon.
     * @param gender         The gender of the pigeon.
     * @param weight         The weight of the pigeon.
     * @param speed          The speed of the pigeon.
     * @param medals         The array of medals won by the pigeon.
     * @param location       The location (Point object) of the pigeon.
     * @param wingspan       The wingspan of the pigeon.
     * @param family         The family of the pigeon.
     * @return The created Pigeon object.
     */
	public static Pigeon createPigeon(String name, Genders gender, double weight, double speed, Medal[] medals,
			Point location, double wingspan, String family) {
		Pigeon PigeonObj = new Pigeon(name, gender, weight, speed, medals, location, wingspan, family);
		System.out.println("A Pigeon has been created");
		return PigeonObj;
	}
	 /**
     * Creates a new Alligator object with the specified attributes.
     *
     * @param name         The name of the alligator.
     * @param gender       The gender of the alligator.
     * @param weight       The weight of the alligator.
     * @param speed        The speed of the alligator.
     * @param medals       The array of medals won by the alligator.
     * @param location     The location (Point object) of the alligator.
     * @param diveDept     The diving depth of the alligator.
     * @param AreaOfLiving The area of living for the alligator.
     * @return The created Alligator object.
     */
	public static Alligator createAlligator(String name, Genders gender, double weight, double speed, Medal[] medals,
			Point location, double diveDept, String AreaOfLiving) {
		if(speed > IReptile.MAX_SPEED)
			speed = 0;
		Alligator AlligatorObj = new Alligator(name, gender, weight, speed, medals, location, diveDept, AreaOfLiving);
		System.out.println("A Alligator has been created");
		return AlligatorObj;
	}
	 /**
     * Creates a new Whale object with the specified attributes.
     *
     * @param name         The name of the whale.
     * @param gender       The gender of the whale.
     * @param weight       The weight of the whale.
     * @param speed        The speed of the whale.
     * @param medals       The array of medals won by the whale.
     * @param location     The location (Point object) of the whale.
     * @param diveDept     The diving depth of the whale.
     * @param foodType     The type of food for the whale.
     * @return The created Whale object.
     */
	public static Whale createWhale(String name, Genders gender, double weight, double speed, Medal[] medals,
			Point location, double diveDept, String foodType) {
		Whale WhaleObj = new Whale(name, gender, weight, speed, medals, location, diveDept, foodType);
		System.out.println("A Whale has been created");
		return WhaleObj;
	}
	/**
     * Creates a new Dolphin object with the specified attributes.
     *
     * @param name         The name of the dolphin.
     * @param gender       The gender of the dolphin.
     * @param weight       The weight of the dolphin.
     * @param speed        The speed of the dolphin.
     * @param medals       The array of medals won by the dolphin.
     * @param location     The location (Point object) of the dolphin.
     * @param diveDept     The diving depth of the dolphin.
     * @param WaterType    The type of water where the dolphin lives.
     * @return The created Dolphin object.
     */
	public static Dolphin createDolphin(String name, Genders gender, double weight, double speed, Medal[] medals,
			Point location, double diveDept, TypeOfWater WaterType) {
		Dolphin DolphinObj = new Dolphin(name, gender, weight, speed, medals, location, diveDept, WaterType);
		System.out.println("A Dolphin has been created");
		return DolphinObj;
	}
	/**
     * Creates a new Dog object with the specified attributes.
     *
     * @param name       The name of the dog.
     * @param gender     The gender of the dog.
     * @param weight     The weight of the dog.
     * @param speed      The speed of the dog.
     * @param medals     The array of medals won by the dog.
     * @param location   The location (Point object) of the dog.
     * @param breed      The breed of the dog.
     * @return The created Dog object.
     */
	public static Dog createDog(String name, Genders gender, double weight, double speed, Medal[] medals,
			Point location, String breed) {
		Dog DogObj = new Dog(name, gender, weight, speed, medals, location, breed);
		System.out.println("A Dog has been created");
		return DogObj;
	}
	/**
     * Creates a new Cat object with the specified attributes.
     *
     * @param name       The name of the cat.
     * @param gender     The gender of the cat.
     * @param weight     The weight of the cat.
     * @param speed      The speed of the cat.
     * @param medals     The array of medals won by the cat.
     * @param location   The location (Point object) of the cat.
     * @param Castrated  True if the cat is castrated, false otherwise.
     * @return The created Cat object.
     */
	public static Cat createCat(String name, Genders gender, double weight, double speed, Medal[] medals,
			Point location, boolean Castrated) {
		Cat CatObj = new Cat(name, gender, weight, speed, medals, location, Castrated);
		System.out.println("A Cat has been created");
		return CatObj;
	}
	/**
     * Creates a new Snake object with the specified attributes.
     *
     * @param name       The name of the snake.
     * @param gender     The gender of the snake.
     * @param weight     The weight of the snake.
     * @param speed      The speed of the snake.
     * @param medals     The array of medals won by the snake.
     * @param location   The location (Point object) of the snake.
     * @param type       The toxicity level of the snake's venom.
     * @param length     The length of the snake.
     * @return The created Snake object.
     */
	public static Snake createSnake(String name, Genders gender, double weight, double speed, Medal[] medals,
			Point location, SnakeToxicityLevel type, double length) {
		if(speed > IReptile.MAX_SPEED)
			speed = 0;
		Snake SnakeObj = new Snake(name, gender, weight, speed, medals, location, type, length);
		System.out.println("A Snake has been created");
		return SnakeObj;
	}
}
