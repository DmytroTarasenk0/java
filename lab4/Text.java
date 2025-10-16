import java.util.ArrayList;
import java.util.List;

/**
 * Represents a text, which is composed of a collection of sentence objects.
 * This class serves as the root of the text object model.
 *
 * @author Dmytro Tarasenko
 * @version 1.0
 * @since 16-10-2025
 * @see Sentence
 */
public class Text {
    /**
     * A list of sentences that make up the text.
     */
    private final List<Sentence> sentences = new ArrayList<>();

    /**
     * Adds a sentence to the end of the text.
     *
     * @param sentence the sentence to be added.
     */
    public void addSentence(Sentence sentence) {
        this.sentences.add(sentence);
    }

    /**
     * Returns the list of sentences in this text.
     *
     * @return a list of the sentence objects.
     */
    public List<Sentence> getSentences() {
        return sentences;
    }

    /**
     * Returns a string-representation of the entire text by concatenating its sentences.
     *
     * @return the full text as a single {@code String}.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Sentence sentence : sentences) {
            sb.append(sentence.toString());
        }
        return sb.toString();
    }
}