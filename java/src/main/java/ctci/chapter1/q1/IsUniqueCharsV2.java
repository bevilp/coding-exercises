package ctci.chapter1.q1;

import org.junit.Assert;
import org.junit.Test;

/**
 * IsUniqueCharsV2
 *
 * @since 2015-11-12
 */
public class IsUniqueCharsV2 {

    public boolean isUniqueChars(String s) {
        if (s == null || !s.matches("[a-zA-Z]*")) {
            throw new IllegalArgumentException();
        }
        // a-z + A-Z
        if (s.length() > 26 + 26) {
            return false;
        }
        int checker = 0;
        for (char sChar : s.toCharArray()) {
            int val = sChar - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

    @Test
    public void isUniqueCharsTest() {
        Assert.assertTrue(isUniqueChars("abcde"));
        Assert.assertFalse(isUniqueChars("hello"));
        Assert.assertFalse(isUniqueChars("abcdeABCDE"));
    }
}
