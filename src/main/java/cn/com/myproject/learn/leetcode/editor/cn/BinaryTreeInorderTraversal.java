//Given a binary tree, return the inorder traversal of its nodes' values. 
//
// Example: 
//
// 
//Input: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//Output: [1,3,2] 
//
// Follow up: Recursive solution is trivial, could you do it iteratively? 
// Related Topics 栈 树 哈希表

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        List<Integer> list = solution.inorderTraversal(treeNode);
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
        //中序 左 根 右

        /***
         * 递归
         * @param root
         * @return
         */
        public List<Integer> inorderTraversal1(TreeNode root) {
            List<Integer> result = new ArrayList< >();
            helper(root, result);
            return result;
        }

        private void helper(TreeNode root, List<Integer> result) {
            if (root == null) {
                return;
            }
            if (root.left != null) {
                helper(root.left, result);
            }
            result.add(root.val);
            if (root.right != null) {
                helper(root.right, result);
            }
        }

        /**
         * 基于栈
         * @param root
         * @return
         */
        public List<Integer> inorderTraversal2(TreeNode root) {
            List<Integer> result = new ArrayList< >();
            Deque<TreeNode> deque = new ArrayDeque();
            TreeNode curr = root;
            while (curr != null || !deque.isEmpty()) {
                while (curr != null) {
                    deque.offerFirst(curr);
                    curr = curr.left;
                }
                curr = deque.pollFirst();
                result.add(curr.val);
                curr = curr.right;
            }
            return result;
        }

        /**
         * 莫里斯遍历
         * @param root
         * @return
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            TreeNode pre = null;
            while (root != null) {
                //如果左节点不为空，就将当前节点连带右子树全部挂到左节点的最右子树下面
                if (root.left != null) {
                    pre = root.left;
                    while (pre.right != null) {
                        pre = pre.right;
                    }
                    pre.right = root;
                    //将root指向root的left
                    TreeNode tmp = root;
                    root = root.left;
                    tmp.left = null;
                } else {
                    result.add(root.val);
                    root = root.right;
                }
            }
            return result;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}