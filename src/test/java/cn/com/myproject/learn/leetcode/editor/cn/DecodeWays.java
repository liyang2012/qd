//A message containing letters from A-Z is being encoded to numbers using the fo
//llowing mapping: 
//
// 
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// Given a non-empty string containing only digits, determine the total number o
//f ways to decode it. 
//
// Example 1: 
//
// 
//Input: "12"
//Output: 2
//Explanation: It could be decoded as "AB" (1 2) or "L" (12).
// 
//
// Example 2: 
//
// 
//Input: "226"
//Output: 3
//Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6)
//. 
// Related Topics 字符串 动态规划

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class DecodeWays{
    public static void main(String[] args) {
       Solution solution = new DecodeWays().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDecodings(String s) {
            char[] arr = s.toCharArray();
            int[] dp = new int[s.length() + 1];
            dp[0] = 1;
            dp[1] = arr[0] == '0' ? 0 : 1;
            if(s.length()<=1) {
                return dp[1];
            }
            for(int i = 2; i <= s.length(); i++){
                int n = (arr[i - 2] - '0') * 10 + (arr[i - 1] - '0');
                if(arr[i-1] == '0' && arr[i - 2] == '0'){
                    return 0;
                }else if(arr[i - 2] == '0'){
                    dp[i] = dp[i - 1];
                }else if(arr[i - 1] == '0'){
                    if(n > 26) {
                        return 0;
                    }
                    dp[i] = dp[i - 2];
                }else if(n > 26){
                    dp[i] = dp[i - 1];
                }else{
                    dp[i] = dp[i - 1]+dp[i - 2];
                }
            }

            return dp[dp.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}