package cn.com.myproject.learn.leetcode;

import java.util.Arrays;

/**
 *945. 使数组唯一的最小增量
 *给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 *
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 *
 * 示例 1:
 *
 * 输入：[1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 * 示例 2:
 *
 * 输入：[3,2,1,2,1,7]
 * 输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 * 提示：
 *
 * 0 <= A.length <= 40000
 * 0 <= A[i] < 40000
 * */
public class LeetCode945 {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);

        //操作次数
        int ans = 0;
        //重复个数
        int taken = 0;

        for (int i = 1; i < A.length; ++i) {
            if (A[i-1] == A[i]) {
                taken++;
                ans -= A[i];
            } else {
                int give = Math.min(taken, A[i] - A[i-1] - 1);
                ans += give * (give + 1) / 2 + give * A[i-1];
                taken -= give;
            }
        }

        if (A.length > 0) {
            ans += taken * (taken + 1) / 2 + taken * A[A.length - 1];
        }

        return ans;
    }

    public static int minIncrementForUnique1(int[] A) {

        if(A == null || A.length == 0){
            return 0;
        }

        int max = 0;

        for(int i = 0; i < A.length; i++){
            max = Math.max(A[i],max);
        }

        int[] B = new int[max + 40000];
        for(int i = 0; i < A.length; i++){
            B[A[i]]++;
        }
        int number = 0;

        for(int i = 0; i < B.length - 1; i++){
            int count = B[i];
            if(count > 1){
                B[i + 1] += count - 1;
                number += count - 1;
            }
        }
        return number;
    }

    public static void main(String[] args) {

    }
}
