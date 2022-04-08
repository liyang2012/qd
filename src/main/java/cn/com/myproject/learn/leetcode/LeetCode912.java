package cn.com.myproject.learn.leetcode;

import java.util.Arrays;

/**
 * 912. 排序数组
 * 给定一个整数数组 nums，将该数组升序排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：[5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * -50000 <= A[i] <= 50000
 *
 *
 * */
public class LeetCode912 {
    public int[] sortArray(int[] nums) {
        sort(nums,0,nums.length-1);
        return nums;
    }

    private void sort(int a[], int low, int hight) {
        int i, j, index;
        if (low > hight) {
            return;
        }
        i = low;
        j = hight;
        index = a[i]; // 用子表的第一个记录做基准
        while (i < j) { // 从表的两端交替向中间扫描
            while (i < j && a[j] >= index) {
                j--;
            }
            if (i < j) {
                a[i++] = a[j];// 用比基准小的记录替换低位记录
            }
            while (i < j && a[i] < index) {
                i++;
            }
            if (i < j) {// 用比基准大的记录替换高位记录
                a[j--] = a[i];
            }
        }
        a[i] = index;// 将基准数值替换回 a[i]
        sort(a, low, i - 1); // 对低子表进行递归排序
        sort(a, i + 1, hight); // 对高子表进行递归排序

    }
    public static void main(String[] args) {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 49 };
        LeetCode912 lc912 = new LeetCode912();
        lc912.sortArray(a);
        System.out.println(Arrays.toString(a));
    }
}
