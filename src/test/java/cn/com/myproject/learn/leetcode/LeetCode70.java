package cn.com.myproject.learn.leetcode;

/**
 * 怕楼梯
 * */
public class LeetCode70 {

    /**
     * 暴力法
     * */
    public static int climbStairs1(int n) {
        return climb_Stairs(0, n);
    }
    public static int  climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }


    public static void main(String[] args) {
        System.out.println(climbStairs1(5));
    }
}
