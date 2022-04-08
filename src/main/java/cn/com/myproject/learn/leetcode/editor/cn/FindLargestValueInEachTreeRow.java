//You need to find the largest value in each row of a binary tree. 
//
// Example: 
// 
//Input: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//Output: [1, 3, 9]
// 
// 
// Related Topics 树 深度优先搜索 广度优先搜索

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow{
    public static void main(String[] args) {
        Solution solution = new FindLargestValueInEachTreeRow().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        private List<Integer> result = new ArrayList();
        public List<Integer> largestValues(TreeNode root) {
            bfs(root, 0);
            return result;
        }
        private void bfs(TreeNode node, int level) {
            if (node == null) {
                return;
            }
            if (result.size() > level) {
                if (node.val > result.get(level)) {
                    result.set(level, node.val);
                }
            } else {
               result.add(node.val);
            }
            bfs(node.left, level + 1);
            bfs(node.right, level + 1);
        }

        public List<Integer> largestValues1(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if(root == null){
                return result;
            }
            //创建一个队列，用于存放当前节点相邻的节点
            Queue<TreeNode> queue = new LinkedList<>();
            //初始化，将根节点放入队列当中
            queue.add(root);

            while(!queue.isEmpty()){
                //计算当前节点相邻的节点数量
                int size = queue.size();
                int min = Integer.MIN_VALUE;
                //遍历当前节点相邻节点
                for(int i = 0; i<size; i++){
                    TreeNode temp = queue.poll();
                    min = Math.max(min,temp.val);
                    if(temp.left != null){
                        queue.add(temp.left);
                    }
                    if(temp.right != null){
                        queue.add(temp.right);
                    }
                }
                result.add(min);
            }
            return result;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}