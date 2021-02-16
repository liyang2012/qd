//Given a char array representing tasks CPU need to do. It contains capital lett
//ers A to Z where different letters represent different tasks. Tasks could be don
//e without original order. Each task could be done in one interval. For each inte
//rval, CPU could finish one task or just be idle. 
//
// However, there is a non-negative cooling interval n that means between two sa
//me tasks, there must be at least n intervals that CPU are doing different tasks 
//or just be idle. 
//
// You need to return the least number of intervals the CPU will take to finish 
//all the given tasks. 
//
// 
//
// Example: 
//
// 
//Input: tasks = ["A","A","A","B","B","B"], n = 2
//Output: 8
//Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
// 
//
// 
// Constraints: 
//
// 
// The number of tasks is in the range [1, 10000]. 
// The integer n is in the range [0, 100]. 
// 
// Related Topics 贪心算法 队列 数组

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.Arrays;

public class TaskScheduler{
    public static void main(String[] args) {
       Solution solution = new TaskScheduler().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * FIXME
         * @param tasks
         * @param n
         * @return
         */
        public int leastInterval(char[] tasks, int n) {
            int[] map = new int[26];
            for (char c: tasks) {
                map[c - 'A']++;
            }
            Arrays.sort(map);
            int max_val = map[25] - 1, idle_slots = max_val * n;
            for (int i = 24; i >= 0 && map[i] > 0; i--) {
                idle_slots -= Math.min(map[i], max_val);
            }
            return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}