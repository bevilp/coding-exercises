package ctci.chapter1.q1;

import org.junit.Assert;
import org.junit.Test;

/**
 * IsUniqueCharsV1
 *
 * @since 2015-11-12
 */
public class IsUniqueCharsV1 {

    /*
     1.1 Implement an algorithm to determine if a string has all unique characters. What if you can not use additional data structures?

     Question is not very specific. We will assume a-zA-Z and treat uppercase/lowercase as being the same
     */

    boolean isUniqueChars(String s) {
        if (s == null || !s.matches("[a-zA-Z]*")) {
            throw new IllegalArgumentException();
        }
        // a-z + A-Z
        if (s.length() > 26 + 26) {
            return false;
        }

        boolean[] foundChars = new boolean[26];
        for (char c : s.toCharArray()) {
            int charIndex = Character.toLowerCase(c) - 'a';
            if (foundChars[charIndex]) {
                return false;
            }
            foundChars[charIndex] = true;
        }

        return true;
    }

    @Test
    public void onlyUniqueCharsTest() {
        Assert.assertTrue(isUniqueChars("azerty"));
        Assert.assertTrue(isUniqueChars("azertyUIOP"));
        Assert.assertFalse(isUniqueChars("azertyAZERTY"));
    }
}
