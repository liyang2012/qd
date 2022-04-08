//Given a collection of distinct integers, return all possible permutations. 
//
// Example: 
//
// 
//Input: [1,2,3]
//Output:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// 
// Related Topics 回溯算法

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Permutations{
    public static void main(String[] args) {
       Solution solution = new Permutations().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /***
         * 回溯
         * @param nums
         * @return
         */
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new LinkedList();
            ArrayList<Integer> output = new ArrayList<Integer>();
            for (int num : nums) {
                output.add(num);
            }
            int n = nums.length;
            backtrack(n, output, res, 0);
            return res;

        }
        private void backtrack(int n,
                              ArrayList<Integer> output,
                              List<List<Integer>> res,
                              int first) {
            // 所有数都填完了
            if (first == n) {
                res.add(new ArrayList<Integer>(output));
                return;
            }
            for (int i = first; i < n; i++) {
                // 动态维护数组
                Collections.swap(output, first, i);
                // 继续递归填下一个数
                backtrack(n, output, res, first + 1);
                // 撤销操作
                Collections.swap(output, first, i);
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}