//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one
// sorted array. 
//
// Note: 
//
// 
// The number of elements initialized in nums1 and nums2 are m and n respectivel
//y. 
// You may assume that nums1 has enough space (size that is greater or equal to 
//m + n) to hold additional elements from nums2. 
// 
//
// Example: 
//
// 
//Input:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//Output: [1,2,2,3,5,6]
// Related Topics 数组 双指针

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class MergeSortedArray{
    public static void main(String[] args) {
       Solution solution = new MergeSortedArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         *
         * 暴力解法
         * @param nums1
         * @param m
         * @param nums2
         * @param n
         */
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = 0, j = 0;
            while (j < n) {
                if (m + j <= i) {
                    nums1[i] = nums2[j];
                    j++;
                    i++;
                    continue;
                }
                if (nums2[j] < nums1[i]) {
                    //后移
                    for (int k = m + j; k > i; k--) {
                        nums1[k] = nums1[k-1];
                    }
                    nums1[i] = nums2[j];
                    j++;
                }
                i++;
            }
        }

        /***
         * 双指针，从前往后
         * @param nums1
         * @param m
         * @param nums2
         * @param n
         */
        public void merge1 (int[] nums1, int m, int[] nums2, int n) {
            int[] nums1_copy = new int[m];
            System.arraycopy(nums1, 0, nums1_copy, 0, m);

            int p1 = 0, p2 = 0;

            int p = 0;

            while (p1 < m && p2 < n) {
                nums1[p++] = nums1_copy[p1] < nums2[p2] ? nums1_copy[p1++] : nums2[p2++];
            }

            if (p1 < m) {
                System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
            }
            if (p2 < n) {
                System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
            }
        }

        /***
         * 双指针，从后往前
         * @param nums1
         * @param m
         * @param nums2
         * @param n
         */
        public void merge2 (int[] nums1, int m, int[] nums2, int n) {
            int p = m + n - 1;
            int p1  = m - 1;
            int p2 = n - 1;
            while (p1 < m && p2 < n){
                nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
            }
            System.arraycopy(nums2, 0, nums1, 0, p2+1);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}