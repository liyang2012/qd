//
//Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses.
// 
//
// 
//For example, given n = 3, a solution set is:
// 
// 
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// Related Topics 字符串 回溯算法

  
package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class GenerateParentheses{
    public static void main(String[] args) {
       Solution solution = new GenerateParentheses().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 动态规划
         * @param n
         * @return
         */
        public List<String> generateParenthesis1(int n) {
            if (n == 0) {
                return new ArrayList<>();
            }
            // 这里 dp 数组我们把它变成列表的样子，方便调用而已
            List<List<String>> dp = new ArrayList<>(n);

            List<String> dp0 = new ArrayList<>();
            dp0.add("");
            dp.add(dp0);
            for (int i = 1; i <= n; i++) {
                List<String> cur = new ArrayList<>();
                for (int j = 0; j < i; j++) {
                    List<String> str1 = dp.get(j);
                    List<String> str2 = dp.get(i - 1 - j);
                    for (String s1 : str1) {
                        for (String s2 : str2) {
                            // 枚举右括号的位置
                            cur.add("(" + s1 + ")" + s2);
                        }
                    }
                }
                dp.add(cur);
            }
            return dp.get(n);
        }

        /**
         * 暴力
         * @param n
         * @return
         */
        public List<String> generateParenthesis2(int n) {
            List<String> combinations = new ArrayList();
            generateAll(new char[2 * n], 0, combinations);
            return combinations;
        }
        public void generateAll(char[] current, int pos, List<String> result) {
            if (pos == current.length) {
                if (valid(current))
                    result.add(new String(current));
            } else {
                current[pos] = '(';
                generateAll(current, pos+1, result);
                current[pos] = ')';
                generateAll(current, pos+1, result);
            }
        }
        public boolean valid(char[] current) {
            int balance = 0;
            for (char c: current) {
                if (c == '(') {
                    balance++;
                } else {
                    balance--;
                }
                if (balance < 0) {
                    return false;
                }
            }
            return (balance == 0);
        }

        /**
         * dfs
         * @param n
         * @return
         */
        public List<String> generateParenthesis3(int n) {
            List<String> res = new ArrayList<>();
            // 特判
            if (n == 0) {
                return res;
            }

            // 执行深度优先遍历，搜索可能的结果
            dfs("", n, n, res);
            return res;
        }
        /**
         * @param curStr 当前递归得到的结果
         * @param left   左括号还有几个可以使用
         * @param right  右括号还有几个可以使用
         * @param res    结果集
         */
        private void dfs(String curStr, int left, int right, List<String> res) {
            // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
            // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
            if (left == 0 && right == 0) {
                res.add(curStr);
                return;
            }

            // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
            if (left > right) {
                return;
            }

            if (left > 0) {
                dfs(curStr + "(", left - 1, right, res);
            }

            if (right > 0) {
                dfs(curStr + ")", left, right - 1, res);
            }
        }


        class Node {
            /**
             * 当前得到的字符串
             */
            private String res;
            /**
             * 剩余左括号数量
             */
            private int left;
            /**
             * 剩余右括号数量
             */
            private int right;

            public Node(String str, int left, int right) {
                this.res = str;
                this.left = left;
                this.right = right;
            }
        }

        // 注意：这是深度优先遍历

        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            if (n == 0) {
                return res;
            }

            // 注意：只使用栈相关的接口，即只使用 `addLast()` 和 `removeLast()`
            Deque<Node> stack = new ArrayDeque<>();
            stack.addLast(new Node("", n, n));

            while (!stack.isEmpty()) {

                Node curNode = stack.removeLast();
                if (curNode.left == 0 && curNode.right == 0) {
                    res.add(curNode.res);
                }
                if (curNode.left > 0) {
                    stack.addLast(new Node(curNode.res + "(", curNode.left - 1, curNode.right));
                }
                if (curNode.right > 0 && curNode.left < curNode.right) {
                    stack.addLast(new Node(curNode.res + ")", curNode.left, curNode.right - 1));
                }
            }
            return res;
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}