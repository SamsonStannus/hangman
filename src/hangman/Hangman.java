package hangman;

import hangman.assets.HangmanFigure;
import hangman.assets.WordContainer;
import hangman.assets.WordList;
import hangman.ui.Screen;
import hangman.ui.ScreenComponent;

import java.util.Scanner;

public class Hangman {
    private static final String HANGMAN_BANNER =
            "  _   _                                         \n" +
            " | | | | __ _ _ __   __ _ _ __ ___   __ _ _ __  \n" +
            " | |_| |/ _` | '_ \\ / _` | '_ ` _ \\ / _` | '_ \\ \n" +
            " |  _  | (_| | | | | (_| | | | | | | (_| | | | |\n" +
            " |_| |_|\\__,_|_| |_|\\__, |_| |_| |_|\\__,_|_| |_|\n" +
            "                    |___/                       ";
    private static final int SCREEN_HEIGHT = 23;
    private static final int SCREEN_WIDTH = 100;
    private static final int HANGMAN_FIGURE_ROW_PLACEMENT = 9;
    private static final int HANGMAN_FIGURE_COL_PLACEMENT = 50;
    private static final int WORD_CONTAINER_ROW_PLACEMENT = 21;
    private static final int WORD_CONTAINER_COL_PLACEMENT = 50;
    private static final int HANGMAN_BANNER_ROW_PLACEMENT = 1;
    private static final int HANGMAN_BANNER_COL_PLACEMENT = 35;

    public static void main(String[] args) {
        boolean play = true;
        while (play) {
            // Get a word for the user to guess.
            final String wordToGuess = WordList.getRandomWord();
            // Initialize Screen.
            Screen screen = new Screen(SCREEN_HEIGHT, SCREEN_WIDTH);
            // Initialize Hangman figure.
            HangmanFigure hangmanFigure = new HangmanFigure(HANGMAN_FIGURE_ROW_PLACEMENT, HANGMAN_FIGURE_COL_PLACEMENT);
            // Initialize WordContainer to hold the state of the guesses.
            WordContainer wordContainer = new WordContainer(wordToGuess, WORD_CONTAINER_ROW_PLACEMENT, WORD_CONTAINER_COL_PLACEMENT);
            // Initialize banner to place across the screen.
            ScreenComponent banner = new ScreenComponent(HANGMAN_BANNER, HANGMAN_BANNER_ROW_PLACEMENT, HANGMAN_BANNER_COL_PLACEMENT);
            // Initialize GameLoop
            GameLoop gameLoop = new GameLoop(wordToGuess, screen, hangmanFigure, wordContainer, banner);
            boolean didUserWin = gameLoop.playGame(Hangman::getGuess);
            play = getPlayAgainOption(didUserWin);
        }
    }

    private static String getGuess() {
        System.out.print("Enter a Guess [letter/whole word] or [ctrl + c] to quit at any time: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static boolean getPlayAgainOption(boolean didUserWin) {
        final String statusString = didUserWin ? "You won, congrats!" : "Game Over, you ran out of guesses!";
        System.out.print(statusString + " Would you like to play again? [y/Y] to continue or any key to quit: ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        return "y".equalsIgnoreCase(answer);
    }

}
