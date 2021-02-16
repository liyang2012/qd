//Given two integers n and k, return all possible combinations of k numbers out 
//of 1 ... n. 
//
// Example: 
//
// 
//Input: n = 4, k = 2
//Output:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// 
// Related Topics 回溯算法

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class Combinations{
    public static void main(String[] args) {
       Solution solution = new Combinations().new Solution();
       solution.combine(4, 2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> output = new LinkedList();
        int n;
        int k;
        public List<List<Integer>> combine(int n, int k) {
            if (n < 1 || k < 1 || n < k) {
                return null;
            }
            this.n = n;
            this.k = k;
            backtrack(1, new LinkedList<Integer>());
            return output;
        }
        private void backtrack(int first, LinkedList<Integer> curr) {
            // if the combination is done
            if (curr.size() == k) {
                output.add(new LinkedList(curr));
            }

            for (int i = first; i < n + 1; ++i) {
                // add i into the current combination
                curr.add(i);
                // use next integers to complete the combination
                backtrack(i + 1, curr);
                // backtrack
                curr.removeLast();
            }
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}