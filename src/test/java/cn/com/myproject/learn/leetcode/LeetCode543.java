package cn.com.myproject.learn.leetcode;

/**
 * 二叉树的直径
 * */
public class LeetCode543 {
    int res = 0;
    public  int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    // 函数dfs的作用是：找到以root为根节点的二叉树的最大深度
    public  int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        res = Math.max(res,leftDepth + rightDepth);
        return Math.max(leftDepth,rightDepth) + 1;
    }

    public static void main(String[] args) {

    }
}
