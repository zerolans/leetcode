import jdk.javadoc.internal.tool.Main;

/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        // int i=0, j=height.length-1;
        int ans = 0;
        // while(i<j) {
        //     int area = Math.min(height[i], height[j])*(j - i);
        //     ans = Math.max(area, ans);
        //     if(height[i] <= height[j]) {
        //         ++i;
        //     } else {
        //         --j;
        //     }
        // }
        ans = maxArea2(height);
        
        return ans;
    }

    public int maxArea2(int[] height) {
        int ans = 0;
        int i = 0, j = height.length - 1;

        while(i < j) {
            int area = (j - i) * (height[i] <= height[j] ? 
                Math.min(height[i++], height[j]) :
                Math.min(height[i], height[j--]));
            
            ans = Math.max(area, ans);
        }

        return ans;
    }
}
// @lc code=end

