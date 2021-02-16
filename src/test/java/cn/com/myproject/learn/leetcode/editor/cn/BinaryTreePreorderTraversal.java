//Given a binary tree, return the preorder traversal of its nodes' values. 
//
// Example: 
//
// 
//Input: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//Output: [1,2,3]
// 
//
// Follow up: Recursive solution is trivial, could you do it iteratively? 
// Related Topics 栈 树

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreePreorderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        List<Integer> list = solution.preorderTraversal(treeNode);
        System.out.println(list.toString());
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
        /***
         * 递归
         * @param root
         * @return
         */
        public List<Integer> preorderTraversal1(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            helper(root,result);
            return result;
        }
        private void helper(TreeNode root, List<Integer> result) {
            if (root == null) {
                return;
            }
            result.add(root.val);
            if (root.left != null) {
                helper(root.left, result);
            }
            if (root.right != null) {
                helper(root.right, result);
            }
        }
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList< >();
            Deque<TreeNode> deque = new ArrayDeque();
            if (root == null) {
                return result;
            }
            deque.offerLast(root);
            while (!deque.isEmpty()) {
                TreeNode node = deque.pollLast();
                result.add(node.val);
                if (node.right != null) {
                    deque.offerLast(node.right);
                }
                if (node.left != null) {
                    deque.offerLast(node.left);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}