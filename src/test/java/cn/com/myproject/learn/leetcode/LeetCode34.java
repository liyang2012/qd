package cn.com.myproject.learn.leetcode;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * */
public class LeetCode34 {
    private static int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }else {
                lo = mid+1;
            }
        }

        return lo;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

        return targetRange;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{5,7,8,8,8,10};
        int[] result = searchRange(nums,10);
        System.out.println(result[0]+","+result[1]);
    }
}
