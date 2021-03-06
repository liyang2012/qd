package cn.com.myproject.learn.leetcode;


/**
 *实现 strStr()
 * */
public class LeetCode28 {

    public static int strStr(String haystack, String needle) {
        if(haystack == null || needle==null) {
            return -1;
        }
        if(needle.equals("")) {
            return 0;
        }
        int len1 = haystack.length();
        int len2 = needle.length();
        for(int i=0;i<=len1-len2;i++) {
            int j;
            for(j=0;j<len2;j++) {
                if(haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == len2) {
                return i;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "a";
        String needle = "a";
        int i = strStr(haystack,needle);
        System.out.println(i);
    }
}
