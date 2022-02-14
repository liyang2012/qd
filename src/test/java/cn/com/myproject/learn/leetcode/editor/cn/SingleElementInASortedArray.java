//You are given a sorted array consisting of only integers where every element 
//appears exactly twice, except for one element which appears exactly once. 
//
// Return the single element that appears only once. 
//
// Your solution must run in O(log n) time and O(1) space. 
//
// 
// Example 1: 
// Input: nums = [1,1,2,3,3,4,4,8,8]
//Output: 2
// Example 2: 
// Input: nums = [3,3,7,7,10,11,11]
//Output: 10
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 二分查找 👍 361 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class SingleElementInASortedArray{
    public static void main(String[] args) {
        Solution solution = new SingleElementInASortedArray().new Solution();
        System.out.println(0 ^ 1);
        System.out.println(1 ^ 1);
        System.out.println(2 ^ 1);
        System.out.println(3 ^ 1);
        System.out.println(4 ^ 1);
        System.out.println(5 ^ 1);
        int a = 3, b = 15;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        a = a ^ b;
        System.out.println(Integer.toBinaryString(a));
        b = b ^ a;
        System.out.println(Integer.toBinaryString(b));
        a = a ^ b;
        System.out.println(Integer.toBinaryString(a));

        System.out.println(a << 1);
        System.out.println(a << 2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            int low = 0, high = nums.length - 1;
            while (low < high) {
                int mid = (high - low) / 2 + low;
                if (nums[mid] == nums[mid ^ 1]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return nums[low];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}