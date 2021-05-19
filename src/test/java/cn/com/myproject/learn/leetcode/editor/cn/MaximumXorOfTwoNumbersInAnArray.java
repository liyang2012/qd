//Given an integer array nums, return the maximum result of nums[i] XOR nums[j],
// where 0 ≤ i ≤ j < n. 
//
// Follow up: Could you do this in O(n) runtime? 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,10,5,25,2,8]
//Output: 28
//Explanation: The maximum result is 5 XOR 25 = 28. 
//
// Example 2: 
//
// 
//Input: nums = [0]
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: nums = [2,4]
//Output: 6
// 
//
// Example 4: 
//
// 
//Input: nums = [8,10,2]
//Output: 10
// 
//
// Example 5: 
//
// 
//Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
//Output: 127
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 104 
// 0 <= nums[i] <= 231 - 1 
// 
// Related Topics 位运算 字典树 
// 👍 324 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class MaximumXorOfTwoNumbersInAnArray{
    public static void main(String[] args) {
       Solution solution = new MaximumXorOfTwoNumbersInAnArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 最高位的二进制位编号为 30
        static final int HIGH_BIT = 30;

        public int findMaximumXOR(int[] nums) {
            int x = 0;
            for (int k = HIGH_BIT; k >= 0; --k) {
                Set<Integer> seen = new HashSet<Integer>();
                // 将所有的 pre^k(a_j) 放入哈希表中
                for (int num : nums) {
                    // 如果只想保留从最高位开始到第 k 个二进制位为止的部分
                    // 只需将其右移 k 位
                    seen.add(num >> k);
                }

                // 目前 x 包含从最高位开始到第 k+1 个二进制位为止的部分
                // 我们将 x 的第 k 个二进制位置为 1，即为 x = x*2+1
                int xNext = x * 2 + 1;
                boolean found = false;

                // 枚举 i
                for (int num : nums) {
                    if (seen.contains(xNext ^ (num >> k))) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    x = xNext;
                } else {
                    // 如果没有找到满足等式的 a_i 和 a_j，那么 x 的第 k 个二进制位只能为 0
                    // 即为 x = x*2
                    x = xNext - 1;
                }
            }
            return x;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}