/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        return twoSum3(nums, target);
    }

    public int[] twoSum1(int[] nums, int target) {
        for(int i = 0; i < nums.length-1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public int[] twoSum2(int[] nums, int target) {
        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;

        while(i < j) {

            int sum = nums[i] + nums[j];
            if(sum > target) {
                j--;
            } else if (sum == target) {
                return new int[]{i, j};
            } else {
                i++;
            }
        }
        return new int[0];
    }

    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            if(hash.containsKey(target - nums[i])) {
                return new int[]{hash.get(target-nums[i]), i};
            }
            hash.put(nums[i], i);
        }
        return new int[0];
    }
}
// @lc code=end

