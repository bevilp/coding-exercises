package leetcode;

import org.junit.Test;

/**
 * FirstBadVersion
 *
 * @since 2015-11-09
 */
public class FirstBadVersion {

    int firstBadVersion = 7;

    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (!isBadVersion(mid)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    boolean isBadVersion(int version) {
        if (version >= firstBadVersion) {
            return true;
        }
        return false;
    }

    @Test
    public void testFirstBadVersion() {
        System.out.println(firstBadVersion(10));
    }

    @Test
    public void testIsUglyNumber() {
        System.out.println(isUglyNumber(10));
        //       System.out.println(isUglyNumber(11));
        //       System.out.println(isUglyNumber(12));
        //      System.out.println(isUglyNumber(13));
    }

    public boolean isUglyNumber(int num) {
        for (int i = 2; i < 6 && num > 0; i++) {
            System.out.println("i " + i);
            while (num % i == 0) {
                System.out.println("num " + (num / i));
                num /= i;
            }
        }
        return num == 1;
    }
}
