package cn.com.myproject.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 * */
public class LeetCode18 {
    public static List<List<Integer>> fourSum(int[] nums,int target) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums == null || nums.length<4) {
            return result;
        }

        Arrays.parallelSort(nums);
        int len = nums.length;

        int minValue = nums[0] + nums[1] + nums[2] + nums[3];
        int maxValue = nums[len - 1] + nums[len - 2] + nums[len - 3] + nums[len - 4];
        if (maxValue < target || minValue > target) {
            return result;
        }

        int l,r;
        int sum = 0;
        List<Integer> list;
        for(int i=0;i<len-3;i++){
            //去重
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
            int min1=nums[i]+nums[i+1]+nums[i+2]+nums[i+3];
            if(min1>target){
                break;
            }
            /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
            int max1=nums[i]+nums[len-1]+nums[len-2]+nums[len-3];
            if(max1<target){
                continue;
            }
            for(int j=i+1;j<len-2;j++) {
                /*当i的值与前面的值相等时忽略*/
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }

                l = j + 1;
                r = len - 1;

                /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏，忽略*/
                int min=nums[i]+nums[j]+nums[l]+nums[l+1];
                if(min>target){
                    continue;
                }
                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
                int max=nums[i]+nums[j]+nums[r]+nums[r-1];
                if(max<target){
                    continue;
                }
                while (l < r) {
                    sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i],nums[j], nums[l], nums[r]));
                        // 去重
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        // 去重
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;

                    } else if (sum > target) {
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        r--;
                        //while(l < r && nums[r] == nums[--r]);
                    } else {
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        l++;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        List<List<Integer>> result = fourSum(nums,0);
        for(List<Integer> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }

    }
}
