//Given a non-empty binary tree, return the average value of the nodes on each l
//evel in the form of an array.
//
// Example 1: 
// 
//Input:
//    3
//   / \
//  9  20
//    /  \
//   15   7
//Output: [3, 14.5, 11]
//Explanation:
//The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 
//2 is 11. Hence return [3, 14.5, 11].
// 
// 
//
// Note: 
// 
// The range of node's value is in the range of 32-bit signed integer. 
// 
// Related Topics 树 
// 👍 178 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree{
    public static void main(String[] args) {
       Solution solution = new AverageOfLevelsInBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Integer> counts = new ArrayList<>();
            List<Double> sums = new ArrayList<>();
            dfs(root, 0, counts, sums);
            List<Double> averages = new ArrayList<>();
            int size = sums.size();
            for (int i = 0; i < size; i++) {
                averages.add(sums.get(i) / counts.get(i));
            }
            return averages;
        }

        public void dfs(TreeNode root, int level, List<Integer> counts, List<Double> sums) {
            if (root == null) {
                return;
            }
            if (level < sums.size()) {
                sums.set(level, sums.get(level) + root.val);
                counts.set(level, counts.get(level) + 1);
            } else {
                sums.add(1.0 * root.val);
                counts.add(1);
            }
            dfs(root.left, level + 1, counts, sums);
            dfs(root.right, level + 1, counts, sums);
        }

        /**
         * bfs
         * @param root
         * @return
         */
        public List<Double> averageOfLevels1(TreeNode root) {
            List<Double> averages = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                double sum = 0;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    sum += node.val;
                    TreeNode left = node.left, right = node.right;
                    if (left != null) {
                        queue.offer(left);
                    }
                    if (right != null) {
                        queue.offer(right);
                    }
                }
                averages.add(sum / size);
            }
            return averages;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}