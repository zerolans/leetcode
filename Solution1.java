
public class Solution1 {
    public static void main(String[] args){
        int[] height = {1,8,6,2,5,4,8,3,7};

        System.out.println("max area: " + maxArea(height));
    }

    public static int maxArea(int[] height) {
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
}
