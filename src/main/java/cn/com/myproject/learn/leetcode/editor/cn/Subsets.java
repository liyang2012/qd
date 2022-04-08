//Given a set of distinct integers, nums, return all possible subsets (the power
// set). 
//
// Note: The solution set must not contain duplicate subsets. 
//
// Example: 
//
// 
//Input: nums = [1,2,3]
//Output:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Subsets{
    public static void main(String[] args) {
       Solution solution = new Subsets().new Solution();
       int[] nums = {1, 2, 3};
        System.out.println(solution.subsets(nums).toString());
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 循环枚举
         * @param nums
         * @return
         */
        public List<List<Integer>> subsets1(int[] nums) {
            List<List<Integer>> output = new ArrayList<>();
            output.add(new ArrayList<Integer>());
            for (int num : nums) {
                List<List<Integer>> newSubsets = new ArrayList<>();
                for (List<Integer> curr : output) {
                    newSubsets.add(new ArrayList<Integer>(curr){ {
                            add(num);
                        }
                    });
                }
                for (List<Integer> curr : newSubsets) {
                    output.add(curr);
                }
            }
            return  output;
        }

        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            backtrack(0, nums, res, new ArrayList<Integer>());
            return res;
        }
        private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
            res.add(new ArrayList<>(tmp));
            for (int j = i; j < nums.length; j++) {
                tmp.add(nums[i]);
                backtrack(j + 1, nums, res, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}