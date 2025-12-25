package competition;

/**
 * The interface describes listening for changes, that is, it will be a kind of notification when any change is made
 */
public interface ListenerForUpdates {

	/**
	 * Responsible for displaying data immediately after its update, the method will be called by the observerable
	 */
	public void ShowResults();
}
