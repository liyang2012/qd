//A conveyor belt has packages that must be shipped from one port to another wit
//hin D days. 
//
// The ith package on the conveyor belt has a weight of weights[i]. Each day, we
// load the ship with packages on the conveyor belt (in the order given by weights
//). We may not load more weight than the maximum weight capacity of the ship. 
//
// Return the least weight capacity of the ship that will result in all the pack
//ages on the conveyor belt being shipped within D days. 
//
// 
// Example 1: 
//
// 
//Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
//Output: 15
//Explanation: A ship capacity of 15 is the minimum to ship all the packages in 
//5 days like this:
//1st day: 1, 2, 3, 4, 5
//2nd day: 6, 7
//3rd day: 8
//4th day: 9
//5th day: 10
//
//Note that the cargo must be shipped in the order given, so using a ship of cap
//acity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8)
//, (9), (10) is not allowed.
// 
//
// Example 2: 
//
// 
//Input: weights = [3,2,2,4,1,4], D = 3
//Output: 6
//Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3
// days like this:
//1st day: 3, 2
//2nd day: 2, 4
//3rd day: 1, 4
// 
//
// Example 3: 
//
// 
//Input: weights = [1,2,3,1,1], D = 4
//Output: 3
//Explanation:
//1st day: 1
//2nd day: 2
//3rd day: 3
//4th day: 1, 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= D <= weights.length <= 5 * 104 
// 1 <= weights[i] <= 500 
// 
// Related Topics 数组 二分查找 
// 👍 304 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.Arrays;

public class CapacityToShipPackagesWithinDDays{
    public static void main(String[] args) {
       Solution solution = new CapacityToShipPackagesWithinDDays().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shipWithinDays(int[] weights, int D) {
            // 确定二分查找左右边界
            int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
            while (left < right) {
                int mid = (left + right) / 2;
                // need 为需要运送的天数
                // cur 为当前这一天已经运送的包裹重量之和
                int need = 1, cur = 0;
                for (int weight : weights) {
                    if (cur + weight > mid) {
                        ++need;
                        cur = 0;
                    }
                    cur += weight;
                }
                if (need <= D) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}