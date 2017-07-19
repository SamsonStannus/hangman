package hangman.ui;

/**
 * An Object to represent a Matrix of Characters (i.e. an NxM double Char array where each inner array has the same length).
 */
public class CharMatrix {
    private char[][] array;

    /**
     * Construct a CharMatrix from a char[][] array which has equal sized inner arrays.
     *
     * @param array the char[][] array to construct a CharMatrix from.
     */
    public CharMatrix(char[][] array) {
        Integer prevLength = null;
        // verify all inner char[] arrays have the same length.
        for (char[] chars : array) {
            if (prevLength == null) {
                prevLength = chars.length;
            }
            if (prevLength != chars.length) {
                throw new IllegalArgumentException("Input char[][] array does not have equal sized inner arrays");
            }
        }
        this.array = array;
    }

    /**
     * Construct an "empty" CharMatrix with spaces in all indices that has width number of rows, and height number of columns.
     *
     * @param height The height of the empty constructed CharMatrix.
     * @param width The width of the empty constructed CharMatrix.
     */
    public CharMatrix(int height, int width) {
        char[][] chars = new char[height][width];
        // Initialize char[][] with spaces at all indices.
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                chars[i][j] = ' ';
            }
        }
        this.array = chars;
    }

    /**
     * Construct a CharMatrix with a "\n" row-delimited string.
     *
     * @param newlineDelimitedString The string to construct a CharMatrix from.
     */
    public CharMatrix(String newlineDelimitedString) {
        if (newlineDelimitedString == null) {
            throw new IllegalArgumentException("Input String cannot be null");
        }
        // validate the width size.
        int width = newlineDelimitedString.contains("\n") ? newlineDelimitedString.indexOf("\n") : newlineDelimitedString.length();
        if (width < 1) {
            throw new IllegalArgumentException("Input String must not be an empty String");
        }
        // validate the height size.
        int height = (newlineDelimitedString.length() - (newlineDelimitedString.replace("\n", "").length())) + 1;
        if (height < 1) {
            // Note: this should never happen, but for completeness sake we verify the height.
            throw new IllegalArgumentException("Input String must not be an empty String");        }
        // validate the width of each row of the body.
        final String[] rowArray = newlineDelimitedString.split("\n");
        for (final String str : rowArray) {
            if (str.length() != width) {
                throw new IllegalArgumentException("Input String does not have a consistent number characters between each \\n");
            }
        }
        this.array = buildArrayFromString(newlineDelimitedString, height, width);
    }

    public int getWidth() {
        return this.array[0].length;
    }

    public int getHeight() {
        return this.array.length;
    }

    /**
     * Returns a String of the row at row index rowNumb.
     *
     * @param rowNumb the row to String-ify.
     * @return The String of the row at row index rowNumb.
     */
    public String getRow(int rowNumb) {
        return String.valueOf(array[rowNumb]);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(getRow(i));
            if (i < (array.length - 1)) {
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    public void setSubMatrix(CharMatrix charMatrix, int row, int col) {
        setSubMatrix(charMatrix.getArray(), row, col);
    }

    private void setSubMatrix(char[][] charsArray, int row, int col) {
        for (int i = 0; i < charsArray.length; i++) {
            for (int j = 0; j < charsArray[i].length; j++) {
                setIndex(charsArray[i][j], row + i, col + j);
            }
        }
    }

    /**
     * Sets the index at (row, col) in the char[][] array to the char val.
     *
     * @param val the char to set the index to.
     * @param row the row of the index.
     * @param col the column of the index.
     */
    private void setIndex(char val, int row, int col) {
        if (row < 0 || row > this.array.length) {
            throw new IndexOutOfBoundsException("row value must be between 0 and the height of the CharMatrix");
        }
        if (col < 0 || col > this.array[0].length) {
            throw new IndexOutOfBoundsException("col value must be between 0 and the width of the CharMatrix");
        }
        this.array[row][col] = val;
    }

    /**
     * Builds a char[][] with a String that delimits new rows with "\n" character
     *
     * @param val The newlineDelimited String to build the char[][] array from.
     * @param height The number of rows in the char[][] array (read: Matrix).
     * @param width The number of columns in the char[][] array (read: Matrix).
     * @return A char[][] of the input String value.
     */
    private char[][] buildArrayFromString(String val, int height, int width) {
        char[][] chars = new char[height][width];
        final String[] bodyStringArray = val.split("\n");
        for (int i = 0; i < bodyStringArray.length; i++) {
            chars[i] = bodyStringArray[i].toCharArray();
        }
        return chars;
    }

    /**
     * Returns the internal char[][] array of a CharMatrix.
     * Note: Used for setting sub-CharMatrices.
     *
     * @return The internal char[][] array
     */
    private char[][] getArray() {
        return this.array;
    }
}
