package cn.com.myproject.learn.leetcode;

/**
 * 将数组分成和相等的三个部分
 *
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 *
 * 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 *
 *  
 *
 * 示例 1：
 *
 * 输出：[0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * 示例 2：
 *
 * 输入：[0,2,1,-6,6,7,9,-1,2,0,1]
 * 输出：false
 * 示例 3：
 *
 * 输入：[3,3,6,5,-2,2,5,1,-9,4]
 * 输出：true
 * 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 *  
 *
 * 提示：
 *
 * 3 <= A.length <= 50000
 * -10^4 <= A[i] <= 10^4
 *
 * */
public class LeetCode1013 {

    /**
     * 直接找
     * */
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for(int i : A){
            sum += i;
        }
        if(sum%3 != 0){
            // 总和不是3的倍数，直接返回false
            return false;
        }
        int s = 0;
        int flag = 0;
        for(int i:A){
            s += i;
            if(s == sum/3){
                flag++;
                s = 0;
            }
        }
        // flag不一定等于3，例如[1,-1,1,-1,1,-1,1,-1]
        return flag >= 3;
    }

    /**
     * 双指针
     * */
    public boolean canThreePartsEqualSum1(int[] A) {
        int sum = 0;
        for(int i : A){
            sum += i;
        }
        if(sum%3 != 0){
            // 总和不是3的倍数，直接返回false
            return false;
        }

        // 使用双指针,从数组两头开始一起找，节约时间
        int left = 0;
        int leftSum = A[left];
        int right = A.length - 1;
        int rightSum = A[right];

        // 使用left + 1 < right 的原因，防止只能将数组分成两个部分
        // 例如：[1,-1,1,-1]，使用left < right作为判断条件就会出错
        while(left + 1 < right){
            if(leftSum == sum/3 && rightSum == sum/3){
                // 左右两边都等于 sum/3 ，中间也一定等于
                return true;
            }
            if(leftSum != sum/3){
                // left = 0赋予了初值，应该先left++，在leftSum += A[left];
                leftSum += A[++left];
            }
            if(rightSum != sum/3){
                // right = A.length - 1 赋予了初值，应该先right--，在rightSum += A[right];
                rightSum += A[--right];
            }
        }
        return false;
    }


    public static void main(String[] args) {

    }
}
