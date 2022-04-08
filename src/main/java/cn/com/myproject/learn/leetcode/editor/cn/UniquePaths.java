//A robot is located at the top-left corner of a m x n grid (marked 'Start' in t
//he diagram below). 
//
// The robot can only move either down or right at any point in time. The robot 
//is trying to reach the bottom-right corner of the grid (marked 'Finish' in the d
//iagram below). 
//
// How many possible unique paths are there? 
//
// 
//Above is a 7 x 3 grid. How many possible unique paths are there? 
//
// 
// Example 1: 
//
// 
//Input: m = 3, n = 2
//Output: 3
//Explanation:
//From the top-left corner, there are a total of 3 ways to reach the bottom-righ
//t corner:
//1. Right -> Right -> Down
//2. Right -> Down -> Right
//3. Down -> Right -> Right
// 
//
// Example 2: 
//
// 
//Input: m = 7, n = 3
//Output: 28
// 
//
// 
// Constraints: 
//
// 
// 1 <= m, n <= 100 
// It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9. 
// 
// Related Topics 数组 动态规划

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.Arrays;

public class UniquePaths{
    public static void main(String[] args) {
       Solution solution = new UniquePaths().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths(int m, int n) {
            int[] cur = new int[n];
            Arrays.fill(cur, 1);
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    cur[j] += cur[j - 1];
                }
            }
            return cur[n - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}