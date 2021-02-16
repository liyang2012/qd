//Given a non-empty array of integers, every element appears three times except 
//for one, which appears exactly once. Find that single one. 
//
// Note: 
//
// Your algorithm should have a linear runtime complexity. Could you implement i
//t without using extra memory? 
//
// Example 1: 
//
// 
//Input: [2,2,3,2]
//Output: 3
// 
//
// Example 2: 
//
// 
//Input: [0,1,0,1,0,1,99]
//Output: 99 
// Related Topics 位运算

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class SingleNumberIi{
    public static void main(String[] args) {
       Solution solution = new SingleNumberIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /***
         * 卡诺图
         * @param nums
         * @return
         */
        public int singleNumber(int[] nums) {
            int seenOnce = 0, seenTwice = 0;
            for (int num : nums) {
                seenOnce = -seenTwice & (seenOnce ^ num);
                seenTwice = -seenOnce & (seenTwice ^ num);
            }
            return seenOnce;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}