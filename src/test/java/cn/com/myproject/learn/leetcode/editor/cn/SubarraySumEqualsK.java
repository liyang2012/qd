//Given an array of integers and an integer k, you need to find the total number
// of continuous subarrays whose sum equals to k. 
//
// Example 1: 
//
// 
//Input:nums = [1,1,1], k = 2
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// The length of the array is in range [1, 20,000]. 
// The range of numbers in the array is [-1000, 1000] and the range of the integ
//er k is [-1e7, 1e7]. 
// 
// Related Topics 数组 哈希表

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.HashMap;

public class SubarraySumEqualsK{
    public static void main(String[] args) {
       Solution solution = new SubarraySumEqualsK().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int count = 0, pre = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                pre += nums[i];
                if (map.containsKey(pre - k)) {
                    count += map.get(pre - k);
                }
                map.put(pre, map.getOrDefault(pre, 0) + 1);
            }
            return count;
        }

        public int subarraySum1(int[] nums, int k) {
            HashMap<Integer, Integer> savedSum = new HashMap<>();
            savedSum.put(0, 1);
            int sum = 0;
            int result = 0;
            for (int num : nums) {
                sum += num;
                result += savedSum.getOrDefault(sum - k, 0);
                savedSum.merge(sum, 1, Integer::sum);
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}