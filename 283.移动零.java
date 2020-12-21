import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        moveZeroes2(nums);
    }
   
    public void moveZeroes1(int[] nums) {
       int[] nums1 = new int[nums.length];
       int count = 0;
       for(int i=0; i<nums.length; i++) {
           if(nums[i] != 0) {
               nums1[count++] = nums[i];
           }
       }

       for(int i=0; i<nums.length; i++){
           if(i < count) {
               nums[i] = nums1[i];
           } else {
               nums[i] = 0;
           }
       }
    }

    public void moveZeroes2(int[] nums) {
        int lastZeroIndex = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] != 0){
                if(i != lastZeroIndex) {
                    nums[lastZeroIndex] = nums[i];
                    nums[i] = 0;
                }
                lastZeroIndex ++;
            }
        }
    }
}
// @lc code=end

