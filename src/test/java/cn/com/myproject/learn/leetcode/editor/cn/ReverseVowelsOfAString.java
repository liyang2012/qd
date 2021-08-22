//Given a string s, reverse only all the vowels in the string and return it. 
//
// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases
//. 
//
// 
// Example 1: 
// Input: s = "hello"
//Output: "holle"
// Example 2: 
// Input: s = "leetcode"
//Output: "leotcede"
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 3 * 105 
// s consist of printable ASCII characters. 
// 
// Related Topics 双指针 字符串 
// 👍 208 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class ReverseVowelsOfAString{
    public static void main(String[] args) {
       Solution solution = new ReverseVowelsOfAString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            int n = s.length();
            char[] arr = s.toCharArray();
            int i = 0, j = n - 1;
            while (i < j) {
                while (i < n && !isVowel(arr[i])) {
                    ++i;
                }
                while (j > 0 && !isVowel(arr[j])) {
                     --j;
                }
                if (i < j) {
                    swap(arr, i, j);
                    ++i;
                    --j;
                }
            }
            return new String(arr);
        }

        public boolean isVowel(char ch) {
            return "aeiouAEIOU".indexOf(ch) >= 0;
        }

        public void swap(char[] arr, int i, int j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}