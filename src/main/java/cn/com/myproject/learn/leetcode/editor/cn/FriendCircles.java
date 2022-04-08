//
//There are N students in a class. Some of them are friends, while some are not.
// Their friendship is transitive in nature. For example, if A is a direct friend 
//of B, and B is a direct friend of C, then A is an indirect friend of C. And we d
//efined a friend circle is a group of students who are direct or indirect friends
//.
// 
//
// 
//Given a N*N matrix M representing the friend relationship between students in 
//the class. If M[i][j] = 1, then the ith and jth students are direct friends with
// each other, otherwise not. And you have to output the total number of friend ci
//rcles among all the students.
// 
//
// Example 1: 
// 
//Input: 
//[[1,1,0],
// [1,1,0],
// [0,0,1]]
//Output: 2
//Explanation:The 0th and 1st students are direct friends, so they are in a frie
//nd circle. The 2nd student himself is in a friend circle. So return 2.
// 
// 
//
// Example 2: 
// 
//Input: 
//[[1,1,0],
// [1,1,1],
// [0,1,1]]
//Output: 1
//Explanation:The 0th and 1st students are direct friends, the 1st and 2nd stude
//nts are direct friends, so the 0th and 2nd students are indirect friends. All of
// them are in the same friend circle, so return 1.
// 
// 
//
//
// Note: 
// 
// N is in range [1,200]. 
// M[i][i] = 1 for all students. 
// If M[i][j] = 1, then M[j][i] = 1. 
// 
// Related Topics 深度优先搜索 并查集

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.Arrays;

public class FriendCircles{
    public static void main(String[] args) {
       Solution solution = new FriendCircles().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 并查集
         * FIXME
         *
         */
        public int findCircleNum(int[][] M) {
            int[] parent = new int[M.length];
            Arrays.fill(parent, -1);
            for (int i = 0; i < M.length; i++) {
                for (int j = 0; j < M.length; j++) {
                    if (M[i][j] == 1 && i != j) {
                        union(parent, i, j);
                    }
                }
            }
            int count = 0;
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == -1)
                    count++;
            }
            return count;
        }

        private int find(int parent[], int i) {
            if (parent[i] == -1)
                return i;
            return find(parent, parent[i]);
        }

        private void union(int parent[], int x, int y) {
            int xset = find(parent, x);
            int yset = find(parent, y);
            if (xset != yset)
                parent[xset] = yset;
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}