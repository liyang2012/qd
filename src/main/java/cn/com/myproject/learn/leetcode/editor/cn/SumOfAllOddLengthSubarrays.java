//Given an array of positive integers arr, calculate the sum of all possible 
//odd-length subarrays. 
//
// A subarray is a contiguous subsequence of the array. 
//
// Return the sum of all odd-length subarrays of arr. 
//
// 
// Example 1: 
//
// 
//Input: arr = [1,4,2,5,3]
//Output: 58
//Explanation: The odd-length subarrays of arr and their sums are:
//[1] = 1
//[4] = 4
//[2] = 2
//[5] = 5
//[3] = 3
//[1,4,2] = 7
//[4,2,5] = 11
//[2,5,3] = 10
//[1,4,2,5,3] = 15
//If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58 
//
//
// Example 2: 
//
// 
//Input: arr = [1,2]
//Output: 3
//Explanation: There are only 2 subarrays of odd length, [1] and [2]. Their sum 
//is 3. 
//
// Example 3: 
//
// 
//Input: arr = [10,11,12]
//Output: 66
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 100 
// 1 <= arr[i] <= 1000 
// 
// Related Topics 数组 前缀和 👍 117 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class SumOfAllOddLengthSubarrays{
    public static void main(String[] args) {
       Solution solution = new SumOfAllOddLengthSubarrays().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int[] prefixSums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSums[i + 1] = prefixSums[i] + arr[i];
        }
        int sum = 0;
        for (int start = 0; start < n; start++) {
            for(int length = 1; start + length <= n; length += 2) {
                int end = start + length - 1;
                sum += prefixSums[end + 1] - prefixSums[start];
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}