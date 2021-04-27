//Given a list of non-negative integers nums, arrange them such that they form t
//he largest number. 
//
// Note: The result may be very large, so you need to return a string instead of
// an integer. 
//
// 
// Example 1: 
//
// 
//Input: nums = [10,2]
//Output: "210"
// 
//
// Example 2: 
//
// 
//Input: nums = [3,30,34,5,9]
//Output: "9534330"
// 
//
// Example 3: 
//
// 
//Input: nums = [1]
//Output: "1"
// 
//
// Example 4: 
//
// 
//Input: nums = [10]
//Output: "10"
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 109 
// 
// Related Topics 排序 
// 👍 616 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.Arrays;

public class LargestNumber{
    public static void main(String[] args) {
       Solution solution = new LargestNumber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            int n = nums.length;
            // 转换成包装类型，以便传入 Comparator 对象（此处为 lambda 表达式）
            Integer[] numsArr = new Integer[n];
            for (int i = 0; i < n; i++) {
                numsArr[i] = nums[i];
            }

            Arrays.sort(numsArr, (x, y) -> {
                long sx = 10, sy = 10;
                while (sx <= x) {
                    sx *= 10;
                }
                while (sy <= y) {
                    sy *= 10;
                }
                return (int) (-sy * x - y + sx * y + x);
            });

            if (numsArr[0] == 0) {
                return "0";
            }
            StringBuilder ret = new StringBuilder();
            for (int num : numsArr) {
                ret.append(num);
            }
            return ret.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}