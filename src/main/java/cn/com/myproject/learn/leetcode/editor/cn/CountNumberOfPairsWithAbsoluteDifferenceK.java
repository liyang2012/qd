//Given an integer array nums and an integer k, return the number of pairs (i, 
//j) where i < j such that |nums[i] - nums[j]| == k. 
//
// The value of |x| is defined as: 
//
// 
// x if x >= 0. 
// -x if x < 0. 
// 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,2,1], k = 1
//Output: 4
//Explanation: The pairs with an absolute difference of 1 are:
//- [1,2,2,1]
//- [1,2,2,1]
//- [1,2,2,1]
//- [1,2,2,1]
// 
//
// Example 2: 
//
// 
//Input: nums = [1,3], k = 3
//Output: 0
//Explanation: There are no pairs with an absolute difference of 3.
// 
//
// Example 3: 
//
// 
//Input: nums = [3,2,1,5,4], k = 2
//Output: 3
//Explanation: The pairs with an absolute difference of 2 are:
//- [3,2,1,5,4]
//- [3,2,1,5,4]
//- [3,2,1,5,4]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 1 <= k <= 99 
// 
// Related Topics 数组 哈希表 计数 👍 47 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfPairsWithAbsoluteDifferenceK{
    public static void main(String[] args) {
        Solution solution = new CountNumberOfPairsWithAbsoluteDifferenceK().new Solution();
        int[] nums = new int[]{1,2,3,4,5,6};
        int res = solution.countKDifference(nums, 1);
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countKDifference(int[] nums, int k) {
            int res = 0, len = nums.length;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                res += map.getOrDefault(nums[i] - k, 0) + map.getOrDefault(nums[i] + k, 0);
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}