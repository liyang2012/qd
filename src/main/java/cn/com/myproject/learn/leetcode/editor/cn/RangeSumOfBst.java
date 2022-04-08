//Given the root node of a binary search tree, return the sum of values of all n
//odes with a value in the range [low, high]. 
//
// 
// Example 1: 
//
// 
//Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
//Output: 32
// 
//
// Example 2: 
//
// 
//Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
//Output: 23
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 2 * 104]. 
// 1 <= Node.val <= 105 
// 1 <= low <= high <= 105 
// All Node.val are unique. 
// Related Topics 树 深度优先搜索 递归 
// 👍 199 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class RangeSumOfBst{
    public static void main(String[] args) {
       Solution solution = new RangeSumOfBst().new Solution();
       TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);

        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(7);


        node.right = new TreeNode(15);
        node.right.right = new TreeNode(18);

        solution.rangeSumBST(node, 7, 15);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        private int low;
        private int high;
        private int sum = 0;

        public int rangeSumBST(TreeNode root, int low, int high) {
            this.low = low;
            this.high = high;
            dfs(root);
            System.out.println(sum);
            return sum;
        }

        private void dfs (TreeNode node) {
            if (node == null) {
                return;
            }
            if (node.val >= low && node.val <= high) {
                sum += node.val;
                dfs(node.left);
                dfs(node.right);
                return;
            }
            if (node.val < low) {
                dfs(node.right);
                return;
            }
            if (node.val > high) {
                dfs(node.left);
                return;
            }


        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}