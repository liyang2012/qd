//English description is not available for the problem. Please switch to Chinese
//. Related Topics 堆 分治算法

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.*;

public class ZuiXiaoDeKgeShuLcof{
    public static void main(String[] args) {
       Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 计数法
         * @param arr
         * @param k
         * @return
         */
        public int[] getLeastNumbers1(int[] arr, int k) {
            if (k == 0 || arr.length == 0) {
                return new int[0];
            }
            // 统计每个数字出现的次数
            int[] counter = new int[10001];
            for (int num: arr) {
                counter[num]++;
            }
            // 根据counter数组从头找出k个数作为返回结果
            int[] res = new int[k];
            int idx = 0;
            for (int num = 0; num < counter.length; num++) {
                while (counter[num]-- > 0 && idx < k) {
                    res[idx++] = num;
                }
                if (idx == k) {
                    break;
                }
            }
            return res;
        }

        /***
         * 快排
         * @param arr
         * @param k
         * @return
         */
        public int[] getLeastNumbers2(int[] arr, int k) {
            if (k == 0 || arr.length == 0) {
                return new int[0];
            }
            // 最后一个参数表示我们要找的是下标为k-1的数
            return quickSearch(arr, 0, arr.length - 1, k - 1);
        }

        private int[] quickSearch(int[] nums, int lo, int hi, int k) {
            // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
            int j = partition(nums, lo, hi);
            if (j == k) {
                return Arrays.copyOf(nums, j + 1);
            }
            // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
            return j > k? quickSearch(nums, lo, j - 1, k): quickSearch(nums, j + 1, hi, k);
        }

        // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
        private int partition(int[] nums, int lo, int hi) {
            int v = nums[lo];
            int i = lo, j = hi + 1;
            while (true) {
                while (++i <= hi && nums[i] < v);
                while (--j >= lo && nums[j] > v);
                if (i >= j) {
                    break;
                }
                int t = nums[j];
                nums[j] = nums[i];
                nums[i] = t;
            }
            nums[lo] = nums[j];
            nums[j] = v;
            return j;
        }


        /**
         * 最小堆
         *
         * */
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0 || arr.length == 0) {
                return new int[0];
            }
            // 默认是小根堆，实现大根堆需要重写一下比较器。
            Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
            for (int num: arr) {
                if (pq.size() < k) {
                    pq.offer(num);
                } else if (num < pq.peek()) {
                    pq.poll();
                    pq.offer(num);
                }
            }

            // 返回堆中的元素
            int[] res = new int[pq.size()];
            int idx = 0;
            for(int num: pq) {
                res[idx++] = num;
            }
            return res;
        }
        public int[] getLeastNumbers3(int[] arr, int k) {
            if (k == 0 || arr.length == 0) {
                return new int[0];
            }
            // TreeMap的key是数字, value是该数字的个数。
            // cnt表示当前map总共存了多少个数字。
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int cnt = 0;
            for (int num: arr) {
                // 1. 遍历数组，若当前map中的数字个数小于k，则map中当前数字对应个数+1
                if (cnt < k) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                    cnt++;
                    continue;
                }
                // 2. 否则，取出map中最大的Key（即最大的数字), 判断当前数字与map中最大数字的大小关系：
                //    若当前数字比map中最大的数字还大，就直接忽略；
                //    若当前数字比map中最大的数字小，则将当前数字加入map中，并将map中的最大数字的个数-1。
                Map.Entry<Integer, Integer> entry = map.lastEntry();
                if (entry.getKey() > num) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                    if (entry.getValue() == 1) {
                        map.pollLastEntry();
                    } else {
                        map.put(entry.getKey(), entry.getValue() - 1);
                    }
                }

            }

            // 最后返回map中的元素
            int[] res = new int[k];
            int idx = 0;
            for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                int freq = entry.getValue();
                while (freq-- > 0) {
                    res[idx++] = entry.getKey();
                }
            }
            return res;
        }



    }
    //leetcode submit region end(Prohibit modification and deletion)

}