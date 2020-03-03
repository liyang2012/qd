package cn.com.myproject.learn.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符串
 * **/
public class LeetCode3 {
    public static int lengthOfLongestSubstring(String s) {
        int l = s.length();
        int max = 0;
        int i=0,j=0;
        Set<Character> set = new HashSet<>();
        while (i<l && j<l) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max,j-i);
            }else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }
    public static void main(String[] args) {
        String str = "sdsfdbasdf";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
