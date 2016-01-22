package leetcode;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * MoveZeroes
 *
 * @since 2015-11-04
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (null == nums) {
            return;
        }

        int numZeroes = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[i - numZeroes] = nums[i];
            } else {
                numZeroes++;
            }
        }

        for (int i = nums.length - numZeroes; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    @Test
    public void moveZeroesTest() {
        int[] nums = new int[] {1, 0, 2, 3, 4, 0, 0, 5, 6, 7, 0, 8, 9};

        int[] result = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0};

        moveZeroes(nums);

        System.out.println(Arrays.toString(nums));

        Assert.assertArrayEquals(result, nums);
    }

}
