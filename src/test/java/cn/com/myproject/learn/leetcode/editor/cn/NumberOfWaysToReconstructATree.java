//You are given an array pairs, where pairs[i] = [xi, yi], and: 
//
// 
// There are no duplicates. 
// xi < yi 
// 
//
// Let ways be the number of rooted trees that satisfy the following conditions:
// 
//
// 
// The tree consists of nodes whose values appeared in pairs. 
// A pair [xi, yi] exists in pairs if and only if xi is an ancestor of yi or yi 
//is an ancestor of xi. 
// Note: the tree does not have to be a binary tree. 
// 
//
// Two ways are considered to be different if there is at least one node that 
//has different parents in both ways. 
//
// Return: 
//
// 
// 0 if ways == 0 
// 1 if ways == 1 
// 2 if ways > 1 
// 
//
// A rooted tree is a tree that has a single root node, and all edges are 
//oriented to be outgoing from the root. 
//
// An ancestor of a node is any node on the path from the root to that node (
//excluding the node itself). The root has no ancestors. 
//
// 
// Example 1: 
//
// 
//Input: pairs = [[1,2],[2,3]]
//Output: 1
//Explanation: There is exactly one valid rooted tree, which is shown in the 
//above figure.
// 
//
// Example 2: 
//
// 
//Input: pairs = [[1,2],[2,3],[1,3]]
//Output: 2
//Explanation: There are multiple valid rooted trees. Three of them are shown 
//in the above figures.
// 
//
// Example 3: 
//
// 
//Input: pairs = [[1,2],[2,3],[2,4],[1,5]]
//Output: 0
//Explanation: There are no valid rooted trees. 
//
// 
// Constraints: 
//
// 
// 1 <= pairs.length <= 10⁵ 
// 1 <= xi < yi <= 500 
// The elements in pairs are unique. 
// 
// Related Topics 树 图 拓扑排序 👍 49 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumberOfWaysToReconstructATree{
    public static void main(String[] args) {
       Solution solution = new NumberOfWaysToReconstructATree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int checkWays(int[][] pairs) {
            Map<Integer, Set<Integer>> adj = new HashMap<Integer, Set<Integer>>();
            for (int[] p : pairs) {
                adj.putIfAbsent(p[0], new HashSet<Integer>());
                adj.putIfAbsent(p[1], new HashSet<Integer>());
                adj.get(p[0]).add(p[1]);
                adj.get(p[1]).add(p[0]);
            }
            /* 检测是否存在根节点*/
            int root = -1;
            Set<Map.Entry<Integer, Set<Integer>>> entries = adj.entrySet();
            for (Map.Entry<Integer, Set<Integer>> entry : entries) {
                int node = entry.getKey();
                Set<Integer> neighbours = entry.getValue();
                if (neighbours.size() == adj.size() - 1) {
                    root = node;
                }
            }
            if (root == -1) {
                return 0;
            }

            int res = 1;
            for (Map.Entry<Integer, Set<Integer>> entry : entries) {
                int node = entry.getKey();
                Set<Integer> neighbours = entry.getValue();
                if (node == root) {
                    continue;
                }
                int currDegree = neighbours.size();
                int parent = -1;
                int parentDegree = Integer.MAX_VALUE;

                /* 根据 degree 的大小找到 node 的父节点 parent */
                for (int neighbour : neighbours) {
                    if (adj.get(neighbour).size() < parentDegree && adj.get(neighbour).size() >= currDegree) {
                        parent = neighbour;
                        parentDegree = adj.get(neighbour).size();
                    }
                }
                if (parent == -1) {
                    return 0;
                }

                /* 检测 neighbours 是否是 adj[parent] 的子集 */
                for (int neighbour : neighbours) {
                    if (neighbour == parent) {
                        continue;
                    }
                    if (!adj.get(parent).contains(neighbour)) {
                        return 0;
                    }
                }
                if (parentDegree == currDegree) {
                    res = 2;
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}