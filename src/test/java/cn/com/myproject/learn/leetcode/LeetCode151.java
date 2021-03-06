package cn.com.myproject.learn.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 151. 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 *
 * 进阶：
 *
 * 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
 *
 * */
public class LeetCode151 {
    public String reverseWords(String s) {
        //去除两端空格
        s = s.trim();
        int left = 0,right = s.length()-1;

        Deque<String> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        while(left<=right) {
            char c = s.charAt(left);
            if(c == ' ' && sb.length() != 0) {
                deque.offerFirst(sb.toString());
                sb = new StringBuilder();
            }else if (c != ' ')  {
                sb.append(c);
            }
            left++;
        }
        deque.offerFirst(sb.toString());
        return String.join(" ", deque);
    }

    public static void main(String[] args) {
        LeetCode151 lc151 = new LeetCode151();
        System.out.println(lc151.reverseWords("  a good  example  "));
    }
}
