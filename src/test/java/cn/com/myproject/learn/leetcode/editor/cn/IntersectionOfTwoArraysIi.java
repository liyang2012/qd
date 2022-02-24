//Given two integer arrays nums1 and nums2, return an array of their 
//intersection. Each element in the result must appear as many times as it shows in both 
//arrays and you may return the result in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2,2]
// 
//
// Example 2: 
//
// 
//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//Output: [4,9]
//Explanation: [9,4] is also accepted.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
//
// 
// Follow up: 
//
// 
// What if the given array is already sorted? How would you optimize your 
//algorithm? 
// What if nums1's size is small compared to nums2's size? Which algorithm is 
//better? 
// What if elements of nums2 are stored on disk, and the memory is limited such 
//that you cannot load all elements into the memory at once? 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 659 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.*;
import java.util.function.IntFunction;

public class IntersectionOfTwoArraysIi{
    public static void main(String[] args) {
       Solution solution = new IntersectionOfTwoArraysIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                return intersect(nums2, nums1);
            }
            Map<Integer, Integer> map = new HashMap<>();

            for (int i : nums1) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            int[] intersection = new int[nums1.length];
            int index = 0;
            for (int num : nums2) {
                int count = map.getOrDefault(num, 0);
                if (count > 0) {
                    intersection[index++] = num;
                    count--;
                    if (count > 0) {
                        map.put(num, count);
                    } else {
                        map.remove(num);
                    }
                }
            }
            return Arrays.copyOfRange(intersection, 0, index);
        }

        public int[] intersect1(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int length1 = nums1.length, length2 = nums2.length;
            int[] intersection = new int[Math.min(length1, length2)];
            int index1 = 0, index2 = 0, index = 0;
            while (index1 < length1 && index2 < length2) {
                if (nums1[index1] < nums2[index2]) {
                    index1++;
                } else if (nums1[index1] > nums2[index2]) {
                    index2++;
                } else {
                    intersection[index] = nums1[index1];
                    index1++;
                    index2++;
                    index++;
                }
            }
            return Arrays.copyOfRange(intersection, 0, index);
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}