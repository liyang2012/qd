package cn.com.myproject.learn.leetcode;

import java.util.Arrays;

/**
 *不同路径
 *个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 *
 *
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 *
 *
 *
 * 示例 1:
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 *
 * 输入: m = 7, n = 3
 * 输出: 28
 *
 *
 * 提示：
 *
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 10 ^ 9
 * */
public class LeetCode62 {
    public int uniquePaths(int m, int n) {
        int[][] r = new int[m][n];
        r[0][0] = 1;
        for(int i=1;i<m;i++) {
            r[i][0] = 1;
        }
        for(int i=1;i<n;i++) {
            r[0][i] = 1;
        }
        for(int i=1;i< m;i++){
            for(int j=1;j<n;j++) {
                r[i][j] = r[i-1][j]+r[i][j-1];
            }
        }
        return r[m-1][n-1];
    }

    public int uniquePaths1(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1] ;
            }
        }
        return cur[n-1];
    }

    public static void main(String[] args) {
        LeetCode62 lc62 = new LeetCode62();
        System.out.println(lc62.uniquePaths(7,3));
    }
}
