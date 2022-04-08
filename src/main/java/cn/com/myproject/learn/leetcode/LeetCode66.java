package cn.com.myproject.learn.leetcode;

import java.util.Arrays;

/**
 * 加一
 * */
public class LeetCode66 {
    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        int i = len-1;
        digits[i]++;
        while(i>=0){
            if(digits[i]>9) {
                digits[i] = digits[i]%10;
                if(i!=0){
                    digits[i-1]++;
                }
            }else {
                return digits;
            }
            i--;
        }

        int[] result = new int[len+1];
        result[0] = 1;
        return result;

    }

    public static void main(String[] args) {
        int[] digits = new int[]{9,9,9};
        System.out.println(Arrays.toString(plusOne(digits)));


    }
}
