package hangman.ui;

/**
 * A ScreenComponent is an object that can be added to a Screen.
 * It holds a CharMatrix to add to the Screens CharMatrix, and the row and column position to add the CharMatrix.
 * @see Screen
 */
public class ScreenComponent implements ScreenComponentExtensible {
    protected int row;
    protected int col;
    private CharMatrix charMatrix;

    /**
     * Constructs a ScreenComponent with CharMatrix of input designates where it should render in a Screen
     * @see Screen
     *
     * @param newlineDelimitedString A String representing a CharMatrix delimited by "\n" to signal new rows.
     * @param row
     * @param col
     */
    public ScreenComponent(String newlineDelimitedString, int row, int col) {
        this.row = row;
        this.col = col;
        this.charMatrix = new CharMatrix(newlineDelimitedString);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public CharMatrix getCharMatrix() {
        return charMatrix;
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
     * Update the ScreenComponents CharMatrix in place (from the top left corner) with a newlineDelimitedString.
     * @param newlineDelimitedString
     */
    public void updateScreenComponent(String newlineDelimitedString) {
        this.charMatrix.setSubMatrix(new CharMatrix(newlineDelimitedString), 0, 0);
    }
}
