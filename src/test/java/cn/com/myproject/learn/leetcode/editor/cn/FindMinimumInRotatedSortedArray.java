//Suppose an array sorted in ascending order is rotated at some pivot unknown to
// you beforehand. 
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). 
//
// Find the minimum element. 
//
// You may assume no duplicate exists in the array. 
//
// Example 1: 
//
// 
//Input: [3,4,5,1,2] 
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: [4,5,6,7,0,1,2]
//Output: 0
// 
// Related Topics 数组 二分查找

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class FindMinimumInRotatedSortedArray{
    public static void main(String[] args) {
        Solution solution = new FindMinimumInRotatedSortedArray().new Solution();
        System.out.println(solution.findMin(new int[]{1, 2}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMin(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            int left = 0, right = nums.length - 1;

            if (nums[right] > nums[0]) {
                return nums[0];
            }

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] > nums[mid + 1]) {
                    return nums[mid + 1];
                }

                if (nums[mid] < nums[mid - 1]) {
                    return nums[mid];
                }


               if (nums[mid] > nums[0]) {
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