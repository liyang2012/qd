//There is a strange printer with the following two special properties: 
//
// 
// The printer can only print a sequence of the same character each time. 
// At each turn, the printer can print new characters starting from and ending a
//t any place and will cover the original existing characters. 
// 
//
// Given a string s, return the minimum number of turns the printer needed to pr
//int it. 
//
// 
// Example 1: 
//
// 
//Input: s = "aaabbb"
//Output: 2
//Explanation: Print "aaa" first and then print "bbb".
// 
//
// Example 2: 
//
// 
//Input: s = "aba"
//Output: 2
//Explanation: Print "aaa" first and then print "b" from the second place of the
// string, which will cover the existing character 'a'.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 100 
// s consists of lowercase English letters. 
// 
// Related Topics 深度优先搜索 动态规划 
// 👍 197 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class StrangePrinter{
    public static void main(String[] args) {
       Solution solution = new StrangePrinter().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strangePrinter(String s) {
            int n = s.length();
            int[][] f = new int[n][n];
            for (int i = n - 1; i >= 0; i--) {
                f[i][i] = 1;
                for (int j = i + 1; j < n; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        f[i][j] = f[i][j - 1];
                    } else {
                        int minn = Integer.MAX_VALUE;
                        for (int k = i; k < j; k++) {
                            minn = Math.min(minn, f[i][k] + f[k + 1][j]);
                        }
                        f[i][j] = minn;
                    }
                }
            }
            return f[0][n - 1];
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}