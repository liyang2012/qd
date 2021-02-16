//A robot on an infinite grid starts at point (0, 0) and faces north. The robot 
//can receive one of three possible types of commands: 
//
// 
// -2: turn left 90 degrees 
// -1: turn right 90 degrees 
// 1 <= x <= 9: move forward x units 
// 
//
// Some of the grid squares are obstacles. 
//
// The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1]) 
//
// If the robot would try to move onto them, the robot stays on the previous gri
//d square instead (but still continues following the rest of the route.) 
//
// Return the square of the maximum Euclidean distance that the robot will be fr
//om the origin. 
//
// 
//
// Example 1: 
//
// 
//Input: commands = [4,-1,3], obstacles = []
//Output: 25
//Explanation: robot will go to (3, 4)
// 
//
// 
// Example 2: 
//
// 
//Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
//Output: 65
//Explanation: robot will be stuck at (1, 4) before turning left and going to (1
//, 8)
// 
// 
//
// 
//
// Note: 
//
// 
// 0 <= commands.length <= 10000 
// 0 <= obstacles.length <= 10000 
// -30000 <= obstacle[i][0] <= 30000 
// -30000 <= obstacle[i][1] <= 30000 
// The answer is guaranteed to be less than 2 ^ 31. 
// 
// Related Topics 贪心算法

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation{
    public static void main(String[] args) {
        Solution solution = new WalkingRobotSimulation().new Solution();
        System.out.println(solution.robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{{2, 4}}));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int robotSim(int[] commands, int[][] obstacles) {
            int[] dx = new int[]{0, 1, 0 , -1};
            int[] dy = new int[]{1, 0, -1, 0};

            int x = 0, y = 0, di = 0;

            Set<Long> obstacleSet = new HashSet<>();
            for (int[] obstacle : obstacles) {
                long ox = (long)obstacle[0] + 30000;
                long oy = (long)obstacle[1] + 30000;

                obstacleSet.add((ox << 16) + oy);
            }
            int ans = 0;
            for (int cmd : commands) {
                if (cmd == -2) {
                    di = (di + 3) % 4;
                } else if (cmd == -1) {
                    di = (di + 1) % 4;
                } else {
                    for (int k = 0; k < cmd; ++k) {
                        int nx = x + dx[di];
                        int ny = y + dy[di];
                        long code = (((long)nx + 30000) << 16) + (long)ny + 30000;
                        if (!obstacleSet.contains(code)) {
                            x = nx;
                            y = ny;
                            ans = Math.max(ans, x * x + y * y);
                        }
                    }
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}