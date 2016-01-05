package codingame;

import java.util.Scanner;

/**
 * ChuckNorris
 *
 * @since 2015-11-27
 */
public class ChuckNorris {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String message = in.nextLine();

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        String result = getChuckNorrisation(getBinary(message));
        System.out.println(result);
    }

    static int[] getBinary(char c) {
        int[] bits = new int[7];
        for (int i = 0; i < 7; ++i) {
            // extract the i-th bit
            bits[i] = ((c & 1 << i) >> i);
            // b will be 1 if i-th bit is set, 0 otherwise
        }
        return reverse(bits);
    }

    static int[] getBinary(String s) {
        int[] bits = new int[s.length() * 7];
        int index = 0;
        for (char c : s.toCharArray()) {
            int[] charBits = getBinary(c);
            System.arraycopy(charBits, 0, bits, index * 7, 7);
            index++;
        }
        return bits;
    }

    static String getChuckNorrisation(int[] bits) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        int current = bits[0];
        for (int i : bits) {
            if (first) {
                first = false;
                sb.append(getChuckNorrisIndicator(i)).append(" ");
            } else {
                if (i != current) {
                    current = i;
                    sb.append(' ').append(getChuckNorrisIndicator(i)).append(' ');
                }
            }
            sb.append('0');
        }
        return sb.toString();
    }

    static String getChuckNorrisIndicator(int i) {
        return i == 0 ? "00" : "0";
    }

    public static int[] swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        return array;
    }

    public static int[] reverse(int[] array) {
        for (int i = 0, j = array.length - 1; i < array.length / 2; i++, j--) {
            swap(array, i, j);
        }
        return array;
    }
}
