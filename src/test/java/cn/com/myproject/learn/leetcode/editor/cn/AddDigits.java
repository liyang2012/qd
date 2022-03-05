//Given an integer num, repeatedly add all its digits until the result has only 
//one digit, and return it. 
//
// 
// Example 1: 
//
// 
//Input: num = 38
//Output: 2
//Explanation: The process is
//38 --> 3 + 8 --> 11
//11 --> 1 + 1 --> 2 
//Since 2 has only one digit, return it.
// 
//
// Example 2: 
//
// 
//Input: num = 0
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= num <= 2³¹ - 1 
// 
//
// 
// Follow up: Could you do it without any loop/recursion in O(1) runtime? 
// Related Topics 数学 数论 模拟 👍 493 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class AddDigits{
    public static void main(String[] args) {
       Solution solution = new AddDigits().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int addDigits(int num) {
            return (num - 1) % 9 + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}