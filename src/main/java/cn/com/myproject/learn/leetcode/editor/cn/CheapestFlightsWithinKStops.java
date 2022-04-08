//There are n cities connected by some number of flights. You are given an 
//array flights where flights[i] = [fromi, toi, pricei] indicates that there is a 
//flight from city fromi to city toi with cost pricei. 
//
// You are also given three integers src, dst, and k, return the cheapest price 
//from src to dst with at most k stops. If there is no such route, return -1. 
//
// 
// Example 1: 
//
// 
//Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k =
// 1
//Output: 200
//Explanation: The graph is shown.
//The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as 
//marked red in the picture.
// 
//
// Example 2: 
//
// 
//Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k =
// 0
//Output: 500
//Explanation: The graph is shown.
//The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as 
//marked blue in the picture.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 100 
// 0 <= flights.length <= (n * (n - 1) / 2) 
// flights[i].length == 3 
// 0 <= fromi, toi < n 
// fromi != toi 
// 1 <= pricei <= 10⁴ 
// There will not be any multiple flights between two cities. 
// 0 <= src, dst, k < n 
// src != dst 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 动态规划 最短路 堆（优先队列） 👍 361 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;

import org.bouncycastle.util.Arrays;

public class CheapestFlightsWithinKStops{
    public static void main(String[] args) {
       Solution solution = new CheapestFlightsWithinKStops().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            int inf = 10000 * 101 + 1;
            int[][] f = new int[k + 2][n];
            for (int i = 0; i < k + 2; ++i) {
                Arrays.fill(f[i], inf);
            }
            f[0][src] = 0;
            for (int t = 1; t <= k + 1; ++t) {
                for (int[] flight : flights) {
                    int j = flight[0], i = flight[1], cost = flight[2];
                    f[t][i] = Math.min(f[t][i], f[t - 1][j] + cost);
                }
            }
            int ans = inf;
            for (int t = 1; t <= k + 1; ++t) {
                ans = Math.min(ans, f[t][dst]);
            }
            return ans == inf ? -1 : ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}