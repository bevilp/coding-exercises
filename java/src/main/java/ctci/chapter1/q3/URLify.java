package ctci.chapter1.q3;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Permutation
 *
 * @since 2015-11-12
 */
public class URLify {

    /*
    1.3 URLify: Write a method to replace all spaces in a string with '%20'.
    You may assume that the string has sufficient space at the end to hold additional characters,
    and that you are given the "true" length of the string.
    */

    String URLify(String nonEncodedUrl) {
        if (nonEncodedUrl == null || nonEncodedUrl.isEmpty()) {
            return null;
        }
        // numSpaces(nonEncodedUrl) * 2 because there is already the space character to take into account !
        char[] nonEncodedUrlChars =
                Arrays.copyOf(nonEncodedUrl.toCharArray(), nonEncodedUrl.length() + lengthToAdd(nonEncodedUrl));

        int lastInsertedIndex = nonEncodedUrlChars.length - 1;
        for (int i = nonEncodedUrl.length() - 1; i >= 0; i--) {
            if (nonEncodedUrlChars[i] == ' ') {
                nonEncodedUrlChars[lastInsertedIndex--] = '0';
                nonEncodedUrlChars[lastInsertedIndex--] = '2';
                nonEncodedUrlChars[lastInsertedIndex--] = '%';
            } else {
                nonEncodedUrlChars[lastInsertedIndex--] = nonEncodedUrlChars[i];
            }
        }

        return new String(nonEncodedUrlChars);
    }

    int lengthToAdd(String s) {
        return numSpaces(s) * 2;
    }

    int numSpaces(String s) {
        int numSpaces = 0;
        for (char character : s.toCharArray()) {
            if (character == ' ') {
                numSpaces++;
            }
        }
        return numSpaces;
    }

    @Test
    public void URLifyTest() {
        Assert.assertEquals("ab%20c%20de", URLify("ab c de"));
        Assert.assertEquals("%20%20%20", URLify("   "));
        Assert.assertEquals("ab", URLify("ab"));
    }
}
