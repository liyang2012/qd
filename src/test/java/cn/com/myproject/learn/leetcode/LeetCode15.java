package cn.com.myproject.learn.leetcode;

import org.springframework.util.CollectionUtils;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 三数之和
 * */
public class LeetCode15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.parallelSort(nums);
        int len = nums.length;
        int l,r;
        int sum = 0;
        List<Integer> list;
        for(int i=0;i<len-2;i++){
            if(nums[i]>0){
                break;
            }
            //去重
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            l = i+1;
            r = len-1;
            while(l<r){
                sum = nums[i]+nums[l]+nums[r];
                if(sum==0) {
                    result.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    // 去重
                    while (l<r && nums[l] == nums[l+1]) {
                        l++;
                    }
                    // 去重
                    while (l<r && nums[r] == nums[r-1]){
                        r--;
                    }
                    l++;
                    r--;

                }else if(sum>0){
                    while(l < r && nums[r] == nums[r-1]){
                        r--;
                    }
                    r--;
                    //while(l < r && nums[r] == nums[--r]);
                }else{
                    while(l < r && nums[l] == nums[l+1]){
                        l++;
                    }
                    l++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,-2,-1};
        List<List<Integer>> result = threeSum(nums);
        for(List<Integer> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }

    }
}
