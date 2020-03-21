package cn.com.myproject.learn.leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * 腐烂的橘子
 *
 * bfs
 * */
public class LeetCode994 {


    // dr,dc 配合使用得到 grid[r][c] 上grid[r-1][c]左grid[r][c-1]下grid[r+1][c]右grid[r][c+1]的元素
    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, -1, 0, 1};

    public  static int orangesRotting(int[][] grid) {
        // 获取二维数组的行数row 和 列数 column
        int R = grid.length, C = grid[0].length;

        // queue : all starting cells with rotten oranges
        Queue<Integer> queue = new ArrayDeque();
        Map<Integer, Integer> depth = new HashMap();
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c)
                if (grid[r][c] == 2) {
                    int code = r * C + c;  // 转化为索引唯一的一维数组
                    queue.add(code); //存储腐烂橘子
                    depth.put(code, 0); //存储橘子变为腐烂时的时间,key为橘子的一维数组下标，value为变腐烂的时间
                }

        int ans = 0;
        while (!queue.isEmpty()) {
            int code = queue.remove();
            int r = code / C, c = code % C;
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    int nCode = nr * C + nc;
                    queue.add(nCode);
                    // 计次的关键 元素 grid[r][c] 的上左下右元素得腐烂时间应该一致
                    depth.put(nCode, depth.get(code) + 1);
                    ans = depth.get(nCode);
                }
            }
        }

        //检查grid，此时的grid能被感染已经都腐烂了，此时还新鲜的橘子无法被感染
        for (int[] row: grid) {
            for (int v : row) {
                if (v == 1) {
                    return -1;
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }
}
