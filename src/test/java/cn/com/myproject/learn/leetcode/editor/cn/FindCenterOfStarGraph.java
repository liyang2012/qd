//There is an undirected star graph consisting of n nodes labeled from 1 to n. 
//A star graph is a graph where there is one center node and exactly n - 1 edges 
//that connect the center node with every other node. 
//
// You are given a 2D integer array edges where each edges[i] = [ui, vi] 
//indicates that there is an edge between the nodes ui and vi. Return the center of the 
//given star graph. 
//
// 
// Example 1: 
//
// 
//Input: edges = [[1,2],[2,3],[4,2]]
//Output: 2
//Explanation: As shown in the figure above, node 2 is connected to every other 
//node, so 2 is the center.
// 
//
// Example 2: 
//
// 
//Input: edges = [[1,2],[5,1],[1,3],[1,4]]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 3 <= n <= 10⁵ 
// edges.length == n - 1 
// edges[i].length == 2 
// 1 <= ui, vi <= n 
// ui != vi 
// The given edges represent a valid star graph. 
// 
// Related Topics 图 👍 29 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class FindCenterOfStarGraph{
    public static void main(String[] args) {
       Solution solution = new FindCenterOfStarGraph().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findCenter1(int[][] edges) {
            int n = edges.length + 1;
            int[] degrees = new int[n + 1];
            for (int[] edge : edges) {
                degrees[edge[0]]++;
                degrees[edge[1]]++;
            }
            for (int i = 1; i <= n; i++) {
                if (degrees[i] == n - 1) {
                    return i;
                }
            }
            return 0;
        }

        public int findCenter(int[][] edges) {
            return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}