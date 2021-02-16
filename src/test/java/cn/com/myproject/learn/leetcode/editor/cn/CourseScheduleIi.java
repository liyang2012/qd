//There are a total of n courses you have to take, labeled from 0 to n-1. 
//
// Some courses may have prerequisites, for example to take course 0 you have to
// first take course 1, which is expressed as a pair: [0,1] 
//
// Given the total number of courses and a list of prerequisite pairs, return th
//e ordering of courses you should take to finish all courses. 
//
// There may be multiple correct orders, you just need to return one of them. If
// it is impossible to finish all courses, return an empty array. 
//
// Example 1: 
//
// 
//Input: 2, [[1,0]] 
//Output: [0,1]
//Explanation: There are a total of 2 courses to take. To take course 1 you shou
//ld have finished   
//             course 0. So the correct course order is [0,1] . 
//
// Example 2: 
//
// 
//Input: 4, [[1,0],[2,0],[3,1],[3,2]]
//Output: [0,1,2,3] or [0,2,1,3]
//Explanation: There are a total of 4 courses to take. To take course 3 you shou
//ld have finished both     
//             courses 1 and 2. Both courses 1 and 2 should be taken after you f
//inished course 0. 
//             So one correct course order is [0,1,2,3]. Another correct orderin
//g is [0,2,1,3] . 
//
// Note: 
//
// 
// The input prerequisites is a graph represented by a list of edges, not adjace
//ncy matrices. Read more about how a graph is represented. 
// You may assume that there are no duplicate edges in the input prerequisites. 
//
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class CourseScheduleIi{
    public static void main(String[] args) {
       Solution solution = new CourseScheduleIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean hasCycle;
        Deque<Integer> reversePost = new LinkedList<>();

        /***
         * FIXMEs
         * @param v
         * @param a
         * @return
         */
        public int[] findOrder(int v, int[][] a) {
            // 将边缘列表变为邻接列表
            List<Integer>[] g = new ArrayList[v];
            for (int i = 0; i < v; i++) {
                g[i] = new ArrayList<>();
            }
            for (int[] i : a) {
                g[i[1]].add(i[0]);
            }

            int[] ans = new int[]{};

            findCycle(v, g);
            // 只有无环才能拓扑排序
            if (!hasCycle) {
                ans = new int[reversePost.size()];
                for (int i = 0; i < ans.length; i++) {
                    ans[i] = reversePost.pop();
                }
            }
            return ans;
        }

        void findCycle(int v, List<Integer>[] g) {
            boolean[] seen = new boolean[v];
            boolean[] onstack = new boolean[v];
            for (int i = 0; i < v; i++) {
                if (!seen[i]) {
                    dfs(i, g, seen, onstack);
                }
            }
        }

        void dfs(int v, List<Integer>[] g, boolean[] seen, boolean[] onstack) {
            if (hasCycle) return;
            seen[v] = true;
            onstack[v] = true;
            for (int w : g[v]) {
                if (!seen[w]) {
                    dfs(w, g, seen, onstack);
                } else if (onstack[w]) {
                    hasCycle = true;
                    return;
                }
            }
            // 找环的同时进行记录拓扑排序
            reversePost.push(v);
            onstack[v] = false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}