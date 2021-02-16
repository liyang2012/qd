//Given an array of non-negative integers, you are initially positioned at the f
//irst index of the array. 
//
// Each element in the array represents your maximum jump length at that positio
//n. 
//
// Determine if you are able to reach the last index. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum jum
//p length is 0, which makes it impossible to reach the last index.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 10^4 
// 0 <= nums[i][j] <= 10^5 
// 
// Related Topics 贪心算法 数组

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class JumpGame{
    public static void main(String[] args) {
       Solution solution = new JumpGame().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 贪心 从前往后
         * @param nums
         * @return
         */
        public boolean canJump1(int[] nums) {
            if(nums.length < 2) {
                return true;
            }
            int n = nums.length;
            int rightmost = 0;
            for (int i = 0; i < n; ++i) {
                if (i <= rightmost) {
                    rightmost = Math.max(rightmost, i + nums[i]);
                    if (rightmost >= n - 1) {
                        return true;
                    }
                }
            }
            return false;
        }
        public boolean canJump2(int[] nums) {
            if(nums.length < 2) {
                return true;
            }

            for(int curr = nums.length-2; curr >= 0; curr--){
                if(nums[curr] == 0){
                    int neededJumps = 1;
                    while(neededJumps > nums[curr]){
                        neededJumps++;
                        curr--;
                        if(curr < 0) return false;
                    }
                }
            }
            return true;
        }
        public boolean canJump(int[] nums) {
            if(nums.length < 2) {
                return true;
            }
            int m = nums.length - 1;
            for (int i = m; i >= 0; i--) {
                if (nums[i] + i >= m) {
                    m = i;
                }
            }
            return m == 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}