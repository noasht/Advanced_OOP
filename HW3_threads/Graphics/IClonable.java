package Graphics;

import java.lang.Cloneable;


/**
 * The IClonable interface describes the behavior of replicable objects.
 * It extends the Cloneable interface to allow objects to be cloned.
 */
public interface IClonable extends Cloneable {
	  /**
     * Creates a duplicate of the object that invoked the method.
     * 
     * @return a clone of the invoking object
     */
	public Object Iclone();
}
