package test.assets;

import hangman.assets.WordContainer;
import hangman.ui.ScreenComponent;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test the WordContainer class functionality.
 */
public class WordContainerTest {

    /**
     * Tests initialization of WordContainer and the functionality of it's methods.
     */
    @Test
    public void testWordContainer() {
        String word = "Hello";
        WordContainer wordContainer = new WordContainer(word, 0, 0);
        assertEquals("_____", wordContainer.getGuessWordStateString());
        wordContainer.updateGuessedWord('h');
        assertEquals("H____", wordContainer.getGuessWordStateString());
        wordContainer.updateGuessedWord('l');
        assertEquals("H_ll_", wordContainer.getGuessWordStateString());
        ScreenComponent screenComponent = wordContainer.getCompletedWord();
        assertEquals("Hello", screenComponent.getCharMatrix().toString());
    }
}
