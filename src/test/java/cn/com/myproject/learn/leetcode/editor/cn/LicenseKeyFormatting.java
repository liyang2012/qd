//You are given a license key represented as a string s that consists of only 
//alphanumeric characters and dashes. The string is separated into n + 1 groups by 
//n dashes. You are also given an integer k. 
//
// We want to reformat the string s such that each group contains exactly k 
//characters, except for the first group, which could be shorter than k but still 
//must contain at least one character. Furthermore, there must be a dash inserted 
//between two groups, and you should convert all lowercase letters to uppercase. 
//
// Return the reformatted license key. 
//
// 
// Example 1: 
//
// 
//Input: s = "5F3Z-2e-9-w", k = 4
//Output: "5F3Z-2E9W"
//Explanation: The string s has been split into two parts, each part has 4 
//characters.
//Note that the two extra dashes are not needed and can be removed.
// 
//
// Example 2: 
//
// 
//Input: s = "2-5g-3-J", k = 2
//Output: "2-5G-3J"
//Explanation: The string s has been split into three parts, each part has 2 
//characters except the first part as it could be shorter as mentioned above.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s consists of English letters, digits, and dashes '-'. 
// 1 <= k <= 10⁴ 
// 
// Related Topics 字符串 👍 111 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class LicenseKeyFormatting{
    public static void main(String[] args) {
       Solution solution = new LicenseKeyFormatting().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String licenseKeyFormatting(String s, int k) {
            StringBuilder ans = new StringBuilder();
            int cnt = 0;
            int len = s.length();
            for (int i = len - 1; i >= 0; i--) {
                if (s.charAt(i) != '-') {
                    cnt++;
                    ans.append(Character.toUpperCase(s.charAt(i)));
                    if (cnt % k == 0) {
                        ans.append("-");
                    }
                }
            }
            if (ans.length() > 0 && ans.charAt(ans.length() - 1) == '-') {
                ans.deleteCharAt(ans.length() - 1);
            }

            return ans.reverse().toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}