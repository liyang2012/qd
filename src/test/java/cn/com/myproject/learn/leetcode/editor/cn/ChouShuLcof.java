//English description is not available for the problem. Please switch to Chinese
//. Related Topics 数学

  
package cn.com.myproject.learn.leetcode.editor.cn;
public class ChouShuLcof{
    public static void main(String[] args) {
       Solution solution = new ChouShuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            /**
             *
             * 定义三个指针p2,p3,p5，p2指向的数字永远乘2，p3指向的数字永远乘3，p5指向的数字永远乘5
             * 初始化所有指针都指向第一个丑数，即1
             * 我们从2*dp[p2], 3*dp[p3], 5*dp[p5]选取最小的一个数字，作为新的丑数。
             * 这边新的丑数就是2*dp[p2]=2*1=2，然后p2++
             * 此时p3和p5指向第1个丑数，p2指向第2个丑数。然后重复上一步
             * 这里基于的一个事实是，丑数数列是递增的，当p5指针在当前位置时，后面的数乘以5必然比前面的数乘以5大，
             * 所以下一个丑数必然是先考虑前面的数乘以5。p2,p3同理，所以才可以使用指针
             */
            int p2 = 0, p3 = 0,p5 = 0;
            int[] dp = new int[n];
            dp[0] = 1;
            for(int i = 1; i < n; i++){
                dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
                if(dp[i] == dp[p2]*2) {
                    p2++;
                }
                if(dp[i] == dp[p3]*3) {
                    p3++;
                }
                if(dp[i] == dp[p5]*5) {
                    p5++;
                }
            }
            return dp[n-1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}