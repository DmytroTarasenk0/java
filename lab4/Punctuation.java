/**
 * Represents a punctuation mark or a sequence of whitespace characters.
 * <p>
 * This class is used to model non-word elements within a sentence(spaces, commas or periods)
 *
 * @author Dmytro Tarasenko
 * @version 1.0
 * @since 16-10-2025
 */
public class Punctuation {
    /**
     * The StringBuffer value of the punctuation or separator.
     */
    private final StringBuffer value;

    /**
     * Constructs a new punctuation object.
     *
     * @param value the StringBuffer-representation of the punctuation (" ", ".", ",").
     */
    public Punctuation(StringBuffer value) {
        this.value = new StringBuffer(value);
    }

    /**
     * Returns the string-representation of this punctuation object.
     *
     * @return the string value of the punctuation.
     */
    @Override
    public String toString() {
        return value.toString();
    }
}