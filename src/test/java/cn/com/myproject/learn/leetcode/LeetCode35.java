package cn.com.myproject.learn.leetcode;

/**
 * 搜索插入位置
 * */
public class LeetCode35 {
    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        for(int i=0;i<len;i++) {
            if(target<=nums[i]) {
                return i;
            }
        }
        return len;
    }

    /**
     * 二分法
     * */
    public static int searchInsert1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int target = 4;
        int result = searchInsert1(nums,target);
        System.out.println(result);
    }
}
