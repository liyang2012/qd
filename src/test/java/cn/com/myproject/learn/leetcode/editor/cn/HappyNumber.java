//Write an algorithm to determine if a number n is "happy". 
//
// A happy number is a number defined by the following process: Starting with an
//y positive integer, replace the number by the sum of the squares of its digits, 
//and repeat the process until the number equals 1 (where it will stay), or it loo
//ps endlessly in a cycle which does not include 1. Those numbers for which this p
//rocess ends in 1 are happy numbers. 
//
// Return True if n is a happy number, and False if not. 
//
// Example: 
//
// 
//Input: 19
//Output: true
//Explanation: 
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
// 
// Related Topics 哈希表 数学

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber{
    public static void main(String[] args) {
       Solution solution = new HappyNumber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isHappy(int n) {
            Set<Integer> set = new HashSet<>();
            while (n != 1 && !set.contains(n)) {
                set.add(n);
                n = getNext(n);
            }
            return n == 1;
        }
        private int getNext(int n) {
            int sum = 0;
            while (n > 0) {
                int d = n % 10;
                n = n / 10;
                sum += d * d;
            }
            return sum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}