//Given a set of distinct positive integers nums, return the largest subset answ
//er such that every pair (answer[i], answer[j]) of elements in this subset satisf
//ies: 
//
// 
// answer[i] % answer[j] == 0, or 
// answer[j] % answer[i] == 0 
// 
//
// If there are multiple solutions, return any of them. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3]
//Output: [1,2]
//Explanation: [1,3] is also accepted.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,4,8]
//Output: [1,2,4,8]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 2 * 109 
// All the integers in nums are unique. 
// 
// Related Topics 数学 动态规划 
// 👍 305 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset{
    public static void main(String[] args) {
       Solution solution = new LargestDivisibleSubset().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            int len = nums.length;
            Arrays.sort(nums);

            // 第 1 步：动态规划找出最大子集的个数、最大子集中的最大整数
            int[] dp = new int[len];
            Arrays.fill(dp, 1);
            int maxSize = 1;
            int maxVal = dp[0];
            for (int i = 1; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    // 题目中说「没有重复元素」很重要
                    if (nums[i] % nums[j] == 0) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }

                if (dp[i] > maxSize) {
                    maxSize = dp[i];
                    maxVal = nums[i];
                }
            }

            // 第 2 步：倒推获得最大子集
            List<Integer> res = new ArrayList<Integer>();
            if (maxSize == 1) {
                res.add(nums[0]);
                return res;
            }

            for (int i = len - 1; i >= 0 && maxSize > 0; i--) {
                if (dp[i] == maxSize && maxVal % nums[i] == 0) {
                    res.add(nums[i]);
                    maxVal = nums[i];
                    maxSize--;
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}