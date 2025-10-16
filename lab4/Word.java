/**
 * Represents a word, which is composed of a sequence of characters.
 * <p>
 * This class holds its value in a StringBuffer and uses the {@link Letter}
 * class to perform character-level operations, such as counting vowels.
 *
 * @author Dmytro Tarasenko
 * @version 1.0
 * @since 16-10-2025
 * @see Letter
 */
public class Word {
    /**
     * A StringBuffer that holds the characters of the word.
     */
    private final StringBuffer value;

    /**
     * Constructs a new word from a StringBuffer.
     *
     * @param wordBuffer the StringBuffer to be used as the word's value.
     */
    public Word(StringBuffer wordBuffer) {
        this.value = new StringBuffer(wordBuffer);
    }

    /**
     * Counts the number of vowels in the word.
     * <p>
     * This method iterates through the StringBuffer, creating a {@link Letter} 
     * object for each character and using the vowel-check method.
     *
     * @return the total count of vowel letters in the word.
     */
    public int countVowels() {
        int count = 0;
        for (int i = 0; i < value.length(); i++) {
            // Get each character and check if it's a vowel using Letter class.
            char ch = value.charAt(i);
            Letter letter = new Letter(ch);
            if (letter.isVowel()) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns a string representation of the word.
     *
     * @return the reconstructed word as a string.
     */
    @Override
    public String toString() {
        return value.toString();
    }
}