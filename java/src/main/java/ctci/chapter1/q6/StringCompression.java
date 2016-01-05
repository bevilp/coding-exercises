package ctci.chapter1.q6;

import org.junit.Assert;
import org.junit.Test;

/**
 * StringCompression
 *
 * @since 2015-11-12
 */
public class StringCompression {

    String compressString(String s) {
        StringBuilder sb = new StringBuilder();
        char currentChar = s.charAt(0);
        int currentCharNum = 0;
        for (char c : s.toCharArray()) {
            if (c == currentChar) {
                currentCharNum++;
            } else {
                sb.append(currentChar).append(currentCharNum);
                currentChar = c;
                currentCharNum = 1;
            }
        }

        sb.append(currentChar).append(currentCharNum);
        String compressedString = sb.toString();
        return compressedString.length() < s.length() ? compressedString : s;
    }

    @Test
    public void compressStringTest() {
        Assert.assertEquals("a2b1c5a3", compressString("aabcccccaaa"));
    }
}
