//(This problem is an interactive problem.) 
//
// You may recall that an array A is a mountain array if and only if: 
//
// 
// A.length >= 3 
// There exists some i with 0 < i < A.length - 1 such that:
// 
// A[0] < A[1] < ... A[i-1] < A[i] 
// A[i] > A[i+1] > ... > A[A.length - 1] 
// 
// 
// 
//
// Given a mountain array mountainArr, return the minimum index such that mounta
//inArr.get(index) == target. If such an index doesn't exist, return -1. 
//
// You can't access the mountain array directly. You may only access the array u
//sing a MountainArray interface: 
//
// 
// MountainArray.get(k) returns the element of the array at index k (0-indexed).
// 
// MountainArray.length() returns the length of the array. 
// 
//
// Submissions making more than 100 calls to MountainArray.get will be judged Wr
//ong Answer. Also, any solutions that attempt to circumvent the judge will result
// in disqualification. 
//
// 
// 
//
// 
// Example 1: 
//
// 
//Input: array = [1,2,3,4,5,3,1], target = 3
//Output: 2
//Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum
// index, which is 2. 
//
// Example 2: 
//
// 
//Input: array = [0,1,2,4,2,1], target = 3
//Output: -1
//Explanation: 3 does not exist in the array, so we return -1.
// 
//
// 
// Constraints: 
//
// 
// 3 <= mountain_arr.length() <= 10000 
// 0 <= target <= 10^9 
// 0 <= mountain_arr.get(index) <= 10^9 
// 
// Related Topics 二分查找

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class FindInMountainArray{
    public static void main(String[] args) {
       Solution solution = new FindInMountainArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * // This is MountainArray's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface MountainArray {
     *     public int get(int index) {}
     *     public int length() {}
     * }
     */

    class Solution {
        public int findInMountainArray(int target, MountainArray mountainArr) {
            int len = mountainArr.length();
            //山顶点
            int peek = findPeak(0, len - 1, mountainArr);

            int leftRes = findLeft(0, peek, target, mountainArr);
            //左半边有结果直接返回
            if (leftRes != -1) {
                return  leftRes;
            }
            int rightRes = findright(peek + 1, len - 1, target , mountainArr);
            return rightRes;
        }

        //先找到山顶的索引位置
        private int findPeak(int left, int right, MountainArray mountainArray) {
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 当前 mid 比右边小，mid 一定不是 peak
                if (mountainArray.get(mid) < mountainArray.get(mid + 1)) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }

        private int findLeft(int left, int right, int target, MountainArray mountainArray) {
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (target == mountainArray.get(mid)) {
                    return mid;
                } else if (target < mountainArray.get(mid)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }

        private int findright(int left, int right, int target, MountainArray mountainArray) {
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (target == mountainArray.get(mid)) {
                    return mid;
                } else if (target < mountainArray.get(mid)) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}