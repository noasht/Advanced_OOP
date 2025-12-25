package Graphics;
/**
 * The Clonable class implements the IClonable interface and provides functionality
 * to clone objects. This class attempts to clone the current object using the clone method.
 */
public class Clonable implements IClonable {
	 /**
     * Attempts to clone the current object.
     * 
     * @return a clone of the current object if successful, otherwise returns null.
     */
	public Object Iclone() {
			try {
				return super.clone();
			} catch (Exception e) {
				System.out.println("Replication error");
				return null;
			}
}
}
