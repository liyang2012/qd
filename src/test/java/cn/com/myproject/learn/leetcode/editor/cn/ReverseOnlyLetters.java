//Given a string s, reverse the string according to the following rules: 
//
// 
// All the characters that are not English letters remain in the same position. 
//
// All the English letters (lowercase or uppercase) should be reversed. 
// 
//
// Return s after reversing it. 
//
// 
// Example 1: 
// Input: s = "ab-cd"
//Output: "dc-ba"
// Example 2: 
// Input: s = "a-bC-dEf-ghIj"
//Output: "j-Ih-gfE-dCba"
// Example 3: 
// Input: s = "Test1ng-Leet=code-Q!"
//Output: "Qedo1ct-eeLg=ntse-T!"
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 100 
// s consists of characters with ASCII values in the range [33, 122]. 
// s does not contain '\"' or '\\'. 
// 
// Related Topics 双指针 字符串 👍 118 👎 0


package cn.com.myproject.learn.leetcode.editor.cn;
public class ReverseOnlyLetters{
    public static void main(String[] args) {
        Solution solution = new ReverseOnlyLetters().new Solution();
        System.out.println(solution.reverseOnlyLetters("7128"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseOnlyLetters(String s) {
            int i = 0;
            int j = s.length() - 1;
            char[] c = s.toCharArray();
            while (true) {
                while (i < j && !Character.isLetter(s.charAt(i))) {
                    i++;
                }
                while (j > i && !Character.isLetter(s.charAt(j))) {
                    j--;
                }
                if (i >= j) {
                    break;
                }
                c[i] = s.charAt(j);
                c[j] = s.charAt(i);
                i++;
                j--;

            }
            return String.valueOf(c);
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}