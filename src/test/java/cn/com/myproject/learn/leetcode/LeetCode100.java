package cn.com.myproject.learn.leetcode;

import java.util.ArrayDeque;

/**
 *相同的树
 * */
public class LeetCode100 {

    /**
     * 递归
     * */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // p and q are both null
        if (p == null && q == null){
            return true;
        }
        // one of p and q is null
        if (q == null || p == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);

    }
    /**
     * 迭代
     * */
    public static boolean isSameTree1(TreeNode p, TreeNode q) {

        if (!check(p, q)) {
            return false;
        }

        // init deques
        ArrayDeque<TreeNode> deqP = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> deqQ = new ArrayDeque<TreeNode>();
        deqP.addLast(p);
        deqQ.addLast(q);

        while (!deqP.isEmpty()) {
            p = deqP.removeFirst();
            q = deqQ.removeFirst();

            if (!check(p, q)){
                return false;
            }
            if (p != null) {
                // in Java nulls are not allowed in Deque
                if (!check(p.left, q.left)){
                    return false;
                }
                if (p.left != null) {
                    deqP.addLast(p.left);
                    deqQ.addLast(q.left);
                }
                if (!check(p.right, q.right)){
                    return false;
                }
                if (p.right != null) {
                    deqP.addLast(p.right);
                    deqQ.addLast(q.right);
                }
            }
        }
        return true;
    }
    public static boolean check(TreeNode p, TreeNode q) {
        // p and q are null
        if (p == null && q == null){
            return true;
        }
        // one of p and q is null
        if (q == null || p == null){
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(0);
        TreeNode q = new TreeNode(1);
        System.out.println(isSameTree(p,q));
    }
}
