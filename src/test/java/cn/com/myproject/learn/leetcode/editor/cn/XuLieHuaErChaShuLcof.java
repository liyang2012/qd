//English description is not available for the problem. Please switch to Chinese
//. Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 
// 👍 187 👎 0

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class XuLieHuaErChaShuLcof{
    public static void main(String[] args) {
        Codec codec = new XuLieHuaErChaShuLcof().new Codec();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(codec.serialize(root));
        TreeNode root1 = codec.deserialize(codec.serialize(root));
        System.out.println(root1.toString());
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
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        private void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("N,");
                return;
            }
            sb.append(root.val).append(",");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] s = data.split(",");
            String[] dataArray = data.split(",");
            List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
            return deserialize(dataList);
        }

        private TreeNode deserialize (List<String> dataList) {
            if (dataList.get(0).equals("N")) {
                dataList.remove(0);
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
            dataList.remove(0);
            root.left = deserialize(dataList);
            root.right = deserialize(dataList);
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}