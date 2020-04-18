//Given n non-negative integers a1, a2, ..., an , where each represents a point 
//at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of
// line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis for
//ms a container, such that the container contains the most water. 
//
// Note: You may not slant the container and n is at least 2. 
//
// 
//
// 
//
// The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In thi
//s case, the max area of water (blue section) the container can contain is 49. 
//
// 
//
// Example: 
//
// 
//Input: [1,8,6,2,5,4,8,3,7]
//Output: 49
//Related Topics 数组 双指针

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class ContainerWithMostWater{
    public static void main(String[] args) {
       Solution solution = new ContainerWithMostWater().new Solution();
       System.out.println(solution.maxArea(new int[]{2,3,4,5,18,17,6}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            int result = 0;
            int i=0,j=height.length-1;
            while(i<j){
                int temp;
                int loMax = height[i], hiMax = height[j];
                if(height[i]>height[j]){
                    temp = height[j]*(j-i);
                    while(i<j && height[j]<=hiMax) {
                        j--;
                    }
                }else{
                    temp = height[i]*(j-i);
                    while(i<j && height[i]<=loMax) {
                        i++;
                    }
                }
                result = result>temp ? result : temp;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}