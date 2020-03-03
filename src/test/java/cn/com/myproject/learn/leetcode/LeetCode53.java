package cn.com.myproject.learn.leetcode;

/**
 * 最大子序和
 *
 *
 * **/
public class LeetCode53 {
    /**
     * 分治法
     * */
    public static int maxSubArray(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    public static int crossSum(int[] nums, int left, int right, int p) {
        if (left == right){
            return nums[left];
        }

        int leftSubSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = p; i > left - 1; --i) {
            currSum += nums[i];
            leftSubSum = Math.max(leftSubSum, currSum);
        }

        int rightSubSum = Integer.MIN_VALUE;
        currSum = 0;
        for(int i = p + 1; i < right + 1; ++i) {
            currSum += nums[i];
            rightSubSum = Math.max(rightSubSum, currSum);
        }

        return leftSubSum + rightSubSum;
    }


    public static int helper(int[] nums, int left, int right) {
        if (left == right){
            return nums[left];
        }

        int p = (left + right) / 2;

        int leftSum = helper(nums, left, p);
        int rightSum = helper(nums, p + 1, right);
        int crossSum = crossSum(nums, left, right, p);

        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }


    /**
     * 贪心
     * */
    public static int maxSubArray1(int[] nums) {
        int n = nums.length;
        int currSum = nums[0], maxSum = nums[0];

        for(int i = 1; i < n; ++i) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
    public static int maxSubArray2(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public static int maxSubArray3(int[] nums) {
        int n = nums.length, maxSum = nums[0];
        for(int i = 1; i < n; ++i) {
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }




    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));


        int[] arr2 = new int[]{-2,-1,-3};
        System.out.println(maxSubArray2(arr2));
    }


}
