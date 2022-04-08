//Given a string columnTitle that represents the column title as appear in an 
//Excel sheet, return its corresponding column number. 
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
//Input: columnTitle = "A"
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: columnTitle = "AB"
//Output: 28
// 
//
// Example 3: 
//
// 
//Input: columnTitle = "ZY"
//Output: 701
// 
//
// 
// Constraints: 
//
// 
// 1 <= columnTitle.length <= 7 
// columnTitle consists only of uppercase English letters. 
// columnTitle is in the range ["A", "FXSHRXW"]. 
// 
// Related Topics 数学 字符串 👍 313 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ExcelSheetColumnNumber{
    public static void main(String[] args) {
       Solution solution = new ExcelSheetColumnNumber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int titleToNumber(String columnTitle) {
            int number = 0;
            int multiple = 1;
            for (int i = columnTitle.length() - 1; i >= 0; i--) {
                int k = columnTitle.charAt(i) - 'A' + 1;
                number += k * multiple;
                multiple *= 26;
            }
            return number;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}