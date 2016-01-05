package ctci.chapter1.q5;

import org.junit.Assert;
import org.junit.Test;

/**
 * Permutation
 *
 * @since 2015-11-12
 */
public class OneEditAway {

    /*

    1.5 One Away: There are three types of edits that can be performed on strings: insert a character, remove a character and replace a character.
    Given two strings, write a function to check if they are within one edit of each other.

     */

    public boolean isOneEditAway(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException();
        }

        if (Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }

        boolean differenceFound = false;
        // case where both strings are same length
        if (s1.length() == s2.length()) {
            return oneReplaceAway(s1, s2);
        } else {
            return oneInsertOrRemoveAway(s1, s2);

        }
    }

    boolean oneInsertOrRemoveAway(String s1, String s2) {
        String longest = s1.length() > s2.length() ? s1 : s2;
        String shortest = s1.length() < s2.length() ? s2 : s1;
        int index1 = 0;
        int index2 = 0;
        while (index2 < shortest.length() && index1 < longest.length()) {
            if (longest.charAt(index1) != shortest.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    boolean oneReplaceAway(String s1, String s2) {
        boolean differenceFound = false;
        // case where both strings are same length
        if (s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    if (differenceFound) {
                        return false;
                    }
                    differenceFound = true;
                }
            }
        }
        return true;
    }

    @Test
    public void isOneEditAwayTest() {
        Assert.assertTrue(isOneEditAway("azerty", "azert"));
        Assert.assertTrue(isOneEditAway("azert", "azerty"));
        Assert.assertTrue(isOneEditAway("azerty", "azerta"));
        Assert.assertFalse(isOneEditAway("azerty", "azer"));
        Assert.assertFalse(isOneEditAway("azert", "azertyy"));
    }
}
