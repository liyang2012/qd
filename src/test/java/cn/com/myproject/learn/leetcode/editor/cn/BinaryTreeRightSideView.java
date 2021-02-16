//Given a binary tree, imagine yourself standing on the right side of it, return
// the values of the nodes you can see ordered from top to bottom. 
//
// Example: 
//
// 
//Input: [1,2,3,null,5,null,4]
//Output: [1, 3, 4]
//Explanation:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// Related Topics 树 深度优先搜索 广度优先搜索

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView{
    public static void main(String[] args) {
       Solution solution = new BinaryTreeRightSideView().new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        left1.right = new TreeNode(5);
        root.left = left1;
        TreeNode right1 = new TreeNode(3);
//        right1.right = new TreeNode(4);
        root.right = right1;
        List<Integer> list = solution.rightSideView(root);
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
        public List<Integer> rightSideView1(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            LinkedList<TreeNode> level = new LinkedList<>();
            level.add(root);
            helper(level, result);
            return result;
        }
        private void helper(LinkedList<TreeNode> level, List<Integer> result) {
            if (level.isEmpty()) {
                return;
            }
            result.add(level.peekLast().val);
            LinkedList<TreeNode> nextLevel = new LinkedList<>();
            for (TreeNode node : level) {
                if (node.left != null) {
                    nextLevel.offer(node.left);
                }
                if (node.right != null) {
                    nextLevel.offer(node.right);
                }
            }
            helper(nextLevel, result);

        }

        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            dfs(root, 0, res); // 从根节点开始访问，根节点深度是0
            return res;
        }

        private void dfs(TreeNode root, int depth, List<Integer> res) {
            if (root == null) {
                return;
            }
            // 先访问 当前节点，再递归地访问 右子树 和 左子树。
            if (depth == res.size()) {   // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
                res.add(root.val);
            }
            depth++;
            dfs(root.right, depth, res);
            dfs(root.left, depth, res);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}