/**

 */
package animals;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import Graphics.Clonable;
import Graphics.CompetitionPanel;
import Graphics.Drawable;
import Graphics.IClonable;
import Graphics.IDrawable;
import Graphics.IMoveable;
import Graphics.Moveable;
import Olympics.Medal;
import mobility.ILocatable;
import mobility.Mobile;
import mobility.Point;

/**
 * Abstract class representing an Animal, extending Mobile.
 * This class provides the basic properties and behaviors of an animal, 
 * including movement, energy consumption, and drawable capabilities.
 */ 

public abstract class Animal extends Mobile implements ILocatable, IMoveable,IDrawable, IClonable  {
    /** The track type for the animal. */
	private String track;
    /** The unique ID number for the animal. */
	private static int IdNumber = 0;
    /** The name of the animal. */
	private String name;
    /** The gender of the animal. */
	private Genders gender;
    /** The weight of the animal. */
	private double weight;
    /** The speed of the animal. */
	private int speed;
    /** The medals won by the animal. */
	private Medal[] medals;
    /** The moveable interface for the animal. */
	private IMoveable iMoveable;
    /** The drawable interface for the animal. */
	private IDrawable iDrawable;
    /** The clonable interface for the animal. */
	private IClonable iClonable;
    /** The size of the animal. */
	private int size;
    /** The ID of the animal. */
	private int id;
    /** The orientation of the animal. */
	private Orientation orien;
    /** The maximum energy of the animal. */
	private int maxEnergy;
    /** The energy consumption per meter traveled. */
	private int energyPerMeter;
    /** The current energy amount of the animal. */
	private int energyAmount;
    /** The total energy consumption of the animal. */
	private int EnergyConsumption;
    /** The competition panel associated with the animal. */
	private CompetitionPanel pan;
    /** Indicates if the animal is cleared. */
	private boolean IsCleard;
	
	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image3;
	private BufferedImage image4;
		
	  /**
     * Constructs an Animal with the specified properties.
     *
     * @param name the name of the animal
     * @param speed the speed of the animal
     * @param location the initial location of the animal
     * @param maxEnergy the maximum energy of the animal
     * @param energyPerMeter the energy consumption per meter traveled
     * @param pan the competition panel
     * @param img1 the image file path for the animal
     * @param track the track type
     */
	
	public Animal(String name, int speed, Point location, int maxEnergy, int energyPerMeter, CompetitionPanel pan,String img1, String track) {
		super(location);

		this.name = name;
		this.speed = speed;
		this.maxEnergy = maxEnergy;
		this.energyPerMeter = energyPerMeter;
		this.pan = pan;
		this.energyAmount = this.maxEnergy;
		this.track = track;
		initializeDefaultValues();
		this.iDrawable = new Drawable(super.GetMobile(),orien,pan,img1);
		this.iMoveable = new Moveable(name,speed,super.GetMobile());
		this.image1 = iDrawable.getImage1();
		this.image2 = iDrawable.getImage2();
		this.image3 = iDrawable.getImage3();
		this.image4 = iDrawable.getImage4();
	}
	  /**
     * Initializes the default values for the animal.
     */

	private void initializeDefaultValues() {
		this.gender = Genders.FEMALE;
		this.weight = 10;
		this.medals = null;
		this.size = Drawable.SIZE_PICTURE;
		this.id = ++IdNumber;
		this.orien = Orientation.EAST;
		this.IsCleard = false;
		this.iClonable = new Clonable();
		this.EnergyConsumption = 0;
	}

	 /**
     * Sets the speed of the animal by adding a speed increment.
     *
     * @param SpeedingUp the speed increment to add
     * @return true if speed was successfully set, false otherwise
     */
	protected boolean SetSpeedFromAnimal(int SpeedingUp) {
		this.speed = this.speed + SpeedingUp;
		return true;
	}
	
	  /**
     * Retrieves the total energy consumption of the animal.
     *
     * @return the total energy consumption
     */
	public int GetEnergyConsumption() {
		return this.EnergyConsumption;
	}

	 /**
     * Prints the sound produced by the animal.
     */
	
	public void makeSound() {
		System.out.println("Animal < " + getAnimaleName() + " > said < " + animalIndividualSound() + " >");
	}
	
	 /**
     * Checks if the animal is cleared.
     *
     * @return true if the animal is cleared, false otherwise
     */
	
	public boolean GetIsCleard() {
		return this.IsCleard;
	}

	  /**
     * Abstract method to get the name of the animal class.
     *
     * @return the name of the animal class
     */
	public abstract String getAnimaleName();

	/**
	 * Abstract method to get the sound produced by the animal.
	 *
	 * @return The sound produced by the animal.
	 */
	protected abstract String animalIndividualSound();
	/**
     * Abstract method to get the category of the animal.
     *
     * @return the category of the animal
     */
	public abstract String Category();

	  /**
     * Retrieves the location of the animal.
     *
     * @return the location point of the animal
     */
	public Point getLocation() {
		return super.getLocation();
	}

	 /**
     * Checks if the current animal object is equal to another object.
     *
     * @param obj the object to compare with
     * @return true if the objects are equal, false otherwise
     */
	public boolean equals(Object obj) {
		return (super.equals(obj)) && (obj instanceof Animal) && (this.name.equals(((Animal) obj).name))
				&& (this.gender.equals(((Animal) obj).gender)) && (this.weight == ((Animal) obj).weight)
				&& (this.speed == ((Animal) obj).speed) && (Arrays.equals(this.medals, ((Animal) obj).medals));
	}

	  /**
     * Retrieves the speed of the animal.
     *
     * @return the speed of the animal
     */
	
	public int getSpeed() {
		return this.speed;
	}

    /**
     * Retrieves the name of the animal.
     *
     * @return the name of the animal
     */

	public String getName() {
		return this.name;
	}

	  /**
     * Generates a string representation of the animal object.
     *
     * @return the string representation of the animal, including its attributes
     */
	public String toString() {
		String MobileString = super.toString();
		String locationString = super.getLocation().toString();
		String nameStringOfClassString = getAnimaleName();
		String animalString = nameStringOfClassString + "\n" + "The name is - " + this.name + "\n" + "It weighs - "
				+ this.weight + "\n" + "Its speed is - " + this.speed + "\n" + "Medals it has won - "
				+ Arrays.toString(this.medals) + "\n" + "Its location is - " + locationString + "\n" + MobileString
				+ "\n";
		return animalString;
	}
	  /**
     * Clones the animal object.
     *
     * @return the cloned animal object
     */
	public Object Iclone() {
		return this.iClonable.Iclone();
	}
	  /**
     * Moves the animal to a specified point.
     *
     * @param p the point to move the animal to
     * @return the distance moved
     */
	@Override
	public double move(Point p) {
	    if (this.getLocation().equals(p)) {
	        return 0;
	    }
	    double distance = iMoveable.move(p);
	    return distance;
	}
	 /**
     * Draws the animal on the provided graphics context.
     *
     * @param g the graphics context
     */
	public void drawObject(Graphics g) {
		iDrawable.drawObject(g);
	}
	 /**
     * Retrieves the orientation of the animal.
     *
     * @return the orientation of the animal
     */
	public Orientation getOrien() {
		return this.orien;
	}
	public IDrawable grtIDrawable() {
		return this.iDrawable;
	}

	  /**
     * Feeds the animal with a specified amount of energy.
     *
     * @param energy the amount of energy to feed the animal
     * @return true means the animal was successfully fed
     */
	public boolean eat(int energy) {
		if (!((this.energyAmount + energy) <= this.maxEnergy)) {
			energy = maxEnergy - energyAmount;
		}
		this.energyAmount += energy;
		this.EnergyConsumption += energy;
		return true;
	}
	   /**
     * Checks if the animal is full.
     *
     * @return true if the animal is full, false otherwise
     */
	public boolean IsFull() {
		if(maxEnergy - energyAmount == 0)
			return true;
		return false;
	}
	 /**
     * Clears the animal.
     *
     * @return true means the animal was successfully cleared
     */
	public boolean SetCleard() {
		this.IsCleard = true;
		return true;
	}

//	public boolean setOrien(Orientation Or) {
//		this.orien = Or;
//		return true;
//	}
//
	  /**
     * Sets the energy amount of the animal.
     *
     * @param Energy the energy amount to set
     * @return true means the energy amount was successfully set
     */
	public boolean SetEnergyAmount(int Energy) {
		if(this.energyAmount - Energy >= 0) 
			this.energyAmount -= Energy;
		else this.energyAmount = 0;
		return true;
	
	}
	 /**
     * Retrieves the total distance traveled by the animal.
     *
     * @return the total distance traveled
     */

	public double getTotalDistance() {
		return super.GetTotalDistance();
	}
	  /**
     * Retrieves the track type of the animal.
     *
     * @return the track type
     */

	public String getTrack() {
		return this.track;
	}
	 /**
     * Retrieves the energy consumption per meter traveled.
     *
     * @return the energy consumption per meter traveled
     */
	public double getEnergyPerMeter() {
		return this.energyPerMeter;
	}

    /**
     * Retrieves the current energy amount of the animal.
     *
     * @return the current energy amount
     */
	public double GetEnergyAmount() {
		return this.energyAmount;
	}

    /**
     * Retrieves the competition panel associated with the animal.
     *
     * @return the competition panel
     */
	public CompetitionPanel GetComPan() {
		return this.pan;
	}
	 /**
     * Retrieves the current location of the animal.
     *
     * @return the current location
     */
	public Point GetLoc() {
		return super.getLocation();
	}
	public void loadImages(String img_path) {
		this.iDrawable.loadImages(img_path);
	}
	public BufferedImage getImage1() {
		return this.iDrawable.getImage1();
	}

	public BufferedImage getImage2() {
		return this.iDrawable.getImage2();
	}

	public BufferedImage getImage3() {
		return this.iDrawable.getImage3();
	}

	public BufferedImage getImage4() {
		return this.iDrawable.getImage4();
	}
}
