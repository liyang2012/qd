//You are given an integer array nums. We call a subset of nums good if its 
//product can be represented as a product of one or more distinct prime numbers. 
//
// 
// For example, if nums = [1, 2, 3, 4]:
//
// 
// [2, 3], [1, 2, 3], and [1, 3] are good subsets with products 6 = 2*3, 6 = 2*3
//, and 3 = 3 respectively. 
// [1, 4] and [4] are not good subsets with products 4 = 2*2 and 4 = 2*2 
//respectively. 
// 
// 
// 
//
// Return the number of different good subsets in nums modulo 10⁹ + 7. 
//
// A subset of nums is any array that can be obtained by deleting some (
//possibly none or all) elements from nums. Two subsets are different if and only if the 
//chosen indices to delete are different. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,4]
//Output: 6
//Explanation: The good subsets are:
//- [1,2]: product is 2, which is the product of distinct prime 2.
//- [1,2,3]: product is 6, which is the product of distinct primes 2 and 3.
//- [1,3]: product is 3, which is the product of distinct prime 3.
//- [2]: product is 2, which is the product of distinct prime 2.
//- [2,3]: product is 6, which is the product of distinct primes 2 and 3.
//- [3]: product is 3, which is the product of distinct prime 3.
// 
//
// Example 2: 
//
// 
//Input: nums = [4,2,3,15]
//Output: 5
//Explanation: The good subsets are:
//- [2]: product is 2, which is the product of distinct prime 2.
//- [2,3]: product is 6, which is the product of distinct primes 2 and 3.
//- [2,15]: product is 30, which is the product of distinct primes 2, 3, and 5.
//- [3]: product is 3, which is the product of distinct prime 3.
//- [15]: product is 15, which is the product of distinct primes 3 and 5.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 30 
// 
// Related Topics 位运算 数组 数学 动态规划 状态压缩 👍 76 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class TheNumberOfGoodSubsets{
    public static void main(String[] args) {
       Solution solution = new TheNumberOfGoodSubsets().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        int NUM_MAX = 30;
        int MOD = 1000000007;

        public int numberOfGoodSubsets(int[] nums) {
            int[] freq = new int[NUM_MAX + 1];
            for (int num : nums) {
                ++freq[num];
            }

            int[] f = new int[1 << PRIMES.length];
            f[0] = 1;
            for (int i = 0; i < freq[1]; ++i) {
                f[0] = f[0] * 2 % MOD;
            }

            for (int i = 2; i <= NUM_MAX; ++i) {
                if (freq[i] == 0) {
                    continue;
                }

                // 检查 i 的每个质因数是否均不超过 1 个
                int subset = 0, x = i;
                boolean check = true;
                for (int j = 0; j < PRIMES.length; ++j) {
                    int prime = PRIMES[j];
                    if (x % (prime * prime) == 0) {
                        check = false;
                        break;
                    }
                    if (x % prime == 0) {
                        subset |= (1 << j);
                    }
                }
                if (!check) {
                    continue;
                }

                // 动态规划
                for (int mask = (1 << PRIMES.length) - 1; mask > 0; --mask) {
                    if ((mask & subset) == subset) {
                        f[mask] = (int) ((f[mask] + ((long) f[mask ^ subset]) * freq[i]) % MOD);
                    }
                }
            }

            int ans = 0;
            for (int mask = 1, maskMax = (1 << PRIMES.length); mask < maskMax; ++mask) {
                ans = (ans + f[mask]) % MOD;
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}