//Given a non-empty array of digits representing a non-negative integer, plus on
//e to the integer. 
//
// The digits are stored such that the most significant digit is at the head of 
//the list, and each element in the array contain a single digit. 
//
// You may assume the integer does not contain any leading zero, except the numb
//er 0 itself. 
//
// Example 1: 
//
// 
//Input: [1,2,3]
//Output: [1,2,4]
//Explanation: The array represents the integer 123.
// 
//
// Example 2: 
//
// 
//Input: [4,3,2,1]
//Output: [4,3,2,2]
//Explanation: The array represents the integer 4321.
// Related Topics 数组

  
package cn.com.myproject.learn.leetcode.editor.cn;


public class PlusOne{
    public static void main(String[] args) {
       Solution solution = new PlusOne().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            int len = digits.length;
            int i = len - 1;
            digits[i]++;
            while (i >= 0) {
                if (digits[i] > 9) {
                    digits[i] = digits[i] % 10;
                    if (i != 0) {
                        digits[i-1]++;
                    }
                } else {
                    return digits;
                }
                i--;
            }
            int[] result = new int[len + 1];
            result[0] = 1;
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}