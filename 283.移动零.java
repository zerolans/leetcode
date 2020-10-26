/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        moveZeroes6(nums);
    }

    public void moveZeroes1(int[] nums) {

        int nums1[] = new int[nums.length];
        int index = 0;
        for (int i=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                nums1[index++] = nums[i];
            }
        }

        for(int i = index; i<nums.length; i++) {
            nums1[i] = 0;
        }

        for(int i=0; i<nums.length; i++){
            nums[i] = nums1[i];
        }
    }

    public void moveZeroes2(int[] nums) {
        int nonZeroTail = 0;
        for (int i=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                nums[nonZeroTail++] = nums[i];
            }
        }

        for(int i=nonZeroTail; i<nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes3(int[] nums) {
        int nonZeroTail = 0;
        for(int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                if(i != nonZeroTail) {
                    nums[nonZeroTail] = nums[i];
                    nums[i] = 0;
                }
                nonZeroTail++;
            }
        }
    }

    public void moveZeroes4(int[] nums) {
        int lastNonZeroIndex = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                if(lastNonZeroIndex != i) {
                    nums[lastNonZeroIndex] = nums[i];
                    nums[i] = 0;
                }
                ++lastNonZeroIndex;
            }
        }
    }

    public void moveZeroes5(int[] nums) {
        int[] num1 = new int[nums.length];
        int index = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                num1[index++] = nums[i];
            }
        }

        while(index < nums.length) {
            num1[index] = 0;
            index ++;
        }

        for(int i=0; i<nums.length; i++) {
            nums[i] = num1[i];
        }
    }

    public void moveZeroes6(int[] nums) {
        int lastNonZeroIndex = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                nums[lastNonZeroIndex++] = nums[i];
            }
        }

        for(int i=lastNonZeroIndex; i<nums.length; i++) {
            nums[i] = 0;
        }
    }
}
// @lc code=end

