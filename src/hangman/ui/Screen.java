package hangman.ui;

/**
 * A Screen object for displaying the state of a game in a Graphical User Interface.
 */
public class Screen implements ScreenComponentExtensible {
    private CharMatrix charMatrix;

    public Screen(int height, int width) {
        this.charMatrix = new CharMatrix(height, width);
    }

    /**
     * Overwrites a sub matrix of the CharMatrix with the ScreenComponents CharMatrix.
     * @param component The ScreenComponent to add.
     */
    @Override
    public void addScreenComponent(ScreenComponent component) {
        this.charMatrix.setSubMatrix(component.getCharMatrix(), component.getRow(), component.getCol());
    }

    /**
     * Clears the current terminal window and redraws the current state of the Screen.
     * Note: Since there is no easy way to get the COLUMN and LINES environment variable for the terminal running the program,
     *       through java, I have chosen to clear the terminal window each time and redraw from the top left corner again.
     *       I want the screen to render in place, and the only platform independent way to do that is to print enough lines
     *       such that the terminal appears cleared, but with the dimensions of the Terminal running the program being unknown it
     *       would makes for a very ugly render and a lot of guess work.
     */
    public void render() {
        // ANSI escape code for clearing the terminal screen WARNING: might not work on all operating systems (e.g. Windows).
        // TODO: make a OS independent way to clear the terminal window.
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.print(this.charMatrix.toString());
        System.out.println();
    }

}
