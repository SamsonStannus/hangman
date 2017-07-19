package hangman.assets;

import hangman.ui.Screen;
import hangman.ui.ScreenComponent;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * ScreenComponent to represent the HangmanFigure.
 */
public class HangmanFigure extends ScreenComponent implements Iterator<ScreenComponent> {
    private static final String HANGMAN_POST =
            "    _________ \n" +
            "    |       | \n" +
            "            | \n" +
            "            | \n" +
            "            | \n" +
            "            | \n" +
            "            | \n" +
            "            | \n" +
            "            | \n" +
            "            | \n" +
            "____________|_";
    private static final String HEAD =
            "  __|__     \n" +
            " |     |    \n" +
            "  \\___/     ";
    private static final String EYE = "0";
    private static final String NOSE = ".";
    private static final String MOUTH = "=";
    private static final String BODY =
            "|\n" +
            "|\n" +
            "|";
    private static final String LEFT_ARM =
            " /\n" +
            "| ";
    private static final String RIGHT_ARM =
            "\\ \n" +
            " |";
    private static final String LEFT_LEG =
            "  /\n" +
            " | \n" +
            "_| ";
    private static final String RIGHT_LEG =
            "\\  \n" +
            " | \n" +
            " |_";
    private static final String DEAD_FACE =
            "X.X\n" +
            "_o_";

    private Iterator<ScreenComponent> screenComponentIterator;

    /**
     * Constructs a HangmanFigure to be placed at the row-th row and col-th column of whatever ScreenComponent it is attached to.
     * @see ScreenComponent
     * @see Screen
     *
     * @param row the row to place the HangmanFigure.
     * @param col the column to place the HangmanFigure.
     */
    public HangmanFigure(int row, int col) {
        super(HANGMAN_POST, row, col);
        // Order of Hangman parts to be added: Head, left eye, right eye, nose, mouth, body, left arm, right arm, left leg, right leg.
        ScreenComponent head = new ScreenComponent(HEAD, 1, 0);
        ScreenComponent leftEye = new ScreenComponent(EYE, 2, 3);
        ScreenComponent rightEye = new ScreenComponent(EYE, 2, 5);
        ScreenComponent nose = new ScreenComponent(NOSE, 2, 4);
        ScreenComponent mouth = new ScreenComponent(MOUTH, 3, 4);
        ScreenComponent body = new ScreenComponent(BODY, 4, 4);
        ScreenComponent leftArm = new ScreenComponent(LEFT_ARM, 4, 2);
        ScreenComponent rightArm = new ScreenComponent(RIGHT_ARM, 4, 5);
        ScreenComponent leftLeg = new ScreenComponent(LEFT_LEG, 7, 1);
        ScreenComponent rightLeg = new ScreenComponent(RIGHT_LEG, 7, 5);
        screenComponentIterator = Arrays.asList(head, leftEye, rightEye, nose, mouth, body, leftArm,
                rightArm, leftLeg, rightLeg).iterator();
    }

    @Override
    public boolean hasNext() {
        return screenComponentIterator.hasNext();
    }

    @Override
    public ScreenComponent next() {
        // get the next ScreenComponent in the screenComponentIterator and add it to the HangmanFigure.
        this.addScreenComponent(screenComponentIterator.next());
        // Add a dead face if this is the last ScreenComponent to be added to the HangmanFigure (e.g. no more guess left).
        if (!hasNext()) {
            this.addScreenComponent(new ScreenComponent(DEAD_FACE, 2, 3));
        }
        // Return the current state of the HangmanFigure.
        return this;
    }

    @Override
    public void remove() {
        screenComponentIterator.remove();
    }

    @Override
    public void forEachRemaining(Consumer action) {
        screenComponentIterator.forEachRemaining(action);
    }
}
