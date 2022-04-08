//There is a rectangular brick wall in front of you with n rows of bricks. The i
//th row has some number of bricks each of the same height (i.e., one unit) but th
//ey can be of different widths. The total width of each row is the same. 
//
// Draw a vertical line from the top to the bottom and cross the least bricks. I
//f your line goes through the edge of a brick, then the brick is not considered a
//s crossed. You cannot draw a line just along one of the two vertical edges of th
//e wall, in which case the line will obviously cross no bricks. 
//
// Given the 2D array wall that contains the information about the wall, return 
//the minimum number of crossed bricks after drawing such a vertical line. 
//
// 
// Example 1: 
//
// 
//Input: wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: wall = [[1],[1],[1]]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// n == wall.length 
// 1 <= n <= 104 
// 1 <= wall[i].length <= 104 
// 1 <= sum(wall[i].length) <= 2 * 104 
// sum(wall[i]) is the same for each row i. 
// 1 <= wall[i][j] <= 231 - 1 
// 
// Related Topics 哈希表 
// 👍 168 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall{
    public static void main(String[] args) {
       Solution solution = new BrickWall().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int leastBricks(List<List<Integer>> wall) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < wall.size(); i++) {
                int pos = 0;
                for (int j = 0; j < wall.get(i).size() - 1; j++) {
                    pos += wall.get(i).get(j);
                    map.put(pos, map.getOrDefault(pos, 0) + 1);
                }
            }

            int res = 0;
            for (Integer i : map.keySet()) {
                res = Math.max(res, map.get(i));
            }
            return wall.size() - res;
        }

        public int leastBricks1(List<List<Integer>> wall) {
            Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
            for (List<Integer> widths : wall) {
                int n = widths.size();
                int sum = 0;
                for (int i = 0; i < n - 1; i++) {
                    sum += widths.get(i);
                    cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
                }
            }
            int maxCnt = 0;
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                maxCnt = Math.max(maxCnt, entry.getValue());
            }
            return wall.size() - maxCnt;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}