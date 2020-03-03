package cn.com.myproject.learn.leetcode;

/**
 * 盛最多水的容器
 * */
public class LeetCode11 {
    /**
     * 暴力法
     * */
    public static int maxArea(int[] height) {
        int result = 0;
        int len = height.length;
        for(int i=0;i<len-1;i++) {
            for(int j=i+1;j<len;j++){
                result = Math.max(result,Math.min(height[i], height[j]) * (j - i));
            }
        }
        return result;
    }
    /**
     * 双指针法
     * */
    public static int maxArea1(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while(l<r){
            maxarea =Math.max(Math.min(height[l],height[r])*(r-l),maxarea) ;
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxarea;
    }
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea1(height));
    }
}
