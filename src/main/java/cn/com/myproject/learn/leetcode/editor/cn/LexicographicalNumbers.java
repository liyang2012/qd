//给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。 
//
// 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 13
//输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 5 * 10⁴ 
// 
// Related Topics 深度优先搜索 字典树 👍 270 👎 0


package cn.com.myproject.learn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers{
    public static void main(String[] args) {
        Solution solution = new LexicographicalNumbers().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> lexicalOrder1(int n) {
            List<Integer> ret = new ArrayList<>(n);
            int number = 1;
            for (int i = 0; i < n; i++) {
                ret.add(number);
                if (number * 10 <= n) {
                    number *= 10;
                } else {
                    while (number % 10 == 9 || number + 1 > n) {
                        number /= 10;
                    }
                    number++;
                }
            }
            return ret;
        }

        public List<Integer> lexicalOrder(int n) {
            List<Integer> res = new ArrayList<>();
            int x = 1;
            //list的大小=n
            while (res.size() < n) {
                //每次将当前层 *10进入下一层
                while (x <= n) {
                    res.add(x);
                    x *= 10;
                }
                //如果当前层的元素已经从9跃升到10这个阶梯或者当前层元素比n大，返回上一层
                while (x % 10 == 9 || x > n) {
                    x /= 10;
                }
                //当前层遍历完，递进1
                x++;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}