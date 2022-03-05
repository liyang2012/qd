//You are given an integer array nums. The range of a subarray of nums is the 
//difference between the largest and smallest element in the subarray. 
//
// Return the sum of all subarray ranges of nums. 
//
// A subarray is a contiguous non-empty sequence of elements within an array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3]
//Output: 4
//Explanation: The 6 subarrays of nums are the following:
//[1], range = largest - smallest = 1 - 1 = 0 
//[2], range = 2 - 2 = 0
//[3], range = 3 - 3 = 0
//[1,2], range = 2 - 1 = 1
//[2,3], range = 3 - 2 = 1
//[1,2,3], range = 3 - 1 = 2
//So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4. 
//
// Example 2: 
//
// 
//Input: nums = [1,3,3]
//Output: 4
//Explanation: The 6 subarrays of nums are the following:
//[1], range = largest - smallest = 1 - 1 = 0
//[3], range = 3 - 3 = 0
//[3], range = 3 - 3 = 0
//[1,3], range = 3 - 1 = 2
//[3,3], range = 3 - 3 = 0
//[1,3,3], range = 3 - 1 = 2
//So the sum of all ranges is 0 + 0 + 0 + 2 + 0 + 2 = 4.
// 
//
// Example 3: 
//
// 
//Input: nums = [4,-2,-3,4,1]
//Output: 59
//Explanation: The sum of all subarray ranges of nums is 59.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
// Follow-up: Could you find a solution with O(n) time complexity? 
// Related Topics 栈 数组 单调栈 👍 127 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class SumOfSubarrayRanges{
    public static void main(String[] args) {
       Solution solution = new SumOfSubarrayRanges().new Solution();
       long l = solution.subArrayRanges(new int[]{1,2,3,4});
        System.out.println(l);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long subArrayRanges(int[] nums) {
            int n = nums.length;
            long ret = 0;
            for (int i = 0; i < n; i++) {
                int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
                for (int j = i; j < n; j++) {
                    minVal = Math.min(minVal, nums[j]);
                    maxVal = Math.max(maxVal, nums[j]);
                    ret += maxVal - minVal;
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}