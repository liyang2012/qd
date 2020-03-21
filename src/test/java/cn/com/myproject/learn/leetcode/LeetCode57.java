package cn.com.myproject.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * II. 和为s的连续正数序列
 * */
public class LeetCode57 {
    public static int[][] findContinuousSequence(int target) {
        int i = 1; // 滑动窗口的左边界
        int j = 1; // 滑动窗口的右边界
        int sum = 0; // 滑动窗口中数字的和
        List<int[]> res = new ArrayList<>();

        while (i <= target / 2) {
            if (sum < target) {
                // 右边界向右移动
                sum += j;
                j++;
            } else if (sum > target) {
                // 左边界向右移动
                sum -= i;
                i++;
            } else {
                // 记录结果
                int[] arr = new int[j-i];
                for (int k = i; k < j; k++) {
                    arr[k-i] = k;
                }
                res.add(arr);
                // 左边界向右移动
                sum -= i;
                i++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] r = findContinuousSequence(30);

        for(int[] i:r) {
            System.out.println(Arrays.toString(i));
        }

    }
}
