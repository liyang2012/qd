//On an N x N board, the numbers from 1 to N*N are written boustrophedonically s
//tarting from the bottom left of the board, and alternating direction each row. F
//or example, for a 6 x 6 board, the numbers are written as follows: 
//
// 
//
// 
//
// You start on square 1 of the board (which is always in the last row and first
// column). Each move, starting from square x, consists of the following: 
//
// 
// You choose a destination square S with number x+1, x+2, x+3, x+4, x+5, or x+6
//, provided this number is <= N*N.
//
// 
// (This choice simulates the result of a standard 6-sided die roll: ie., there 
//are always at most 6 destinations, regardless of the size of the board.) 
// 
// 
// If S has a snake or ladder, you move to the destination of that snake or ladd
//er. Otherwise, you move to S. 
// 
//
// A board square on row r and column c has a "snake or ladder" if board[r][c] !
//= -1. The destination of that snake or ladder is board[r][c]. 
//
// Note that you only take a snake or ladder at most once per move: if the desti
//nation to a snake or ladder is the start of another snake or ladder, you do not 
//continue moving. (For example, if the board is `[[4,-1],[-1,3]]`, and on the fir
//st move your destination square is `2`, then you finish your first move at `3`, 
//because you do not continue moving to `4`.) 
//
// Return the least number of moves required to reach square N*N. If it is not p
//ossible, return -1. 
//
// Example 1: 
//
// 
//Input: [
//[-1,-1,-1,-1,-1,-1],
//[-1,-1,-1,-1,-1,-1],
//[-1,-1,-1,-1,-1,-1],
//[-1,35,-1,-1,13,-1],
//[-1,-1,-1,-1,-1,-1],
//[-1,15,-1,-1,-1,-1]]
//Output: 4
//Explanation: 
//At the beginning, you start at square 1 [at row 5, column 0].
//You decide to move to square 2, and must take the ladder to square 15.
//You then decide to move to square 17 (row 3, column 5), and must take the snak
//e to square 13.
//You then decide to move to square 14, and must take the ladder to square 35.
//You then decide to move to square 36, ending the game.
//It can be shown that you need at least 4 moves to reach the N*N-th square, so 
//the answer is 4.
// 
//
// Note: 
//
// 
// 2 <= board.length = board[0].length <= 20 
// board[i][j] is between 1 and N*N or is equal to -1. 
// The board square with number 1 has no snake or ladder. 
// The board square with number N*N has no snake or ladder. 
// 
// Related Topics 广度优先搜索 数组 矩阵 
// 👍 71 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders{
    public static void main(String[] args) {
       Solution solution = new SnakesAndLadders().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int snakesAndLadders(int[][] board) {
            int n = board.length;
            boolean[] vis = new boolean[n * n + 1];
            Queue<int[]> queue = new LinkedList<int[]>();
            queue.offer(new int[]{1, 0});
            while (!queue.isEmpty()) {
                int[] p = queue.poll();
                for (int i = 1; i <= 6; ++i) {
                    int nxt = p[0] + i;
                    if (nxt > n * n) { // 超出边界
                        break;
                    }
                    int[] rc = id2rc(nxt, n); // 得到下一步的行列
                    if (board[rc[0]][rc[1]] > 0) { // 存在蛇或梯子
                        nxt = board[rc[0]][rc[1]];
                    }
                    if (nxt == n * n) { // 到达终点
                        return p[1] + 1;
                    }
                    if (!vis[nxt]) {
                        vis[nxt] = true;
                        queue.offer(new int[]{nxt, p[1] + 1}); // 扩展新状态
                    }
                }
            }
            return -1;
        }

        public int[] id2rc(int id, int n) {
            int r = (id - 1) / n, c = (id - 1) % n;
            if (r % 2 == 1) {
                c = n - 1 - c;
            }
            return new int[]{n - 1 - r, c};
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}