//Given an n-ary tree, return the postorder traversal of its nodes' values. 
//
// Nary-Tree input serialization is represented in their level order traversal, 
//each group of children is separated by the null value (See examples). 
//
// 
//
// Follow up: 
//
// Recursive solution is trivial, could you do it iteratively? 
//
// 
// Example 1: 
//
// 
//
// 
//Input: root = [1,null,3,2,4,null,5,6]
//Output: [5,6,3,2,4,1]
// 
//
// Example 2: 
//
// 
//
// 
//Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null
//,12,null,13,null,null,14]
//Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
// 
//
// 
// Constraints: 
//
// 
// The height of the n-ary tree is less than or equal to 1000 
// The total number of nodes is between [0, 10^4] 
// 
// Related Topics 树

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.*;

public class NAryTreePostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new NAryTreePostorderTraversal().new Solution();
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
        List<Integer> list = solution.postorder(root);
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
        public List<Integer> postorder1(Node root) {
            List<Integer> result = new ArrayList<>();
            helper(root, result);
            return result;
        }

        private void helper (Node root, List<Integer> result) {
            if (root == null) {
                return;
            }
            if (root.children != null && root.children.size() != 0) {
                for (Node node : root.children) {
                    helper(node, result);
                }
            }
            result.add(root.val);
        }

        public List<Integer> postorder(Node root) {
            LinkedList<Integer> result = new LinkedList<>();
            Deque<Node> deque = new ArrayDeque();
            if (root == null) {
                return result;
            }
            Node curr = root;

            deque.add(root);
            while (!deque.isEmpty()) {
                Node node = deque.pollLast();
                result.addFirst(node.val);
                if(node.children != null) {
                    for (Node item : node.children) {
                        if (item != null) {
                            deque.add(item);
                        }
                    }
                }

            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}