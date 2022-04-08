//A super ugly number is a positive integer whose prime factors are in the array
// primes. 
//
// Given an integer n and an array of integers primes, return the nth super ugly
// number. 
//
// The nth super ugly number is guaranteed to fit in a 32-bit signed integer. 
//
// 
// Example 1: 
//
// 
//Input: n = 12, primes = [2,7,13,19]
//Output: 32
//Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 
//super ugly numbers given primes = [2,7,13,19].
// 
//
// Example 2: 
//
// 
//Input: n = 1, primes = [2,3,5]
//Output: 1
//Explanation: 1 has no prime factors, therefore all of its prime factors are in
// the array primes = [2,3,5].
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 106 
// 1 <= primes.length <= 100 
// 2 <= primes[i] <= 1000 
// primes[i] is guaranteed to be a prime number. 
// All the values of primes are unique and sorted in ascending order. 
// 
// Related Topics 数组 哈希表 数学 动态规划 堆（优先队列） 
// 👍 223 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SuperUglyNumber{
    public static void main(String[] args) {
       Solution solution = new SuperUglyNumber().new Solution();
       solution.nthSuperUglyNumber(5, new int[]{2, 7, 11, 13});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthSuperUglyNumber1(int n, int[] primes) {
            Set<Long> seen = new HashSet<Long>();
            PriorityQueue<Long> heap = new PriorityQueue<>();
            seen.add(1L);
            heap.offer(1L);
            int ugly = 0;
            for (int i = 0; i < n; i++) {
                long curr = heap.poll();
                ugly = (int) curr;
                for (int prime : primes) {
                    long next = curr * prime;
                    if (seen.add(next)) {
                        heap.offer(next);
                    }
                }
            }
            return ugly;
        }

        public int nthSuperUglyNumber(int n, int[] primes) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            int m = primes.length;
            int[] pointers = new int[m];
            Arrays.fill(pointers, 1);
            for (int i = 2; i <= n; i++) {
                int[] nums = new int[m];
                int minNum = Integer.MAX_VALUE;
                for (int j = 0; j < m; j++) {
                    nums[j] = dp[pointers[j]] * primes[j];
                    minNum = Math.min(minNum, nums[j]);
                }
                dp[i] = minNum;
                for (int j = 0; j < m; j++) {
                    if (minNum == nums[j]) {
                        pointers[j] ++;
                    }
                }
            }
            return dp[n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}