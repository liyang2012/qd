//Given an array nums, write a function to move all 0's to the end of it while m
//aintaining the relative order of the non-zero elements. 
//
// Example: 
//
// 
//Input: [0,1,0,3,12]
//Output: [1,3,12,0,0] 
//
// Note: 
//
// 
// You must do this in-place without making a copy of the array. 
// Minimize the total number of operations. 
// Related Topics 数组 双指针

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.Arrays;

public class MoveZeroes{
    public static void main(String[] args) {
       Solution solution = new MoveZeroes().new Solution();
       int[] i = new int[]{1,3,0,0,0,5,6,7,8};
        solution.moveZeroes(i);
        System.out.println(Arrays.toString(i));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int len = nums.length;
            if (len < 2) {
                return;
            }
            int j = -1;
            for(int i=0;i<len;i++) {
                if(nums[i] != 0) {
                    j++;
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;

                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}