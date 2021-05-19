//You are given a 2D matrix of size m x n, consisting of non-negative integers. 
//You are also given an integer k. 
//
// The value of coordinate (a, b) of the matrix is the XOR of all matrix[i][j] w
//here 0 <= i <= a < m and 0 <= j <= b < n (0-indexed). 
//
// Find the kth largest value (1-indexed) of all the coordinates of matrix. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[5,2],[1,6]], k = 1
//Output: 7
//Explanation: The value of coordinate (0,1) is 5 XOR 2 = 7, which is the larges
//t value. 
//
// Example 2: 
//
// 
//Input: matrix = [[5,2],[1,6]], k = 2
//Output: 5
//Explanation: The value of coordinate (0,0) is 5 = 5, which is the 2nd largest 
//value. 
//
// Example 3: 
//
// 
//Input: matrix = [[5,2],[1,6]], k = 3
//Output: 4
//Explanation: The value of coordinate (1,0) is 5 XOR 1 = 4, which is the 3rd la
//rgest value. 
//
// Example 4: 
//
// 
//Input: matrix = [[5,2],[1,6]], k = 4
//Output: 0
//Explanation: The value of coordinate (1,1) is 5 XOR 2 XOR 1 XOR 6 = 0, which i
//s the 4th largest value. 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 1000 
// 0 <= matrix[i][j] <= 106 
// 1 <= k <= m * n 
// 
// Related Topics 数组 
// 👍 53 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class FindKthLargestXorCoordinateValue{
    public static void main(String[] args) {
       Solution solution = new FindKthLargestXorCoordinateValue().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kthLargestValue(int[][] matrix, int k) {
            int m = matrix.length, n = matrix[0].length;
            int[][] pre = new int[m + 1][n + 1];
            List<Integer> results = new ArrayList<Integer>();
            for (int i = 1; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    pre[i][j] = pre[i - 1][j] ^ pre[i][j - 1] ^ pre[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                    results.add(pre[i][j]);
                }
            }

            nthElement(results, 0, k - 1, results.size() - 1);
            return results.get(k - 1);
        }

        public void nthElement(List<Integer> results, int left, int kth, int right) {
            if (left == right) {
                return;
            }
            int pivot = (int) (left + Math.random() * (right - left + 1));
            swap(results, pivot, right);
            // 三路划分（three-way partition）
            int sepl = left - 1, sepr = left - 1;
            for (int i = left; i <= right; i++) {
                if (results.get(i) > results.get(right)) {
                    swap(results, ++sepr, i);
                    swap(results, ++sepl, sepr);
                } else if (results.get(i) == results.get(right)) {
                    swap(results, ++sepr, i);
                }
            }
            if (sepl < left + kth && left + kth <= sepr) {
                return;
            } else if (left + kth <= sepl) {
                nthElement(results, left, kth, sepl);
            } else {
                nthElement(results, sepr + 1, kth - (sepr - left + 1), right);
            }
        }

        public void swap(List<Integer> results, int index1, int index2) {
            int temp = results.get(index1);
            results.set(index1, results.get(index2));
            results.set(index2, temp);
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}