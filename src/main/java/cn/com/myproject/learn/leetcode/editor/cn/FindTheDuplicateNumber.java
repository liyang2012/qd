//Given an array nums containing n + 1 integers where each integer is between 1 
//and n (inclusive), prove that at least one duplicate number must exist. Assume t
//hat there is only one duplicate number, find the duplicate one. 
//
// Example 1: 
//
// 
//Input: [1,3,4,2,2]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: [3,1,3,4,2]
//Output: 3 
//
// Note: 
//
// 
// You must not modify the array (assume the array is read only). 
// You must use only constant, O(1) extra space. 
// Your runtime complexity should be less than O(n2). 
// There is only one duplicate number in the array, but it could be repeated mor
//e than once. 
// 
// Related Topics 数组 双指针 二分查找

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class FindTheDuplicateNumber{
    public static void main(String[] args) {
       Solution solution = new FindTheDuplicateNumber().new Solution();

       String s = new String("1");
       s.intern();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 弗洛伊德的乌龟和兔子（循环检测）
         * FIXME
         * @param nums
         * @return
         */
        public int findDuplicate(int[] nums) {
            int l = nums[0];
            int r = nums[0];
            do {
                l = nums[l];
                r = nums[nums[r]];
            } while (l != r);
            int p1 = nums[0];
            int p2 = l;
            while (p1 != p2) {
                p1 = nums[p1];
                p2 = nums[p2];
            }
            return p1;
        }

        /**
         * 二分法
         * @param nums
         * @return
         */
        public int findDuplicate1(int[] nums) {
            int n = nums.length;
            int l = 1, r = n - 1, ans = -1;
            while (l <= r) {
                int mid = (l + r) >> 1;
                int cnt = 0;
                for (int i = 0; i < n; ++i) {
                    if (nums[i] <= mid) {
                        cnt++;
                    }
                }
                if (cnt <= mid) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                    ans = mid;
                }
            }
            return ans;

        }


        /***
         * 二进制
         * @param nums
         * @return
         */
        public int findDuplicate2(int[] nums) {
            int n = nums.length, ans = 0;
            int bit_max = 31;
            while (((n - 1) >> bit_max) == 0) {
                bit_max -= 1;
            }
            for (int bit = 0; bit <= bit_max; ++bit) {
                int x = 0, y = 0;
                for (int i = 0; i < n; ++i) {
                    if ((nums[i] & (1 << bit)) != 0) {
                        x += 1;
                    }
                    if (i >= 1 && ((i & (1 << bit)) != 0)) {
                        y += 1;
                    }
                }
                if (x > y) {
                    ans |= 1 << bit;
                }
            }
            return ans;
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}