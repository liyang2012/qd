package cn.com.myproject.learn.sort;

import java.util.Arrays;

/**
 * 插入排序
 * */
public class InsertionSort {
    static int[] insertionSort(int[] arr) {
        int len = arr.length;
        int preIndex, current;
        for(int i=1;i<len;i++) {
            preIndex = i - 1;
            current = arr[i];
            while(preIndex>=0 && current<arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }

        return  arr;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{19,23,1,36,72,2,3,8,0,123};
        arr = insertionSort(arr);
        System.out.println("排序结果：" + Arrays.toString(arr));
    }
}
