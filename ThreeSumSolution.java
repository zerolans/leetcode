import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class ThreeSumSolution {

    public static void main(String[] args){
        int[] sum = new int[]{-1,0,1,2,-1,-4};

        List<List<Integer>> result = threeSum(sum);
        
        System.out.println(result.toString());
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Arrays:
        // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Arrays.html#sort(byte%5B%5D)
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            if (i == 0 || nums[i - 1] != nums[i]) {
                while (j < k) {
                    // if (ignoreRepeat(nums, i, j, k)) {
                        int sum = nums[i] + nums[j] + nums[k];

                        if (sum < 0) {
                            ++j;
                        } else if (sum == 0) {
                            List<Integer> tmp = new ArrayList<>();
                            tmp.add(nums[i]);
                            tmp.add(nums[j]);
                            tmp.add(nums[k]);
                            result.add(tmp);
                            tmp = null;
                            ++j;
                            --k;
                        } else {
                            --k;
                        }
                    // }
                }
            }
        }

        return result;
    }

    private static boolean ignoreRepeat(int[] nums, int i, int j, int k) {
        return (j == i + 1 || nums[j - 1] != nums[j]) 
            && (k == nums.length - 1 || nums[k] != nums[k + 1]);
    }
}
// @lc code=end
