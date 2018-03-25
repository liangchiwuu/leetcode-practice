package algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as
 * follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 * 
 * For convenience, the full table for the 26 letters of the English alphabet is given below:
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * 
 * Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For
 * example, "cab" can be written as "-.-.-....-", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a
 * concatenation, the transformation of a word.
 * 
 * Return the number of different transformations among all words we have.
 * 
 * Example:
 * Input: words = ["gin", "zen", "gig", "msg"]
 * Output: 2
 * Explanation:
 * The transformation of each word is:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 * There are 2 different transformations, "--...-." and "--...--.".
 * 
 * Note:
 * The length of words will be at most 100.
 * Each words[i] will have length in range [1, 12].
 * words[i] will only consist of lowercase letters.
 */
public class UniqueMorseCodeWords {

    public static void main(String[] args) {
        String[] words = { "gin", "zen", "gig", "msg" };
        int count = new UniqueMorseCodeWords().new Solution().uniqueMorseRepresentations(words);
        System.out.println(count);
    }

    /**
     * A naive solution with hash. Simply convert each word into Morse code then add into set to remove duplication. The
     * only thing to note is the conversion between char and int.
     * 
     * Time complexity: O(n * m), n for # of words, m for average length of words
     */
    class Solution {
        private final String[] morseCode = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
                "-.--", "--.." };

        public int uniqueMorseRepresentations(String[] words) {
            if (words == null || words.length == 0) {
                return 0;
            }

            Set<String> seen = new HashSet<>();
            for (String word : words) {
                StringBuilder code = new StringBuilder();
                for (int i = 0; i < word.length(); i++) {
                    code.append(morseCode[word.charAt(i) - 'a']);
                }
                seen.add(code.toString());
            }

            return seen.size();
        }
    }

}
