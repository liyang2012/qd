//Suppose an array of length n sorted in ascending order is rotated between 1 an
//d n times. For example, the array nums = [0,1,4,4,5,6,7] might become: 
//
// 
// [4,5,6,7,0,1,4] if it was rotated 4 times. 
// [0,1,4,4,5,6,7] if it was rotated 7 times. 
// 
//
// Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results 
//in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]]. 
//
// Given the sorted rotated array nums that may contain duplicates, return the m
//inimum element of this array. 
//
// 
// Example 1: 
// Input: nums = [1,3,5]
//Output: 1
// Example 2: 
// Input: nums = [2,2,2,0,1]
//Output: 0
// 
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 5000 
// -5000 <= nums[i] <= 5000 
// nums is sorted and rotated between 1 and n times. 
// 
//
// 
//Follow up: This is the same as Find Minimum in Rotated Sorted Array but with d
//uplicates. Would allow duplicates affect the run-time complexity? How and why? R
//elated Topics 数组 二分查找 
// 👍 323 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class FindMinimumInRotatedSortedArrayIi{
    public static void main(String[] args) {
       Solution solution = new FindMinimumInRotatedSortedArrayIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMin(int[] nums) {
            int low = 0;
            int high = nums.length - 1;
            while (low < high) {
                int pivot = low + (high - low) / 2;
                if (nums[pivot] < nums[high]) {
                    high = pivot;
                } else if (nums[pivot] > nums[high]) {
                    low = pivot + 1;
                } else {
                    high -= 1;
                }
            }
            return nums[low];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}