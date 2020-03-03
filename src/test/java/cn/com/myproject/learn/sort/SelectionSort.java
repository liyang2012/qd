package cn.com.myproject.learn.sort;

import java.util.Arrays;

/**
 *选择排序
 * */
public class SelectionSort {

    static int[] selectionSort(int[] arr) {
        int len = arr.length;
        int minIndex, temp;
        for(int i = 0; i < len - 1; i++) {
            minIndex = i;
            for(int j = i + 1; j < len; j++) {
                // 寻找最小的数
                if(arr[j] < arr[minIndex]) {
                    // 将最小数的索引保存
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{19,23,1,36,72,2,3,8,0,123};
        arr = selectionSort(arr);
        System.out.println("排序结果：" + Arrays.toString(arr));
    }
}
