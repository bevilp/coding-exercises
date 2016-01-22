package leetcode;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * MultiplyArrayExceptSelf
 *
 * @since 2015-11-04
 */
public class MultiplyArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int[] t1 = new int[nums.length];
        int[] t2 = new int[nums.length];

        t1[0] = 1;
        t2[nums.length - 1] = 1;

        //scan from left to right
        for (int i = 0; i < nums.length - 1; i++) {
            t1[i + 1] = nums[i] * t1[i];
        }

        System.out.println("T1" + Arrays.toString(t1));

        //scan from right to left
        for (int i = nums.length - 1; i > 0; i--) {
            t2[i - 1] = t2[i] * nums[i];
        }

        System.out.println("T2" + Arrays.toString(t2));

        //multiply
        for (int i = 0; i < nums.length; i++) {
            result[i] = t1[i] * t2[i];
        }

        System.out.println("result" + Arrays.toString(result));

        return result;
    }

    /**
     * No extra space
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf2(int[] nums) {
        int[] result = new int[nums.length];
        result[result.length - 1] = 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            result[i] = result[i + 1] * nums[i + 1];
        }

        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] *= left;
            left *= nums[i];
        }

        return result;
    }

    // @Test
    public void productExceptSelfTest() {

        int[] nums = {1, 2, 3, 4};
        int[] result = {24, 12, 8, 6};

        Assert.assertArrayEquals(result, productExceptSelf(nums));
    }

    @Test
    public void duplicateTest() {
        int[] nums = {1, 9, 7, 3, 6, 5, 4, 7};
        System.out.println(containsDuplicate(nums));
    }

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return true;
            }
        }
        return false;

    }

}
