//Given a binary tree, determine if it is a valid binary search tree (BST). 
//
// Assume a BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than the node's
// key. 
// The right subtree of a node contains only nodes with keys greater than the no
//de's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
//
// Example 1: 
//
// 
//    2
//   / \
//  1   3
//
//Input: [2,1,3]
//Output: true
// 
//
// Example 2: 
//
// 
//    5
//   / \
//  1   4
//     / \
//    3   6
//
//Input: [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
// 
// Related Topics 树 深度优先搜索

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.Stack;

public class ValidateBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        System.out.println( solution.isValidBST(root));

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
        public boolean helper(TreeNode node, Integer lower, Integer upper) {
            if (node == null) {
                return true;
            }

            int val = node.val;
            if (lower != null && val <= lower) {
                return false;
            }
            if (upper != null && val >= upper) {
                return false;
            }

            if (! helper(node.right, val, upper)) {
                return false;
            }
            if (! helper(node.left, lower, val)) {
                return false;
            }
            return true;
        }

        public boolean isValidBST(TreeNode root) {
            return helper(root, null, null);
        }


        public boolean isValidBST1(TreeNode root) {
            Stack<TreeNode> stack = new Stack();
            long inorder = Long.MIN_VALUE;

            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
                if (root.val <= inorder) return false;
                inorder = root.val;
                root = root.right;
            }
            return true;
        }

        long pre = Long.MIN_VALUE;
        public boolean isValidBST2(TreeNode root) {
            if (root == null) {
                return true;
            }
            // 访问左子树
            if (!isValidBST(root.left)) {
                return false;
            }
            // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
            if (root.val <= pre) {
                return false;
            }
            pre = root.val;
            // 访问右子树
            return isValidBST(root.right);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}