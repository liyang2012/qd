//Given preorder and inorder traversal of a tree, construct the binary tree. 
//
// Note: 
//You may assume that duplicates do not exist in the tree. 
//
// For example, given 
//
// 
//preorder = [3,9,20,15,7]
//inorder = [9,3,15,20,7] 
//
// Return the following binary tree: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args) {
       Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
        int pre_idx = 0;
        //前序
        int[] preorder;
        //中序
        int[] inorder;
        //中序索引位置
        HashMap<Integer, Integer> idx_map = new HashMap<>();

        private TreeNode helper(int in_left, int in_right) {
            // if there is no elements to construct subtrees
            if (in_left == in_right) {
                return null;
            }

            // pick up pre_idx element as a root
            int root_val = preorder[pre_idx];
            TreeNode root = new TreeNode(root_val);

            // root splits inorder list
            // into left and right subtrees
            int index = idx_map.get(root_val);

            // recursion
            pre_idx++;
            // build left subtree
            root.left = helper(in_left, index);
            // build right subtree
            root.right = helper(index + 1, in_right);
            return root;
        }

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            this.inorder = inorder;

            // build a hashmap value -> its index
            int idx = 0;
            for (Integer val : inorder) {
                idx_map.put(val, idx++);
            }
            return helper(0, inorder.length);
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}