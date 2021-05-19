//There is an integer array perm that is a permutation of the first n positive i
//ntegers, where n is always odd. 
//
// It was encoded into another integer array encoded of length n - 1, such that 
//encoded[i] = perm[i] XOR perm[i + 1]. For example, if perm = [1,3,2], then encod
//ed = [2,1]. 
//
// Given the encoded array, return the original array perm. It is guaranteed tha
//t the answer exists and is unique. 
//
// 
// Example 1: 
//
// 
//Input: encoded = [3,1]
//Output: [1,2,3]
//Explanation: If perm = [1,2,3], then encoded = [1 XOR 2,2 XOR 3] = [3,1]
// 
//
// Example 2: 
//
// 
//Input: encoded = [6,5,4,6]
//Output: [2,4,1,5,3]
// 
//
// 
// Constraints: 
//
// 
// 3 <= n < 105 
// n is odd. 
// encoded.length == n - 1 
// 
// Related Topics 位运算 
// 👍 114 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class DecodeXoredPermutation{
    public static void main(String[] args) {
       Solution solution = new DecodeXoredPermutation().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] decode(int[] encoded) {
            int n = encoded.length + 1;
            int total = 0;
            for (int i = 1; i <= n; i++) {
                total ^= i;
            }
            int odd = 0;
            for (int i = 1; i < n - 1; i += 2) {
                odd ^= encoded[i];
            }
            int[] perm = new int[n];
            perm[0] = total ^ odd;
            for (int i = 0; i < n - 1; i++) {
                perm[i + 1] = perm[i] ^ encoded[i];
            }
            return perm;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}