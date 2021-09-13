//Given a string s containing only three types of characters: '(', ')' and '*', 
//return true if s is valid. 
//
// The following rules define a valid string: 
//
// 
// Any left parenthesis '(' must have a corresponding right parenthesis ')'. 
// Any right parenthesis ')' must have a corresponding left parenthesis '('. 
// Left parenthesis '(' must go before the corresponding right parenthesis ')'. 
//
// '*' could be treated as a single right parenthesis ')' or a single left 
//parenthesis '(' or an empty string "". 
// 
//
// 
// Example 1: 
// Input: s = "()"
//Output: true
// Example 2: 
// Input: s = "(*)"
//Output: true
// Example 3: 
// Input: s = "(*))"
//Output: true
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 100 
// s[i] is '(', ')' or '*'. 
// 
// Related Topics 栈 贪心 字符串 动态规划 👍 361 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class ValidParenthesisString{
    public static void main(String[] args) {
       Solution solution = new ValidParenthesisString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkValidString(String s) {
        int minCount = 0, maxCount = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                minCount++;
                maxCount++;
            } else if (c == ')') {
                minCount = Math.max(minCount - 1, 0);
                maxCount--;
                if (maxCount < 0) {
                    return false;
                }
            } else {
                minCount = Math.max(minCount - 1, 0);
                maxCount++;
            }
        }
        return minCount == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}