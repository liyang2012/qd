//Given the coordinates of two rectilinear rectangles in a 2D plane, return the 
//total area covered by the two rectangles. 
//
// The first rectangle is defined by its bottom-left corner (ax1, ay1) and its 
//top-right corner (ax2, ay2). 
//
// The second rectangle is defined by its bottom-left corner (bx1, by1) and its 
//top-right corner (bx2, by2). 
//
// 
// Example 1: 
//
// 
//Input: ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 
//2
//Output: 45
// 
//
// Example 2: 
//
// 
//Input: ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 
//= 2
//Output: 16
// 
//
// 
// Constraints: 
//
// 
// -10⁴ <= ax1, ay1, ax2, ay2, bx1, by1, bx2, by2 <= 10⁴ 
// 
// Related Topics 几何 数学 👍 133 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class RectangleArea{
    public static void main(String[] args) {
       Solution solution = new RectangleArea().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
            int area1 = (ax2 - ax1) * (ay2 - ay1), area2 = (bx2 - bx1) * (by2 - by1);
            int overlapWidth = Math.min(ax2, bx2) - Math.max(ax1, bx1),
                    overlapHeight = Math.min(ay2, by2) - Math.max(ay1, by1);
            int overlapArea = Math.max(overlapWidth, 0) * Math.max(overlapHeight, 0);
            return area1 + area2 - overlapArea;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}