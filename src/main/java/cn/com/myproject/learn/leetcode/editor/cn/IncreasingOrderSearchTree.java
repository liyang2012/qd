//Given the root of a binary search tree, rearrange the tree in in-order so that
// the leftmost node in the tree is now the root of the tree, and every node has n
//o left child and only one right child. 
//
// 
// Example 1: 
//
// 
//Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
//Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
// 
//
// Example 2: 
//
// 
//Input: root = [5,1,7]
//Output: [1,null,5,null,7]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the given tree will be in the range [1, 100]. 
// 0 <= Node.val <= 1000 
// Related Topics 树 深度优先搜索 递归 
// 👍 187 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class IncreasingOrderSearchTree{
    public static void main(String[] args) {
       Solution solution = new IncreasingOrderSearchTree().new Solution();
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
        private TreeNode resNode;

        public TreeNode increasingBST(TreeNode root) {
            TreeNode dummyNode = new TreeNode(-1);
            resNode = dummyNode;
            inorder(root);
            return dummyNode.right;
        }

        public void inorder(TreeNode node) {
            if (node == null) {
                return;
            }
            inorder(node.left);

            // 在中序遍历的过程中修改节点指向
            resNode.right = node;
            node.left = null;
            resNode = node;

            inorder(node.right);
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}