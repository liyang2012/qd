package cn.com.myproject.learn.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

public class LeetCode {
    public static String[] findRelativeRanks(int[] nums) {
        int len = nums.length;
        int[] sortNums = Arrays.copyOf(nums,len);
        Arrays.parallelSort(sortNums);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<len;i++) {
            map.put(sortNums[i],len-i);
        }

        String[] result = new String[len];
        String str;
        int k;
        for(int i=0;i<len;i++){
            k = map.get(nums[i]);
            if(k == 1) {
                str = "Gold Medal";
            }else if(k==2) {
                str = "Silver Medal";
            }else if(k==3) {
                str = "Bronze Medal";
            }else {
                str = k+"";
            }
            result[i] = str;
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(findRelativeRanks(nums)));
    }
}
