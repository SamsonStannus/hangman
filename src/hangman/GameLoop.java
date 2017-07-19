package hangman;

import hangman.assets.HangmanFigure;
import hangman.assets.WordContainer;
import hangman.ui.Screen;
import hangman.ui.ScreenComponent;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * The GameLoop the handles are the logic for the game.
 */
public class GameLoop {
    private Map<Character, Integer> guessedCharactersMap;
    private String wordToGuess;
    private Screen screen;
    private HangmanFigure hangmanFigure;
    private WordContainer wordContainer;

    public GameLoop(String wordToGuess, Screen screen, HangmanFigure hangmanFigure, WordContainer wordContainer, ScreenComponent banner) {
        this.wordToGuess = wordToGuess;
        this.screen = screen;
        this.hangmanFigure = hangmanFigure;
        this.screen.addScreenComponent(hangmanFigure);
        this.wordContainer = wordContainer;
        this.screen.addScreenComponent(wordContainer);
        this.screen.addScreenComponent(banner);
        this.guessedCharactersMap = new HashMap<>();
    }

    /**
     * The Main GameLoop
     * Note: The logic (like most game logic) is a bit complex, so I've commented most lines.
     * @return a boolean value, true if the player won, false if they lost.
     */
    public boolean playGame(Supplier<String> inputSupplier) {
        // render the initial screen.
        screen.render();
        // While the HangmanFigure has body parts to add keep playing
        while (hangmanFigure.hasNext()) {
            String guess = inputSupplier.get().toLowerCase();
            // If the user guessed one letter.
            if (guess.length() == 1) {
                char letterGuess = guess.charAt(0);
                // If the user guessed the same letter more than once
                if (guessedCharactersMap.containsKey(letterGuess)) {
                    handleGuessMapContainsKey(letterGuess);
                // If the user guessed a letter contained in the wordToGuess.
                } else if (wordToGuess.toLowerCase().contains(guess)) {
                    guessedCharactersMap.put(letterGuess, 1);
                    screen.addScreenComponent(wordContainer.updateGuessedWord(guess.toLowerCase().charAt(0)));
                    if (wordToGuess.equalsIgnoreCase(wordContainer.getGuessWordStateString())) {
                        screen.render();
                        return true;
                    }
                    screen.render();
                // Otherwise the guess was a unique guess, but it is not contained in the wordToGuess.
                } else {
                    guessedCharactersMap.put(letterGuess, 1);
                    screen.addScreenComponent(hangmanFigure.next());
                    screen.render();
                }
            // If the user guessed a whole word.
            } else if (wordToGuess.equalsIgnoreCase(guess)) {
                screen.addScreenComponent(wordContainer.getCompletedWord());
                screen.render();
                return true;
            // Otherwise it's a failed guess attempt.
            } else {
                screen.addScreenComponent(hangmanFigure.next());
                screen.render();
            }
        }
        // If the user did not win while the HangMan figure hasNext, they lost.
        return false;
    }

    /**
     * Helper method to handle when a user guesses the same letter more than once.
     * @param letterGuess the guessed letter.
     */
    private void handleGuessMapContainsKey(char letterGuess) {
        int count = guessedCharactersMap.get(letterGuess);
        if (count > 1) {
            screen.addScreenComponent(hangmanFigure.next());
            screen.render();
        } else {
            guessedCharactersMap.put(letterGuess, ++count);
            System.out.println("Warning you've guessed that Letter before, next time you guess that Letter it will automatically count as a failed guess.");
        }
    }

}
