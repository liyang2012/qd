//English description is not available for the problem. Please switch to Chinese
//. Related Topics 递归

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class FeiBoNaQiShuLieLcof{
    public static void main(String[] args) {
        Solution solution = new FeiBoNaQiShuLieLcof().new Solution();
        System.out.println(solution.fib(5));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fib(int n) {
            if (n < 1) {
                return 0;
            }
            int res = 1;
            if (n < 3) {
                return res;
            }
            int i = 1, j = 1;
            for (int k = 2; k < n; k++) {
                res = (i + j) % 1000000007;
                i = j;
                j = res;
            }
            return res;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}