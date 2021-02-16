//A gene string can be represented by an 8-character long string, with choices f
//rom "A", "C", "G", "T". 
//
// Suppose we need to investigate about a mutation (mutation from "start" to "en
//d"), where ONE mutation is defined as ONE single character changed in the gene s
//tring. 
//
// For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation. 
//
// Also, there is a given gene "bank", which records all the valid gene mutation
//s. A gene must be in the bank to make it a valid gene string. 
//
// Now, given 3 things - start, end, bank, your task is to determine what is the
// minimum number of mutations needed to mutate from "start" to "end". If there is
// no such a mutation, return -1. 
//
// Note: 
//
// 
// Starting point is assumed to be valid, so it might not be included in the ban
//k. 
// If multiple mutations are needed, all mutations during in the sequence must b
//e valid. 
// You may assume start and end string is not the same. 
// 
//
// 
//
// Example 1: 
//
// 
//start: "AACCGGTT"
//end:   "AACCGGTA"
//bank: ["AACCGGTA"]
//
//return: 1
// 
//
// 
//
// Example 2: 
//
// 
//start: "AACCGGTT"
//end:   "AAACGGTA"
//bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
//
//return: 2
// 
//
// 
//
// Example 3: 
//
// 
//start: "AAAAACCC"
//end:   "AACCCCCC"
//bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
//
//return: 3
// 
//
// 
//

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class MinimumGeneticMutation{
    public static void main(String[] args) {
        Solution solution = new MinimumGeneticMutation().new Solution();
        System.out.println(solution.minMutation("AACCGGTT", "AAACGGTA" , new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int min = Integer.MAX_VALUE;
        HashSet<String> step = new HashSet<>();
        String[] _bank = null;
        public int minMutation(String start, String end, String[] bank) {
            _bank = bank;
            dfs(0, start, end);
            return min  == Integer.MAX_VALUE ? -1 : min;
        }
        private void dfs(int stepCount, String current, String end) {
            if (stepCount >= min) {
                return;
            }

            if (current.equals(end)) {
                min = Math.min(stepCount, min);
            }
            for (String str : _bank) {
                int diff = 0;
                for (int i = 0; i < str.length(); i++) {
                    if (current.charAt(i) != str.charAt(i)) {
                        if (++diff > 1) {
                            break;
                        }
                    }
                }
                if (diff == 1 && !step.contains(str)) {
                    step.add(str);
                    dfs( stepCount + 1, str, end);
                    step.remove(str);
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}