//Given two strings text1 and text2, return the length of their longest common s
//ubsequence. 
//
// A subsequence of a string is a new string generated from the original string 
//with some characters(can be none) deleted without changing the relative order of
// the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is
// not). A common subsequence of two strings is a subsequence that is common to bo
//th strings. 
//
// 
//
// If there is no common subsequence, return 0. 
//
// 
// Example 1: 
//
// 
//Input: text1 = "abcde", text2 = "ace" 
//Output: 3  
//Explanation: The longest common subsequence is "ace" and its length is 3.
// 
//
// Example 2: 
//
// 
//Input: text1 = "abc", text2 = "abc"
//Output: 3
//Explanation: The longest common subsequence is "abc" and its length is 3.
// 
//
// Example 3: 
//
// 
//Input: text1 = "abc", text2 = "def"
//Output: 0
//Explanation: There is no such common subsequence, so the result is 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= text1.length <= 1000 
// 1 <= text2.length <= 1000 
// The input strings consist of lowercase English characters only. 
// 
// Related Topics 动态规划

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class LongestCommonSubsequence{
    public static void main(String[] args) {
       Solution solution = new LongestCommonSubsequence().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
                return 0;
            }
            char[] c1 = text1.toCharArray();
            char[] c2 = text2.toCharArray();
            int m = c1.length, n = c2.length;
            int[][] dp = new int[m][n];
            dp[0][0] = c1[0] == c2[0] ? 1 : 0;
            for (int i = 1; i < m; i++) {
                dp[i][0] = c1[i] == c2[0] ? 1 : dp[i - 1][0];
            }

            for (int j = 1; j < n; j++) {
                dp[0][j] = c1[0] == c2[j] ? 1 : dp[0][j - 1];
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    if (c1[i] == c2[j]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                    }
                }
            }
            return dp[m - 1][n - 1];

        }
        public int longestCommonSubsequence2nd(String text1, String text2) {
            if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
                return 0;
            }
            int m = text1.length(), n = text2.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }
            return dp[m][n];
        }

        public int longestCommonSubsequence3rd(String text1, String text2) {
            if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
                return 0;
            }
            int m = text1.length(), n = text2.length();
            int[] dp = new int[n + 1];
            int tmp = 0;
            for (int i = 1; i <= m; i++) {
                int last = 0;
                for (int j = 1; j <= n; j++) {
                    tmp = dp[j];
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)){
                        dp[j] = last + 1;
                    } else {
                        dp[j] = Math.max(tmp, dp[j - 1]);
                    }
                    last = tmp;
                }
            }
            return dp[n];
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}