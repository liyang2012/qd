//An integer array is called arithmetic if it consists of at least three element
//s and if the difference between any two consecutive elements is the same. 
//
// 
// For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequence
//s. 
// 
//
// Given an integer array nums, return the number of arithmetic subarrays of num
//s. 
//
// A subarray is a contiguous subsequence of the array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,4]
//Output: 3
//Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,
//2,3,4] itself.
// 
//
// Example 2: 
//
// 
//Input: nums = [1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -1000 <= nums[i] <= 1000 
// 
// Related Topics 数组 动态规划 
// 👍 298 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class ArithmeticSlices{
    public static void main(String[] args) {
       Solution solution = new ArithmeticSlices().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            int n = nums.length;
            if (n == 1) {
                return 0;
            }
            int d = nums[0] - nums[1], t = 0;
            int ans = 0;
            for (int i = 2; i < n; ++i) {
                if (nums[i - 1] - nums[i] == d) {
                    ++t;
                } else {
                    d = nums[i - 1] - nums[i];
                    t = 0;
                }
                ans += t;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}