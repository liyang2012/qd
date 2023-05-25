//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。 
//
// 示例 1 : 
//
// 
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
// 
//
// 示例 2 : 
//
// 
//输入: 9973
//输出: 9973
//解释: 不需要交换。
// 
//
// 注意: 
//
// 
// 给定数字的范围是 [0, 10⁸] 
// 
//
// Related Topics 贪心 数学 👍 334 👎 0


package cn.com.myproject.learn.leetcode.editor.cn;

public class MaximumSwap{
    public static void main(String[] args) {
        Solution solution = new MaximumSwap().new Solution();
        int arg = 1234;
        int result = solution.maximumSwap(arg);
        System.out.println("arg:" + arg + " result:" + result);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumSwap(int num) {
            char[] charArray = String.valueOf(num).toCharArray();
            int n = charArray.length;
            int maxIdx = n - 1;
            int idx1 = -1, idx2 = -1;
            for (int i = n - 1; i >= 0; i--) {
                if (charArray[i] > charArray[maxIdx]) {
                    maxIdx = i;
                } else if (charArray[i] < charArray[maxIdx]) {
                    idx1 = i;
                    idx2 = maxIdx;
                }
            }
            if (idx1 >= 0) {
                swap(charArray, idx1, idx2);
                return Integer.parseInt(new String(charArray));
            } else {
                return num;
            }
        }

        public void swap(char[] charArray, int i, int j) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}