package test.assets;

import hangman.assets.HangmanFigure;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotSame;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by sstannus on 7/18/17.
 */
public class HangmanFigureTest {
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
            "    _________ \n" +
            "  __|__     | \n" +
            " |     |    | \n" +
            "  \\___/     | \n" +
            "            | \n" +
            "            | \n" +
            "            | \n" +
            "            | \n" +
            "            | \n" +
            "            | \n" +
            "____________|_";
    private static final String LEFT_EYE =
            "    _________ \n" +
            "  __|__     | \n" +
            " | 0   |    | \n" +
            "  \\___/     | \n" +
            "            | \n" +
            "            | \n" +
            "            | \n" +
            "            | \n" +
            "            | \n" +
            "            | \n" +
            "____________|_";
    private static final String RIGHT_EYE =
            "    _________ \n" +
            "  __|__     | \n" +
            " | 0 0 |    | \n" +
            "  \\___/     | \n" +
            "            | \n" +
            "            | \n" +
            "            | \n" +
            "            | \n" +
            "            | \n" +
            "            | \n" +
            "____________|_";
    private static final String NOSE =
            "    _________ \n" +
            "  __|__     | \n" +
            " | 0.0 |    | \n" +
            "  \\___/     | \n" +
            "            | \n" +
            "            | \n" +
            "            | \n" +
            "            | \n" +
            "            | \n" +
            "            | \n" +
            "____________|_";
    private static final String MOUTH =
            "    _________ \n" +
            "  __|__     | \n" +
            " | 0.0 |    | \n" +
            "  \\_=_/     | \n" +
            "            | \n" +
            "            | \n" +
            "            | \n" +
            "            | \n" +
            "            | \n" +
            "            | \n" +
            "____________|_";
    private static final String BODY =
            "    _________ \n" +
            "  __|__     | \n" +
            " | 0.0 |    | \n" +
            "  \\_=_/     | \n" +
            "    |       | \n" +
            "    |       | \n" +
            "    |       | \n" +
            "            | \n" +
            "            | \n" +
            "            | \n" +
            "____________|_";
    private static final String LEFT_ARM =
            "    _________ \n" +
            "  __|__     | \n" +
            " | 0.0 |    | \n" +
            "  \\_=_/     | \n" +
            "   /|       | \n" +
            "  | |       | \n" +
            "    |       | \n" +
            "            | \n" +
            "            | \n" +
            "            | \n" +
            "____________|_";
    private static final String RIGHT_ARM =
            "    _________ \n" +
            "  __|__     | \n" +
            " | 0.0 |    | \n" +
            "  \\_=_/     | \n" +
            "   /|\\      | \n" +
            "  | | |     | \n" +
            "    |       | \n" +
            "            | \n" +
            "            | \n" +
            "            | \n" +
            "____________|_";
    private static final String LEFT_LEG =
            "    _________ \n" +
            "  __|__     | \n" +
            " | 0.0 |    | \n" +
            "  \\_=_/     | \n" +
            "   /|\\      | \n" +
            "  | | |     | \n" +
            "    |       | \n" +
            "   /        | \n" +
            "  |         | \n" +
            " _|         | \n" +
            "____________|_";
    private static final String RIGHT_LEG =
            "    _________ \n" +
            "  __|__     | \n" +
            " | X.X |    | \n" +
            "  \\_o_/     | \n" +
            "   /|\\      | \n" +
            "  | | |     | \n" +
            "    |       | \n" +
            "   / \\      | \n" +
            "  |   |     | \n" +
            " _|   |_    | \n" +
            "____________|_";

    @Test
    public void testHangmanFigureOrder() {
        HangmanFigure hangmanFigure = new HangmanFigure(1, 1);
        assertEquals(hangmanFigure.getCharMatrix().toString(), HANGMAN_POST);
        hangmanFigure.next();
        assertEquals(hangmanFigure.getCharMatrix().toString(), HEAD);
        hangmanFigure.next();
        assertEquals(hangmanFigure.getCharMatrix().toString(), LEFT_EYE);
        hangmanFigure.next();
        assertEquals(hangmanFigure.getCharMatrix().toString(), RIGHT_EYE);
        hangmanFigure.next();
        assertEquals(hangmanFigure.getCharMatrix().toString(), NOSE);
        hangmanFigure.next();
        assertEquals(hangmanFigure.getCharMatrix().toString(), MOUTH);
        hangmanFigure.next();
        assertEquals(hangmanFigure.getCharMatrix().toString(), BODY);
        hangmanFigure.next();
        assertEquals(hangmanFigure.getCharMatrix().toString(), LEFT_ARM);
        hangmanFigure.next();
        assertEquals(hangmanFigure.getCharMatrix().toString(), RIGHT_ARM);
        hangmanFigure.next();
        assertEquals(hangmanFigure.getCharMatrix().toString(), LEFT_LEG);
        hangmanFigure.next();
        assertEquals(hangmanFigure.getCharMatrix().toString(), RIGHT_LEG);
        assertFalse(hangmanFigure.hasNext());
    }
}
