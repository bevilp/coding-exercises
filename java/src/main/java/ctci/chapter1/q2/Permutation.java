package ctci.chapter1.q2;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Permutation
 *
 * @since 2015-11-12
 */
public class Permutation {

    /*
    1.2 Given two strings, write a method to decide if one is a permutation of the other
    */

    boolean isPermutation(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException();
        }

        // If not the same length, cannot be a permutation
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();

        Arrays.sort(s1Array);
        Arrays.sort(s2Array);

        return Arrays.equals(s1Array, s2Array);
    }

    @Test
    public void isPermutationTest() {
        Assert.assertTrue(isPermutation("azerty", "rtyaze"));
        Assert.assertFalse(isPermutation("az", "aze"));
        Assert.assertFalse(isPermutation("az", "AZ"));
    }
}
