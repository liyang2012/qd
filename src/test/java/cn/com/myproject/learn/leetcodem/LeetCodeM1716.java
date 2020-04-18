package cn.com.myproject.learn.leetcodem;

/**
 * 面试题 17.16. 按摩师
 *
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 注意：本题相对原题稍作改动
 *
 *  
 *
 * 示例 1：
 *
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 * 示例 2：
 *
 * 输入： [2,7,9,3,1]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 * 示例 3：
 *
 * 输入： [2,1,4,5,3,1,1,3]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 *
 * */
public class LeetCodeM1716 {
    public int massage(int[] nums) {
        if(nums == null || nums.length==0){
            return 0;
        }else if(nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        int[][] result = new int[len][2];
        result[0][0] = 0;
        result[0][1] = nums[0];
        for(int i=1;i<len;i++) {
            result[i][0] = Math.max(result[i-1][0],result[i-1][1]);
            result[i][1] = result[i-1][0]+nums[i];
        }

        return Math.max(result[len-1][0],result[len-1][1]);
    }

    public int massage2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];

    }

    public int massage3(int[] nums) {
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            int c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        return b;
    }


    public static void main(String[] args) {
        int[] nums = {2,1,4,5,3,1,1,3};
        LeetCodeM1716 m1716 = new LeetCodeM1716();
        System.out.println(m1716.massage(nums));
    }
}
