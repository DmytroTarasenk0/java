import java.util.ArrayList;
import java.util.List;

/**
 * Represents a sentence, which is an ordered collection of word
 * and punctuation objects.
 *
 * @author Dmytro Tarasenko
 * @version 1.0
 * @since 16-10-2025
 * @see Word
 * @see Punctuation
 */
public class Sentence {
    /**
     * A list holding the constituent parts of the sentence, which can be
     * instances of either word or punctuation.
     */
    private final List<Object> elements = new ArrayList<>();

    /**
     * Adds a new element to the end of the sentence.
     * The element is only added if it is an instance of word or punctuation.
     *
     * @param element the word or punctuation object to be added.
     */
    public void addElement(Object element) {
        if (element instanceof Word || element instanceof Punctuation) {
            elements.add(element);
        }
    }

    /**
     * Returns the list of all words and punctuation in the sentence.
     *
     * @return an unmodifiable list of sentence elements.
     */
    public List<Object> getElements() {
        return elements;
    }
    
    /**
     * Filters the sentence elements and returns a list containing only the word objects.
     *
     * @return a new list containing all word objects from the sentence in their original order.
     */
    public List<Word> getWords() {
        List<Word> words = new ArrayList<>();
        for (Object element : elements) {
            if (element instanceof Word) {
                words.add((Word) element);
            }
        }
        return words;
    }

    /**
     * Reconstructs the sentence into a single string by concatenating all its elements.
     *
     * @return the full sentence as a string.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object element : elements) {
            sb.append(element.toString());
        }
        return sb.toString();
    }
}