package cn.com.myproject.learn.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称二叉树
 * */
public class LeetCode101 {

    /**
     * 递归
     * */
    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null){
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }

    /**
     * 迭代
     * */
    public static boolean isSymmetric1(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null){
                continue;
            }
            if (t1 == null || t2 == null){
                return false;
            }
            if (t1.val != t2.val){
                return false;
            }
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);

        System.out.println(isSymmetric(root));
    }
}
