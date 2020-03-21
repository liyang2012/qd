package cn.com.myproject.learn.leetcode;

/**
 *  买卖股票的最佳时机
 * */
public class LeetCode121 {
    /**
     * 暴力法
     * */
    public static int maxProfit(int[] prices) {
        int result = 0;
        if(prices.length<2) {
            return result;
        }
        for(int i=0;i<prices.length-1;i++) {
            for(int j=i+1;j<prices.length;j++) {
                result = Math.max(result,prices[j]-prices[i]);
            }
        }
        return result;
    }
    /**
     * 一次遍历
     * */

    public static int maxProfit1(int prices[]) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit1(prices));
    }
}
