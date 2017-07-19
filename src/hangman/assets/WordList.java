package hangman.assets;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * WordList for the Hangman game.
 */
public class WordList {
    private WordList() {
        // no-op
    }

    // List of words, feel free to add more!
    private static final List<String> WORD_LIST = Arrays.asList("Hello", "World", "Travel", "Poignant", "Inheritance",
            "Composition", "Principle", "Tree", "Cup", "Picture", "Hangman", "Feature", "Expedia",
            "Window", "Java", "Computer", "Beer", "Dog", "Table", "Desk", "Ambiguous", "Ubiquitous",
            "Friend", "Television", "Airplane", "Car", "Train", "Controller", "Processor", "Media",
            "Geography", "Mathematics", "Vision", "Graphics", "Wine", "Cake", "Cheese", "Keyboard",
            "Numbers", "Dates", "Words", "Quotient", "Determinant", "Chair", "Sofa", "Fuzzy", "Milk",
            "Potato", "Tomato", "Coffee", "String", "List", "Map", "Set", "Heap", "Queue");

    /**
     * Return a random word from the WORD_LIST.
     * @return random String word from the WORD_LIST.
     */
    public static String getRandomWord() {
        final int index = ThreadLocalRandom.current().nextInt(0, WORD_LIST.size());
        return WORD_LIST.get(index);
    }

}
