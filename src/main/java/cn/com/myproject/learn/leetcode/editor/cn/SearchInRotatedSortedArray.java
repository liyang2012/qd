//Suppose an array sorted in ascending order is rotated at some pivot unknown to
// you beforehand. 
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). 
//
// You are given a target value to search. If found in the array return its inde
//x, otherwise return -1. 
//
// You may assume no duplicate exists in the array. 
//
// Your algorithm's runtime complexity must be in the order of O(log n). 
//
// Example 1: 
//
// 
//Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// 
//
// Example 2: 
//
// 
//Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1 
// Related Topics 数组 二分查找

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class SearchInRotatedSortedArray{
    public static void main(String[] args) {
       Solution solution = new SearchInRotatedSortedArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length-1;
            int mid = left + (right-left)/2;

            while(left <= right){
                if(nums[mid] == target){
                    return mid;
                }

                if(nums[left] <= nums[mid]){  //左边升序
                    if(target >= nums[left] && target <= nums[mid]){//在左边范围内
                        right = mid-1;
                    }else{//只能从右边找
                        left = mid+1;
                    }

                }else{ //右边升序
                    if(target >= nums[mid] && target <= nums[right]){//在右边范围内
                        left = mid +1;
                    }else{//只能从左边找
                        right = mid-1;
                    }

                }
                mid = left + (right-left)/2;
            }

            return -1;  //没找到
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}