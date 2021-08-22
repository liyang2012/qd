//Given a string s and an integer k, reverse the first k characters for every 2k
// characters counting from the start of the string. 
//
// If there are fewer than k characters left, reverse all of them. If there are 
//less than 2k but greater than or equal to k characters, then reverse the first k
// characters and left the other as original. 
//
// 
// Example 1: 
// Input: s = "abcdefg", k = 2
//Output: "bacdfeg"
// Example 2: 
// Input: s = "abcd", k = 2
//Output: "bacd"
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 104 
// s consists of only lowercase English letters. 
// 1 <= k <= 104 
// 
// Related Topics 双指针 字符串 
// 👍 176 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class ReverseStringIi{
    public static void main(String[] args) {
       Solution solution = new ReverseStringIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseStr(String s, int k) {
            int n = s.length();
            char[] arr = s.toCharArray();
            for (int i = 0; i < n; i += 2 * k) {
                reverse(arr, i, Math.min(i + k, n) - 1);
            }
            return new String(arr);
        }
        void reverse(char[] arr, int left, int right) {
            while (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}