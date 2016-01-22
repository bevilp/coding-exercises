package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * BalancedString
 *
 * @since 2015-10-30
 */
public class BalancedString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            System.out.println(isBalanced(input));
        }
    }

    private static char OPENING_CURLY = '{';

    private static char CLOSING_CURLY = '}';

    private static char OPENING_SQUARE = '[';

    private static char CLOSING_SQUARE = ']';

    private static char OPENING_PARENTHESIS = '(';

    private static char CLOSING_PARENTHESIS = ')';

    private static boolean isOpening(char c) {
        return c == OPENING_CURLY || c == OPENING_SQUARE || c == OPENING_PARENTHESIS;
    }

    private static char getClosing(char c) {
        if (c == OPENING_CURLY) {
            return CLOSING_CURLY;
        } else if (c == OPENING_PARENTHESIS) {
            return CLOSING_PARENTHESIS;
        } else if (c == OPENING_SQUARE) {
            return CLOSING_SQUARE;
        }
        throw new IllegalArgumentException("invalid input");
    }

    public static boolean isBalanced(String input) {
        Deque<Character> stack = new ArrayDeque<>((input.length() + 1) / 2);
        for (char c : input.toCharArray()) {
            if (isOpening(c)) {
                stack.push(c);
            } else {
                try {
                    char charOnStack = stack.pop();
                    if (getClosing(charOnStack) != c) {
                        return false;
                    }
                } catch (NoSuchElementException e) {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     *
     * {}()     true
     * ({()})   true
     * {}(      false
     * []       true
     *
     */

    @Test
    public void isBalancedTest() {
        assertEquals(true, isBalanced("[]"));
        assertEquals(true, isBalanced("{}()"));
        assertEquals(true, isBalanced("({()})"));
        assertEquals(false, isBalanced("{}("));
    }
}
