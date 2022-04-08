//Given an integer array nums and two integers k and t, return true if there are
// two distinct indices i and j in the array such that abs(nums[i] - nums[j]) <= t
// and abs(i - j) <= k. 
//
// 
// Example 1: 
// Input: nums = [1,2,3,1], k = 3, t = 0
//Output: true
// Example 2: 
// Input: nums = [1,0,1,1], k = 1, t = 2
//Output: true
// Example 3: 
// Input: nums = [1,5,9,1,5,9], k = 2, t = 3
//Output: false
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 2 * 104 
// -231 <= nums[i] <= 231 - 1 
// 0 <= k <= 104 
// 0 <= t <= 231 - 1 
// 
// Related Topics 排序 Ordered Map 
// 👍 403 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ContainsDuplicateIii{
    public static void main(String[] args) {
       Solution solution = new ContainsDuplicateIii().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
            int n = nums.length;
            TreeSet<Long> set = new TreeSet<Long>();
            for (int i = 0; i < n; i++) {
                Long ceiling = set.ceiling((long) nums[i] - (long) t);
                if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                    return true;
                }
                set.add((long) nums[i]);
                if (i >= k) {
                    set.remove((long) nums[i - k]);
                }
            }
            return false;
        }

        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            int n = nums.length;
            Map<Long, Long> map = new HashMap<Long, Long>();
            long w = (long) t + 1;
            for (int i = 0; i < n; i++) {
                long id = getID(nums[i], w);
                if (map.containsKey(id)) {
                    return true;
                }
                if (map.containsKey(id - 1) && Math.abs(nums[i] - map.get(id - 1)) < w) {
                    return true;
                }
                if (map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id + 1)) < w) {
                    return true;
                }
                map.put(id, (long) nums[i]);
                if (i >= k) {
                    map.remove(getID(nums[i - k], w));
                }
            }
            return false;
        }

        public long getID(long x, long w) {
            if (x >= 0) {
                return x / w;
            }
            return (x + 1) / w - 1;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}