package cn.com.myproject.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最接近的三数之和
 * */
public class LeetCode16 {
    public static int threeSumClosest(int[] nums, int target) {

        Arrays.parallelSort(nums);
        int result = nums[0] + nums[1] + nums[2];
        int len = nums.length;
        int l,r;
        int sum = 0;
        List<Integer> list;
        for(int i=0;i<len-2;i++){
            l = i+1;
            r = len-1;
            while(l<r) {
                sum = nums[i] + nums[l] + nums[r];

                // 判断最小值
                int min = nums[i] + nums[l] + nums[l + 1];
                if(target < min){
                    if(Math.abs(result - target) > Math.abs(min - target))
                        result = min;
                    break;
                }
                //判断最大值
                int max = nums[i] + nums[r] + nums[r - 1];
                if(target > max){
                    if(Math.abs(result - target) > Math.abs(max - target))
                        result = max;
                    break;
                }



                if (Math.abs(target - sum) < Math.abs(target - result)){
                    result = sum;
                }
                if(sum>target){
                    while(l < r && nums[r] == nums[r-1]){
                        r--;
                    }
                    r--;
                    //while(l < r && nums[r] == nums[--r]);
                }else if(sum<target){
                    while(l < r && nums[l] == nums[l+1]){
                        l++;
                    }
                    l++;
                }else{
                    return result;
                }
            }
            // 解决nums[i]重复
            while(i<nums.length-2 && nums[i] == nums[i+1]) {
                i++;
            }

        }

        return result;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        int i = threeSumClosest(nums,1);
        System.out.println(i);
    }
}
