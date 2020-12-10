import jdk.javadoc.internal.tool.Main;
import jdk.nashorn.internal.ir.WhileNode;

/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        ans = maxArea4(height);
        
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

    public static int maxArea3(int[] height) {
        int ans = 0;

        int l = 0, r = height.length - 1;

        while(l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);

            ans = Math.max(ans, area);

            if (height[l] <= height[r]){
                ++l;
            } else {
                --r;
            }

        }
        return ans;
    }

    public int maxArea4(int[] height) {
        int areas = 0;
        int i = 0;
        int j = height.length - 1;

        while(i < j) {
            int a = Math.min(height[i], height[j]) * (j - i);
            areas = Math.max(a, areas);

            if(height[i] < height[j]){
                ++i;
            } else {
                --j;
            }
            
        }

        return areas;
    }

}
// @lc code=end

