//Given an unsorted array of integers, find the length of the longest consecutiv
//e elements sequence. 
//
// Your algorithm should run in O(n) complexity. 
//
// Example: 
//
// 
//Input: [100, 4, 200, 1, 3, 2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Theref
//ore its length is 4.
// 
// Related Topics 并查集 数组

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence{
    public static void main(String[] args) {
       Solution solution = new LongestConsecutiveSequence().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> num_set = new HashSet<>();
            for (int num : nums) {
                num_set.add(num);
            }

            int longestStreak = 0;

            for (int num : num_set) {
                if (!num_set.contains(num - 1)) {
                    int currentNum = num;
                    int currentStreak = 1;
                    while (num_set.contains(currentNum + 1)) {
                        currentNum += 1;
                        currentStreak += 1;
                    }

                    longestStreak = Math.max(longestStreak, currentStreak);
                }
            }

            return longestStreak;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}