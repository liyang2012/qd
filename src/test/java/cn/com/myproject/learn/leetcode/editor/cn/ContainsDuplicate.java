//Given an integer array nums, return true if any value appears at least twice 
//in the array, and return false if every element is distinct. 
//
// 
// Example 1: 
// Input: nums = [1,2,3,1]
//Output: true
// Example 2: 
// Input: nums = [1,2,3,4]
//Output: false
// Example 3: 
// Input: nums = [1,1,1,3,3,4,3,2,4,2]
//Output: true
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics 数组 哈希表 排序 👍 622 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.*;

public class ContainsDuplicate{
    public static void main(String[] args) {
       Solution solution = new ContainsDuplicate().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsDuplicate1(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int x : nums) {
                if (!set.add(x)) {
                    return true;
                }
            }
            return false;
        }
        public boolean containsDuplicate(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            for (int i = 0; i < n - 1; i++) {
                if (nums[i] == nums[i + 1]) {
                    return true;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}