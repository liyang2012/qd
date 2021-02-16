//Given an array of integers nums and an integer k. A subarray is called nice if
// there are k odd numbers on it. 
//
// Return the number of nice sub-arrays. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,2,1,1], k = 3
//Output: 2
//Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1
//].
// 
//
// Example 2: 
//
// 
//Input: nums = [2,4,6], k = 1
//Output: 0
//Explanation: There is no odd numbers in the array.
// 
//
// Example 3: 
//
// 
//Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
//Output: 16
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 50000 
// 1 <= nums[i] <= 10^5 
// 1 <= k <= nums.length 
// 
// Related Topics 双指针

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class CountNumberOfNiceSubarrays{
    public static void main(String[] args) {
       Solution solution = new CountNumberOfNiceSubarrays().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfSubarrays(int[] nums, int k) {
            int n = nums.length;
            int l = 0, r = -1, cnt = 0;
            int ans = 0;
            while (r + 1 < n) {
                cnt += nums[++r] & 1;
                while (r + 1 < n && cnt < k) {
                    cnt += nums[++r] & 1;
                }
                if (r > n) {
                    break;
                }
                int k_cnt_right_begin = r;
                while (r + 1 < n && (nums[r + 1] & 1)  == 0) {
                    ++r;
                }
                while (l <= r  && cnt == k) {
                    ans += r - k_cnt_right_begin + 1;
                    cnt -= nums[l++] & 1;
                }

            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}