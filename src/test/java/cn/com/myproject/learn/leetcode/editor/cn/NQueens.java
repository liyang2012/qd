//The n-queens puzzle is the problem of placing n queens on an n×n chessboard su
//ch that no two queens attack each other. 
//
// 
//
// Given an integer n, return all distinct solutions to the n-queens puzzle. 
//
// Each solution contains a distinct board configuration of the n-queens' placem
//ent, where 'Q' and '.' both indicate a queen and an empty space respectively. 
//
// Example: 
//
// 
//Input: 4
//Output: [
// [".Q..",  // Solution 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // Solution 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//Explanation: There exist two distinct solutions to the 4-queens puzzle as show
//n above.
// 
// Related Topics 回溯算法

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class NQueens{
    public static void main(String[] args) {
       Solution solution = new NQueens().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // rows 用于标记是否被列方向的皇后被攻击
        // hills 用于标记是否被主对角线方向的皇后被攻击
        // dales 用于标记是否被次对角线方向的皇后被攻击
        int[] rows, hills, dales;
        int n;
        List<List<String>> output = new ArrayList<>();
        // 用于存储皇后放置的位置
        int[] queens;

        public List<List<String>> solveNQueens(int n) {
            this.n = n;
            rows = new int[n];
            hills = new int[4 * n - 1];
            dales = new int[2 * n - 1];
            queens = new int[n];

            backtrack(0);
            return output;
        }
        private void backtrack(int row) {
            for (int col = 0; col < n; col++) {
                if (isNotUnderAttack(row, col)) {
                    placeQueen(row, col);
                    if (row + 1 == n) {
                        addSolution();
                    } else {
                        backtrack(row + 1);
                    }
                    reomveQueen(row, col);
                }
            }
        }

        private void reomveQueen(int row, int col) {
            queens[row] = 0;
            rows[col] = 0;
            hills[row - col + 2 * n] = 0;
            dales[row + col] = 0;
        }

        private void addSolution() {
            List<String> solution = new ArrayList<String>();
            for (int i = 0; i < n; ++i) {
                int col = queens[i];
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < col; ++j) {
                    sb.append(".");
                }
                sb.append("Q");
                for(int j = 0; j < n - col - 1; ++j) {
                    sb.append(".");
                }
                solution.add(sb.toString());
            }
            output.add(solution);
        }

        private void placeQueen(int row, int col) {
            // 在 row 行，col 列 放置皇后
            queens[row] = col;
            // 当前位置的列方向已经有皇后了
            rows[col] = 1;
            // 当前位置的主对角线方向已经有皇后了
            hills[row - col + 2 * n] = 1;
            // 当前位置的次对角线方向已经有皇后了
            dales[row + col] = 1;
        }

        // 判断 row 行，col 列这个位置有没有被其他方向的皇后攻击
        private boolean isNotUnderAttack(int row, int col) {
            // 判断的逻辑是：
            //      1. 当前位置的这一列方向没有皇后攻击
            //      2. 当前位置的主对角线方向没有皇后攻击
            //      3. 当前位置的次对角线方向没有皇后攻击
            int res = rows[col] + hills[row - col + 2 * n] + dales[row + col];
            return (res == 0) ? true : false;
        }
    }


    //leetcode submit region end(Prohibit modification and deletion)

}