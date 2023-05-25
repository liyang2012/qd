package cn.com.myproject.learn.lcci;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xx
 */
public class Solution0102 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> permutation = new HashMap<Character, Integer>(s1.length());
        for (char c : s1.toCharArray()) {
            permutation.put(c, permutation.getOrDefault(c, 0) + 1);
        }
        for (char c : s2.toCharArray()) {
            if (!permutation.containsKey(c)) {
                return false;
            }
            permutation.put(c, permutation.get(c) - 1);
            if (permutation.get(c) < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean CheckPermutation1(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 != n2) {
            return false;
        }
        int[]  counter = new int[28];
        for (int i = 0; i < counter.length; i++) {
            ++counter[s1.charAt(i)];
            --counter[s2.charAt(i)];
        }
        for (int v : counter) {
            if (v != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution0102 solution0102 = new Solution0102();
        System.out.println(solution0102.CheckPermutation("baaa", "aaab"));
        System.out.println(solution0102.CheckPermutation1("baaa", "aaab"));
    }
}
