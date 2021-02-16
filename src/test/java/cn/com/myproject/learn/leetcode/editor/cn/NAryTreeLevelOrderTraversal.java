//Given an n-ary tree, return the level order traversal of its nodes' values. 
//
// Nary-Tree input serialization is represented in their level order traversal, 
//each group of children is separated by the null value (See examples). 
//
// 
// Example 1: 
//
// 
//
// 
//Input: root = [1,null,3,2,4,null,5,6]
//Output: [[1],[3,2,4],[5,6]]
// 
//
// Example 2: 
//
// 
//
// 
//Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null
//,12,null,13,null,null,14]
//Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
// 
//
// 
// Constraints: 
//
// 
// The height of the n-ary tree is less than or equal to 1000 
// The total number of nodes is between [0, 10^4] 
// 
// Related Topics 树 广度优先搜索

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class NAryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new NAryTreeLevelOrderTraversal().new Solution();
        Node root = new Node(1);
        List<Node> children2 = new ArrayList<>();
        children2.add(new Node(5));
        children2.add(new Node(6));
        List<Node> children1 = new ArrayList<>();
        Node node = new Node(3);
        node.children = children2;
        children1.add(node);
        children1.add(new Node(2));
        children1.add(new Node(4));
        root.children = children1;
        List<List<Integer>> list = solution.levelOrder(root);
        System.out.println(list.toString());
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /*
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    */

    class Solution {
        /**
         * 递归
         * @param root
         * @return
         */
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            List<Node> level = new ArrayList<>();
            level.add(root);
            helper(level, result);
            return result;

        }
        private void helper(List<Node> level, List<List<Integer>> result) {
            if (level.isEmpty()) {
                return;
            }
            List<Integer> list = new ArrayList<>();
            List<Node> nextLevel = new ArrayList<>();
            for (Node node : level) {
                list.add(node.val);
                if (node.children != null) {
                    nextLevel.addAll(node.children);
                }
            }
            result.add(list);
            helper(nextLevel,result);

        }

        /***
         * 迭代
         * @param root
         * @return
         */
        public List<List<Integer>> levelOrder1(Node root) {
            List<List<Integer>> result = new ArrayList<>();

            if (root == null) {
                return result;
            }
            List<Node> level = new ArrayList<>();
            level.add(root);
            while (!level.isEmpty() ) {
                List<Integer> list = new ArrayList<>();
                List<Node> nextLevel = new ArrayList<>();
                for (Node node : level) {
                    list.add(node.val);
                    if (node.children != null) {
                        nextLevel.addAll(node.children);
                    }
                }
                result.add(list);
                level = nextLevel;
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}