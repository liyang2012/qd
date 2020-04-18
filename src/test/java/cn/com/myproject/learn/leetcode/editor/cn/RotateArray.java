//Given an array, rotate the array to the right by k steps, where k is non-negat
//ive. 
//
// Example 1: 
//
// 
//Input: [1,2,3,4,5,6,7] and k = 3
//Output: [5,6,7,1,2,3,4]
//Explanation:
//rotate 1 steps to the right: [7,1,2,3,4,5,6]
//rotate 2 steps to the right: [6,7,1,2,3,4,5]
//rotate 3 steps to the right: [5,6,7,1,2,3,4]
// 
//
// Example 2: 
//
// 
//Input: [-1,-100,3,99] and k = 2
//Output: [3,99,-1,-100]
//Explanation: 
//rotate 1 steps to the right: [99,-1,-100,3]
//rotate 2 steps to the right: [3,99,-1,-100]
// 
//
// Note: 
//
// 
// Try to come up as many solutions as you can, there are at least 3 different w
//ays to solve this problem. 
// Could you do it in-place with O(1) extra space? 
// Related Topics 数组

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class RotateArray{
    public static void main(String[] args) {
       Solution solution = new RotateArray().new Solution();
       int[] nums = {1,2,3,4,5,6,7};
       solution.rotate(nums,2);
       for (int i : nums) {
           System.out.println(i);
       }

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate1(int[] nums, int k) {
            if (nums.length == 0 || k == 0) {
                return;
            }
            int len = nums.length;
            int temp,pre;
            for (int i = 0; i < k; i++) {
                pre = nums[len-1];
                for (int j = 0; j < nums.length; j++) {
                    temp = nums[j];
                    nums[j] = pre;
                    pre = temp;
                }
            }
        }
        public void rotate(int[] nums, int k) {
            k %= nums.length;
            reverse(nums, 0, nums.length-1);
            reverse(nums, 0, k-1);
            reverse(nums, k ,nums.length-1);

        }
        private void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;

            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}