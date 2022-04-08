//Given an array nums, there is a sliding window of size k which is moving from 
//the very left of the array to the very right. You can only see the k numbers in 
//the window. Each time the sliding window moves right by one position. Return the
// max sliding window. 
//
// Follow up: 
//Could you solve it in linear time? 
//
// Example: 
//
// 
//Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
//Output: [3,3,5,5,6,7] 
//Explanation: 
//
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.*;

public class SlidingWindowMaximum{
    public static void main(String[] args) {
       Solution solution = new SlidingWindowMaximum().new Solution();
       int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums,3)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /***
         * 暴力解法
         *
         * @param nums
         * @param k
         * @return
         */
        public int[] maxSlidingWindow1(int[] nums, int k) {
            int len = nums.length;
            if (len * k == 0) {
                return new int[0];
            }
            if (k == 1) {
                return nums;
            }
            int[] result = new int[len - k + 1];

            for (int i = 0; i <= len - k; i++) {
                int max = nums[i];
                for (int j = i + 1; j < i + k; j++) {
                    max = max > nums[j] ? max : nums[j];
                }
                result[i] = max;
            }
            return result;
        }

        /**
         * 双向队列
         * */
        public int[] maxSlidingWindow2(int[] nums, int k) {
            int len = nums.length;
            if (len * k == 0) {
                return new int[0];
            }
            if (k == 1) {
                return nums;
            }
            int[] result = new int[len - k + 1];

            LinkedList<Integer> queue = new LinkedList();
            for (int i = 0;i < len;i++) {
                //把比当前值小的值弹出来
                while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                    queue.pollLast();
                }
                queue.add(i);
                //把前面窗口外的值去除
                if (queue.peek() <= i - k) {
                    queue.poll();
                }
                //需要取值了
                if (i + 1 >= k) {
                    result[i - k + 1] = nums[queue.peek()];
                }
            }
            return result;
        }
        /**
         * 动态规划
         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            int len = nums.length;
            if (len * k == 0) {
                return new int[0];
            }
            if (k == 1) {
                return nums;
            }
            int[] result = new int[len - k + 1];


            int[] left = new int[len];
            left[0] = nums[0];
            int[] right = new int[len];
            right[len - 1] = nums[len - 1];

            for (int i = 1; i < len; i++) {
                if (i % k == 0) {
                    left[i] = nums[i];
                } else {
                    left[i] = Math.max(left[i - 1], nums[i]);
                }
                int j = len - i - 1;
                if ((j + 1) % k == 0) {
                    right[j] = nums[j];
                } else {
                    right[j] = Math.max(right[j + 1], nums[j]);
                }
            }

            for (int i = 0; i <= len - k; i++) {
                result[i] = Math.max(left[i + k - 1], right[i]);
            }

            return result;
        }

        /**
         * 优先队列 堆
         * @param nums
         * @param k
         * @return
         */
        public int[] maxSlidingWindow3(int[] nums, int k) {
            // 建立最大堆
            Queue<Integer> max = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer i1, Integer i2) {
                    // TODO Auto-generated method stub
                    return i2 - i1;
                }
            });
            int n = nums.length;
            if (n == 0) {
                return nums;
            }
            int result[] = new int[n - k + 1];
            int index = 0;
            for (int i = 0; i < n; i++) {
                //移除第一个元素
                if (max.size() >= k) {
                    max.remove(nums[i - k]);
                }
                max.offer(nums[i]);
                //更新 result
                if (i >= k - 1) {
                    result[index++] = max.peek();
                }
            }
            return result;
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}