//Given an integer numRows, return the first numRows of Pascal's triangle. 
//
// In Pascal's triangle, each number is the sum of the two numbers directly 
//above it as shown: 
//
// 
// Example 1: 
// Input: numRows = 5
//Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// Example 2: 
// Input: numRows = 1
//Output: [[1]]
// 
// 
// Constraints: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics 数组 动态规划 👍 694 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle{
    public static void main(String[] args) {
       Solution solution = new PascalsTriangle().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ret = new ArrayList<List<Integer>>();
            for (int i = 0; i < numRows; ++i) {
                List<Integer> row = new ArrayList<Integer>();
                for (int j = 0; j <= i; ++j) {
                    if (j == 0 || j == i) {
                        row.add(1);
                    } else {
                        row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                    }
                }
                ret.add(row);
            }
            return ret;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}