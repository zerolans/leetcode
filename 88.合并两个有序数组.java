/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        merge2(nums1, m, nums2, n);
    }

    //从前向后排序
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int end1 = 0, end2 = 0, count = 0;
        int[] nums1_copy = new int[m + n];
        System.arraycopy(nums1, 0, nums1_copy, 0, m+n);

        while(end1 < m && end2 < n) {
            nums1[count++] = nums1_copy[end1] > nums2[end2] ? nums2[end2++] : nums1_copy[end1++];
        }
        if(end1 < m) {
            System.arraycopy(nums1_copy, end1, nums1, count, m - end1);
        }
        if(end2 < n){
            System.arraycopy(nums2, end2, nums1, count, n - end2);
        }
    }

    //从后向前排序
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int result = n + m - 1;
        int end1 = m - 1;
        int end2 = n - 1;

        while(end1 >= 0 && end2 >= 0) {
            nums1[result--] = nums1[end1] < nums2[end2] ? nums2[end2--] : nums1[end1--];
        }

        System.arraycopy(nums2, 0, nums1, 0, end2+1);
    }
}
// @lc code=end

