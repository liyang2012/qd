//Given an integer columnNumber, return its corresponding column title as it app
//ears in an Excel sheet. 
//
// For example: 
//
// 
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28 
//...
// 
//
// 
// Example 1: 
//
// 
//Input: columnNumber = 1
//Output: "A"
// 
//
// Example 2: 
//
// 
//Input: columnNumber = 28
//Output: "AB"
// 
//
// Example 3: 
//
// 
//Input: columnNumber = 701
//Output: "ZY"
// 
//
// Example 4: 
//
// 
//Input: columnNumber = 2147483647
//Output: "FXSHRXW"
// 
//
// 
// Constraints: 
//
// 
// 1 <= columnNumber <= 231 - 1 
// Related Topics 数学 字符串 
// 👍 405 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class ExcelSheetColumnTitle{
    public static void main(String[] args) {
       Solution solution = new ExcelSheetColumnTitle().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToTitle(int columnNumber) {
            StringBuilder sb = new StringBuilder();
            while (columnNumber > 0) {
                int a = (columnNumber - 1) % 26 + 1;
                sb.append((char)(a - 1 + 'A'));
                columnNumber = (columnNumber - a) / 26;
            }
            return sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}