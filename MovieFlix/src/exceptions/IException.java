package exceptions;

import java.util.logging.Level;

// TODO: Auto-generated Javadoc
/**
 * The Class IException.
 */
public abstract class IException extends Exception {

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 874532556300020858L;

	/** The level. */
	private Level level;
	
	/**
	 * Sets the level.
	 *
	 * @param tipo the new level
	 */
	public abstract void setLevel(int tipo);


}
