//You are building a diving board by placing a bunch of planks of wood end-to-en
//d. There are two types of planks, one of length shorter and one of length longer
//. You must use exactly K planks of wood. Write a method to generate all possible
// lengths for the diving board. 
//
// return all lengths in non-decreasing order. 
//
// Example: 
//
// 
//Input: 
//shorter = 1
//longer = 2
//k = 3
//Output:  {3,4,5,6}
// 
//
// Note: 
//
// 
// 0 < shorter <= longer 
// 0 <= k <= 100000 
// 
// Related Topics 递归 记忆化

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.Arrays;

public class DivingBoardLcci{
    public static void main(String[] args) {
        Solution solution = new DivingBoardLcci().new Solution();
        int[] res = solution.divingBoard(1, 2, 3);
        System.out.println(Arrays.toString(res));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] divingBoard(int shorter, int longer, int k) {
            if(k == 0) return new int[0];
            if(shorter == longer) {
                return new int[]{k * shorter};
            }
            int[] res = new int[k+1];
            for(int i = 0; i < k + 1; i ++) {
                res[i] = (k - i) * shorter + i * longer;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}