import java.util.ArrayList;
import java.util.List;

/**
 * Main application class to demonstrate text processing and sorting.
 * <p>
 * This program takes a string-input, format it into an object model
 * Text => Sentence => Word(Letter)/Punctuation, prints the formatted result, sorts
 * the words by vowel count, and prints the sorted sentence.
 *
 * @author Dmytro Tarasenko
 * @version 1.0
 * @since 16-10-2025
 * @see Text
 * @see Sentence
 * @see Word
 * @see Punctuation
 * @see Letter
 */
public class lab4 {

    /**
     * The main entry point for the application.
     *
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {
        StringBuffer inputText = new StringBuffer("I lllove Javvva programmiiinng,     laaanguage and its featureees. If you no longer go for a gap, which exists, you are no longer a racing driver. You always have to leave the space.");

        // Convert input String to StringBuffer for processing.
        Text text = formatText(new StringBuffer(inputText));

        if (!text.getSentences().isEmpty()) {
            Sentence sentence = text.getSentences().get(0);

            System.out.println("Formatted text before sorting:");
            System.out.println(sentence.toString());
            System.out.println("------------------------------------");
            
            List<Word> words = sentence.getWords();
            bubbleSortWordsByVowels(words);

            System.out.println("Sorted words and vowel counts:");
            for (Word word : words) {
                System.out.println(word.countVowels() + " vowel(s) in " + word);
            }
            
            Sentence sortedSentence = new Sentence();
            for (int i = 0; i < words.size(); i++) {
                sortedSentence.addElement(words.get(i));
                if (i < words.size() - 1) {
                    sortedSentence.addElement(new Punctuation(new StringBuffer(" ")));
                }
            }
            
            System.out.println("Sorted sentence: " + sortedSentence);
        }
    }

    /**
     * Format a StringBuffer into a text object, separating
     * words from punctuation and normalizing whitespace.
     *
     * @param input The StringBuffer to be formatted.
     * @return A text object representing the structured content.
     */
    public static Text formatText(StringBuffer input) {
        Text text = new Text();
        Sentence sentence = new Sentence();
        StringBuffer currentWordBuffer = new StringBuffer();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            Letter currentLetter = new Letter(ch);

            if (!Character.isWhitespace(ch) && ch != '.') {
                currentWordBuffer.append(ch);
            } else {
                // If found a dot, the current word has ended.
                if (currentWordBuffer.length() > 0) {
                    sentence.addElement(new Word(currentWordBuffer));
                    currentWordBuffer.setLength(0);
                }

                // Add punctuation marks.
                if (!Character.isWhitespace(ch)) {
                    sentence.addElement(new Punctuation(new StringBuffer().append(ch)));
                } else {
                    // Normalize whitespace.
                    List<Object> elements = sentence.getElements();
                    if (elements.isEmpty() || !(elements.get(elements.size() - 1).toString().equals(" "))) {
                        sentence.addElement(new Punctuation(new StringBuffer(" ")));
                    }
                }
            }
        }

        // Add the last word if the text doesn't end with a separator/space.
        if (currentWordBuffer.length() > 0) {
            sentence.addElement(new Word(currentWordBuffer));
        }

        text.addSentence(sentence);
        return text;
    }

    /**
     * Sorts a list of {@link Word} objects based on their vowel count.
     * @param words The list of word objects to be sorted.
     */
    public static void bubbleSortWordsByVowels(List<Word> words) {
        int n = words.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (words.get(j).countVowels() > words.get(j + 1).countVowels()) {
                    Word temp = words.get(j);
                    words.set(j, words.get(j + 1));
                    words.set(j + 1, temp);
                }
            }
        }
    }
}