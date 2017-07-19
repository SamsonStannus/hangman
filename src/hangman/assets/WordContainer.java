package hangman.assets;

import hangman.ui.ScreenComponent;

/**
 * An Object that contains the state of Word being guessed as a ScreenComponent.
 */
public class WordContainer extends ScreenComponent {
    private String word;
    private char[] guessedWordState;

    public WordContainer(String word, int row, int col) {
        super(buildEmptyGuessWord(word), row, col);
        this.word = word;
        this.guessedWordState = buildEmptyGuessWord(word).toCharArray();
    }

    /**
     * Returns a String of the guessedWordState char[] with the first letter capitalized.
     * Note: The capitalization is just for aesthetic purposes.
     *
     * @return String of the guessedWordState char[] with the first letter capitalized.
     */
    public String getGuessWordStateString() {
        guessedWordState[0] = Character.toUpperCase(guessedWordState[0]);
        return String.valueOf(guessedWordState);
    }

    public ScreenComponent updateGuessedWord(char guessedLetter) {
        char[] wordCharArray = word.toLowerCase().toCharArray();
        // traverse array backwards because it's slightly (nms scale) more efficient, due to not needing to get array.length in each pass.
        // this has almost no effect on the program though...
        for (int i = wordCharArray.length - 1; i >= 0; i--) {
            if (wordCharArray[i] == guessedLetter) {
                guessedWordState[i] = guessedLetter;
            }
        }
        this.updateScreenComponent(getGuessWordStateString());
        return this;
    }

    public ScreenComponent getCompletedWord() {
        this.updateScreenComponent(word);
        return this;
    }

    private static String buildEmptyGuessWord(String word) {
        StringBuilder sb = new StringBuilder();
        for (final char ignored : word.toCharArray()) {
            sb.append("_");
        }
        return sb.toString();
    }

}
