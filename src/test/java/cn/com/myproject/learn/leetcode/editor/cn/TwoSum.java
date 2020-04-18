//Given an array of integers, return indices of the two numbers such that they a
//dd up to a specific target. 
//
// You may assume that each input would have exactly one solution, and you may n
//ot use the same element twice. 
//
// Example: 
//
// 
//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].
// 
// Related Topics 数组 哈希表

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum{
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        int[] i = new int[]{1,2,3,4,5,6};
        System.out.println(Arrays.toString( solution.twoSum(i,10)));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> map = new HashMap<>();
            map.put(nums[0],0);
            for(int i=1;i<nums.length;i++) {
                int r = target - nums[i];
                if(map.containsKey(r)){
                    return new int[]{map.get(r),i};
                }
                map.put(nums[i],i);
            }
            throw new RuntimeException("没有合适的值");
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}