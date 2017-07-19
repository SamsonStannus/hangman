package hangman.ui;

/**
 * Interface for adding additional ScreenComponents to the implementing Object.
 * @see ScreenComponent
 */
public interface ScreenComponentExtensible {

    /**
     * Adds a ScreenComponent to the implementing Object.
     * @param component The ScreenComponent to add.
     */
    void addScreenComponent(ScreenComponent component);
}
