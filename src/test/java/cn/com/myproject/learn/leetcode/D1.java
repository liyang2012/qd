package cn.com.myproject.learn.leetcode;

import java.util.Arrays;

/**
 * 面试题 10.01. 合并排序的数组
 * */
public class D1 {
    /**
     * 单指针
     * */
    public static void merge(int[] a, int m, int[] b, int n) {
        System.arraycopy(b,0,a,m,n);
        int p1 = 0;
        for(int i=m;i<a.length;i++) {
            for(int j=p1;j<i+1;j++){
                if(a[i]>a[j]) {
                    p1++;
                }else{
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

    }

    /**
     * 双指针
     * */


    public static void main(String[] args) {
        int[] a = {1,2,6,7,0,0};
        int[] b = {4,5};
        merge(a,4,b,2);
        System.out.println(Arrays.toString(a));
    }
}
