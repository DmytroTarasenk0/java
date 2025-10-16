/**
 * Represents a single character(letter).
 * <p>
 * This class encapsulates a primitive char and provides checking if it's a vowel.
 *
 * @author Dmytro Tarasenko
 * @version 1.0
 * @since 16-10-2025
 */
public class Letter {
    /**
     * The underlying character value of this letter.
     */
    private final char character;

    /**
     * Constructs a new letter object with the specified character.
     *
     * @param character the character value for this letter.
     */
    public Letter(char character) {
        this.character = character;
    }

    /**
     * Returns the character value of this letter.
     *
     * @return the primitive char-representation.
     */
    public char getCharacter() {
        return character;
    }

    /**
     * Converts the character of this letter to lowercase.
     *
     * @return the lowercase version of the character.
     */
    public char toLowerCase() {
        return Character.toLowerCase(this.character);
    }

    /**
     * Checks if this letter is a vowel (a, e, i, o, u, y), case doesn't matter.
     *
     * @return true if the character is a vowel, false otherwise.
     */
    public boolean isVowel() {
        char lowerCaseChar = toLowerCase();
        return lowerCaseChar == 'a' || lowerCaseChar == 'e' || lowerCaseChar == 'i' ||
               lowerCaseChar == 'o' || lowerCaseChar == 'u' || lowerCaseChar == 'y';
    }

    /**
     * Returns a string-representation of this letter.
     *
     * @return a string containing the single character of this letter.
     */
    @Override
    public String toString() {
        return String.valueOf(character);
    }
}