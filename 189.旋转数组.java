/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        rotate1(nums, k);
    }

    //方法一、暴力旋转
    public void rotate1(int[] nums, int k){
        int temp,prev;
        for(int i=0; i<k; i++){
            prev = nums[nums.length - 1];
            for(int j=0; j<nums.length; j++){
                temp = nums[j];
                nums[j] = prev;
                prev = temp;
            }
        }
    }

    //方法二、使用额外的数组
    public void rotate2(int[] nums, int k){
        int[] nums1 = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            nums1[(i+k)%nums.length] = nums[i];
        }

        for(int i=0; i<nums.length; i++){
            nums[i] = nums1[i];
        }
    }

    //方法三、环状替换
    public void rotate3(int[] nums, int k){
        int count = 0;
        int current ;
        int temp, next;
        k = k % nums.length;
        for (int i=0; count < nums.length; i++){
            current = i;
            do{
                next = (current+k)%nums.length;
                temp = nums[current];
                nums[current] = nums[next];
                nums[next] = temp;
                current = next;
                count ++;
            } while (current != i);
        }
    }

    //方法四、反转数组
    public void rotate4(int[] nums, int k) {
        k = k%nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        int temp ;
        while(start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }
}
// @lc code=end

