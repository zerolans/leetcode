import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        moveZeroes5(nums);
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
                //此处没有过滤掉 nonZeroTail 和 i 相等的情况，会出现多余的拷贝
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

    
   //四刷
   public void moveZeroes4(int[] nums) {
       int[] num1 = new int[nums.length];
       int index = 0;

       for(int i: nums) {
           if(i != 0) {
                num1[index++] = i;
           }
       }

       for(int i = index; i<num1.length; i++){
           num1[i] = 0;
       }

       index = 0;
       for(int i: num1){
            nums[index++] = i;
       }
   }

   public void moveZeroes5(int[] nums) {
       int lastNonZero = 0;
       for(int i=0; i<nums.length; i++){
           if(nums[i] != 0){
               if(i != lastNonZero){
                   nums[lastNonZero] = nums[i];
                   nums[i] = 0;
               }
               lastNonZero ++;
           }
       }
   }
}
// @lc code=end

