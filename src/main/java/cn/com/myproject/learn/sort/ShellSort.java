package cn.com.myproject.learn.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * */
public class ShellSort {

    static int[]  shellSort(int[] arr) {
        int len = arr.length;
        int gap = len;
        while (true) {
            gap /= 2;
            for (int i = 0;i<gap;i++) {
                // 注意：这里和动图演示的不一样，动图是分组执行，实际操作是多个分组交替执行
                for (int j = i + gap; j < len; j += gap) {
                    int temp = arr[j];
                    int k = j - gap;
                    while (k >= 0 && arr[k] > temp) {
                        arr[k + gap] = arr[k];
                        k -= gap;
                    }
                    arr[k + gap] = temp;
                    System.out.println("排序结果：j-"+j+","+ Arrays.toString(arr));
                }
                System.out.println("排序结果：i-"+i+","+ Arrays.toString(arr));

            }
            System.out.println("排序结果："+gap+","+ Arrays.toString(arr)+"\n");
            if (gap == 1) {
                break;
            }

        }
        return arr;
    }

    static int[]  shellSort1(int[] arr) {
        int j;
        for (int gap = arr.length/2;gap>0;gap/=2) {
            for(int i = gap;i< arr.length;i++) {
                int tmp = arr[i];
                for(j=i;j>=gap && tmp<arr[j-gap];j-=gap) {
                    arr[j] = arr[j-gap];
                }
                arr[j] = tmp;
                System.out.println("排序结果：i-"+i+","+ Arrays.toString(arr));
            }
            System.out.println("排序结果："+gap+","+ Arrays.toString(arr)+"\n");
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{19,23,1,36,72,2,3,8,0,123};
        System.out.println("原始数据：" + Arrays.toString(arr));
        arr = shellSort1(arr);
        System.out.println("排序结果：" + Arrays.toString(arr));
    }
}
