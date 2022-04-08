package cn.com.myproject.learn.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * */
public class BubbleSort {

    static int[] bubbleSort(int[] arr) {
        int len = arr.length;
        for(int i = 0; i < len - 1; i++) {
            for(int j = 0; j < len - 1 - i; j++) {
                // 相邻元素两两对比
                if(arr[j] > arr[j+1]) {
                    // 元素交换
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{19,23,1,36,72,2,3,8,0,123};
        arr = bubbleSort(arr);
        System.out.println("排序结果：" + Arrays.toString(arr));
    }
}
