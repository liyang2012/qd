package cn.com.myproject.learn.leetcode;

/**
 * 最长字符串
 * */
public class LeetCode58 {
    public static int lengthOfLastWord(String s) {
        if(s==null || s.trim().equals("")){
            return 0;
        }
        int end = s.length() - 1;
        while(end>=0 && s.charAt(end) == ' '){
            end --;
        }
        if(end<0){
            return 0;
        }
        int start = end;
        while(start>=0 && s.charAt(start) != ' ') {
            start--;
        }
        return end-start;

    }

    public static void main(String[] args) {
        String s = "Hell";
        System.out.println(lengthOfLastWord(s));
    }
}
