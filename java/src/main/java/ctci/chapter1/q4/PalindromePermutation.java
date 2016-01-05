package ctci.chapter1.q4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Permutation
 *
 * @since 2015-11-12
 */
public class PalindromePermutation {

    /*
    1.4 Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
    A palindrome is a word or phrase that is the same forwards and backwards.
    A permutation is a rearrangement of letters.
    The palindrome does not need to be limited to just dictionary words
     */

    /**
     * checks if s is a permutation of a palindrome or not.
     *
     * Spaces are ignored
     *
     * One letter is considered a palindrome.
     *
     * @param s
     * @throws IllegalArgumentException if s is null or empty
     * @return
     */
    public boolean isPalindromePermutation(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }

        if (s.length() == 1) {
            return true;
        }

        int[] letterFrequency = new int['z' - 'a' + 1];

        int numOddLetters = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                //ignore spaces
                continue;
            }
            letterFrequency[c - 'a']++;
            if (letterFrequency[c - 'a'] % 2 == 1) {
                numOddLetters++;
            } else {
                numOddLetters--;
            }
        }

        return numOddLetters <= 1;
    }

    @Test
    public void isPalindromePermutationTest() {
        Assert.assertTrue(isPalindromePermutation("a"));
        Assert.assertTrue(isPalindromePermutation("aca"));
        Assert.assertTrue(isPalindromePermutation("aa"));
        Assert.assertTrue(isPalindromePermutation("aac"));
        Assert.assertTrue(isPalindromePermutation("acbbabb"));
        Assert.assertFalse(isPalindromePermutation("acbbabbd"));
    }
}
