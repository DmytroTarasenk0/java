public class lab2 {
    public static void main(String[] args) {
        int num = 23; // student number
        int c3 = num % 3; // 2 => StringBuffer
        int c17 = num % 17; // 6 => sort words by num of vowels by increase

        StringBuffer sb = new StringBuffer("I lllove Javvva programmiiinng    laaanguage and its featureees"); 
        // output is correct despite spaces and doubles

        // Count words
        int wordCount = 0;
        boolean inWord = false;
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (ch != ' ' && !inWord) {
                wordCount++;
                inWord = true;
            } else if (ch == ' ') {
                inWord = false;
            }
        }

        // Words into array
        StringBuffer[] words = new StringBuffer[wordCount];
        int wordid = 0;
        StringBuffer currentWord = new StringBuffer();
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (ch == ' ') {
                if (currentWord.length() > 0) {
                    words[wordid++] = new StringBuffer(currentWord);
                    currentWord.setLength(0);
                }
            } else {
                currentWord.append(ch);
            }
        } 
        // Last word(no space after)
        if (currentWord.length() > 0) {
            words[wordid] = new StringBuffer(currentWord);
        }

        bubbleSortVowels(words);

        // Sorted words and vowel 
        for (int i = 0; i < words.length; i++) {
            System.out.println(countVowels(words[i]) + " vowel(s) in " + words[i]);
        }

        // Rebuild the sentence
        StringBuffer sortedSb = new StringBuffer();
        for (int i = 0; i < words.length; i++) {
            sortedSb.append(words[i]);
            if (i < words.length - 1) sortedSb.append(' ');
        }
        System.out.println("Sorted: " + sortedSb);
    }

    public static void bubbleSortVowels(StringBuffer[] words) {
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words.length - i - 1; j++) {
                if (countVowels(words[j]) > countVowels(words[j + 1])) {
                    StringBuffer temp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = temp;
                }
            }
        }
    }

    public static int countVowels(StringBuffer word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = Character.toLowerCase(word.charAt(i));
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'y') {
                count++;
            }
        }
        return count;
    }

    // Ukrainian vowels(counts correct, but in console � symbols, so not used)
    // public static int countVowelsUKR(StringBuffer word) {
    //     int count = 0;
    //     for (int i = 0; i < word.length(); i++) {
    //         char ch = Character.toLowerCase(word.charAt(i));
    //         if (ch == 'а' || ch == 'о' || ch == 'у' || ch == 'и' || ch == 'і' || ch == 'е' || ch == 'є' || ch == 'ю' || ch == 'я' || ch == 'ї') {
    //             count++;
    //         }
    //     }
    //     return count;
    // }
}