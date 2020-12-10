import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Arrays:
        // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Arrays.html#sort(byte%5B%5D)
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            if (i == 0 || nums[i - 1] != nums[i]) {
                while (j < k) {
                    if ((j == i + 1 ) || (nums[j-1] != nums[j])) {
                        if((k == nums.length - 1) || (nums[k] != nums[k+1])){

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
                        } else {
                            --k;
                        }
                    } else {
                        ++j;
                    }
                }
            }
        }

        return result;
    }

    public List<List<Integer>> threeSum3(int[] nums) {
        return threeSum3(nums);
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        if((nums.length==0) || ((nums[0] * nums[nums.length-1]) > 0)) {
            return result;
        }
    
        for(int i=0; i<nums.length-2; i++) {
            if(i==0 || nums[i-1] != nums[i]) {
                int j = i + 1;
                int k = nums.length - 1;
                if((nums[i] * nums[k]) <= 0) {
                    while(j < k) {
                        if((j == (i+1)) || (nums[j-1] != nums[j]) ){
                            int res = nums[i] + nums[j] + nums[k];
                            if(res == 0) {
                                ArrayList<Integer> list = new ArrayList<>();
                                list.add(nums[i]);
                                list.add(nums[j]);
                                list.add(nums[k]);
                                result.add(list);
                                
                                ++j;
                                --k;
                            } else if(res < 0) {
                                ++j;
                            } else {
                                --k;
                            }
                        } else {
                            ++j;
                        }
                    } 
                }
            }
        }
        
        return result;
    }

}
// @lc code=end
