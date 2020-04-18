//Given an array nums of n integers, are there elements a, b, c in nums such tha
//t a + b + c = 0? Find all unique triplets in the array which gives the sum of ze
//ro. 
//
// Note: 
//
// The solution set must not contain duplicate triplets. 
//
// Example: 
//
// 
//Given array nums = [-1, 0, 1, 2, -1, -4],
//
//A solution set is:
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// Related Topics 数组 双指针

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum{
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = solution.threeSum(nums);
        System.out.println(list.toString());


    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            int len = 0;
            if(nums == null || (len = nums.length) < 3) {
                return result;
            }
            Arrays.parallelSort(nums);
            for(int i=0;i<len-2;i++) {
                //如果nums[i]>0，则结果一定大于0
                if(nums[i] > 0) {
                    break;
                }
                //去重
                if(i > 0 && nums[i] == nums[i-1]) {
                    continue;
                }
                int l = i+1;
                int r = len-1;
                while(l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    if(sum == 0) {
                        result.add(Arrays.asList(nums[i],nums[l],nums[r]));
                        l++;
                        r--;
                        //去重
                        while (l < r && nums[l] == nums[l+1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r-1]) {
                            r--;
                        }
                    }else if(sum < 0) {
                        l++;
                    }else {
                        r--;
                    }
                }
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}