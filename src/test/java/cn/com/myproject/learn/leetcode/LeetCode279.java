package cn.com.myproject.learn.leetcode;

import java.util.*;

/**
 * 完全平方数
 *
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 *
 * */
public class LeetCode279 {

    /**
     * 回溯法
     * */
    public int numSquares(int n) {
        return numSquaresHelper(n, new HashMap<Integer, Integer>());
    }

    private int numSquaresHelper(int n, HashMap<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 0) {
            return 0;
        }
        int count = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            count = Math.min(count, numSquaresHelper(n - i * i, map) + 1);
        }
        map.put(n, count);
        return count;
    }

    /**
     * 动态规划
     * */
    static ArrayList<Integer> dp = new ArrayList<>();
    public int numSquares2(int n) {
        //第一次进入将 0 加入
        if(dp.size() == 0){
            dp.add(0);
        }
        //之前是否计算过 n
        if(dp.size() <= n){
            //接着之前最后一个值开始计算
            for (int i = dp.size(); i <= n; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j * j <= i; j++) {
                    min = Math.min(min, dp.get(i - j * j) + 1);
                }
                dp.add(min);
            }
        }
        return dp.get(n);
    }

    /**
     *BFS
     * */
    public int numSquares3(int n) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        int level = 0;
        queue.add(n);
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++; // 开始生成下一层
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                //依次减 1, 4, 9... 生成下一层的节点
                for (int j = 1; j * j <= cur; j++) {
                    int next = cur - j * j;
                    if (next == 0) {
                        return level;
                    }
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
        }
        return -1;
    }

    /**
     * 数学
     * */
    public int numSquare3(int n) {
        //判断是否是 1
        if (isSquare(n)) {
            return 1;
        }

        //判断是否是 4
        int temp = n;
        while (temp % 4 == 0) {
            temp /= 4;
        }
        if (temp % 8 == 7) {
            return 4;
        }

        //判断是否是 2
        for (int i = 1; i * i < n; i++) {
            if (isSquare(n - i * i)) {
                return 2;
            }
        }

        return 3;
    }

    //判断是否是平方数
    private boolean isSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    public static void main(String[] args) {
        LeetCode279 lc279 = new LeetCode279();
        System.out.println(lc279.numSquares(13));
    }

}
