/**
 * @author 
 */
package Olympics;
/**
 * The Medal class represents a medal won in a tournament.
 * medal is immutable
 */
public class Medal {
	/**
	 * typeOfMedals type = Type of the medal (Gold, Silver, Bronze)
	 * String tournament; // Name of the tournament
	 * int year; // Year of the tournament
	 */
	private typeOfMedals type;
	private String tournament;
	private int year;
	 /**
     * Constructs a Medal object with specified type, tournament, and year.
     *
     * @param type The type of the medal (Gold, Silver, Bronze).
     * @param tournament The name of the tournament.
     * @param year The year of the tournament.
     */
	public Medal(typeOfMedals type,String tournament, int year){
		this.type = type;
		this.tournament = tournament;
		this.year = year;
	}
	 /**
     * Constructs a default Medal object with Bronze type, default tournament name, and year 2024.
     */
	public Medal() {
		this.type = typeOfMedals.BRONZE;
		this.tournament = "tournament";
		this.year = 2024;
	}
	 /**
     * Checks if this Medal object is equal to another object.
     *
     * @param obj The object to compare to.
     * @return True if the objects are equal (same type, tournament name, and year), false otherwise.
     */
	public boolean equals(Object obj) {
		return (obj instanceof Medal) && (this.year == ((Medal)obj).year) && (this.tournament.equalsIgnoreCase(((Medal)obj).tournament)) 
				&& (this.type.equals(((Medal)obj).type));
	}
	 /**
     * Returns a string representation of the Medal object.
     *
     * @return A string representation including the year, tournament, and type of the medal.
     */
	public String toString() {
		return "In " + this.year + ", in the tournament " + this.tournament + ", winning a " + this.type + " medal.";
	}
}
