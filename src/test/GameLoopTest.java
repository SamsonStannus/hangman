package test;

import hangman.GameLoop;
import hangman.assets.HangmanFigure;
import hangman.assets.WordContainer;
import hangman.ui.Screen;
import hangman.ui.ScreenComponent;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Test the GameLoop logic.
 */
public class GameLoopTest {

    @Test
    public void testWinningGame() {
        Iterator<String> winningGame = Arrays.asList("h", "E", "l", "o").iterator();
        String wordToGuess = "Hello";
        Screen screen = new Screen(23, 100);
        HangmanFigure hangmanFigure = new HangmanFigure(9, 50);
        WordContainer wordContainer = new WordContainer(wordToGuess, 21, 50);
        ScreenComponent banner = new ScreenComponent("Banner", 1, 1);
        GameLoop gameLoop = new GameLoop(wordToGuess, screen, hangmanFigure, wordContainer, banner);
        boolean didUserWin = gameLoop.playGame(winningGame::next);
        assertTrue(didUserWin);
        assertEquals("Hello", wordContainer.getGuessWordStateString());
    }

    @Test
    public void testWinningGameCompleteWord() {
        Iterator<String> winningGame = Arrays.asList("h", "hello").iterator();
        String wordToGuess = "Hello";
        Screen screen = new Screen(23, 100);
        HangmanFigure hangmanFigure = new HangmanFigure(9, 50);
        WordContainer wordContainer = new WordContainer(wordToGuess, 21, 50);
        ScreenComponent banner = new ScreenComponent("Banner", 1, 1);
        GameLoop gameLoop = new GameLoop(wordToGuess, screen, hangmanFigure, wordContainer, banner);
        boolean didUserWin = gameLoop.playGame(winningGame::next);
        assertTrue(didUserWin);
        // Note that when guess a whole word the guessed state does not become the whole word, the loop just gets broken
        assertEquals("H____", wordContainer.getGuessWordStateString());
    }

    @Test
    public void testLosingGameSameLetterMultipleTimes() {
        Iterator<String> losingGame = Arrays.asList("s", "S", "f", "s", "q", "S", "S", "y", "s", "S", "s", "s", "s", "s").iterator();
        String wordToGuess = "Hello";
        Screen screen = new Screen(23, 100);
        HangmanFigure hangmanFigure = new HangmanFigure(9, 50);
        WordContainer wordContainer = new WordContainer(wordToGuess, 21, 50);
        ScreenComponent banner = new ScreenComponent("Banner", 1, 1);
        GameLoop gameLoop = new GameLoop(wordToGuess, screen, hangmanFigure, wordContainer, banner);
        boolean didUserWin = gameLoop.playGame(losingGame::next);
        assertFalse(didUserWin);
        assertEquals("_____", wordContainer.getGuessWordStateString());
    }

    @Test
    public void testLosingGameRunOutOfGuess() {
        Iterator<String> losingGame = Arrays.asList("h", "h", "i", "x", "c", "h", "w", "w", "w", "q", "z", "m", "s", "t", "w").iterator();
        String wordToGuess = "Hello";
        Screen screen = new Screen(23, 100);
        HangmanFigure hangmanFigure = new HangmanFigure(9, 50);
        WordContainer wordContainer = new WordContainer(wordToGuess, 21, 50);
        ScreenComponent banner = new ScreenComponent("Banner", 1, 1);
        GameLoop gameLoop = new GameLoop(wordToGuess, screen, hangmanFigure, wordContainer, banner);
        boolean didUserWin = gameLoop.playGame(losingGame::next);
        assertFalse(didUserWin);
        assertEquals("H____", wordContainer.getGuessWordStateString());
    }
}
