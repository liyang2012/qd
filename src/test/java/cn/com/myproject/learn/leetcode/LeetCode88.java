package cn.com.myproject.learn.leetcode;

import java.util.Arrays;

/**
 * 合并两个有序数组
 * */
public class LeetCode88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0;
        while(j<n){
            if(m+j<=i){
                nums1[i]=nums2[j];
                j++;
                i++;
                continue;
            }
            if(nums2[j]<nums1[i]){
                for(int k=m+j;k>i;k--){
                   nums1[k] = nums1[k-1];
                }
                nums1[i] = nums2[j];
                j++;
            }
            i++;
        }

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{0,5,6};
        int m=3,n=3;
        merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));

    }
}
